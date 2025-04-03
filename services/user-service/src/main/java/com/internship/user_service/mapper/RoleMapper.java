package com.internship.user_service.mapper;

import com.internship.user_service.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<Role> findAll();

    Role findById(String id);

    void insert(Role role);

    void update(Role role);

    void delete(String id);
}
