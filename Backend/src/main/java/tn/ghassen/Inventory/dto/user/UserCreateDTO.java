package tn.ghassen.inventory.dto.user;

import lombok.Data;
import tn.ghassen.inventory.enums.EmployeeStatus;
import tn.ghassen.inventory.enums.Role;

@Data
public class UserCreateDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Role role;
    private EmployeeStatus employeeStatus;
}
