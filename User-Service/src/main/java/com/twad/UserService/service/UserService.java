package com.twad.UserService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twad.UserService.model.User;
import com.twad.UserService.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;
	
	public Optional<User> create(User user){
        if (userRepository.existsById(user.getId())){
            return Optional.empty();
        }else{
            return Optional.of(userRepository.save(user));
        }
    }

    public List<User> retrieve(){
        return userRepository.findAll();
    }
    public Optional<User> retrieveOne(int Userid){
        return userRepository.findById(Userid);
    }
    public Optional<User> update(User user){
        if (userRepository.existsById(user.getId())){
            return Optional.of(userRepository.save(user));
        }else{
            return Optional.empty();
        }
    }   

    public String delete(int Userid){
        if (userRepository.existsById(Userid)){
        	userRepository.deleteById(Userid);
            return Userid + " deleted successfully!";
        }else{
            return "The user data does not exist in records!";
        }
        
    }
}
