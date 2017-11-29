package com.mandatory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private String email;
    private String name;
    private String password;

    public Student(){

    }

    public Student(String email, String name, String password){
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "email=" + email +
                ", passeword='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
