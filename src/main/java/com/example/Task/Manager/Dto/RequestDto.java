package com.example.Task.Manager.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestDto {
    private String name;
    private String email;
    private LocalDate dob;
    private String phoneNumber;
}
