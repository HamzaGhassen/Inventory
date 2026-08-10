package tn.ghassen.inventory.dto.company;

import lombok.Data;

@Data
public class CompanyCreateDTO {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String taxNumber;
    private String logo;
}