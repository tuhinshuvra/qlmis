package org.bd.quantum.em_project;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employeeEntity")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email;
}
