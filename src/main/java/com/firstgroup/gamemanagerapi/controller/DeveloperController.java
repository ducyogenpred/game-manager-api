//package com.firstgroup.gamemanagerapi.controller;
//
//import com.firstgroup.gamemanagerapi.dto.DeveloperDTO;
//import com.firstgroup.gamemanagerapi.request.DeveloperRO;
//import com.firstgroup.gamemanagerapi.service.DeveloperService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/developers")
//@RequiredArgsConstructor
//public class DeveloperController {
//
//    private final DeveloperService developerService;
//
//    @PostMapping
//    public ResponseEntity<DeveloperDTO> createDeveloper (@Valid @RequestBody DeveloperRO ro) {
//        return ResponseEntity.ok(developerService.createDeveloper(ro));
//    }
//}
