package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.PublisherDTO;
import com.firstgroup.gamemanagerapi.entity.Publisher;
import com.firstgroup.gamemanagerapi.mapper.PublisherMapper;
import com.firstgroup.gamemanagerapi.repository.PublisherRepository;
import com.firstgroup.gamemanagerapi.request.PublisherPatchRO;
import com.firstgroup.gamemanagerapi.request.PublisherRO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Transactional
    public PublisherDTO createPublisher(@Valid PublisherRO ro) {
        Publisher publisher = publisherMapper.toEntity(ro);

        try {
            return publisherMapper.toDto(publisherRepository.save(publisher));
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Publisher with this display name or email already exists.");
        }
    }

    public PublisherDTO getPublisherById(long id) {
        return publisherMapper.toDto(publisherRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher with this ID does not exist.")));
    }

    public PublisherDTO getPublisherByName(String name) {
        return publisherMapper.toDto(publisherRepository.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher with this display name does not exist.")));
    }

    public PublisherDTO getPublisherByEmail(String email) {
        return publisherMapper.toDto(publisherRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher with this email does not exist.")));
    }

    @Transactional
    public PublisherDTO patchPublisher(Long id, @Valid PublisherPatchRO ro) {
        if (ro.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No fields provided for update.");
        }

        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher with this ID does not exist."));

        if (ro.name() != null && !ro.name().equals(publisher.getName())) {
            if (publisherRepository.existsByName((ro.name()))) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Publisher with this display name already exists.");
            }
            publisher.setName(ro.name());
        }

        if (ro.email() != null && !ro.email().equals(publisher.getEmail())) {
            if (publisherRepository.existsByEmail(ro.email())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Publisher with this email already exists.");
            }
            publisher.setEmail(ro.email());
        }

        publisherMapper.updatePublisherFromPatchRo(ro, publisher);
        return publisherMapper.toDto(publisherRepository.save(publisher));
    }

    @Transactional
    public void deletePublisher(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher with this ID does not exist."));
        publisherRepository.delete(publisher);
    }
}