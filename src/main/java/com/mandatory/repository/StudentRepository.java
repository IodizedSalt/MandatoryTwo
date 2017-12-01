package com.mandatory.repository;

import com.mandatory.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 17-11-17.
 */
public interface StudentRepository extends CrudRepository<Student, String> {
    public Student findStudentByEmail(String studentEmail);
//
//  List<Integer> appliedCourses = new ArrayList<>();

}
