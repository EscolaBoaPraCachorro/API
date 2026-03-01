package com.api.service;

import com.api.model.Role;
import com.api.model.User;
import com.api.repository.RepositoryRole;
import com.api.repository.RepositoryUser;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final RepositoryUser userRepository;
    private final RepositoryRole roleRepository;

    public UserService(RepositoryUser userRepository, RepositoryRole roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User criarAdmin(User user) {
        Role admin = roleRepository.findByName("ADMIN");
        user.setRoles(Set.of(admin));
        return userRepository.save(user);
    }

    public User criarUser(User user) {
        Role userRole = roleRepository.findByName("USER");
        user.setRoles(Set.of(userRole));
        return userRepository.save(user);
    }
}