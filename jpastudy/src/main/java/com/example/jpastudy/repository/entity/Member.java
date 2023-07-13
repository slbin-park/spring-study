package com.example.jpastudy.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @Column(name = "MEMEBER_ID")
    private String id;

    @Column(name = "NAME",nullable = false)
    private String username;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "member")
    private List<Product> products;

    private Integer age;

}
