package com.kindergarden.app.controller;

import com.kindergarden.app.entity.Parent;
import com.kindergarden.app.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/parent/{id}")
    ResponseEntity<Parent> showParent(@PathVariable UUID id){
        Parent tempParent = parentService.findParentById(id);
        if(tempParent == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(tempParent);
        }
    }

    @PostMapping(value = "/parent/save", consumes = {"application/json"})
    ResponseEntity<Parent> saveParentToDatabase(@RequestBody @Valid Parent parent){

        Parent newParent = parentService.save(parent);
        return ResponseEntity.created(URI.create("/" + newParent.getId())).body(newParent);
    }

    @DeleteMapping("/parent/delete/{id}")
    ResponseEntity<?> deleteParentFromDatabase(@PathVariable UUID id){

        Parent tempParent = parentService.findParentById(id);
        if(tempParent == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            parentService.delete(id);
            return ResponseEntity.ok(tempParent);
        }

    }
}
