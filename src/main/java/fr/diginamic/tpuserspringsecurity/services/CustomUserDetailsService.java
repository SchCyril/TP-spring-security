package fr.diginamic.tpuserspringsecurity.services;

import fr.diginamic.tpuserspringsecurity.entities.UserApp;
import fr.diginamic.tpuserspringsecurity.repositories.UserAppRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserAppRepository userAppRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserAppRepository userAppRepository, PasswordEncoder passwordEncoder) {
        this.userAppRepository = userAppRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserApp userApp = userAppRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(
                "user pas trouvé" + email));

        return User.builder()
                .username(userApp.getEmail())
                .password(userApp.getPassword())
                .roles("USER")
                .build();
    }

    public void createUser(String username, String password) {
        userAppRepository.save(new UserApp(username, passwordEncoder.encode(password)));
    }

}
