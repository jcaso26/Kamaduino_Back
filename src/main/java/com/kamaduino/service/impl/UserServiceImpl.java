package com.kamaduino.service.impl;

import com.kamaduino.dto.UserDTO;
import com.kamaduino.entity.User;
import com.kamaduino.repository.UserRepository;
import com.kamaduino.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean loginUser(UserDTO user) {
        User userEntity = userRepository.getUserByUserName(user.getUser());
        //TEST
        user.setPass("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        //TEST
        if(userEntity.getUserName().equals(user.getUser()) && userEntity.getPasswordEncrypted().equals(user.getPass())){
            return true;
        }
        else {
            return false;
        }
    }
}
