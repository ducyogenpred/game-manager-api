package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.entity.Developer;
import com.firstgroup.gamemanagerapi.mapper.DeveloperMapper;
import com.firstgroup.gamemanagerapi.repository.DeveloperRepository;
import com.firstgroup.gamemanagerapi.request.DeveloperPatchRO;
import com.firstgroup.gamemanagerapi.request.DeveloperRO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Transactional
    public DeveloperDTO createDeveloper(@Valid DeveloperRO ro) {
        Developer developer = developerMapper.toEntity(ro);

        try {
            return developerMapper.toDto(developerRepository.save(developer));
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Developer with this name or email already exists.");
        }
    }

    public DeveloperDTO getDeveloperById(Long id) {
        return developerMapper.toDto(developerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer with this ID does not exist.")));
    }

    public DeveloperDTO getDeveloperByName(String name) {
        return developerMapper.toDto(developerRepository.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer with this name does not exist.")));
    }

    public DeveloperDTO getDeveloperByEmail(String email) {
        return developerMapper.toDto(developerRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer with this email does not exist.")));
    }

    @Transactional
    public DeveloperDTO patchDeveloper(Long id, @Valid DeveloperPatchRO ro) {
        if (ro.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No fields provided for update.");
        }

        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer with this ID does not exist."));

        if (ro.name() != null && !ro.name().equals(developer.getName())) {
            if (developerRepository.existsByName(ro.name())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Developer with this name already exists.");
            }
            developer.setName(ro.name());
        }

        if (ro.email() != null && !ro.email().equals(developer.getEmail())) {
            if (developerRepository.existsByEmail(ro.email())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Developer with this email already exists.");
            }
            developer.setEmail(ro.email());
        }

        developerMapper.updateDeveloperFromPatchRo(ro, developer);
        return developerMapper.toDto(developerRepository.save(developer));
    }

    @Transactional
    public void deleteDeveloper(Long id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer with this ID does not exist."));
        developerRepository.delete(developer);
    }
}
