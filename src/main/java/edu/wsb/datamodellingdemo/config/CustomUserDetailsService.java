package edu.wsb.datamodellingdemo.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.wsb.datamodellingdemo.authorities.Authority;
import edu.wsb.datamodellingdemo.authorities.AuthorityRepository;
import edu.wsb.datamodellingdemo.people.Person;
import edu.wsb.datamodellingdemo.people.PersonRepository;
import jakarta.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final PersonRepository personRepository;
    public CustomUserDetailsService(PersonRepository personRepository, AuthorityRepository authorityRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person person = personRepository.findByUsername(username).orElse(null);
        if (person == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> authorities = getUserAuthorities(person);

        return new User(person.getUsername(), person.getPassword(), authorities);
    }

    private List<GrantedAuthority> getUserAuthorities(Person person) {
        Set<Authority> authorities = person.getAuthorities();

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        for (Authority a : authorities) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(a.getAuthority());
            grantedAuthorities.add(simpleGrantedAuthority);
        }

        return new ArrayList<>(grantedAuthorities);
    }
    
}
