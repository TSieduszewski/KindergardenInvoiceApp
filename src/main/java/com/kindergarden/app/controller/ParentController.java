package com.kindergarden.app.controller;

import com.kindergarden.app.entity.Parent;
import com.kindergarden.app.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParentController {

    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/parent")
    ResponseEntity<List<Parent>> showAllParents(){
        List<Parent> list = parentService.findALlParents();
        if(list == null | list.size()<=0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(list);
        }

    }
}
