package com.mandatory.controller;

import com.mandatory.repository.CourseRepository;
import com.mandatory.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository sr;
    @Autowired
    private CourseRepository cr;

    @GetMapping(value = "/student")
    public ModelAndView logInStudent(){
        ModelAndView mv = new ModelAndView("student");
        return mv;
    }

    @PostMapping(value = "/student")
    private ModelAndView logInStudent(@RequestParam(name = "studentemail") String studentEmail,
                               @RequestParam(name = "studentpassword") String studentPassword)
    {
        try {
            String sp = sr.findOne(studentEmail).getPassword();


            if (sp.equals(studentPassword)) {
                System.out.println("STUDENT ACCESS GRANTED");
                ModelAndView mvCourse = new ModelAndView("studentCourse");
                mvCourse.getModel().put("courseList", cr.findAll());
                mvCourse.getModel().put("studentCourse", "");
                return mvCourse;
            } else {
                System.out.println("ACCESS DENIED _ INVALID PASSWORD");
                ModelAndView mvStudent = new ModelAndView("student");
                return mvStudent;
            }
        }catch (NullPointerException e){
            System.out.println("ACCESS DENIED _ INVALID USERNAME _ ?ALSO PASSWORD?");
            ModelAndView mvStudent = new ModelAndView("student");
            return mvStudent;
        }

    }
    @PostMapping(value = "/apply")
    public ModelAndView apply(
            @RequestParam(name = "id", defaultValue = "-1") int id){
        if(id > 0){
            sr.appliedCourses.add(id);
        }
        ModelAndView mv = new ModelAndView("studentCourse");
        mv.getModel().put("courseList", cr.findAll());
        return mv;
    }


}
