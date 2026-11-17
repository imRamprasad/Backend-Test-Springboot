package com.Monolitic.monolitic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {


    @GetMapping("/public")
    public String publicEndpoint() {
        return "Anyone can access this endpoint";
    }

    @GetMapping("/private")
    public String privateEndpoint() {
        return "You are authenticated";
    }
}
