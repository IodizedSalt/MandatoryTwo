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
    public ModelAndView logInStudent(){
        ModelAndView mv = new ModelAndView("student");
        return mv;
    }

    @GetMapping(value = "/student/apply")
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
                mvCourse.getModel().put("sid", studentEmail);
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

    @GetMapping(value ="student/applicatios")
    public  ModelAndView apply(
            @RequestParam(name = "S_id",defaultValue = "-1")String sid){
        ModelAndView mv = new ModelAndView("studentApplications");
        mv.getModel().put("applicationList", ar.findAll());
        return mv;
    }

    @PostMapping(value = "student/apply")
    public ModelAndView apply(
            @RequestParam(name = "cid", defaultValue = "-1") int cid,
            @RequestParam(name = "sid", defaultValue = "no_email") String sid)
    {
//        Student s = new Student("2","m","m");
//        List<Student> students = new ArrayList<>().add(s);
//                students.add(sr.findStudentByEmail(sid));
        Application application = new Application((int)counter.incrementAndGet(),cr.findOne(cid),sr.findStudentByEmail(sid), null);
        ar.save(application);

//        ModelAndView mv = new ModelAndView("studentApplication");
//        mv.getModel().put("applicationList", ar.findAll());

        return apply(sid);
    }


}
