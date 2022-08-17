package com.example.Task.Manager.Dto;

import lombok.Data;

@Data
public class TaskDto {
    private String taskTitle;
    private String taskDescription;
    private Long customerId;
    private int taskPriority;
    private boolean isArchived;
}
