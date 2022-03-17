package com.First.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//netstat -ano | findstr 8080  taskkill /F /PID 7908



@Controller
public class TestController {


    @RequestMapping("/hello")
    public String hello(){

        return "hello";
    }


}
