package com.example.blogapplication.Repository;

import com.example.blogapplication.Model.Posts;
import com.example.blogapplication.Model.UserModel;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Integer> {

    Posts findPostsById(Integer id);
    List<Posts> findPostsByAuthorId(Integer authorId);
    List<Posts> findPostsByTitle(String title);
    @Query("select c from Posts c where c.publicationDate>?1 ")
    Posts pleaseFindPostBeforeDate(Data data);

}

