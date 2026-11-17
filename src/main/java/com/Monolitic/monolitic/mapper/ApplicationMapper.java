package com.Monolitic.monolitic.mapper;

import com.Monolitic.monolitic.dto.ApplicationRequest;
import com.Monolitic.monolitic.dto.ApplicationResopnse;
import com.Monolitic.monolitic.entity.Application;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {


    public Application toAppliactionEntity(ApplicationRequest applicationRequest) {
        Application application = new Application();
        application.setName(applicationRequest.name());
        application.setAge(applicationRequest.age());
        application.setEmail(applicationRequest.email());
        return application;
    }

    public ApplicationResopnse toApplicationRequestEntity(Application application) {
       return new ApplicationResopnse(
               application.getId(),
               application.getName(),
               application.getAge(),
               application.getEmail()
       );

    }
}
