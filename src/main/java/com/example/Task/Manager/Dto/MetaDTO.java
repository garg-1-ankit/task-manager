package com.example.Task.Manager.Dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaDTO {
    private String code;
    private String message;

    public MetaDTO(String code,String message){
        this.code = code;
        this.message = message;
    }
}
