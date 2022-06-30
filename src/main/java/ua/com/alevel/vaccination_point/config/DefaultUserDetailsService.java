package ua.com.alevel.vaccination_point.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.dao.repository.user.UserRepository;
import ua.com.alevel.vaccination_point.model.entity.user.User;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    private final UserRepository<User> userRepository;

    public DefaultUserDetailsService(UserRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Невірний логін або пароль");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getClass().getSimpleName().toUpperCase(Locale.ROOT)));
        return convertCustomUserToSpringUser(user, authorities);

    }

    private org.springframework.security.core.userdetails.User convertCustomUserToSpringUser(
            User user, Set<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getEnabled(),
                true,
                true,
                true,
                authorities
        );
    }
}
