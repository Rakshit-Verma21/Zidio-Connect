package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.StudentDTO;
import com.example.zidio_connection.entity.Student;
import com.example.zidio_connection.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO createOrUpdateStudent(StudentDTO dto)
    {
        Student student = new Student(dto.id, dto.name, dto.email, dto.phone, dto.qualifications, dto.resumeURL);
        Student savedStudent = (Student) studentRepository.save(student);
        return mapDTO(savedStudent);
    }
    public StudentDTO GetStudentByEmail(String email)
    {
        try
        {
            Student student = studentRepository.findByEmail(email);
            return mapDTO(student);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Student not found with email: " + email);
        }


    }
    public StudentDTO getStudentByID(Long id)
    {
        try
        {
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
            return mapDTO(student);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Student not found with ID: " + id);
        }

    }

    public StudentDTO mapDTO(Student student)
    {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getPhone(),
                student.getQualifications(),
                student.getResumeURL());
    }



    public StudentDTO createStudent(StudentDTO dto , String email)
    {
        Student student=new Student(dto.id, dto.name, dto.email, dto.phone, dto.qualifications, dto.resumeURL);
        return dto;

    }

    public StudentDTO getStudentByEmail(String email)
    {
        Student student = studentRepository.findByEmail(email);
        if (student == null)
        {
            return null;
        }
        else
        {
            return new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.getPhone(), student.getQualifications(), student.getResumeURL());

        }
    }

}
