package com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String index() {
        return "Hello World, Welcome us site";
    }
}
