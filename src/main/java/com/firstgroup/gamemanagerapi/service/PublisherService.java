package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.exception.AlreadyExistsException;
import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.model.dto.PublisherDTO;
import com.firstgroup.gamemanagerapi.model.entity.Publisher;
import com.firstgroup.gamemanagerapi.model.mapper.PublisherMapper;
import com.firstgroup.gamemanagerapi.model.request.PublisherRO;
import com.firstgroup.gamemanagerapi.model.request.PublisherPatchRO;
import com.firstgroup.gamemanagerapi.model.response.ErrorResponse;
import com.firstgroup.gamemanagerapi.repository.PublisherRepository;
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
public class PublisherService {

    public static final String PUBLISHERS = "Publishers";
    public static final String PUBLISHER = "Publisher";

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Transactional
    public PublisherDTO save(PublisherRO ro) {
        boolean nameExists = publisherRepository.existsByName(ro.name());

        if (nameExists) {
            List<ErrorResponse.FieldError> errors = List.of(
                    new ErrorResponse.FieldError("name", "Publisher name already exists.", ro.name())
            );
            throw new AlreadyExistsException(PUBLISHER, errors);
        }

        Publisher entity = publisherMapper.toEntity(ro);
        Publisher saved = publisherRepository.save(entity);
        log.info(MessageUtils.saveSuccess(PUBLISHER));
        return publisherMapper.toDto(saved);
    }

    public List<PublisherDTO> getAll() {
        log.info(MessageUtils.retrieveSuccess(PUBLISHERS));
        return publisherRepository.findAll().stream()
                .map(publisherMapper::toDto)
                .collect(toList());
    }

    public PublisherDTO getById(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with ID: " + id));

        log.info(MessageUtils.retrieveSuccess(PUBLISHER));
        return publisherMapper.toDto(publisher);
    }

    @Transactional
    public PublisherDTO update(Long id, PublisherRO ro) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with ID: " + id));

        publisherMapper.updateFromPutRo(ro, publisher);
        Publisher updated = publisherRepository.save(publisher);
        log.info(MessageUtils.updateSuccess(PUBLISHER));
        return publisherMapper.toDto(updated);
    }

    @Transactional
    public PublisherDTO patch(Long id, PublisherPatchRO ro) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with ID: " + id));

        publisherMapper.updateFromPatchRo(ro, publisher);
        Publisher updated = publisherRepository.save(publisher);
        log.info(MessageUtils.updateSuccess(PUBLISHER));
        return publisherMapper.toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with ID: " + id));

        publisherRepository.delete(publisher);
        log.info(MessageUtils.deleteSuccess(PUBLISHER));
    }
}
