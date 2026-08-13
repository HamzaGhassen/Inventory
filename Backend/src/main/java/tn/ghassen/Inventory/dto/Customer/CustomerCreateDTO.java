package tn.ghassen.inventory.dto.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreateDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    private String phone;

    private String address;

    private String taxNumber;

    private String logo;

    @NotNull
    private Long companyId;
}