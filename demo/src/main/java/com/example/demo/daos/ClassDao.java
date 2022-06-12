package com.example.demo.daos;


import com.example.demo.entities.Class;
import org.springframework.data.repository.CrudRepository;
public interface ClassDao extends CrudRepository<Class, Long>{ } //Magia Spring Data
