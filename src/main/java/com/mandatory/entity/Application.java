package com.mandatory.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriele on 28/11/2017.
 */
@Entity
public class Application {

    private static List<Application> appStatus = new ArrayList<>();

    @Id
    int id;
    @ManyToOne
    Course course;
    @ManyToOne
    Student student;
    private String status;


    public Application(int id, Course course , Student student, String status) {
        this.id = id;
        this.course = course;
        this.student = student;
        this.status = status;

    }

    public Application() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static List<Application> getAppStatus() {
        return appStatus;
    }

    public static void setAppStatus(List<Application> appStatus) {
        Application.appStatus = appStatus;
    }

    public static Application getAppById(Integer id){
        List<Application> list = Application.getAppStatus();

        Application theApp = new Application();
        for(int i = 0; i<list.size(); i++){
            Application a = list.get(i);
            if(a.getId() == id){
                System.out.println(a);
                theApp = a;
                break;
            }
        }
        return theApp;
    }
}
