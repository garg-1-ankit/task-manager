package com.example.Task.Manager.Service;

import com.example.Task.Manager.Dto.MetaDTO;
import com.example.Task.Manager.Dto.ResponseDto;
import com.example.Task.Manager.Dto.TaskDto;
import com.example.Task.Manager.Entity.Customer;
import com.example.Task.Manager.Repositorty.CustomerRepository;
import com.example.Task.Manager.converter.TaskConverter;
import com.example.Task.Manager.entity.Task;
import com.example.Task.Manager.Repositorty.TaskRepository;
import com.example.Task.Manager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        if(customerRepository.findById(customerId) != null){
            return taskRepository.save(task);
        }else throw new ResourceNotFoundException("Customer Id does not exist");

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
    public ResponseEntity<Task> deleteTask(Long taskId){
        if(taskId!=null){
            taskRepository.deleteById(taskId);
            return ResponseEntity.ok().build();
        }else throw new ResourceNotFoundException("Please enter Task Id");

    }

    public Task updateTask(TaskDto taskDto, Long taskId){
        Task currentTask =  taskRepository.findById(taskId)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found with id :"));
        if(taskDto.getTaskTitle()!=null)
            currentTask.setTaskTitle(taskDto.getTaskTitle());

        if(taskDto.getTaskDescription()!=null)
            currentTask.setTaskDescription(taskDto.getTaskDescription());

        Integer taskP = taskDto.getTaskPriority();
        if( taskP != null)
            currentTask.setTaskPriority(taskDto.getTaskPriority());

        if(taskDto.isArchived() == true || taskDto.isArchived() == false)
            currentTask.setIsArchived(taskDto.isArchived());
        return taskRepository.save(currentTask);
    }
}
