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
public class Posts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotEmpty(message = "please enter Title")
    @Column(columnDefinition = "varchar(50)not null ")
    private String title;
    @NotEmpty(message = "please enter content")
    @Column(columnDefinition = "varchar(50)not null ")
    private String content;
    @NotNull(message = "please enter ID_user")
    @Column(columnDefinition = "int  not null ")
    private Integer authorId;
    @NotNull(message = "please enter CategoryId")
    @Column(columnDefinition = "int not null ")
    private Integer categoryId;

    private LocalDate publicationDate=LocalDate.now();
}
