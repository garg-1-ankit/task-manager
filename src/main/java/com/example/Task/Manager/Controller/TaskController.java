package com.example.Task.Manager.Controller;

import com.example.Task.Manager.Dto.ResponseDto;
import com.example.Task.Manager.Dto.TaskDto;
import com.example.Task.Manager.Dto.TaskRequestDto;
import com.example.Task.Manager.Entity.Task;
import com.example.Task.Manager.Routes;
import com.example.Task.Manager.Service.TaskService;
import com.example.Task.Manager.converter.TaskConverter;
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

    @GetMapping(Routes.GET_ACTIVE_TASK)
    public ResponseDto getActiveTask(){
        return taskService.getactiveTask();
    }
    @PostMapping(Routes.GET_MULTIPLE_TASK)
    public ResponseDto findMultipleTask(@RequestBody TaskRequestDto taskRequestDto){
        return taskService.findMultipleTask(taskRequestDto);
    }
    @DeleteMapping(Routes.DELETE_TASK)
    public ResponseDto deleteTask(@PathVariable Long taskId){
         return taskService.deleteTask(taskId);
    }

    @PutMapping(Routes.UPDATE_TASK)
    public ResponseDto updateTask(@RequestBody TaskDto taskDto, @PathVariable Long taskId){
        return taskService.updateTask(taskDto,taskId);
    }

    @PutMapping(Routes.TOGGLE_TASK_ACTIVATION)
    public ResponseDto toggleActivation(@PathVariable Long taskId){
        return taskService.toggleActivation(taskId);
    }

}
