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
//        user.setPass("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        //TEST
        if(userEntity.getUserName().equals(user.getUser()) && userEntity.getPasswordEncrypted().equals(user.getPass())){
            return true;
        }
        else {
            return false;
        }
    }

//    @Override
//    public void newUser() {
//        String password = bCryptPasswordEncoder.encode("260785");
//        if(bCryptPasswordEncoder.matches(password, "$2a$10$3Kt5LxEG45lLcrmqb/K2nOKZaBRxCqpuc9yRfQLSGY1taAQ20zmsW")){
//            System.out.print("PRIMERO SI");
//        }
//        if(bCryptPasswordEncoder.matches(password, "$2a$10$WgL0XOpwep78.V1yvshBVu.wNqDoBQxQ72NqPZ6PhohfhWXz32vOa")){
//            System.out.print("SEGUNDO SI");
//        }
//    }

//    @Override
////    public boolean getUserByIDUser(String user) {
////        return false;
////    }
}
