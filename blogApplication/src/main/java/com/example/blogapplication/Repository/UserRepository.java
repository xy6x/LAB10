package com.example.blogapplication.Repository;

import com.example.blogapplication.Model.UserModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {
    UserModel findUserModelById(Integer id);
    UserModel findUserModelByEmail(String email);
    @Query("select  c from UserModel c where c.userName=?1 ")
    UserModel pleaseFindMyUserForMe(String userName);
}
