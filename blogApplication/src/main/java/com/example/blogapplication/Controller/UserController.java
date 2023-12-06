package com.example.blogapplication.Controller;

import com.example.blogapplication.ApiExceotion.ApiException;
import com.example.blogapplication.Model.Posts;
import com.example.blogapplication.Model.UserModel;
import com.example.blogapplication.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController{
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid UserModel userModel, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiException(message));
        }
        userService.addUser(userModel);
        return ResponseEntity.status(HttpStatus.OK).body("added User");

    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid UserModel userModel, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiException(message));
        }
        userService.updateUser(id, userModel);
        return ResponseEntity.status(HttpStatus.OK).body("Update User");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
    @GetMapping("/check/{userName}")
    public ResponseEntity CheckUser(@PathVariable String userName){
        return ResponseEntity.status(HttpStatus.OK).body(userService.checkUser(userName));
    }
    @GetMapping("/search/{email}")
    public ResponseEntity searchEmail(@PathVariable String email) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getEmail(email));
    }
}
