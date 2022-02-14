package com.consumer.controller;

import com.cloud.utils.ResponseData;
import com.consumer.service.ProviderFeign;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final String URL = "http://bzy-server/provider/get_test/";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private ProviderFeign providerFeign;


    @GetMapping("get_test/{id}")
    public ResponseData<Object> getTest(@PathVariable("id") Integer id) {

        ResponseEntity<String> forEntity = restTemplate.getForEntity(URL + id, String.class);
        return ResponseData.success(forEntity, "RestTemplate调用");
    }

    @GetMapping("get_open_feign_test/{id}")
    public ResponseData<String> getOpenFeignTest(@PathVariable("id") Integer id){

        return ResponseData.success(providerFeign.getOpenFeignTest(id), "openFeign调用");
    }

    @GetMapping("get_open_feign_time_out/{id}")
    public ResponseData<String> getFeignTimeOut(@PathVariable("id") Integer id){

        return ResponseData.success(providerFeign.getFeignTimeOut(id), "openFeign超时调用");
    }
}
