package com.example.blogapplication.Repository;

import com.example.blogapplication.Model.Comments;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {
    Comments findCommentsById(Integer id);

    List<Comments>  findCommentsByPostId(Integer id);
}
