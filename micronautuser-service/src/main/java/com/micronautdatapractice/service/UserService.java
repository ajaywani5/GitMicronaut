package com.micronautdatapractice.service;

import com.micronautdatapractice.exception.UserNotFoundException;
import com.micronautdatapractice.model.User;
import com.micronautdatapractice.repository.UserRepository;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class UserService {
    //private List<User> users=new ArrayList<>();
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        // users.add(user);
        //return user;
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        //return users;
        return userRepository.findAll();
    }

    public long getUserCount(){
        return userRepository.count();
    }

    public User getUser(int id){
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
//        return users.stream()
//                .filter(user -> user.getId() == id)
//                .findFirst()
//                //.orElse(null);
//                .orElseThrow(() -> new UserNotFoundException());
    }

    public User updateUser(int id,User user){
        User prevUser =getUser(id);
        prevUser.setName(user.getName());
        prevUser.setMobile(user.getMobile());
        prevUser.setEmail(user.getEmail());
        //return prevUser;
        return userRepository.update(prevUser);
    }

    public void deleteUser(int id){
        //User userToBeDelete=getUser(id);
        //users.remove(userToBeDelete);
        userRepository.deleteById(id);
    }

}


