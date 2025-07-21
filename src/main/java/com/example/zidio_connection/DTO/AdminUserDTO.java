package com.example.zidio_connection.DTO;

import com.example.zidio_connection.Enum.Role;

public class AdminUserDTO {
    public Long id;
    public String username;
    public String email;
    public Role role;
    public boolean isActive;
    public boolean isBlocked;

    public AdminUserDTO() {
    }
    public AdminUserDTO(Long id, String username, String email, Role role, boolean isActive, boolean isBlocked) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
        this.isBlocked = isBlocked;
    }
}
