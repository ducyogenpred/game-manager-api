package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.exception.AlreadyExistsException;
import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.model.dto.DeveloperDTO;
import com.firstgroup.gamemanagerapi.model.entity.Developer;
import com.firstgroup.gamemanagerapi.model.mapper.DeveloperMapper;
import com.firstgroup.gamemanagerapi.model.request.DeveloperPatchRO;
import com.firstgroup.gamemanagerapi.model.request.DeveloperRO;
import com.firstgroup.gamemanagerapi.model.response.ErrorResponse;
import com.firstgroup.gamemanagerapi.repository.DeveloperRepository;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeveloperService {

    public static final String DEVELOPERS = "Developers";
    public static final String DEVELOPER = "Developer";

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Transactional
    public DeveloperDTO save(DeveloperRO ro) {
        boolean nameExists = developerRepository.existsByName(ro.name());

        if (nameExists) {
            List<ErrorResponse.FieldError> errors = List.of(
                    new ErrorResponse.FieldError("name", "Developer name already exists.", ro.name())
            );
            throw new AlreadyExistsException(DEVELOPER, errors);
        }

        Developer entity = developerMapper.toEntity(ro);
        Developer saved = developerRepository.save(entity);
        log.info(MessageUtils.saveSuccess(DEVELOPER));
        return developerMapper.toDto(saved);
    }

    public List<DeveloperDTO> getAll() {
        log.info(MessageUtils.retrieveSuccess(DEVELOPERS));
        return developerRepository.findAll().stream()
                .map(developerMapper::toDto)
                .collect(toList());
    }

    public DeveloperDTO getById(Long id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Developer not found with ID: " + id));

        log.info(MessageUtils.retrieveSuccess(DEVELOPER));
        return developerMapper.toDto(developer);
    }

    @Transactional
    public DeveloperDTO update(Long id, DeveloperRO ro) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Developer not found with ID: " + id));

        developerMapper.updateFromPutRo(ro, developer);
        Developer updated = developerRepository.save(developer);
        log.info(MessageUtils.updateSuccess(DEVELOPER));
        return developerMapper.toDto(updated);
    }

    @Transactional
    public DeveloperDTO patch(Long id, DeveloperPatchRO ro) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Developer not found with ID: " + id));

        developerMapper.updateFromPatchRo(ro, developer);
        Developer updated = developerRepository.save(developer);
        log.info(MessageUtils.updateSuccess(DEVELOPER));
        return developerMapper.toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Developer not found with ID: " + id));

        developerRepository.delete(developer);
        log.info(MessageUtils.deleteSuccess(DEVELOPER));
    }
}
