package edu.wsb.datamodellingdemo.config;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.wsb.datamodellingdemo.people.Person;
import edu.wsb.datamodellingdemo.people.PersonRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final PersonRepository personRepository;

    public CustomUserDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person person = personRepository.findByUsername(username).orElse(null);
        if (person == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> authorities = Collections.emptyList();

        return new User(person.getUsername(), person.getPassword(), authorities);
    }
    
}
