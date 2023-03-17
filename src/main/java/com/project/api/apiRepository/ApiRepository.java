package com.project.api.apiRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.project.api.model.Person;
import java.util.List;

public interface ApiRepository extends CrudRepository<Person, Integer> {
    //Person findById(int id);   
    List<Person> findAll();

    Person findById(int id);

    List<Person> findByOrderByNameDesc();

    List<Person> findByNameOrderByAgeDesc(String name);

    List<Person> findByNameContaining(String term);

    List<Person> findByNameStartsWith(String termo);

    List<Person> findByNameEndsWith(String termo);

    @Query("SELECT SUM(p.idade) FROM person p")
    int sumAges();
}
