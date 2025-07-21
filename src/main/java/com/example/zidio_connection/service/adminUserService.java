package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.AdminUserDTO;
import com.example.zidio_connection.Enum.Role;
import com.example.zidio_connection.entity.AdminUser;
import com.example.zidio_connection.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class adminUserService
{
    @Autowired
    private AdminUserRepository adminUserRepository;

    public List<AdminUserDTO>getAllUsers()
    {
        List<AdminUserDTO> userDTOs = new ArrayList<>();
        for (Object user : adminUserRepository.findAll()) {
            userDTOs.add(convertToDTO((AdminUser) user));
        }
        return userDTOs;

    }
    public AdminUserDTO blockUser(Long id)
    {
        AdminUser user = (AdminUser) adminUserRepository.findById(id).orElse(null);
        if(user != null) {
            user.setBlocked(true);
            adminUserRepository.save(user);
            return convertToDTO(user);
        }
        return null;

    }
    public AdminUserDTO unblockUser(Long id)
    {
        AdminUser user = (AdminUser) adminUserRepository.findById(id).orElse(null);
        if(user != null) {
            user.setBlocked(false);
            adminUserRepository.save(user);
            return convertToDTO(user);
        }
        return null;

    }

    public List<AdminUserDTO> getUserByRole(Role role)
    {
        List<AdminUser> users = Collections.singletonList(adminUserRepository.findByRole(role));
        if (users == null) {
            return Collections.emptyList(); // or handle it however you prefer
        }
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());

    }
    public AdminUserDTO updateStatus(String email, boolean status)
    {
        AdminUser user = adminUserRepository.findByEmail(email);
        if (user != null) {
            user.setActive(true);
            adminUserRepository.save(user);
            return convertToDTO(user);
        }
        return null;
    }
    public AdminUserDTO convertToDTO(AdminUser user)
    {
        return new AdminUserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), user.isActive(), user.isBlocked());
    }
    public AdminUserDTO getUserByEmail(String email)
    {
        AdminUser user = adminUserRepository.findByEmail(email);
        if (user != null) {
            return convertToDTO(user);
        }
        return null;
    }
    public AdminUserDTO getUserByUsername(String username)
    {
        AdminUser user = adminUserRepository.findByUsername(username);
        if (user != null) {
            return convertToDTO(user);
        }
        return null;
    }


}
