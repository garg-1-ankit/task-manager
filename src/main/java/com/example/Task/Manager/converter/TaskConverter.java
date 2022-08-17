package com.example.Task.Manager.converter;

import com.example.Task.Manager.Dto.TaskDto;
import com.example.Task.Manager.Entity.Task;
import com.example.Task.Manager.Entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class TaskConverter {

    public TaskDto entityToDto(Task task){

        TaskDto dto = new TaskDto();
        dto.setTaskTitle(task.getTaskTitle());
        dto.setTaskDescription(task.getTaskDescription());
        dto.setCustomerId(task.getCustomerId());
        dto.setTaskPriority(task.getTaskPriority());
        dto.setArchived(task.getIsArchived());
        return dto;
    }

    public Task dtoToEntity(TaskDto dto){
        Task newTask = new Task();
        newTask.setTaskTitle(dto.getTaskTitle());
        newTask.setTaskDescription(dto.getTaskDescription());
        newTask.setCustomerId(dto.getCustomerId());
        newTask.setTaskPriority(dto.getTaskPriority());
        newTask.setIsArchived(dto.isArchived());
        return newTask;
    }

    public List<TaskDto> entityToDto(List<Task> task){

        return task.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public List<Task> dtoToEntity(List<TaskDto> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
