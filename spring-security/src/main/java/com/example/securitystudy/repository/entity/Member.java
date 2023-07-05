package com.example.securitystudy.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MemberId")
    private Long id;

    private String email;

    private String role;

    private String password;

    private String isUsed;

    private String idDel;

}
