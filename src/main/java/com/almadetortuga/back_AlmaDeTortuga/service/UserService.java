package com.almadetortuga.back_AlmaDeTortuga.service;

import com.almadetortuga.back_AlmaDeTortuga.exceptions.UserNotFoundException;
import com.almadetortuga.back_AlmaDeTortuga.model.User;
import com.almadetortuga.back_AlmaDeTortuga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Lista de usuarios
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    // Crear un usuario
    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Actualizar usuario
    public User updateUser(User user, Long id){
        return userRepository.findById(id)
                .map(userMap -> {
                    userMap.setName(user.getName());
                    userMap.setLast_name(user.getLastname());
                    userMap.setEmail(user.getEmail());
                    userMap.setRol(user.getRol());
                    return userRepository.save(userMap);
                })
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    // Eliminar usuario
    public void deleteUser(Long id){
        if( userRepository.existsById(id) ){
            userRepository.deleteById(id);
        }else{
            throw new UserNotFoundException(id);
        }
    }
}
