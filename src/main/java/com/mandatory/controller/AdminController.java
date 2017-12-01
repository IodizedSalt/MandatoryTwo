package com.mandatory.controller;

import com.mandatory.entity.Application;
import com.mandatory.entity.Course;
import com.mandatory.repository.AdminRepository;
import com.mandatory.repository.ApplicationRepository;
import com.mandatory.repository.CourseRepository;
import com.mandatory.repository.StudentRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {

    @Autowired
    private AdminRepository ar;

    @Autowired
    private CourseRepository cr;
    @Autowired
    private StudentRepository sr;
    @Autowired
    private ApplicationRepository r;


    @GetMapping(value = "/admin")
    public ModelAndView logInAdmin(){
        ModelAndView mv = new ModelAndView("adminLogIn");
        return mv;

    }

    @PostMapping(value = "/admin/loggedIn")
    private ModelAndView checkLogIn(@RequestParam(name = "adminemail") String adminEmail,
                               @RequestParam(name = "adminpassword") String adminPassword)
    {
        try {
            String pass = ar.findOne(adminEmail).getPassword();


            if (pass.equals(adminPassword)) {
                System.out.println("ACCESS GRANTED");
                ModelAndView mv = new ModelAndView("adminPage");
                mv.getModel().put("courseList", cr.findAll());
                mv.getModel().put("course", "");
                return mv;
            } else {
                System.out.println("ACCESS DENIED _ INVALID PASSWORD");
                ModelAndView mv2 = new ModelAndView("adminLogIn");
                return mv2;
            }
        }catch (NullPointerException e){
            System.out.println("ACCESS DENIED _ INVALID USERNAME _ ?ALSO PASSWORD?");
            ModelAndView mv2 = new ModelAndView("adminLogIn");
            return mv2;
        }

    }
    @GetMapping(value = "/admin/applications")
    public ModelAndView ApplicationsPage(){
        ModelAndView mv = new ModelAndView("adminApplications");
        mv.getModel().put("pending","pending");
        mv.getModel().put("applicationList", r.findAll());

        return mv;
    }

    @PostMapping(value = "/admin/applications/approve")
    public ModelAndView approve(@RequestParam(name = "id", defaultValue = "-1") int id)
    {

        System.out.println(id);
        Application a= r.findOne(id);
        a.setStatus("approved");
        r.save(a);

        ModelAndView mv = new ModelAndView("adminApplications");
        mv.getModel().put("pending","pending");

        mv.getModel().put("applicationList", r.findAll());
        return mv;
    }

    @PostMapping(value = "/admin/applications/reject")
    public ModelAndView reject(@RequestParam(name = "id", defaultValue = "-1") int id)
    {

        System.out.println(id);
        Application a= r.findOne(id);
        a.setStatus("reject");
        r.save(a);

        ModelAndView mv = new ModelAndView("adminApplications");
        mv.getModel().put("pending","pending");

        mv.getModel().put("applicationList", r.findAll());
        return mv;
    }

}
