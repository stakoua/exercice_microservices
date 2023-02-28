package com.microserviceUsers.exercice.service;

import com.microserviceUsers.exercice.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> getUserById (int id);
    List<User> getAllUser ();
    User createUser (User adresse);
    User updateUser (User user,int id);
    void deleteUser (int id);


}
