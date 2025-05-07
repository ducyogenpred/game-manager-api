package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.PublisherDTO;
import com.firstgroup.gamemanagerapi.entity.Publisher;
import com.firstgroup.gamemanagerapi.mapper.PublisherMapper;
import com.firstgroup.gamemanagerapi.repository.PublisherRepository;
import com.firstgroup.gamemanagerapi.request.PublisherRO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public PublisherService(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    public PublisherDTO createPublisher(@Valid PublisherDTO ro) {
        Publisher publisher; // Convert RO to Entity
        publisher = publisherMapper.toEntity(ro);

        publisher = publisherRepository.save(publisher);

        return publisherMapper.toDto(publisher);
    }

    public List<PublisherDTO> getAllPublishers() {
        return publisherRepository.findAll()
                .stream()
                .map(publisherMapper::toDto) // Convert entity to DTO
                .toList();
    }

    public PublisherDTO getPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Publisher with id " + id + " not found!"));

        return publisherMapper.toDto(publisher);
    }

    public List<PublisherDTO> getPublishersByName(String name) {
        return publisherRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(publisherMapper::toDto)
                .toList();
    }

    public PublisherDTO getPublisherByName(String name) {
        Publisher publisher = publisherRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new EntityNotFoundException("Publisher with name " + name + " not found!"));

        return publisherMapper.toDto(publisher);
    }

    public List<PublisherDTO> getPublishersByReviewCount(Integer reviewCount) {
        return publisherRepository.findByReviewCountGreaterThanEqual(reviewCount)
                .stream()
                .map(publisherMapper::toDto)
                .toList();
    }

    public PublisherDTO updatePublisher(long id, @Valid PublisherRO ro) {
        return null;
    }

    public void deletePublisherById(long id) {
    }


}