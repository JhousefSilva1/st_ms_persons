package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth.Service;


import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final StPersonRepository stPersonRepository;

    public UserDetailsServiceImpl(StPersonRepository stPersonRepository) {
        this.stPersonRepository = stPersonRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        StPersonEntity person = stPersonRepository.findByPersonEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return org.springframework.security.core.userdetails.User.builder()
                .username(person.getPersonEmail())
                .password(person.getPersonPassword())
                .roles(person.getPersonType().getPersonType()) // Asume que PersonType tiene un campo nombre
                .build();
    }
}