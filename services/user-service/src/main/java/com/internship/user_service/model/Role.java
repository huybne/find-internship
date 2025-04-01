package com.internship.user_service.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String id;
    private String roleName;
    private String description;
}
