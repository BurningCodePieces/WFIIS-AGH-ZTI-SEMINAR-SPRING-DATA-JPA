package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Person { // to samo co w samym Hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_class"))
    private Class aClass;

    public Person(String name, String email, Class aClass) {
        this.name = name;
        this.email = email;
        this.aClass = aClass;
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", aClass=" + aClass +
                '}';
    }
}
