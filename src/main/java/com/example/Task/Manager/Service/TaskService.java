package com.example.Task.Manager.Service;

import com.example.Task.Manager.Dto.*;
import com.example.Task.Manager.Repositorty.CustomerRepository;
import com.example.Task.Manager.Entity.Task;
import com.example.Task.Manager.Repositorty.TaskRepository;
import com.example.Task.Manager.exception.ResourceNotFoundException;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CustomerRepository customerRepository;
    public Task addTask(Task task) {
        Long customerId = task.getCustomerId();
        this.customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer with id "+ customerId+" dosen't exist" ));
          return taskRepository.save(task);

    }
    public ResponseDto getTask(){
        ResponseDto responseDto = new ResponseDto();
        MetaDTO metaDTO = new MetaDTO("success","200");
        responseDto.setMeta(metaDTO);
        List<Task> result = taskRepository.findAll();
        responseDto.setData(result
                .stream().collect(Collectors.toList()).toString());
        return responseDto;
    }
    public ResponseDto findTaskById(Long taskId) {
        if (taskId != null) {
            Task result = taskRepository.findById(taskId)
                         .orElseThrow(() -> new ResourceNotFoundException("Task not found with id :" + taskId));
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMeta(new MetaDTO("success", "200"));
            responseDto.setData(result.toString());
            return responseDto;
        } else throw new ResourceNotFoundException("Please enter Task Id");
    }
    public ResponseDto deleteTask(Long taskId){
        if(taskId!=null){
            taskRepository.deleteById(taskId);
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMeta(new MetaDTO("success", "200"));
            responseDto.setData("Task "+taskId+" deleted successfully");
            return responseDto;
        }else throw new ResourceNotFoundException("Please enter Task Id");

    }

    public ResponseDto updateTask(TaskDto taskDto, Long taskId){
        ResponseDto responseDto = new ResponseDto();
        Task currentTask =  taskRepository.findById(taskId)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found with id :"+ taskId));

        if(taskDto.getTaskTitle()!=null ||  !taskDto.getTaskTitle().isEmpty()){
            currentTask.setTaskTitle(taskDto.getTaskTitle());}

        if(taskDto.getTaskDescription()!=null || !taskDto.getTaskDescription().isEmpty())
            currentTask.setTaskDescription(taskDto.getTaskDescription());

        Integer taskP = taskDto.getTaskPriority();
        if( taskP != null)
            currentTask.setTaskPriority(taskDto.getTaskPriority());

        if(taskDto.isArchived() == true || taskDto.isArchived() == false)
            currentTask.setIsArchived(taskDto.isArchived());
        taskRepository.save(currentTask);
        responseDto.setData("UPDATED");
        MetaDTO metaDTO = new MetaDTO("success","200");
        responseDto.setMeta(metaDTO);
        return responseDto;
    }

    public ResponseDto toggleActivation(Long taskId){
        ResponseDto responseDto = new ResponseDto();
        Task currentTask =  taskRepository.findById(taskId)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found with id :"+ taskId));
        if(currentTask.getIsArchived() == true) {
            currentTask.setIsArchived(false);
            responseDto.setData("Task "+taskId+" is ACTIVE now");
        }
        else {
            currentTask.setIsArchived(true);
            responseDto.setData("Task "+taskId+" is ARCHIVED now");
        }
        taskRepository.save(currentTask);
        MetaDTO metaDTO = new MetaDTO("success","200");
        responseDto.setMeta(metaDTO);
        return responseDto;
    }

    public ResponseDto getactiveTask(){
        ResponseDto responseDto = new ResponseDto();
        List<JoinResponseDto> result = taskRepository.getActiveTask();
        responseDto.setData(result
                .stream().collect(Collectors.toList()).toString());
        MetaDTO metaDTO = new MetaDTO("success","200");
        responseDto.setMeta(metaDTO);
        return responseDto;
    }

    public ResponseDto findMultipleTask(TaskRequestDto taskRequestDto){
        ResponseDto responseDto = new ResponseDto();
        List<Long> id = taskRequestDto.getTaskId();
        List<JoinResponseDto> result = taskRepository.findMultipleTask(id);
        responseDto.setData(result
                .stream().collect(Collectors.toList()).toString());
        MetaDTO metaDTO = new MetaDTO("success","200");
        responseDto.setMeta(metaDTO);
        return responseDto;
    }


}
