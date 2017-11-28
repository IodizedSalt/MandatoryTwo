package com.mandatory.controller;

import com.mandatory.entity.Course;
import com.mandatory.repository.AdminRepository;
import com.mandatory.repository.CourseRepository;
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
//    @GetMapping(value = "/courseedit")
//    public ModelAndView editUser(
//            @RequestParam(name = "id", defaultValue = "0")
//                    long id) {
//        System.out.println("id = " + id);
//        ModelAndView mv = new ModelAndView("edit");
//
//        mv.getModel().put("course", Course.getCourseById(id));
//
//        return mv;
//    }

}
