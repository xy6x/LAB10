package com.example.blogapplication.Controller;

import com.example.blogapplication.ApiExceotion.ApiException;
import com.example.blogapplication.Model.Categories;
import com.example.blogapplication.Model.Comments;
import com.example.blogapplication.Service.CategoriesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cate")
public class CategoriesController {
    private final CategoriesService categoriesService;
    @GetMapping("/get")
    public ResponseEntity getAllCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriesService.getAllCategories());
    }
    @PostMapping("/add")
    public ResponseEntity addCategories(@RequestBody @Valid Categories categories, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiException(message));
        }
        categoriesService.addCategories(categories);
        return ResponseEntity.status(HttpStatus.OK).body("added Categories");

    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateCategories(@PathVariable Integer id,@RequestBody @Valid Categories categories, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiException(message));
        }
        categoriesService.updateCategories(id, categories);
        return ResponseEntity.status(HttpStatus.OK).body("Update Categories");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategories(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(categoriesService.deleteCategories(id));
    }
}
