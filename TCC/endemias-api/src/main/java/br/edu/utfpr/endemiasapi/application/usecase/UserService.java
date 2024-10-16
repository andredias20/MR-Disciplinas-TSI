package br.edu.utfpr.endemiasapi.application.usecase;

import br.edu.utfpr.endemiasapi.application.dto.security.RegisterDTO;
import br.edu.utfpr.endemiasapi.domain.entity.security.AppUser;
import br.edu.utfpr.endemiasapi.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser save(RegisterDTO register) {
        AppUser user = new AppUser();
        user.setUsername(register.getUsername());
        user.setPassword(passwordEncoder.encode((register.getPassword())));
        user.setRole(register.getRole());
        return userRepository.save(user);
    }

    public List<AppUser> findAll(){
        return userRepository.findAll();
    }

    public Optional<AppUser> findById(String id) {
        return userRepository.findById(id);
    }

    public void delete(String id) {
        Optional<AppUser> user = this.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
    }

    public boolean existsByUsername(String username) {
        return userRepository.findUserByUsername(username).isPresent();
    }
}
