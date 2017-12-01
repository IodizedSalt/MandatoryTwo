package com.mandatory.repository;

import com.mandatory.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Chris on 17-11-17.
 */
public interface TeacherRepository extends CrudRepository<Teacher, String> {
}
