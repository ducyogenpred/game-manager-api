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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Transactional
    public DeveloperDTO createDeveloper(@Valid DeveloperRO ro) {
        if (developerRepository.existsByEmail(ro.email())) {
            throw new IllegalArgumentException("Email already exists!");
        }

        Developer developer = developerMapper.toEntity(ro);
        return developerMapper.toDto(developerRepository.save(developer));
    }

//    public List<DeveloperDTO> getAllDevelopers() {
//        return developerRepository.findAll()
//                .stream()
//                .map(developerMapper::toDto)
//                .toList();
//    }

    public DeveloperDTO getDevelopersById(Long id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Developer with id" + id + "already exists"));
        return developerMapper.toDto(developer);
    }

    public DeveloperDTO getDevelopersByName(String name) {
        Developer developer = developerRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Developer with name" + name + "already exists"));
        return developerMapper.toDto(developer);
    }

    @Transactional
    public Developer patchDevelopers(Long id, @Valid DeveloperPatchRO ro) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Developer not found!"));

        if (ro.email().isPresent()) {
            String email = ro.email().get();
            if (developerRepository.existsByEmail(email)) {
                throw new IllegalArgumentException("Developer with this display name already exists.");
            }
            developer.setEmail(email);
        }

        if (ro.name().isPresent()) {
            String name = ro.name().get();
            if (developerRepository.existsByName(name)) {
                throw new IllegalArgumentException("Developer with this name already exists.");
            }
            developer.setName(name);
        }

        ro.name().ifPresent(developer::setName);
        ro.email().ifPresent(developer::setEmail);
        ro.description().ifPresent(developer::setDescription);

        return developerRepository.save(developer);
    }

    @Transactional
    public Developer deleteDeveloper (long id){
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Developer with id" + id + "already exists"));

        developerRepository.delete(developer);
        return developer;
    }
}