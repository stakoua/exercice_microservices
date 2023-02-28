package com.microserviceUsers.exercice.service;

import com.microserviceUsers.exercice.model.User;
import com.microserviceUsers.exercice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
@Autowired
private UserRepository userRepository;

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public  User updateUser(User user, int id) {
        Optional<User> userSerched=userRepository.findUserByEmail(user.getEmail());
        if(userSerched.isEmpty())
            return null;
        else{
            userSerched.get().setEmail(user.getEmail());
            userSerched.get().setName(user.getName());
            userSerched.get().setPassword(user.getPassword());
            return userRepository.save(userSerched.get());
        }
    }

    @Override
    public void deleteUser(int id) {
    userRepository.deleteById(id);
    }
}
