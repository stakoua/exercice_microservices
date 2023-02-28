package com.microserviceUsers.exercice.controller;

import com.microserviceUsers.exercice.model.User;
import com.microserviceUsers.exercice.repository.UserRepository;
import com.microserviceUsers.exercice.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
//open for all ports
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class userController {
private final UserServiceImpl userServiceImpl;
private final UserRepository userRepository;
@GetMapping("/")
    public List<User> getAllUser(){
    return userServiceImpl.getAllUser();
}
@GetMapping("/{id}")
        public ResponseEntity<User> getUserById(@PathVariable int id){
    Optional<User> userGetById=userServiceImpl.getUserById(id);
    return ResponseEntity.status(201).body(userGetById.get());

}
@PostMapping("/")
public ResponseEntity<User> createUser(@RequestBody  User user){

    Optional<User> adresseFound= userRepository.findUserByEmail(user.getEmail());

    if(adresseFound.isEmpty() ){
        User userCreated =userServiceImpl.createUser(user);
        return  ResponseEntity.status(201).body(userCreated);
    }else{return ResponseEntity.status(204).body(null); }


}
    @DeleteMapping("/{id}")
    public void deleteuserById(@PathVariable int id){
        userServiceImpl.deleteUser(id);

    }
    @PutMapping ("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id){
        return ResponseEntity.status(200).body( userServiceImpl.updateUser( user ,  id));

    }

  }
