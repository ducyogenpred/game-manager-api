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

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    // Create a new publisher
    public PublisherDTO createPublisher(@Valid PublisherRO ro) {
        Publisher publisher = publisherMapper.toEntity(ro);

        publisher.setCreatedAt(LocalDateTime.now());
        publisher.setUpdatedAt(LocalDateTime.now());

        publisher = publisherRepository.save(publisher);

        return publisherMapper.toDto(publisher);
    }

    // Get all publishers
    public List<PublisherDTO> getAllPublishers() {
        return publisherRepository.findAll()
                .stream()
                .map(publisherMapper::toDto)
                .toList();
    }

    // Get publisher by ID
    public PublisherDTO getPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Publisher with id " + id + " not found!"));

        return publisherMapper.toDto(publisher);
    }

    // Get publishers by partial name match
    public List<PublisherDTO> getPublishersByName(String name) {
        return publisherRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(publisherMapper::toDto)
                .toList();
    }

    // Get publisher by exact name
    public PublisherDTO getPublisherByName(String name) {
        Publisher publisher = publisherRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new EntityNotFoundException("Publisher with name " + name + " not found!"));

        return publisherMapper.toDto(publisher);
    }

    // Get publishers by minimum review count
    public List<PublisherDTO> getPublishersByReviewCount(Integer reviewCount) {
        return publisherRepository.findByReviewCountGreaterThanEqual(reviewCount)
                .stream()
                .map(publisherMapper::toDto)
                .toList();
    }
}