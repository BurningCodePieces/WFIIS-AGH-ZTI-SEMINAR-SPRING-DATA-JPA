package com.example.demo.daos;

import com.example.demo.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Long> {
    Person findPersonById(long id);//magia Spring Data JPA - generowanie SQL na podstawie nazw funkcji

    //ale nie trzeba z tej magii korzystać - można definiować własne zapytania
    @Query(value = "Select p from Person p where p.id=?1")
    Person znajdzMiOsobe(long id);

    // dodatkowo (jesli stosujemy nazewnictwo funkcji wymagane przez Spring Data)
    // zaimplementowane są nawet interfejsy obsługujące paginację
    Page<Person> findAll(Pageable pageable);
}

