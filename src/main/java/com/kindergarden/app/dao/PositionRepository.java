package com.kindergarden.app.dao;

import com.kindergarden.app.entity.Invoice;
import com.kindergarden.app.entity.position.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PositionRepository extends JpaRepository<Position, UUID> {

    List<Position> findAllByInvoice(Invoice invoice);
}
