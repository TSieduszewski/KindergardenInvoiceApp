package com.kindergarden.app.dao;

import com.kindergarden.app.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParentRepository extends JpaRepository<Parent, UUID> {

    Parent findById(int id);
}
