package com.example.Task.Manager.Controller;

import com.example.Task.Manager.Dto.ResponseDto;
import com.example.Task.Manager.Dto.TaskDto;
import com.example.Task.Manager.Routes;
import com.example.Task.Manager.Service.TaskService;
import com.example.Task.Manager.converter.TaskConverter;
import com.example.Task.Manager.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    TaskConverter taskConverter;

    @PostMapping(Routes.ADD_TASK)
    public TaskDto addTask(@RequestBody TaskDto taskDto){
        Task task = taskConverter.dtoToEntity(taskDto);
        return taskConverter.entityToDto(taskService.addTask(task));
    }

    @GetMapping(Routes.GET_TASK)
    public ResponseDto getAllTask(){
        return taskService.getTask();
    }

    @GetMapping(Routes.FIND_TASK)
    public ResponseDto findTask(@PathVariable Long taskId){
        return taskService.findTaskById(taskId);
    }

    @DeleteMapping(Routes.DELETE_TASK)
    public void deleteTask(@PathVariable Long taskId){
         taskService.deleteTask(taskId);
    }

    @PutMapping(Routes.UPDATE_TASK)
    public void updateTask(@RequestBody TaskDto taskDto, @PathVariable Long taskId){
        taskService.updateTask(taskDto,taskId);
    }


}
