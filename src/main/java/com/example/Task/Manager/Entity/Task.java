package com.example.Task.Manager.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false, updatable = false)
    private Long taskId;

    @Column(name = "task_title", columnDefinition = "varchar(100) not null")
    private String taskTitle;

    @Column(name = "task_description", columnDefinition = "varchar(200) not null")
    private String taskDescription;

    @Column(name = "task_priority", columnDefinition = "int not null")
    private int taskPriority;

    @Column(name = "customer_details_customer_id")
    private Long customerId;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "is_archived")
    private Boolean isArchived = false;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="customer_details_customer_id",
            referencedColumnName = "customer_id",
            insertable = false,
            updatable = false
    )
    private Customer customer_details;

}
