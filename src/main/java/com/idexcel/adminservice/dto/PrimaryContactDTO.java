package com.idexcel.adminservice.dto;

import javax.validation.constraints.NotNull;

public class PrimaryContactDTO {
	
	@NotNull
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String phone;

    public PrimaryContactDTO() {
    }

    public PrimaryContactDTO(@NotNull String email, @NotNull String name, @NotNull String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
