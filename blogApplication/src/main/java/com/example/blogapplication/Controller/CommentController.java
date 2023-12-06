package com.example.blogapplication.Controller;

import com.example.blogapplication.ApiExceotion.ApiException;
import com.example.blogapplication.Model.Comments;
import com.example.blogapplication.Model.UserModel;
import com.example.blogapplication.Service.CommentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
 private final CommentsService commentsService;
    @GetMapping("/get")
    public ResponseEntity getAllComment(){
        return ResponseEntity.status(HttpStatus.OK).body(commentsService.getAllComment());
    }
    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comments comments, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        commentsService.addComment(comments);
        return ResponseEntity.status(HttpStatus.OK).body("added Comments");

    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id,@RequestBody @Valid Comments comments, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        commentsService.updateComment(id, comments);
        return ResponseEntity.status(HttpStatus.OK).body("Update Comment");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(commentsService.deleteComments(id));
    }
    @GetMapping("/search/{id}")
    public ResponseEntity searchPost(@PathVariable Integer id){
        List<Comments> comments =commentsService.searchPost(id);
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }
}
