package com.example.blogapplication.Service;

import com.example.blogapplication.ApiExceotion.ApiException;
import com.example.blogapplication.Model.Categories;
import com.example.blogapplication.Repository.CategoriesRepository;
import com.example.blogapplication.Repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;
    private final PostsRepository postsRepository;

    public List<Categories> getAllCategories(){
        return categoriesRepository.findAll();
    }
    public void addCategories(Categories categories){

                    categoriesRepository.save(categories);


    }
    public Categories updateCategories(Integer id ,Categories categories){
        Categories oldCate =categoriesRepository.findCategoriesById(id);
        if (oldCate == null) {
            throw  new ApiException("please check Id categories");
        }
        oldCate.setCategory_name(categories.getCategory_name());
        categoriesRepository.save(oldCate);
       return oldCate;
    }
    public Categories deleteCategories(Integer id){
        Categories categories =categoriesRepository.findCategoriesById(id);
        if (categories == null) {
            throw new ApiException("please enter id true");
        }
        categoriesRepository.delete(categories);
        return categories;
    }
}
