package com.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/provider")
public class ProviceController {

    @GetMapping("get_test/{id}")
    public String getTest(@PathVariable("id") Integer id){


        return "id=" + id.toString() + ",port:8002";
    }

    @GetMapping("get_open_feign_test/{id}")
    public String getOpenFeignTest(@PathVariable("id") Integer id){

        return "id=" + id.toString() + ",port:8002";
    }

    @GetMapping("get_open_feign_time_out/{id}")
    public String getFeignTimeOut(@PathVariable("id") Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "id=" + id.toString() + ",port:8002";
    }
}
