package com.kindergarden.app.service;

import com.kindergarden.app.entity.Parent;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParentService {

    List<Parent> findALlParents();
}
