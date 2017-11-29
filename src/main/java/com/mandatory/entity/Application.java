package com.mandatory.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gabriele on 28/11/2017.
 */
@Entity
public class Application {

    @Id
    int id;
    @ManyToOne
    Course course;
    @ManyToOne
    Student student;


    public Application(int id, Course course , Student student) {
        this.id = id;
        this.course = course;
        this.student = student;

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
}
