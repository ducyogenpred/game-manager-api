package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.entity.Developer;
import com.firstgroup.gamemanagerapi.mapper.DeveloperMapper;
import com.firstgroup.gamemanagerapi.repository.DeveloperRepository;
import com.firstgroup.gamemanagerapi.request.DeveloperRO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

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

    public DeveloperDTO updateDeveloper (Long id, DeveloperRO developerRO) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Developer not found with id: + id"));

        if (!developer.getEmail().equals(developerRO.email()) &&
                developerRepository.existsByEmail(developerRO.email())) {
            throw new IllegalArgumentException("Email already exist");
        }

        Developer dev = developerMapper.toEntity(developerRO);
        return developerMapper.toDto(developerRepository.save(dev));
    }

    public DeveloperDTO getDeveloperById(Long id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Developer not found with id: " + id));
        return developerMapper.toDto(developer);
    }

    public void deleteDeveloper(Long id) {
        if (!developerRepository.existsById(id)) {
            throw new EntityNotFoundException("Developer not found with id: " + id);
        }
        developerRepository.deleteById(id);
    }

    public List<DeveloperDTO> searchDevelopersByName(String name) {
        return developerRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(developerMapper::toDto)
                .toList();

    }

    public DeveloperDTO findDeveloperByName(String name) {
        return developerRepository.findByNameIgnoreCase(name)
                .map(developerMapper::toDto)
                .orElse(null);
    }

    public List<DeveloperDTO> findDevelopersByMinReviewCount(Integer reviewCount) {
        return developerRepository.findByReviewCountGreaterThanEqual(reviewCount)
                .stream()
                .map(developerMapper::toDto)
                .toList();
    }

    public DeveloperDTO findTopRatedDeveloper() {
        return developerRepository.findByRatingAverageDesc()
                .map(developerMapper::toDto)
                .orElse(null);
    }

}

