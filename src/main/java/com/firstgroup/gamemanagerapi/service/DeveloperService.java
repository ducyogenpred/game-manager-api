package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.entity.Developer;
import com.firstgroup.gamemanagerapi.mapper.DeveloperMapper;
import com.firstgroup.gamemanagerapi.repository.DeveloperRepository;
import com.firstgroup.gamemanagerapi.request.DeveloperRO;
import com.firstgroup.gamemanagerapi.request.DeveloperPatchRO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor()
public class DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Transactional
    public DeveloperDTO createDeveloper(@Valid DeveloperRO ro) {
        if (developerRepository.existsByEmail(ro.email())) {
            throw new IllegalArgumentException("Email already exists!");
        }

        Developer developer = developerMapper.toEntity(ro);
        try {
            Developer savedDeveloper = developerRepository.save(developer);
            return developerMapper.toDto(savedDeveloper);
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Developer with this name or email already exists.");
        }
    }

    public DeveloperDTO getDeveloperById(Long id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Developer with id" + id + "already exists"));
        return developerMapper.toDto(developer);
    }

    public DeveloperDTO getDeveloperByName(String name) {
        Developer developer = developerRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Developer with name" + name + "already exists"));
        return developerMapper.toDto(developer);
    }

    @Transactional
    public DeveloperDTO patchDeveloper(Long id, @Valid DeveloperPatchRO ro) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer with this ID does not exist."));

        if (ro.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No fields provided for update.");
        }

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
    public Long deleteDeveloper (long id){
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Developer with id" + id + "already exists"));

        developerRepository.delete(developer);
        return id;
    }
}




