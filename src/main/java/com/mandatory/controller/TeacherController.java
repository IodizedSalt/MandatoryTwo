package com.mandatory.controller;

import com.mandatory.repository.ApplicationRepository;
import com.mandatory.repository.CourseRepository;
import com.mandatory.entity.Course;
import com.mandatory.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TeacherController {

    private static AtomicLong counter = new AtomicLong();

    @Autowired
    private CourseRepository cr;
    @Autowired
    private TeacherRepository tr;



    @GetMapping(value = "/teacher")
    public ModelAndView logInAdmin(){
        ModelAndView mv = new ModelAndView("teacherLogIn");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("course", "");
        return mv;

    }

    @PostMapping(value = "/teacher/loggedIn")
    private ModelAndView checkLogIn(@RequestParam(name = "teacheremail") String teacherEmail,
                                    @RequestParam(name = "teacherpassword") String teacherPassword)
    {
        try {
            String pass = tr.findOne(teacherEmail).getPassword();


            if (pass.equals(teacherPassword)) {
                System.out.println("ACCESS GRANTED");
                ModelAndView mv = new ModelAndView("teacherPage");
                mv.getModel().put("courseList", cr.findAll());
                mv.getModel().put("course", "");
                return mv;
            } else {
                System.out.println("ACCESS DENIED _ INVALID PASSWORD");
                ModelAndView mv2 = new ModelAndView("teacherLogIn");
                return mv2;
            }
        }catch (NullPointerException e){
            System.out.println("ACCESS DENIED _ INVALID USERNAME _ ?ALSO PASSWORD?");
            ModelAndView mv2 = new ModelAndView("teacherLogIn");
            return mv2;
        }

    }

//    //teacherPage.html
//    @GetMapping("/teacher/coureses")
//    public ModelAndView showCoureses(){
//        ModelAndView mv = new ModelAndView("teacherPage");
//        mv.getModel().put("courseList", cr.findAll());
//        return mv;
//    }

    @GetMapping(value = "/teacher/coureses/delete")
    public ModelAndView delete(
            @RequestParam(name = "ID", defaultValue = "-1") int id){
        if (id > 0) {
            cr.delete(id);
        }
        ModelAndView mv = new ModelAndView("teacherPage");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("course", "");
        return  mv;
    }

    @GetMapping(value = "/teacher/coureses/add")
    public ModelAndView Getadd(){
        ModelAndView mv = new ModelAndView("addCourse");
        return mv;
    }

    @PostMapping("/teacher/coureses/add")
    public ModelAndView PostAdd(
            @RequestParam(name = "ID", defaultValue = "-1")
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

        Course c = Course.getCourseById(id);
        if (id != -1) {
            c.setNamee(namee);
            c.setNamed(named);
            c.setStudyProgramme(studyProgramme);
            c.setMandElect(mandElect);
            c.setECTS(ECTS);
            c.setCourseLanguage(courseLanguage);
            c.setMinStud(minStud);
            c.setExpStud(expStud);
            c.setMaxStud(maxStud);
            c.setPrerequisite(prerequisite);
            c.setLearningOutcome(learningOutcome);
            c.setContent(content);
            c.setLearningActivity(learningActivity);
            c.setExamForm(examForm);
            c.setTeachers(teachers);
        } else {
            c = new Course((int)counter.incrementAndGet(), namee, named, studyProgramme, mandElect, ECTS, courseLanguage, minStud, expStud, maxStud, prerequisite, learningOutcome, content, learningActivity, examForm, teachers);
            Course.getCourseList().add(c);
        }
        cr.save(c);
        ModelAndView mv = new ModelAndView("teacherPage");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("course", c);
        return mv;
    }


    @GetMapping(value = "/teacher/coureses/edit")
    public ModelAndView getEdit(@RequestParam(name = "ID", defaultValue = "-1") int id)
    {
        Course c = cr.findOne(id);

        ModelAndView mv = new ModelAndView("editCourse");
        mv.getModel().put("ID",id);


        mv.getModel().put("namee",c.getNamee());
        mv.getModel().put("named",c.getNamed());
        mv.getModel().put("studyProgramme",c.getStudyProgramme());
        mv.getModel().put("mandElect",c.getMandElect());
        mv.getModel().put("ECTS",c.getECTS());
        mv.getModel().put("courseLanguage",c.getCourseLanguage());
        mv.getModel().put("minStud",c.getMinStud());
        mv.getModel().put("expStud",c.getExpStud());
        mv.getModel().put("maxStud",c.getMaxStud());
        mv.getModel().put("prerequisite",c.getPrerequisite());
        mv.getModel().put("learningOutcome",c.getLearningOutcome());
        mv.getModel().put("content",c.getContent());
        mv.getModel().put("learningActivity",c.getLearningActivity());
        mv.getModel().put("examForm",c.getExamForm());
        mv.getModel().put("teachers",c.getTeachers());

        return mv;
    }

    @PostMapping(value = "/teacher/coureses/edit")
    public ModelAndView edit(
            @RequestParam(name = "ID", defaultValue = "-1")
                    int id,
            @RequestParam(name = "namee", defaultValue = "NO_NAMEE")
                    String namee,
            @RequestParam(name = "named", defaultValue = "NO_NAMED")
                    String named,
            @RequestParam(name = "studyProgramme", defaultValue = "NO_STUDYPROGRAMME")
                    String studyProgramme,
            @RequestParam(name = "mandElect", defaultValue = "NO_STUDYPROGRAMME")
                    String mandElect,
            @RequestParam(name = "ECTS", defaultValue = "-1")
                    int ECTS,
            @RequestParam(name = "courseLanguage", defaultValue = "NO_COURSELANGUAGE")
                    String courseLanguage,
            @RequestParam(name = "minStud", defaultValue = "-1")
                    int minStud,
            @RequestParam(name = "expStud", defaultValue = "-1")
                    int expStud,
            @RequestParam(name = "maxStud", defaultValue = "-1")
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
        c = Course.getCourseById(id);
        c.setId(id);
        c.setNamee(namee);
        c.setNamed(named);
        c.setStudyProgramme(studyProgramme);
        c.setMandElect(mandElect);
        c.setECTS(ECTS);
        c.setCourseLanguage(courseLanguage);
        c.setMinStud(minStud);
        c.setExpStud(expStud);
        c.setMaxStud(maxStud);
        c.setPrerequisite(prerequisite);
        c.setLearningOutcome(learningOutcome);
        c.setContent(content);
        c.setLearningActivity(learningActivity);
        c.setExamForm(examForm);
        c.setTeachers(teachers);
        cr.save(c);

        ModelAndView mv = new ModelAndView("teacherPage");
        mv.getModel().put("courseList", cr.findAll());
        mv.getModel().put("course", "");
        return mv;
    }

}