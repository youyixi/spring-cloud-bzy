package com.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${user}")
    private String user;
    @Value("${name}")
    private String name;

    @GetMapping("get_config")
    public String getConfig(){
//        return null;
        return "user=" + user + ",name=" + name;
    }

}
