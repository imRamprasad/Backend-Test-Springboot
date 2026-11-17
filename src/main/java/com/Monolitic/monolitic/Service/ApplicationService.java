package com.Monolitic.monolitic.Service;

import com.Monolitic.monolitic.dto.ApplicationRequest;
import com.Monolitic.monolitic.dto.ApplicationResopnse;
import com.Monolitic.monolitic.entity.Application;
import com.Monolitic.monolitic.mapper.ApplicationMapper;
import com.Monolitic.monolitic.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository repository;
    private final ApplicationMapper mapper;

    public ApplicationService(
            ApplicationRepository repository,
            ApplicationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Application saveApplication(ApplicationRequest application) {
       return repository.save(mapper.toAppliactionEntity(application));
    }

    public List<ApplicationResopnse> getAll(){
        List<Application> applications = repository.findAll();
        List<ApplicationResopnse> applicationResopnse = new ArrayList<>();
        for (Application application : applications) {
            applicationResopnse.add(mapper.toApplicationRequestEntity(application));
        }
        return applicationResopnse;
    }





}
