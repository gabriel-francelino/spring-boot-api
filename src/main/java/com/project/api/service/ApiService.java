package com.project.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.api.apiRepository.ApiRepository;
import com.project.api.model.Person;

@Service
public class ApiService {
    
    @Autowired
    private Mensage msg;

    @Autowired
    private ApiRepository action; // uma boa prática é usar o repositorio na classe de serviço

    public ResponseEntity<?> register(Person obj){
        if (obj.getName().equals("")) {
            msg.setMsg("The name cannot be null");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getAge() < 0){
            msg.setMsg("Invalid age");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
    }
}
