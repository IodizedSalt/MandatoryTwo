package com.mandatory.Course;

import javax.persistence.*;

/**
 * Created by gabriele on 22/11/2017.
 */
    @Entity
    public class Course {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String namee;
    private String named;

    public Course() {

    }

    public Course(Integer id, String namee, String named) {
        this.id = id;
        namee = namee;
        named = named;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getnamee() {
        return namee;
    }

    public void setnamee(String namee) {
        namee = namee;
    }

    public String getnamed(){
        return named;
    }

    public void setNameD(String named) {
        named = named;
    }

}
