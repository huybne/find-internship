package com.internship.user_service.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private UUID id;
    @NotNull
    private String fullName;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String password;
    @NotNull
    private LocalDate dob;
    @NotNull
    private String address;
    @NotNull
    private boolean isActive;

    private Set<Role> roles;

    private CV CVs;

}
