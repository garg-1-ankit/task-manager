package com.example.TaskManager1.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestDto {
    private String name;
    private String email;
    private LocalDate dob;
    private String phoneNumber;
}
