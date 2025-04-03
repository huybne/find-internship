package com.internship.user_service.service;

import com.internship.user_service.dto.request.CreateRole;
import com.internship.user_service.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    // Lấy tất cả các role
    List<RoleResponse> getAllRoles();

    // Tạo mới role
    void createRole(CreateRole createRole);

    // Cập nhật role
    void updateRole(String id, CreateRole createRole);

    // Xóa role
    void deleteRole(String id);
}
