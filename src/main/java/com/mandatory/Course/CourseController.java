package com.mandatory.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gabriele on 22/11/2017.
 */
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository cr;

    @RequestMapping("/courses")
    public List<Course> getAllCourses()
    {
        return courseService.getAllCourses();
    }


    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable Integer id){
        return courseService.getCourse(id);
    }




    @RequestMapping(method = RequestMethod.POST, value ="/courses",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }



    @GetMapping("/course/show")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView("course");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("course", "Here are the courses");
        return mv;
    }

    //DOESN'T WORK
//    @RequestMapping(value = "/course/show", method = RequestMethod.GET)
//    public ModelAndView show(
//        @RequestParam(name = "id",defaultValue = "NO_ID")
//        String id,
//        @RequestParam(name = "namee", defaultValue = "NO_NAMED")
//        String namee,
//        @RequestParam(name = "named", defaultValue = "NO_NAMED")
//        String named){
//
//
//
//        Course course = new Course();
//        course.setNamee(namee);
//        course.setNamed(named);
//        cr.save(course);
//
//        ModelAndView mv = new ModelAndView("course");
//        mv.getModel().put("usersList", cr.findAll());
//        mv.getModel().put("Couse", course);
//
//        return mv;
//
//    }


    @RequestMapping(method = RequestMethod.DELETE, value ="courses/{id}")
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }
//    @RequestMapping(method = RequestMethod.PUT, value ="/topics/{topicId}/courses/{id}")
//    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId){
//        course.setTopic(new Topic(topicId, "",""));
//        courseService.updateCours(course);
//    }




//TO DO
//    @RequestMapping(method = RequestMethod.PUT, value ="/topics/{topicId}/courses/{id}")
//    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId){
//        course.setTopic(new Topic(topicId, "",""));
//        courseService.updateCours(course);
//    }




}
