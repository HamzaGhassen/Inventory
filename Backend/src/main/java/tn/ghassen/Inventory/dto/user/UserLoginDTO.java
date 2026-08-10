package tn.ghassen.inventory.dto.user;

import lombok.Data;

@Data
public class UserLoginDTO {

    private String email;
    private String password;
}