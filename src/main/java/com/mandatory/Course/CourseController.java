package com.mandatory.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gabriele on 22/11/2017.
 */
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getAllCourses()
    {
        return courseService.getAllCourses();
    }











    //    @RequestMapping("/topics/{topicId}/courses/{id}")
//    public Course getCourse(@PathVariable String id){
//        return courseService.getCourse(id);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value ="/topics/{topicId}/courses/")
//    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
//        course.setTopic(new Topic(topicId, "",""));
//        courseService.addCourse(course);x
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value ="/topics/{topicId}/courses/{id}")
//    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId){
//        course.setTopic(new Topic(topicId, "",""));
//        courseService.updateCours(course);
//    }
//    @RequestMapping(method = RequestMethod.DELETE, value ="/topics/{topicId}/courses/{id}")
//    public void deleteCourse(@PathVariable String id){
//        courseService.deleteCourse(id);
//    }



}
