package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.InvoiceDTO;
import com.example.zidio_connection.Enum.ServiceType;
import com.example.zidio_connection.entity.Invoice;
import com.example.zidio_connection.entity.SubscriptionPlan;
import com.example.zidio_connection.repository.InvoiceRepository;
import com.example.zidio_connection.repository.SubscriptionPlanRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javassist.bytecode.ByteArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BillingService
{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    public byte[] generateInvoice(Long SubscriptionId)
    {
        Optional<Invoice> sub= invoiceRepository.findById(SubscriptionId);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
       try
       {
           Document document = new Document();
           PdfWriter .getInstance(document, byteArrayOutputStream);
           document.open();
              document.addTitle("Zidio Connection Invoice");
              document.add(new Paragraph("INVOICE", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20)));
              document.add(new Paragraph("Invoice number: "+ UUID.randomUUID()));
              document.add(new Paragraph("Issued Date"+ LocalDate.now()));
              document.add(new Paragraph("Email"+sub.get().getUserEmail()));
              document.add(new Paragraph("Subscription Plan: "+sub.get().getSubscriptionPlan()));
              document.add((new Paragraph("Amount: "+sub.get().getAmount())));
              document.add(new Paragraph("Service Type: "+sub.get().getServiceType()));
              document.add(new Paragraph("Payment Method: "+sub.get().getPaymentMethod()));

                document.close();
       }
         catch (Exception e)
         {
            e.printStackTrace();
         }
        return  byteArrayOutputStream.toByteArray();

    }
    public Invoice createInvoice(InvoiceDTO dto)
    {
        Invoice invoice = new Invoice();
        invoice.setId(dto.id);
        invoice.setUserEmail(dto.userEmail);
        invoice.setAmount(dto.amount);
        invoice.setStatus(dto.status);
        invoice.setServiceType(dto.serviceType);
        invoice.setPaymentMethod(dto.paymentMethod);
        invoice.setPurchaseDate(dto.purchaseDate);
        invoice.setInvoiceNumber(dto.invoiceNumber);
        invoice.setSubscriptionPlan(dto.subscriptionPlan);

        return invoiceRepository.save(invoice);
    }
    public List<Invoice> getInvoiceByEmail(String userEmail)
    {
        return invoiceRepository.findByUserEmail(userEmail);
    }
    public List<Invoice> getInvoicesByServiceType(ServiceType serviceType)
    {
        return invoiceRepository.findByServiceType(serviceType);
    }
    

}
