package com.example.zidio_connection.repository;

import com.example.zidio_connection.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long>
{
    Recruiter findByEmail(String email);

    @Override
    Optional<Recruiter> findById(Long aLong);


}
