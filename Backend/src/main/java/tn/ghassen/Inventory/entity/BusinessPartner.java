package tn.ghassen.inventory.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BusinessPartner extends BaseEntity {

    protected String name;
    protected String email;
    protected String phone;
    protected String address;
    protected String taxNumber;
    protected String logo;

}