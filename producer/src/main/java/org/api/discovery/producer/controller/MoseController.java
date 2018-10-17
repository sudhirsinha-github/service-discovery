package org.api.discovery.producer.controller;

import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoseController {

    @RequestMapping(value = "/login/{name}", method = RequestMethod.GET, produces = "application/json")
    public String loginUser(@PathVariable String name) {
       return "Hello!! Welcome " + name;
    }
}
