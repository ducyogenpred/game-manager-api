package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.entity.Developer;
import com.firstgroup.gamemanagerapi.mapper.DeveloperMapper;
import com.firstgroup.gamemanagerapi.repository.DeveloperRepository;
import com.firstgroup.gamemanagerapi.request.DeveloperRO;
import jakarta.persistence.EntityNotFoundException;
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

    public DeveloperDTO createDeveloper(@Valid DeveloperRO ro) {
        if (developerRepository.existsByEmail(ro.email())) {
            throw new IllegalArgumentException("Email already exists!");
        }

        Developer developer = developerMapper.toEntity(ro);
        return developerMapper.toDto(developerRepository.save(developer));
    }

    public List<DeveloperDTO> getAllDevelopers() {
        return developerRepository.findAll()
                .stream()
                .map(developerMapper::toDto)
                .toList();
    }

    public DeveloperDTO getAllDevelopersById(Long id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Developer with id" + id + "already exists"));
        return developerMapper.toDto(developer);
    }
}
