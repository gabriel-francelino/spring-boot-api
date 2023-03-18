package com.project.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.api.model.Person;
import com.project.api.repository.ApiRepository;

@Service
public class ApiService {
    
    @Autowired
    private Mensage msg;

    @Autowired
    private ApiRepository action; // uma boa prática é usar o repositorio na classe de serviço

    // método para cadastrar pessoas
    public ResponseEntity<?> register(Person obj){
        if (obj.getName().equals("")) {
            msg.setMsg("The name cannot be null");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getAge() < 0){
            msg.setMsg("Invalid age");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
        }

    }

    // método para buscar pessoas
    public ResponseEntity<?> select(){
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    // método para buscar pessoas pelo id
    public ResponseEntity<?> selectById(int id){
        if (action.countById(id) == 0) {
            msg.setMsg("Not found person");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(action.findById(id), HttpStatus.OK);
        }
    }

    // método para editar pessoas
    public ResponseEntity<?> edit(Person obj){
        if (action.countById(obj.getId()) == 0) {
            msg.setMsg("Not found person");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }else if (obj.getName().equals("")) {
            msg.setMsg("It is necessary to enter a name");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(obj.getAge() < 0){
            msg.setMsg("Invalid age");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
        }
    }

    // método para remover pessoas
    public ResponseEntity<?> remove(int id){
        if (action.countById(id) == 0) {
            msg.setMsg("Not found person");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }else {
            Person obj = action.findById(id);
            action.delete(obj);

            msg.setMsg("Removed successfully");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
    }
}
