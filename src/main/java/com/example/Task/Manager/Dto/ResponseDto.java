package com.example.Task.Manager.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {
    private MetaDTO meta;
    private String data;
}
//    private long Id;
//    private String name;
//    private String email;
//    private LocalDate dob;
//    private String phoneNumber;