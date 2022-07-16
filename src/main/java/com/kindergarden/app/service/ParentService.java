package com.kindergarden.app.service;

import com.kindergarden.app.entity.Parent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface ParentService {

    List<Parent> findALlParents();

    Parent findParentById(UUID id);

    Parent save(Parent parent);

    void delete(UUID id);
}
