package com.internship.user_service.model;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CV {

    private UUID id;
    private String userId;
    private String titleCV;
    // sẽ sửa cv detail thành file pdf sau
    private String CVDetail;
    private String target_job;
    private String university;
    private String experience;
    private Enum<Status> Status;
    private LocalDate createdAt;
    private LocalDate updatedAt;


}

