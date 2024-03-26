package tech.neckel.security.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tech.neckel.security.entity.User;
import tech.neckel.security.repository.UserRepository;
import tech.neckel.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User create(User user) {
        User existUser = userRepository.findByUsername(user.getUsername());

        if (existUser != null) {
            throw new RuntimeException("User already exists!");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));
        User createdUser = userRepository.save(user);

        return createdUser;
    }
}
