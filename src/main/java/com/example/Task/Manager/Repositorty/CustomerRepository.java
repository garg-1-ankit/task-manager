package com.example.Task.Manager.Repositorty;

import com.example.Task.Manager.Dto.JoinResponseDto;
import com.example.Task.Manager.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("select new com.example.Task.Manager.Dto.JoinResponseDto(t.taskId, t.taskTitle, t.taskDescription, t.taskPriority, t.createdAt,t.customerId,c.name, c.email, c.dob, c.phoneNumber) from Customer c join c.task t where c.isArchived = true")
    List<JoinResponseDto> getActiveCustomer();
    @Query("select new com.example.Task.Manager.Dto.JoinResponseDto(t.taskId, t.taskTitle, t.taskDescription, t.taskPriority, t.createdAt,t.customerId,c.name, c.email, c.dob, c.phoneNumber) from Customer c join c.task t where c.Id IN :cid")
    List<JoinResponseDto> findMultipleCustomer(@Param("cid") List<Long> cid);
}
