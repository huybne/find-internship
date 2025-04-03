package com.internship.user_service.controller;

import com.internship.user_service.dto.ApiResponse;
import com.internship.user_service.dto.request.CreateRole;
import com.internship.user_service.dto.response.RoleResponse;
import com.internship.user_service.service.RoleService;
import com.internship.user_service.exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    // Lấy tất cả các role
    @GetMapping
    public ResponseEntity<ApiResponse<List<RoleResponse>>> getAllRoles() {
        try {
            List<RoleResponse> roles = roleService.getAllRoles();
            return ResponseEntity.ok(ApiResponse.<List<RoleResponse>>builder()
                    .success(true)
                    .data(roles)
                    .build());
        } catch (Exception e) {
            throw new Exception(400, "Error fetching roles: " + e.getMessage());
        }
    }

    // Tạo mới role
    @PostMapping
    public ResponseEntity<ApiResponse<String>> createRole(@RequestBody CreateRole createRole) {
        try {
            roleService.createRole(createRole);
            return ResponseEntity.ok(ApiResponse.<String>builder()
                    .success(true)
                    .data("Role created successfully")
                    .build());
        } catch (Exception e) {
            throw new Exception(400, "Error creating role: " + e.getMessage());
        }
    }

    // Cập nhật role
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateRole(@PathVariable String id, @RequestBody CreateRole createRole) {
        try {
            roleService.updateRole(id, createRole);
            return ResponseEntity.ok(ApiResponse.<String>builder()
                    .success(true)
                    .data("Role updated successfully")
                    .build());
        } catch (Exception e) {
            throw new Exception(400, "Error updating role: " + e.getMessage());
        }
    }

    // Xóa role
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteRole(@PathVariable String id) {
        try {
            roleService.deleteRole(id);
            return ResponseEntity.ok(ApiResponse.<String>builder()
                    .success(true)
                    .data("Role deleted successfully")
                    .build());
        } catch (Exception e) {
            throw new Exception(400, "Error deleting role: " + e.getMessage());
        }
    }
}
