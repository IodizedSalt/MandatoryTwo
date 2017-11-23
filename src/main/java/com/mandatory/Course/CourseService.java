package com.mandatory.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriele on 22/11/2017.
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }


    public Course getCourse(Integer id){
        return courseRepository.findOne(id);
    }


    //DOESN'T WORK
    public void addCourse(Course course) {
        courseRepository.save(course);

    }

    public void deleteCourse(Integer id) {
        courseRepository.delete(id);
    }

//    public void updateCours(Course course) {
//        courseRepository.save(course);
//    }


}
