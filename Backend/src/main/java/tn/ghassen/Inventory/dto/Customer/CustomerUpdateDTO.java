package tn.ghassen.inventory.dto.Customer;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUpdateDTO {

    private String name;

    @Email
    private String email;

    private String phone;

    private String address;

    private String taxNumber;

    private String logo;

    private Long companyId;
}