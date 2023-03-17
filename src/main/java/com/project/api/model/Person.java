package com.project.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // especifica a criação das tabelas
@Table(name = "person")
public class Person {
    @Id // responsável pela criação da primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // responsável pela geração automatica da PK de maneira crescente
    private int id;
    private String name;
    private int age;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    
}
