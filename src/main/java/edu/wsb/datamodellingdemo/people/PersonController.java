package edu.wsb.datamodellingdemo.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PersonController {

    // Dependency injection -> https://www.digitalocean.com/community/tutorials/java-dependency-injection-design-pattern-example-tutorial
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/demo")
    String demo() {
        return "WSB!";
    }

    @GetMapping("/list")
    public Iterable<Person> list() {
        return personRepository.findAll();
    }

    // NIE DZIALA
    @PostMapping("/save")
    public Person save(@RequestParam String username, @RequestParam String password) {
        Person person = new Person(username, password, true);
        return personRepository.save(person);
    }

    @GetMapping("/get")
    public Optional<Person> get(@RequestParam Long id) {
        return personRepository.findById(id);
    }

    // NIE DZIALA
    @GetMapping("/passwords")
    public Iterable<Person> byPassword(@RequestParam String p) {
        return personRepository.findALlByPasswordLikeIgnoreCase(p + "%");
    }

    @GetMapping("/created")
    public Iterable<Person> usersCreatedAfter(@RequestParam String d) {
        Date date = new Date();
        return personRepository.findAllByDateCreatedAfterOrderByUsername(date);
    }
}
