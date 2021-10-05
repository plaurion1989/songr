package com.codefellowslab.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController
{
    @GetMapping("/hello")
    public String helloMessage()
    {
        System.out.println("Hello World!");
        return "hello/hello";
    }
    @GetMapping("/capitalize/{capString}")
    public String capHelloMessage(Model hello, @PathVariable String capString)
    {
        hello.addAttribute("capitalizeString", capString.toUpperCase());
        return "hello/hello";
    }
}
