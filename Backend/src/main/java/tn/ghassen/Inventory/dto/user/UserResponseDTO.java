package tn.ghassen.inventory.dto.user;

import lombok.Data;
import tn.ghassen.inventory.enums.EmployeeStatus;
import tn.ghassen.inventory.enums.Role;

import java.time.LocalDateTime;

@Data

public class UserResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Role role;
    private EmployeeStatus employeeStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}