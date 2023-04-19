package edu.wsb.datamodellingdemo.companies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.wsb.datamodellingdemo.homework.Corporation;
import edu.wsb.datamodellingdemo.people.Person;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Company {

    private String name;

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "company")
    @JsonIgnoreProperties("company")
    private Set<Person> people;

    @ManyToOne
    @JoinColumn(name = "corporation_id")
    @JsonIgnoreProperties("companies")
    private Corporation corporation;

    public Company() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
}
