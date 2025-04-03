package com.internship.user_service.mapper;

import org.springframework.stereotype.Component;
import com.internship.user_service.dto.request.CreateRole;
import com.internship.user_service.dto.response.RoleResponse;
import com.internship.user_service.model.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleBuilder {
    public Role toRole(CreateRole createRole) {
        if (createRole == null) {
            return null;
        }
        return Role.builder()
                .roleName(createRole.getRoleName())
                .description(createRole.getDescription())
                .build();
    }

    public RoleResponse toRoleResponse(Role role) {
        if (role == null) {
            return null;
        }
        return RoleResponse.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .description(role.getDescription())
                .build();
    }
}
