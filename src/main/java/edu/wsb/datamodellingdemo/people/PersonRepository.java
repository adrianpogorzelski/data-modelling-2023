package edu.wsb.datamodellingdemo.people;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Iterable<Person> findALlByPasswordLikeIgnoreCase(String p);
    Iterable<Person> findAllByDateCreatedAfterOrderByUsername(Date d);
}
