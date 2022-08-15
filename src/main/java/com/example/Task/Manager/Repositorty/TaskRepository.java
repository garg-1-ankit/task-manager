package com.example.Task.Manager.Repositorty;

import com.example.Task.Manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
