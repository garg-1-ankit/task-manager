package com.example.Task.Manager.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinResponseDto {
    private Long taskId;
    private String taskTitle;
    private String taskDescription;
    private int taskPriority;
    private Date createdAt;
    private Long customerId;
    private String name;
    private String email;
    private LocalDate dob;
    private String phoneNumber;

}
