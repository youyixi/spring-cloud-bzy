package com.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(value = "bzy-server")
@RequestMapping("/provider")
public interface ProviderFeign {

    @GetMapping("get_open_feign_test/{id}")
    String getOpenFeignTest(@PathVariable("id") Integer id);

    @GetMapping("get_open_feign_time_out/{id}")
    String getFeignTimeOut(@PathVariable("id") Integer id);
}
