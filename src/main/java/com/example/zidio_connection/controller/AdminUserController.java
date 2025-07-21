package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.AdminUserDTO;
import com.example.zidio_connection.Enum.Role;
import com.example.zidio_connection.service.adminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminUserController
{
    @Autowired
    private adminUserService adminUserService;

    @GetMapping("/users")
    public ResponseEntity<List<AdminUserDTO>> getAllUsers() {
        return ResponseEntity.ok(adminUserService.getAllUsers());
    }
    @GetMapping("/users/{role}")
    public ResponseEntity<List<AdminUserDTO>> getUsersByRole(@PathVariable String role) {
        return ResponseEntity.ok(adminUserService.getUserByRole(Role.valueOf(role)));
    }
    @GetMapping("/users/{email}")
    public ResponseEntity<AdminUserDTO> getUserByEmail(@PathVariable String email) {
        AdminUserDTO user = adminUserService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/users/{username}")
    public ResponseEntity<AdminUserDTO> getUserByUsername(@PathVariable String username) {
        AdminUserDTO user = adminUserService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/status/{email}")
    public ResponseEntity<AdminUserDTO> updateUserStatus(@PathVariable String email) {
        AdminUserDTO updatedUser = adminUserService.updateStatus(email, false);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/users/{id}/block")
    public ResponseEntity<AdminUserDTO> blockUser(@PathVariable Long id) {
        AdminUserDTO dto=adminUserService.blockUser(id);
        if(dto==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);

    }
    @PostMapping("/users/{id}/unblock")
    public ResponseEntity<AdminUserDTO> unblockUser(@PathVariable Long id) {
        AdminUserDTO dto=adminUserService.blockUser(id);
        if(dto==null) {
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(dto);

    }
}
