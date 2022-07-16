package com.kindergarden.app.service;

import com.kindergarden.app.dao.ParentRepository;
import com.kindergarden.app.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    @Autowired
    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<Parent> findALlParents() {

        return parentRepository.findAll();

    }

    @Override
    public Parent findParentById(UUID id) {
        Optional<Parent> tempParent = parentRepository.findById(id);

        return tempParent.orElse(null);

    }

    @Override
    public Parent save(Parent parent) {

        return parentRepository.save(parent);
    }

    @Override
    public void delete(UUID id){
        parentRepository.deleteById(id);
    }
}
