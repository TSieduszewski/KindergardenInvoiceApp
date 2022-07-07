package com.kindergarden.app.service;

import com.kindergarden.app.dao.ParentRepository;
import com.kindergarden.app.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }
}
