package com.example.blogapplication.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Comments {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotNull(message = "please enter Post_id")
    @Column(columnDefinition = "int not null ")
    private Integer postId;
    @NotNull(message = "please enter ID_user")
    @Column(columnDefinition = "int not null ")
    private Integer authorId;
    @NotEmpty(message = "please enter content")
    @Column(columnDefinition = "varchar(255)not null ")
    private String content;
    private LocalDate comment_date=LocalDate.now();



}
