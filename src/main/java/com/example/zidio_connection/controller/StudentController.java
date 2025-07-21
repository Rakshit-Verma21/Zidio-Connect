package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.StudentDTO;
import com.example.zidio_connection.repository.StudentRepository;
import com.example.zidio_connection.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping("/email/{email}")
    public ResponseEntity<StudentDTO> getStudentByEmail(@PathVariable String email)
    {
        return ResponseEntity.ok(studentService.getStudentByEmail(email));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StudentDTO> getStudentByID(@PathVariable Long id)
    {
        return ResponseEntity.ok(studentService.getStudentByID(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createOrUpdateStudent(@RequestBody StudentDTO studentDTO)
    {
        return ResponseEntity.ok(studentService.createOrUpdateStudent(studentDTO));
    }

    @GetMapping("internal/count")
    public ResponseEntity<Long> countStudents()
    {
        return ResponseEntity.ok(studentRepository.count());
    }


}
