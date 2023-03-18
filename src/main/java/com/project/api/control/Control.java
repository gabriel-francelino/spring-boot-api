package com.project.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.project.api.model.Person;
import com.project.api.repository.ApiRepository;
import com.project.api.service.ApiService;


@RestController // marca uma classe como um controlador REST e simplifica a criação de APIs RESTful em um aplicativo Spring Boot.
public class Control {
    @Autowired // é usada no Spring Boot para realizar a injeção de dependência automática de um objeto em uma classe.
    private ApiRepository action;

    @Autowired
    private ApiService service;

    @PostMapping("/api")
    public ResponseEntity<?> register(@RequestBody Person obj){
        return service.register(obj);
    }

    @GetMapping("/api")
    public ResponseEntity<?> select(){
        return service.select();
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<?> selectById(@PathVariable int id){
        return service.selectById(id);
    }

    @PutMapping("/api") // é usado para atualizar um recurso existente em um servidor usando uma solicitação HTTP PUT
    public ResponseEntity<?> edit(@RequestBody Person obj){
        return service.edit(obj); // save() pode ser usado para cadastrar e atualizar
    }

    @DeleteMapping("/api/{id}") // é usado para excluir um recurso existente em um servidor usando uma solicitação HTTP DELETE.
    public ResponseEntity<?> remove(@PathVariable int id){
        return service.remove(id);
    }

    @GetMapping("/api/counter")
    public long counter(){
        return action.count();
    }

    @GetMapping("/api/sortNames")
    public List<Person> sortNames(){
        return action.findByOrderByNameDesc();
    }

    @GetMapping("/api/sortNames2")
    public List<Person> sortNames2(){
        return action.findByNameOrderByAgeDesc("Gabriel");
    }

    @GetMapping("/api/nameContains")
    public List<Person> nameContains(){
        return action.findByNameContaining("el");
    }

    @GetMapping("/api/startsWith")
    public List<Person> startsWith(){
        return action.findByNameStartsWith("k");
    }

    @GetMapping("/api/endsWith")
    public List<Person> endsWith(){
        return action.findByNameEndsWith("y");
    }

    // ERRO NA INSTÂNCIAÇÃO
    // @GetMapping("/api/sumAges")
    // public int sumAges(){
    //     return action.sumAges();
    // }

    @GetMapping("/api/ageGreaterEqual")
    public List<Person> ageGreaterEqual(){
        return action.ageGreaterEqual(23);
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

    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
