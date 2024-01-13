package com.example.nacosrestfulprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping(value = "/service")
    public String service(){
        return "success";
    }
}
