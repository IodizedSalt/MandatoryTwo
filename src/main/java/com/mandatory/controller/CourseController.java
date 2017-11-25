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


    @PostMapping(value = "/")
    public ModelAndView delete(
            @RequestParam(name = "id", defaultValue = "-1") int id){
        if (id > 0) {
            cr.delete(id);
        }
        ModelAndView mv = new ModelAndView("homepage");
        return  mv;
    }


    @GetMapping(value = "/course/add")
    public ModelAndView Getadd(){
        ModelAndView mv = new ModelAndView("addCourse");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("course", "");
        return mv;
    }


    @PostMapping("/course/add")
    public ModelAndView PostAdd(
            @RequestParam(name = "id", defaultValue = "-1")
                    int id,
            @RequestParam(name = "namee", defaultValue = "NO_NAMEE")
                    String namee,
            @RequestParam(name = "named", defaultValue = "NO_NAMED")
                    String named,
            @RequestParam(name = "studyProgramme", defaultValue = "NO_STUDYPROGRAMME")
                    String studyProgramme,
            @RequestParam(name = "mandElect", defaultValue = "NO_STUDYPROGRAMME")
                    String mandElect,
            @RequestParam(name = "ECTS", defaultValue = "NO_ECTS")
                    int ECTS,
            @RequestParam(name = "courseLanguage", defaultValue = "NO_COURSELANGUAGE")
                    String courseLanguage,
            @RequestParam(name = "minStud", defaultValue = "NO_MINSTUDENTS")
                    int minStud,
            @RequestParam(name = "expStud", defaultValue = "NO_EXPSTUDENTS")
                    int expStud,
            @RequestParam(name = "maxStud", defaultValue = "NO_MAXSTUDENTS")
                    int maxStud,
            @RequestParam(name = "prerequisite", defaultValue = "NO_PREREQUISITE")
                    String prerequisite,
            @RequestParam(name = "learningOutcome", defaultValue = "NO_LEARNINGOUTCOME")
                    String learningOutcome,
            @RequestParam(name = "content", defaultValue = "NO_CONTENT")
                    String content,
            @RequestParam(name = "learningActivity", defaultValue = "NO_LEARNINGACTIVITY")
                    String learningActivity,
            @RequestParam(name = "examForm", defaultValue = "NO_EXAMFORM")
                    String examForm,
            @RequestParam(name = "teachers", defaultValue = "NO_TEACHERS")
                    String teachers){

        Course c;
        System.out.println("in saveandget and id="+id);
        if (id != -1) {
            System.out.println("inside if and id="+id);
            Course.getCourseById(id).setNamee(namee);
            Course.getCourseById(id).setNamed(named);
            Course.getCourseById(id).setStudyProgramme(studyProgramme);
            Course.getCourseById(id).setMandElect(mandElect);
            Course.getCourseById(id).setECTS(ECTS);
            Course.getCourseById(id).setCourseLanguage(courseLanguage);
            Course.getCourseById(id).setMinStud(minStud);
            Course.getCourseById(id).setExpStud(expStud);
            Course.getCourseById(id).setMaxStud(maxStud);
            Course.getCourseById(id).setPrerequisite(prerequisite);
            Course.getCourseById(id).setLearningOutcome(learningOutcome);
            Course.getCourseById(id).setContent(content);
            Course.getCourseById(id).setLearningActivity(learningActivity);
            Course.getCourseById(id).setExamForm(examForm);
            Course.getCourseById(id).setTeachers(teachers);

            c = Course.getCourseById(id);
        } else {
            c = new Course((int)counter.incrementAndGet(), namee, named, studyProgramme, mandElect, ECTS, courseLanguage, minStud, expStud, maxStud, prerequisite, learningOutcome, content, learningActivity, examForm, teachers);
            Course.getCourseList().add(c);
        }
        cr.save(c);
        ModelAndView mv = new ModelAndView("addCourse");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("course", c);
        return mv;
    }





    // GET ALL
    //    @RequestMapping("/courses")
    //    public List<Course> getAllCourses()
    //    {
    //        List<Course> courses = new ArrayList<>();
    //        cr.findAll().forEach(courses::add);
    //        return courses;
    //    }
    // GET ONE
    //    @GetMapping("/courses/{id}")
    //    public Course getCourse(@PathVariable Integer id){
    //        return cr.findOne(id);
    //    }
    //ADD
    //    @RequestMapping(method = RequestMethod.POST, value ="/courses",consumes = MediaType.APPLICATION_JSON_VALUE)
    //    public void addCourse(@RequestBody Course course){
    //        cr.save(course);
    //    }
    //DELETE
    //    @RequestMapping(method = RequestMethod.DELETE, value ="courses/{id}")
    //    public void deleteCourse(@PathVariable Integer id){
    //        cr.delete(id);
    //    }
    //UPDATE
    //    @RequestMapping(method = RequestMethod.PUT, value ="courses/{id}")
    //    public void updateCourse(@RequestBody Course course, @PathVariable String id){
    //        courseService.updateCourse(course);
    //    }



}
