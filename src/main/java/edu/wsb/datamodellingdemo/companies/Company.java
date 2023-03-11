package edu.wsb.datamodellingdemo.companies;

import edu.wsb.datamodellingdemo.people.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
public class Company {

    private String name;
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "company")
    private Set<Person> people;
}
