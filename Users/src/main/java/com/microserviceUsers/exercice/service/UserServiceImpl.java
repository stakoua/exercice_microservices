package com.microserviceUsers.exercice.service;

import com.microserviceUsers.exercice.Dto.AdresseDto;
import com.microserviceUsers.exercice.Dto.ResponseDto;
import com.microserviceUsers.exercice.Dto.UserDto;
import com.microserviceUsers.exercice.model.User;
import com.microserviceUsers.exercice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
@Autowired
private UserRepository userRepository;

private APIClient APIClient;
    @Override
    public ResponseDto getUserById(int id) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(id).get();
        UserDto userDto = mapToUser(user);

       AdresseDto  adresseDto = APIClient.getAdresseById(user.getAdresseId());




        responseDto.setUser(userDto);
        responseDto.setAdressse(adresseDto);

        return responseDto;
    }

    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
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
