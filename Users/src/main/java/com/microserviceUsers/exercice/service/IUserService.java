package com.microserviceUsers.exercice.service;

import com.microserviceUsers.exercice.Dto.AdresseDto;
import com.microserviceUsers.exercice.Dto.ResponseDto;
import com.microserviceUsers.exercice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    ResponseDto getUserById (int id);
    List<User> getAllUser ();
    User createUser (User adresse);
    User updateUser (User user,int id);
    void deleteUser (int id);

}
