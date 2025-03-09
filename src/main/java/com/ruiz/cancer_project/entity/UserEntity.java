package com.ruiz.cancer_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String pass;
    @Column(name = "urlWebSite")
    private String webSite;
    @Column(name = "image")
    private String img;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NewEntity> news;

}
