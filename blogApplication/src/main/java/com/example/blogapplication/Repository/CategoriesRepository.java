package com.example.blogapplication.Repository;

import com.example.blogapplication.Model.Categories;
import com.example.blogapplication.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer> {
//    Categories findCategoriesByCa(Integer id);

    Categories findCategoriesById(Integer id);
}
