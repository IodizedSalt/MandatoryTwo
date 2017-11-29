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
        ModelAndView mv = new ModelAndView("admin");
        return mv;

    }

    @PostMapping(value = "/admin")
    private ModelAndView logInAdmin(@RequestParam(name = "adminemail") String adminEmail,
                               @RequestParam(name = "adminpassword") String adminPassword)
    {
        try {
            String pass = ar.findOne(adminEmail).getPassword();


            if (pass.equals(adminPassword)) {
                System.out.println("ACCESS GRANTED");
                ModelAndView mv = new ModelAndView("courses");
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
    @GetMapping(value = "/studentApplications")
    public ModelAndView manageApps(){
//            @RequestParam(name = "id", defaultValue = "0")
//                    long id) {
//        System.out.println("id = " + id);
        ModelAndView mv = new ModelAndView("studentApplications");
        mv.getModel().put("pending","pending");

        mv.getModel().put("applicationList", r.findAll());

        return mv;
    }
//    @GetMapping(value = "/approve")
//    public ModelAndView approveApp(){
//        ModelAndView mv = new ModelAndView("studentApplications");
//        return mv;
//    }
    @PostMapping(value = "/approve")
    public ModelAndView approveApp(@RequestParam(name = "id", defaultValue = "-1") int id)
    {

        System.out.println(id);
        Application a= r.findOne(id);
        a.setStatus("approved");
        r.save(a);
        System.out.println("save to db a great success");


        ModelAndView mv = new ModelAndView("studentApplications");
        mv.getModel().put("pending","pending");

        mv.getModel().put("applicationList", r.findAll());
        return mv;
    }
    @PostMapping(value = "/reject")
    public ModelAndView rejectApp(@RequestParam(name = "id", defaultValue = "-1") int id)
    {

        System.out.println(id);
        Application a= r.findOne(id);
        a.setStatus("reject");
        r.save(a);
        System.out.println("save to db a great success");


        ModelAndView mv = new ModelAndView("studentApplications");
        mv.getModel().put("pending","pending");

        mv.getModel().put("applicationList", r.findAll());
        return mv;
    }

}
