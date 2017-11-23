package com.mandatory.controller;

import com.mandatory.entity.Admin;
import com.mandatory.entity.Course;
import com.mandatory.repository.AdminRepository;
import com.mandatory.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminRepository ar;

    @Autowired
    private CourseRepository cr;


    @GetMapping(value = "/admin")
    public ModelAndView logIn(){
        ModelAndView mv = new ModelAndView("admin");
        return mv;
    }

    @PostMapping(value = "/admin")
    private ModelAndView logIn(@RequestParam(name = "email") String email,
                               @RequestParam(name = "password") String password)
    {
        try {
            String pass = ar.findOne(email).getPassword();


            if (pass.equals(password)) {
                System.out.println("ACCESS GRANTED");
                ModelAndView mv = new ModelAndView("course");
                mv.getModel().put("courseList", cr.findAll());
                mv.getModel().put("course", "");
                return mv;
            } else {
                System.out.println("ACCESS DENIED _ INVALID PASSWORD");
                ModelAndView mv2 = new ModelAndView("admin");
                return mv2;
            }
        }catch (NullPointerException e){
            System.out.println("ACCESS DENIED _ INVALID USERNAME _ ?ALSO PASSWORD?");
            ModelAndView mv2 = new ModelAndView("admin");
            return mv2;
        }

    }

}
