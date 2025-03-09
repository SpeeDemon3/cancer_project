package com.ruiz.cancer_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="new")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="publicationDate")
    private Date publicationDate;
    @Column(name="img")
    private String img;


    @ManyToOne()
    @JoinColumn(name = "userId")
    private UserEntity user;

}
