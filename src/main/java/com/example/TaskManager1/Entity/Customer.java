package com.example.TaskManager1.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_details")
public class Customer {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",updatable = false,nullable = false)
    private long Id;

    @Column(name = "customer_name",nullable = false)
    private String name;

    @Column(name = "customer_email",nullable = false)
    private String email;

    @Column(name = "customer_dob",nullable = false)
    private LocalDate dob;

    @Column(name = "customer_phoneNumber",nullable = false)
    private String phoneNumber;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "is_archived",nullable = false)
    private boolean isArchived;
}
