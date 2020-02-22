package com.spring2020cyse6225.studinfo.contoller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello! Go it!";
    }

}
