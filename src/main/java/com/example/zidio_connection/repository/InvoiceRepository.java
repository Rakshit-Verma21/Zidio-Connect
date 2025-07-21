package com.example.zidio_connection.repository;

import com.example.zidio_connection.Enum.ServiceType;
import com.example.zidio_connection.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>
{
    List<Invoice> findByUserEmail(String userEmail);
    List<Invoice> findByServiceType(ServiceType serviceType);
    List<Invoice> findByUserEmailAndServiceType(String userEmail, ServiceType serviceType);
}
