package com.ruiz.cancer_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity
@Table(name="new")
@AllArgsConstructor
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
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private UserEntity user;

}
