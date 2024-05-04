package com.javaGuide.organizationservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class OrganizationMessageController {

@Value("${spring.boot.message}")
private String message;

@GetMapping("/org/message")
    public  String giveMessage(){
        return message;
    }
}
