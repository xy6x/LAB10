package com.example.blogapplication.Controller;

import com.example.blogapplication.ApiExceotion.ApiException;
import com.example.blogapplication.Model.Posts;
import com.example.blogapplication.Model.UserModel;
import com.example.blogapplication.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostsController {
    private final PostService postService;
    @GetMapping("/get")
    public ResponseEntity getAllPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosys());
    }
    @PostMapping("/add")
    public ResponseEntity addPosts(@RequestBody @Valid Posts posts, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
postService.AddPost(posts);
        return ResponseEntity.status(HttpStatus.OK).body("added posts");

    }
    @PutMapping("/put/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id,@RequestBody @Valid Posts posts, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        postService.updatePost(id, posts)
;        return ResponseEntity.status(HttpStatus.OK).body("Update Posts");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(postService.deletePost(id));
    }
    @GetMapping("/check/{id}")
    public ResponseEntity checkUser(@PathVariable Integer id){
        List<Posts> post =postService.CheckUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }
    @GetMapping("/search/{title}")

    public ResponseEntity searchTitle(@PathVariable String title){
        List<Posts> titles =postService.searchTitle(title);
        return ResponseEntity.status(HttpStatus.OK).body(titles);

    }
}
