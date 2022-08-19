package com.example.Task.Manager.Repositorty;

import com.example.Task.Manager.Dto.JoinResponseDto;
import com.example.Task.Manager.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select new com.example.Task.Manager.Dto.JoinResponseDto(t.taskId, t.taskTitle, t.taskDescription, t.taskPriority, t.createdAt,t.customerId,c.name, c.email, c.dob," +
            " c.phoneNumber) from Task t INNER JOIN t.customer_details c where t.isArchived =0 ")
    List<JoinResponseDto> getActiveTask();

    @Query("select new com.example.Task.Manager.Dto.JoinResponseDto(t.taskId, t.taskTitle, t.taskDescription, t.taskPriority, t.createdAt,t.customerId,c.name, c.email, c.dob, c.phoneNumber)" +
            " from Task t INNER JOIN t.customer_details c where t.taskId IN :tid")
    List<JoinResponseDto> findMultipleTask(@Param("tid") List<Long> tid);
}
