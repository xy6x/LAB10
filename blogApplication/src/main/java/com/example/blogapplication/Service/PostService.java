package com.example.blogapplication.Service;

import com.example.blogapplication.ApiExceotion.ApiException;
import com.example.blogapplication.Model.Posts;
import com.example.blogapplication.Repository.CategoriesRepository;
import com.example.blogapplication.Repository.PostsRepository;
import com.example.blogapplication.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;
    private  final CategoriesRepository categoriesRepository;

    public List<Posts> getAllPosys(){

        return postsRepository.findAll();
    }
    public void AddPost(Posts posts){
        for (int i = 0; i <userRepository.findAll().size() ; i++) {
            if (posts.getAuthorId()==userRepository.findAll().get(i).getId()) {
                for (int j = 0; j < categoriesRepository.findAll().size(); j++) {
                    if (posts.getCategoryId()==categoriesRepository.findAll().get(j).getId()) {
                        postsRepository.save(posts);
                    }
                }

            }

        }
        postsRepository.save(posts);
    }
    public Posts updatePost(Integer id,Posts posts){
        Posts oldPost =postsRepository.findPostsById(id);
        if (oldPost == null) {
            throw new ApiException("post Not found");
        }

        oldPost.setTitle(posts.getTitle());
        oldPost.setContent(posts.getContent());
        oldPost.setPublication_date(posts.getPublication_date());
       postsRepository.save(oldPost);
       return oldPost;

    }
    public Posts deletePost(Integer id){
        Posts posts =postsRepository.findPostsById(id);
        if (posts == null) {
            throw new ApiException("the id not found");
        }
        postsRepository.delete(posts);
        return posts;
    }
    public List<Posts> CheckUser(Integer id){
        List<Posts> posts =postsRepository.findPostsByAuthorId(id);
        if (posts == null) {
            throw new ApiException("Id not found");
        }
       return posts;
    }
    public List<Posts> searchTitle(String title){
        List<Posts> posts =postsRepository.findPostsByTitle(title);
        if (posts == null) {
            throw new ApiException("title not found");
        }
        return posts;
    }



}
