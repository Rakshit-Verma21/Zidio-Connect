package com.example.zidio_connection.repository;

import com.example.zidio_connection.Enum.Role;
import com.example.zidio_connection.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long>
{

    AdminUser findByEmail(String email);
    AdminUser findByRole(Role role);
    AdminUser findByUsername(String username);


}
