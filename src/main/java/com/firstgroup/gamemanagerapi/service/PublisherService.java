//package com.firstgroup.gamemanagerapi.service;
//
//import com.firstgroup.gamemanagerapi.dto.PublisherDTO;
//import com.firstgroup.gamemanagerapi.entity.Publisher;
//import com.firstgroup.gamemanagerapi.mapper.PublisherMapper;
//import com.firstgroup.gamemanagerapi.repository.PublisherRepository;
//import com.firstgroup.gamemanagerapi.request.PublisherRO;
//import com.firstgroup.gamemanagerapi.request.PublisherPatchRO;
//import jakarta.persistence.EntityNotFoundException;
//import jakarta.transaction.Transactional;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@RequiredArgsConstructor()
//public class PublisherService {
//
//    private final PublisherRepository publisherRepository;
//    private final PublisherMapper publisherMapper;
//
//    @Transactional
//    public PublisherDTO createPublisher(@Valid PublisherRO ro) {
//        if (publisherRepository.existsByEmail(ro.email())) {
//            throw new IllegalArgumentException("Email already exists!");
//        }
//
//        Publisher publisher = publisherMapper.toEntity(ro);
//        return publisherMapper.toDto(publisherRepository.save(publisher));
//    }
//
//    public PublisherDTO getPublisherById(Long id) {
//        Publisher publisher = publisherRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Publisher with id" + id + "already exists"));
//        return publisherMapper.toDto(publisher);
//    }
//
//    public PublisherDTO getPublisherByName(String name) {
//        Publisher publisher = publisherRepository.findByName(name)
//                .orElseThrow(() -> new EntityNotFoundException("Publisher with name" + name + "already exists"));
//        return publisherMapper.toDto(publisher);
//    }
//
//    @Transactional
//    public Publisher patchPublisher(Long id, @Valid PublisherPatchRO ro) {
//        Publisher publisher = publisherRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Developer not found!"));
//
//        if (ro.email().isPresent()) {
//            String email = ro.email().get();
//            if (publisherRepository.existsByEmail(email)) {
//                throw new IllegalArgumentException("Developer with this display name already exists.");
//            }
//            publisher.setEmail(email);
//        }
//
//        if (ro.name().isPresent()) {
//            String name = ro.name().get();
//            if (publisherRepository.existsByName(name)) {
//                throw new IllegalArgumentException("Developer with this name already exists.");
//            }
//            publisher.setName(name);
//        }
//
//        ro.name().ifPresent(publisher::setName);
//        ro.email().ifPresent(publisher::setEmail);
//        ro.description().ifPresent(publisher::setDescription);
//
//        return publisherRepository.save(publisher);
//    }
//
//    @Transactional
//    public Long deletePublisher (long id){
//        Publisher publisher = publisherRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Developer with id" + id + "already exists"));
//
//        publisherRepository.delete(publisher);
//        return id;
//    }
//}