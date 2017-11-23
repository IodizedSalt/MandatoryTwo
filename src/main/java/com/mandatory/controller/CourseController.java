package com.mandatory.controller;

import com.mandatory.repository.CourseRepository;
import com.mandatory.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CourseController {

    private static AtomicLong counter = new AtomicLong();

    @Autowired
    private CourseRepository cr;

    @RequestMapping("/courses")
    public List<Course> getAllCourses()
    {
        List<Course> courses = new ArrayList<>();
        cr.findAll().forEach(courses::add);
        return courses;
    }


    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable Integer id){
        return cr.findOne(id);
    }


    @RequestMapping(method = RequestMethod.POST, value ="/courses",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCourse(@RequestBody Course course){
        cr.save(course);
    }


    @GetMapping("/course/show")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView("course");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("course", "Here are the courses");
        return mv;
    }


    @RequestMapping(method = RequestMethod.DELETE, value ="courses/{id}")
    public void deleteCourse(@PathVariable Integer id){
        cr.delete(id);
    }


    @GetMapping(value = "/course/add")
    public ModelAndView name(){
        ModelAndView mv = new ModelAndView("addCourse");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("course", "");
        return mv;
    }


    @PostMapping("/course/add")
    public ModelAndView saveAndAdd(
            @RequestParam(name = "id", defaultValue = "-1")
                    int id,
            @RequestParam(name = "namee", defaultValue = "NO_NAMEE")
                    String namee,
            @RequestParam(name = "named", defaultValue = "NO_NAMED")
                    String named){

        Course c;
        System.out.println("in saveandget and id="+id);
        if (id != -1) {
            System.out.println("inside if and id="+id);
            Course.getCourseById(id).setNamee(namee);
            Course.getCourseById(id).setNamed(named);
            c = Course.getCourseById(id);
        } else {
            c = new Course((int)counter.incrementAndGet(), namee, named);
            Course.getCourseList().add(c);
        }
        cr.save(c);
        ModelAndView mv = new ModelAndView("addCourse");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("course", c);
        return mv;
    }


//
//    @RequestMapping(method = RequestMethod.PUT, value ="courses/{id}")
//    public void updateCourse(@RequestBody Course course, @PathVariable String id){
//        courseService.updateCourse(course);
//    }



}
