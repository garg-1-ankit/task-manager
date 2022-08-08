package com.example.TaskManager1.Dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ResponseDto {
    private long Id;
    private String name;
    private String email;
    private LocalDate dob;
    private String phoneNumber;
}
