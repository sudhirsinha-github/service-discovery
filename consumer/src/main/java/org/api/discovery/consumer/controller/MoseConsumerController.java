package org.api.discovery.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MoseConsumerController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callback")
    @RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/json")
    public String getData() {
        final String name = "Sudhir";
        System.out.println("***MoseConsumerController -->> ");
        return restTemplate.getForObject("http://producer/login/" + name, String.class);
    }

    public String callback()
    {
        return "callback called!!";
    }
}
