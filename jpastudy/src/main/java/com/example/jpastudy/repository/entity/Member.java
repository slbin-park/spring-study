package com.example.jpastudy.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MEMBER")
public class Member {
    @Id
    @Column
    private String id;

    @Column(name = "NAME",nullable = false)
    private String username;

    @ManyToOne
    private Team team;

    private Integer age;

}
