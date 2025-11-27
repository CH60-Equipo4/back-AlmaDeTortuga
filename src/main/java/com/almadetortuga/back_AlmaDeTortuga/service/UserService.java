package com.almadetortuga.back_AlmaDeTortuga.service;

import com.almadetortuga.back_AlmaDeTortuga.exceptions.UserNotFoundException;
import com.almadetortuga.back_AlmaDeTortuga.model.User;
import com.almadetortuga.back_AlmaDeTortuga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Lista de usuarios
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    // Crear un usuario
    public User createUser(User newUser){
        String encryptedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encryptedPassword);
        return userRepository.save(newUser);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Método para eliminar usuarios id
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    // Método para actualizar a todo un usuario mediante su id
    public User updateUser(User user, Long id) {
        return userRepository.findById(id)
                .map(userMap -> {
                    userMap.setName(user.getName());
                    userMap.setEmail(user.getEmail());
                    userMap.setPassword(user.getPassword());
                    return userRepository.save(userMap);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }



}
