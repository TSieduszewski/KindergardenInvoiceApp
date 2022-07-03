package com.kindergarden.app.dao;

import com.kindergarden.app.entity.Invoice;
import com.kindergarden.app.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {

    List<Invoice> findAllByInvoiceDate(LocalDate localDate);

    List<Invoice> findAllByParent(Parent parent);

    Invoice findById(int id);
}
