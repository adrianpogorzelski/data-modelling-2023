package edu.wsb.datamodellingdemo.homework;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.wsb.datamodellingdemo.companies.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;


// Zadanie 4
@Entity
public class Corporation {

    private String name;

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "corporation")
    @JsonIgnoreProperties("corporation")
    private Set<Company> companies;

    public Corporation() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
