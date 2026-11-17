package com.Monolitic.monolitic.controller;

import com.Monolitic.monolitic.Service.ApplicationService;
import com.Monolitic.monolitic.dto.ApplicationRequest;
import com.Monolitic.monolitic.dto.ApplicationResopnse;
import com.Monolitic.monolitic.entity.Application;
import com.Monolitic.monolitic.mapper.ApplicationMapper;
import com.Monolitic.monolitic.repository.ApplicationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class AplicationController {

    private final ApplicationService  applicationService;
   public AplicationController(ApplicationService applicationServicer) {
        this.applicationService = applicationServicer;
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ApplicationRequest applicationRequest) {
       applicationService.saveApplication(applicationRequest);
        return  ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<ApplicationResopnse>> getAll() {

       return ResponseEntity.status(200).body(applicationService.getAll());
    }



}
