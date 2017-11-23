package com.mandatory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(){
        return "homepage";
    }
    @GetMapping("/student")
    public String studentPage(){
        return "student";
    }
    @GetMapping("/teacher")
    public String teacherPage(){
        return "teacher";
    }
    //    @GetMapping("/admin")
    //    public String adminPage (){
    //        return "admin";
    //    }

}
