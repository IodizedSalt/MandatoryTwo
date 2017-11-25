package com.mandatory.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriele on 22/11/2017.
 */
    @Entity
    public class Course {

    private static List<Course> courseList = new ArrayList<>();


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String namee;
    private String named;
    private String studyProgramme;
    private String mandElect;
    private int ECTS;
    private String courseLanguage;
    private int minStud;
    private int expStud;
    private int maxStud;
    private String prerequisite;
    private String learningOutcome;
    private String content;
    private String learningActivity;
    private String examForm;
    private String teachers;


    public Course() {

    }

    public Course(int id,String namee, String named, String studyProgramme, String mandElect, int ECTS, String courseLanguage, int minStud, int expStud, int maxStud, String prerequisite, String learningOutcome, String content, String learningActivity, String examForm, String teachers) {
        this.id = id;
        this.namee = namee;
        this.named = named;
        this.studyProgramme = studyProgramme;
        this.mandElect = mandElect;
        this.ECTS = ECTS;
        this.courseLanguage = courseLanguage;
        this.minStud = minStud;
        this.expStud = expStud;
        this.maxStud = maxStud;
        this.prerequisite = prerequisite;
        this.learningOutcome = learningOutcome;
        this.content = content;
        this.learningActivity = learningActivity;
        this.examForm = examForm;
        this.teachers = teachers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getNamed() {
        return named;
    }

    public void setNamed(String named) {
        this.named = named;
    }

    public String getStudyProgramme() {
        return studyProgramme;
    }

    public void setStudyProgramme(String studyProgramme) {
        this.studyProgramme = studyProgramme;
    }

    public String getMandElect() {
        return mandElect;
    }

    public void setMandElect(String mandElect) {
        this.mandElect = mandElect;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public String getCourseLanguage() {
        return courseLanguage;
    }

    public void setCourseLanguage(String courseLanguage) {
        this.courseLanguage = courseLanguage;
    }

    public int getMinStud() {
        return minStud;
    }

    public void setMinStud(int minStud) {
        this.minStud = minStud;
    }

    public int getExpStud() {
        return expStud;
    }

    public void setExpStud(int expStud) {
        this.expStud = expStud;
    }

    public int getMaxStud() {
        return maxStud;
    }

    public void setMaxStud(int maxStud) {
        this.maxStud = maxStud;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(String learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLearningActivity() {
        return learningActivity;
    }

    public void setLearningActivity(String learningActivity) {
        this.learningActivity = learningActivity;
    }

    public String getExamForm() {
        return examForm;
    }

    public void setExamForm(String examForm) {
        this.examForm = examForm;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public static List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> list){list = list;}



    public static Course getCourseById(long id){
        List<Course> list = Course.getCourseList();

        Course theOne = new Course(-1, "English", "Danisyh", "CompSci", "Mandatory", 10, "English", 2, 6, 15,"None", "DevOps", "Some comp stuff", "many activities", "AnExam", "Professors");
        for (int i = 0; i < list.size(); i++) {
            Course u = list.get(i);
            if (u.getId() == id) {
                System.out.println(u);
                theOne = u;
                break;
            }
        }
        return theOne;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", namee='" + namee + '\'' +
                ", named='" + named + '\'' +
                ", studyProgramme='" + studyProgramme + '\'' +
                ", mandElect='" + mandElect + '\'' +
                ", ECTS=" + ECTS +
                ", courseLanguage='" + courseLanguage + '\'' +
                ", minStud=" + minStud +
                ", expStud=" + expStud +
                ", maxStud=" + maxStud +
                ", prerequisite='" + prerequisite + '\'' +
                ", learningOutcome='" + learningOutcome + '\'' +
                ", content='" + content + '\'' +
                ", learningActivity='" + learningActivity + '\'' +
                ", examForm='" + examForm + '\'' +
                ", teachers='" + teachers + '\'' +
                '}';
    }
}
