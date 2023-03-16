package com.project.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.project.api.model.Person;
import com.project.api.apiRepository.ApiRepository;


@RestController // marca uma classe como um controlador REST e simplifica a criação de APIs RESTful em um aplicativo Spring Boot.
public class Control {
    @Autowired // é usada no Spring Boot para realizar a injeção de dependência automática de um objeto em uma classe.
    private ApiRepository action;

    @PostMapping("/api")
    public Person register(@RequestBody Person obj){
        return action.save(obj);
    }

    @GetMapping("/api")
    public List<Person> select(){
        return action.findAll();
    }

    @GetMapping("/api/{id}")
    public Person selectById(@PathVariable int id){
        return action.findById(id);
    }

    @PutMapping("/api") // é usado para atualizar um recurso existente em um servidor usando uma solicitação HTTP PUT
    public Person edit(@RequestBody Person obj){
        return action.save(obj); // save() pode ser usado para cadastrar e atualizar
    }

    @DeleteMapping("/api/{id}") // é usado para excluir um recurso existente em um servidor usando uma solicitação HTTP DELETE.
    public void remove(@PathVariable int id){
        Person obj = action.findById(id);
        action.delete(obj);
    }

    @GetMapping("/api/counter")
    public long counter(){
        return action.count();
    }

    @GetMapping("/api/orderNames")
    public List<Person> orderNames(){
        return action.findByOrderByNameDesc();
    }

    @GetMapping("/") // é usada para mapear solicitações HTTP GET a métodos de controlador específicos.
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
