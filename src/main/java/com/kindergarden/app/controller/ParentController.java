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
        System.out.println(list.size());

        if(list == null | list.size()<=0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(list);
        }

    }

    //TODO do the validation on entity and resolve al exceptions
    @PostMapping(value = "/parent/save", consumes = {"application/json"})
    ResponseEntity<Parent> saveParentToDatabase(@RequestBody @Valid Parent parent){

        Parent newParent = parentService.save(parent);
        return ResponseEntity.created(URI.create("/" + newParent.getId())).body(newParent);
    }
}
