package com.example.zidio_connection.repository;

import com.example.zidio_connection.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
    Student findByEmail(String email);
    Optional<Student> findById(Long id);


}
