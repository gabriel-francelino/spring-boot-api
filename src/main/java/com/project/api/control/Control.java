package com.project.api.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.model.Person;

// marca uma classe como um controlador REST e simplifica a criação de APIs RESTful em um aplicativo Spring Boot.
@RestController
public class Control {
    // é usada para mapear solicitações HTTP GET a métodos de controlador específicos.
    @GetMapping("/")
    public String mensage(){
        return "Hello World!";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome ";
    }

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name){ // captura a variavél passada por URL 
        return "Welcome " + name;
    }

    //rota para retornar nome e idade
    @PostMapping("/person") // é usada para mapear solicitações HTTP POST a métodos de controlador específicos.
    public Person person(@RequestBody Person p){ // é usada para indicar que um parâmetro de método deve ser vinculado ao corpo de uma solicitação HTTP.
        return p;
    }
}
