package com.example.taskmanager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_details")
public class Customer {

  @Id
  @GeneratedValue
  private long Id;
  private String customerName;
  private String email;
  private LocalDate dob;
  private String phoneNumber;
  private LocalDate createdAt;
  private LocalDate updatedAt;
  private boolean isArchived;

}
