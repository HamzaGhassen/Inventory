package tn.ghassen.inventory.dto.company;

import lombok.Data;

@Data
public class CompanyResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String taxNumber;
    private String logo;
}