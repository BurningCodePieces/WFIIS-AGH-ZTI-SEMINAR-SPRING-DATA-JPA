package com.example.demo.service;

import com.example.demo.daos.ClassDao;
import com.example.demo.daos.PersonDao;
import com.example.demo.entities.Class;
import com.example.demo.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class MainService {
    @Autowired                    //wstrzykujemy nasze interfejsy
    PersonDao personDao;
    @Autowired
    ClassDao classDao;

    public Person savePersonToDatabase(String name, String email) {
        return personDao.save(new Person(name, email)); // jedna(!) linijka - do tego
        // jest to operacja nie definiowana ani nawet deklarowana przez nas!
    }

    public Class saveClassToDatabase(String className) {
        return classDao.save(new Class(className));
    }

    public void pairPersonWithClass(Person person, Class class1) {
        //Person person1 = personDao.findPersonById(person.getId());
        Person person1 = personDao.znajdzMiOsobe(person.getId());
        person1.setAClass(class1);
        System.out.println("\n\n\n\n-------------Succesfully paired! Person: " + person1 + "\n\n\n\n");
    }

    @PostConstruct // pozwala nam "odpalić" funkcję, tak, jakbyśmy włączali program
    @Transactional
    public void appDemo() {
        Class exampleClass = saveClassToDatabase("Laby z ZTI");
        Person examplePerson = savePersonToDatabase("Agnieszka Lasek", "aga.lasek@gmail.com");
        pairPersonWithClass(examplePerson, exampleClass);
    }
}
