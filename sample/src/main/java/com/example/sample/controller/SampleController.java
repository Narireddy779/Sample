package com.example.sample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sample")
@RestController
public class SampleController {

    @GetMapping("/fetch")
    public ResponseEntity<String> getSample() {
        return ResponseEntity.ok("Welcome to Narendra Reddy...🙏🙏");
    }
}
