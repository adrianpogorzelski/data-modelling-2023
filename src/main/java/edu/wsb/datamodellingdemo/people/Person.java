package edu.wsb.datamodellingdemo.people;

import edu.wsb.datamodellingdemo.companies.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
public class Person {

    private String username;
    private String password;
    private Boolean enabled;
    private Date dateCreated;
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    public Person(String username, String password, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.dateCreated = new Date();
    }

    public Person() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
