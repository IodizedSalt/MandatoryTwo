package com.mandatory.controller;

import com.mandatory.entity.Application;
import com.mandatory.entity.Course;
import com.mandatory.entity.Student;
import com.mandatory.repository.ApplicationRepository;
import com.mandatory.repository.CourseRepository;
import com.mandatory.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository sr;
    @Autowired
    private CourseRepository cr;
    @Autowired
    private ApplicationRepository ar;

    private static AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/student")
    public ModelAndView logInPage(){
        ModelAndView mv = new ModelAndView("studentLogIn");
        return mv;
    }

    @GetMapping(value = "/student/loggedIn")
    private void checkLogIn()
    {
    }

    @PostMapping(value = "/student/loggedIn")
    private ModelAndView checkLogIn(@RequestParam(name = "studentemail") String studentEmail,
                                    @RequestParam(name = "studentpassword") String studentPassword)
    {
        try {
            String sp = sr.findOne(studentEmail).getPassword();
            System.out.println(sp.toString());


            if (sp.equals(studentPassword)) {
                System.out.println("STUDENT ACCESS GRANTED");
                ModelAndView mvCourse = new ModelAndView("studentPage");
                mvCourse.getModel().put("courseList", cr.findAll());
                mvCourse.getModel().put("sid", studentEmail);
                return mvCourse;
            } else {
                System.out.println("ACCESS DENIED _ INVALID PASSWORD");
                ModelAndView mvStudent = new ModelAndView("studentLogIn");
                return mvStudent;
            }
        }catch (NullPointerException e){
            System.out.println("ACCESS DENIED _ INVALID USERNAME _ ?ALSO PASSWORD?");
            ModelAndView mvStudent = new ModelAndView("studentLogIn");
            return mvStudent;
        }

    }

    @PostMapping(value = "student/apply")
    public ModelAndView apply(
            @RequestParam(name = "cid", defaultValue = "-1") int cid,
            @RequestParam(name = "sid", defaultValue = "no_email") String sid)
    {
        Application application = new Application((int)counter.incrementAndGet(),cr.findOne(cid),sr.findStudentByEmail(sid),"pending");
        ar.save(application);

        //Reload the page after applying for course
        ModelAndView mv = new ModelAndView("studentPage");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("sid", sid);
        return mv;
    }

    @GetMapping(value ="student/applications")
    public  ModelAndView showApplications(
            @RequestParam( name = "sid",defaultValue = "no_sid")String sid){
        ModelAndView mv = new ModelAndView("studentApplications");
        mv.getModel().put("applicationList", ar.findAll());
        mv.getModel().put("sid",sid);
        return mv;
    }


}
