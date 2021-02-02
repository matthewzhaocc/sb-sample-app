package com.matthew_cloud.sampleapp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String index() {
        return "fuck you until you break \n";
    }
}
