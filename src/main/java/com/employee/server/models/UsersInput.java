package com.employee.server.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UsersInput {
    private Integer id;
    private String name;
    private String designation;
    private String salary;
}
