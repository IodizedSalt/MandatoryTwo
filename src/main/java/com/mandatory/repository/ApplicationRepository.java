package com.mandatory.repository;

import com.mandatory.entity.Application;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gabriele on 28/11/2017.
 */
public interface ApplicationRepository extends CrudRepository<Application,Integer> {
    public Application findAppById(Integer id);
}
