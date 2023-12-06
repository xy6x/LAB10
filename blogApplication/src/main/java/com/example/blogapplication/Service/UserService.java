package com.example.blogapplication.Service;

import com.example.blogapplication.ApiExceotion.ApiException;
import com.example.blogapplication.Model.UserModel;
import com.example.blogapplication.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserModel> getAllUser(){

        return userRepository.findAll();
    }
    public void addUser(UserModel userModel){

        userRepository.save(userModel);
    }
    public UserModel updateUser(Integer id,UserModel userModel){
        UserModel oldUser = userRepository.findUserModelById(id);
        oldUser.setUserName(userModel.getUserName());
        oldUser.setEmail(userModel.getEmail());
        oldUser.setPassword(userModel.getPassword());
        oldUser.setRegistration_date(userModel.getRegistration_date());
        userRepository.save(oldUser);
        return oldUser;
    }
    public UserModel deleteUser(Integer id){
        UserModel userModel =userRepository.findUserModelById(id);
        if (userModel == null) {
            throw new ArithmeticException("not found");
        }
        userRepository.delete(userModel);
        return userModel;

    }
    public UserModel getEmail(String email){
        UserModel myUsers = userRepository.findUserModelByEmail(email);
        if (myUsers == null) {
            throw new ApiException("email is not here");

        }
        return myUsers;
    }
    public UserModel checkUser(String userName){
        UserModel users = userRepository.pleaseFindMyUserForMe(userName);
        if (users.getUserName()== null){
            throw  new ApiException(" UserName not found");
        }
        return users;
    }
}
