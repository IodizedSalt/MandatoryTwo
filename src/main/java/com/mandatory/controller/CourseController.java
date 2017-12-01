//package com.mandatory.controller;
//
//import com.mandatory.repository.CourseRepository;
//import com.mandatory.entity.Course;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//
//@RestController
//public class CourseController {
//
//    private static AtomicLong counter = new AtomicLong();
//
//    @Autowired
//    private CourseRepository cr;
//
//
//    //adminPage.html
//    @GetMapping("/course/show")
//    public ModelAndView show(){
//        ModelAndView mv = new ModelAndView("courses");
//        mv.getModel().put("courseList", cr.findAll());
//        return mv;
//    }
//
//    @GetMapping(value = "/course/show/delete")
//    public ModelAndView delete(
//            @RequestParam(name = "ID", defaultValue = "-1") int id){
//        if (id > 0) {
//            cr.delete(id);
//        }
//        ModelAndView mv = new ModelAndView("homepage");
//        return  mv;
//    }
//
//    @GetMapping(value = "/course/add")
//    public ModelAndView Getadd(){
//        ModelAndView mv = new ModelAndView("addCourse");
//        return mv;
//    }
//
//    @PostMapping("/course/add")
//    public ModelAndView PostAdd(
//            @RequestParam(name = "ID", defaultValue = "-1")
//                    int id,
//            @RequestParam(name = "namee", defaultValue = "NO_NAMEE")
//                    String namee,
//            @RequestParam(name = "named", defaultValue = "NO_NAMED")
//                    String named,
//            @RequestParam(name = "studyProgramme", defaultValue = "NO_STUDYPROGRAMME")
//                    String studyProgramme,
//            @RequestParam(name = "mandElect", defaultValue = "NO_STUDYPROGRAMME")
//                    String mandElect,
//            @RequestParam(name = "ECTS", defaultValue = "NO_ECTS")
//                    int ECTS,
//            @RequestParam(name = "courseLanguage", defaultValue = "NO_COURSELANGUAGE")
//                    String courseLanguage,
//            @RequestParam(name = "minStud", defaultValue = "NO_MINSTUDENTS")
//                    int minStud,
//            @RequestParam(name = "expStud", defaultValue = "NO_EXPSTUDENTS")
//                    int expStud,
//            @RequestParam(name = "maxStud", defaultValue = "NO_MAXSTUDENTS")
//                    int maxStud,
//            @RequestParam(name = "prerequisite", defaultValue = "NO_PREREQUISITE")
//                    String prerequisite,
//            @RequestParam(name = "learningOutcome", defaultValue = "NO_LEARNINGOUTCOME")
//                    String learningOutcome,
//            @RequestParam(name = "content", defaultValue = "NO_CONTENT")
//                    String content,
//            @RequestParam(name = "learningActivity", defaultValue = "NO_LEARNINGACTIVITY")
//                    String learningActivity,
//            @RequestParam(name = "examForm", defaultValue = "NO_EXAMFORM")
//                    String examForm,
//            @RequestParam(name = "teachers", defaultValue = "NO_TEACHERS")
//                    String teachers){
//
//        Course c = Course.getCourseById(id);
//        if (id != -1) {
//            c.setNamee(namee);
//            c.setNamed(named);
//            c.setStudyProgramme(studyProgramme);
//            c.setMandElect(mandElect);
//            c.setECTS(ECTS);
//            c.setCourseLanguage(courseLanguage);
//            c.setMinStud(minStud);
//            c.setExpStud(expStud);
//            c.setMaxStud(maxStud);
//            c.setPrerequisite(prerequisite);
//            c.setLearningOutcome(learningOutcome);
//            c.setContent(content);
//            c.setLearningActivity(learningActivity);
//            c.setExamForm(examForm);
//            c.setTeachers(teachers);
//        } else {
//            c = new Course((int)counter.incrementAndGet(), namee, named, studyProgramme, mandElect, ECTS, courseLanguage, minStud, expStud, maxStud, prerequisite, learningOutcome, content, learningActivity, examForm, teachers);
//            Course.getCourseList().add(c);
//        }
//        cr.save(c);
//        ModelAndView mv = new ModelAndView("homepage");
//        mv.getModel().put("courseList", cr.findAll());
//        mv.getModel().put("course", c);
//        return mv;
//    }
//
//
//    @GetMapping(value = "/course/show/edit")
//    public ModelAndView getEdit(@RequestParam(name = "ID", defaultValue = "-1") int id)
//    {
//        Course c = cr.findOne(id);
//
//        ModelAndView mv = new ModelAndView("editCourse");
//        mv.getModel().put("ID",id);
//
//
//        mv.getModel().put("namee",c.getNamee());
//        mv.getModel().put("named",c.getNamed());
//        mv.getModel().put("studyProgramme",c.getStudyProgramme());
//        mv.getModel().put("mandElect",c.getMandElect());
//        mv.getModel().put("ECTS",c.getECTS());
//        mv.getModel().put("courseLanguage",c.getCourseLanguage());
//        mv.getModel().put("minStud",c.getMinStud());
//        mv.getModel().put("expStud",c.getExpStud());
//        mv.getModel().put("maxStud",c.getMaxStud());
//        mv.getModel().put("prerequisite",c.getPrerequisite());
//        mv.getModel().put("learningOutcome",c.getLearningOutcome());
//        mv.getModel().put("content",c.getContent());
//        mv.getModel().put("learningActivity",c.getLearningActivity());
//        mv.getModel().put("examForm",c.getExamForm());
//        mv.getModel().put("teachers",c.getTeachers());
//
//        return mv;
//    }
//
//    @PostMapping(value = "/course/show/edit")
//    public ModelAndView edit(
//            @RequestParam(name = "ID", defaultValue = "-1")
//                    int id,
//            @RequestParam(name = "namee", defaultValue = "NO_NAMEE")
//                    String namee,
//            @RequestParam(name = "named", defaultValue = "NO_NAMED")
//                    String named,
//            @RequestParam(name = "studyProgramme", defaultValue = "NO_STUDYPROGRAMME")
//                    String studyProgramme,
//            @RequestParam(name = "mandElect", defaultValue = "NO_STUDYPROGRAMME")
//                    String mandElect,
//            @RequestParam(name = "ECTS", defaultValue = "-1")
//                    int ECTS,
//            @RequestParam(name = "courseLanguage", defaultValue = "NO_COURSELANGUAGE")
//                    String courseLanguage,
//            @RequestParam(name = "minStud", defaultValue = "-1")
//                    int minStud,
//            @RequestParam(name = "expStud", defaultValue = "-1")
//                    int expStud,
//            @RequestParam(name = "maxStud", defaultValue = "-1")
//                    int maxStud,
//            @RequestParam(name = "prerequisite", defaultValue = "NO_PREREQUISITE")
//                    String prerequisite,
//            @RequestParam(name = "learningOutcome", defaultValue = "NO_LEARNINGOUTCOME")
//                    String learningOutcome,
//            @RequestParam(name = "content", defaultValue = "NO_CONTENT")
//                    String content,
//            @RequestParam(name = "learningActivity", defaultValue = "NO_LEARNINGACTIVITY")
//                    String learningActivity,
//            @RequestParam(name = "examForm", defaultValue = "NO_EXAMFORM")
//                    String examForm,
//            @RequestParam(name = "teachers", defaultValue = "NO_TEACHERS")
//                    String teachers){
//
//            Course c;
//            c = Course.getCourseById(id);
//            c.setId(id);
//            c.setNamee(namee);
//            c.setNamed(named);
//            c.setStudyProgramme(studyProgramme);
//            c.setMandElect(mandElect);
//            c.setECTS(ECTS);
//            c.setCourseLanguage(courseLanguage);
//            c.setMinStud(minStud);
//            c.setExpStud(expStud);
//            c.setMaxStud(maxStud);
//            c.setPrerequisite(prerequisite);
//            c.setLearningOutcome(learningOutcome);
//            c.setContent(content);
//            c.setLearningActivity(learningActivity);
//            c.setExamForm(examForm);
//            c.setTeachers(teachers);
//            cr.save(c);
//
//        ModelAndView mv = new ModelAndView("homepage");
//        return mv;
//    }





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


//
//}