package com.internship.user_service.service.impl;

import com.internship.user_service.dto.request.CreateRole;
import com.internship.user_service.dto.response.RoleResponse;
import com.internship.user_service.mapper.RoleBuilder;
import com.internship.user_service.mapper.RoleMapper;
import com.internship.user_service.model.Role;
import com.internship.user_service.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleMapper roleMapper;

    private RoleBuilder roleBuilder;
    // Lấy tất cả các role
    @Override
    public List<RoleResponse> getAllRoles() {
        List<Role> roles = roleMapper.findAll();
        return roles.stream()
                .map(roleBuilder::toRoleResponse)
                .collect(Collectors.toList());
    }

    // Tạo mới role
    @Override
    public void createRole(CreateRole createRole) {
        Role role = roleBuilder.toRole(createRole);
        roleMapper.insert(role);
    }

    // Cập nhật role
    @Override
    public void updateRole(String id, CreateRole createRole) {
        Role role = roleMapper.findById(id);
        role.setId(id);
        roleMapper.update(role);
    }

    // Xóa role
    @Override
    public void deleteRole(String id) {
        roleMapper.delete(id);
    }
}
