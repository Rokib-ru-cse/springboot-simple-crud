package com.spring.crud.controller;

import com.spring.crud.model.User;
import com.spring.crud.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }
    public void saveUser(User user){
        userRepo.save(user);
    }

    public User getById(int id) throws UserNotFoundException {
         Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("could not find any user with id"+id);
    }

    public void deleteUser(int id) throws UserNotFoundException {
        Long count = userRepo.countById(id);
        if(count==null || count==0){
            throw new UserNotFoundException("could not find any user with id"+id);
        }
        userRepo.deleteById(id);
    }



}
