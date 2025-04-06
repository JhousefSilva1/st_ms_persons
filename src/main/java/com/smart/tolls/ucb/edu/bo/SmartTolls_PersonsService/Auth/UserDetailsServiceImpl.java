package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Auth;



import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Repository.StPersonRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final StPersonRepository stPersonRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(StPersonRepository stPersonRepository,
                                  PasswordEncoder passwordEncoder) {
        this.stPersonRepository = stPersonRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StPersonEntity person = stPersonRepository.findByPersonEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(person.getPersonEmail())
                .password(person.getPersonPassword())
                .roles("USER") // o los roles que necesites
                .build();
    }
}