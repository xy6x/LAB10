package com.example.blogapplication.Service;

import com.example.blogapplication.ApiExceotion.ApiException;
import com.example.blogapplication.Model.Comments;
import com.example.blogapplication.Repository.CommentsRepository;
import com.example.blogapplication.Repository.PostsRepository;
import com.example.blogapplication.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;
    public List<Comments> getAllComment(){
        return commentsRepository.findAll();

    }
    public void addComment(Comments comments){
        for (int i = 0; i <userRepository.findAll().size() ; i++) {
            if (comments.getAuthorId() == userRepository.findAll().get(i).getId()) {
                for (int j = 0; j <postsRepository.findAll().size(); j++) {
                    if (comments.getPostId() == postsRepository.findAll().get(j).getId()){
                        commentsRepository.save(comments);
                    }
                    }
            }
        }
        commentsRepository.findAll();
    }
    public Comments updateComment(Integer id ,Comments comments){
        Comments com =commentsRepository.findCommentsById(id);
        if (com == null) {
            throw new ApiException("please check comments");
        }
        com.setContent(comments.getContent());
        com.setComment_date(comments.getComment_date());
        commentsRepository.save(com);
        return com;
    }
    public Comments deleteComments(Integer id){
        Comments comments =commentsRepository.findCommentsById(id);
        if (comments == null) {
            throw new ApiException("not found id");
        }
        commentsRepository.delete(comments);
        return comments;
    }
    public List<Comments> searchPost(Integer id){
        List<Comments> comments =commentsRepository.findCommentsByPostId(id);
        if (comments == null) {
            throw new ApiException("not found post");

        }
        return comments;
    }
}
