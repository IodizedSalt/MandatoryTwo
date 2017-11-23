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

    public Course() {

    }

    public Course(int id, String namee, String named) {
        this.id = id;
        this.namee = namee;
        this.named = named;

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

    public static List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> list){list = list;}



    public static Course getCourseById(long id){
        List<Course> list = Course.getCourseList();

        Course theOne = new Course(-1, "Dummy", "dummy");

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
                '}';
    }

}
