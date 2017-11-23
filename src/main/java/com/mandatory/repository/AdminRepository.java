package com.mandatory.repository;

import com.mandatory.entity.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Chris on 16-11-17.
 */
public interface AdminRepository extends CrudRepository<Admin, String> {
    public Admin findAdminByEmail(String email);

}
