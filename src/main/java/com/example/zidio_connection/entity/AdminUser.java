package com.example.zidio_connection.entity;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.zidio_connection.Enum.Role;
import jakarta.persistence.*;

@Entity
@Table(name="system_user")
public class AdminUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private Role role;
    private boolean isActive;
    private boolean isBlocked;

    public AdminUser() {
    }
    public AdminUser(String username, String email, Role role, boolean isActive, boolean isBlocked) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
        this.isBlocked = isBlocked;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
