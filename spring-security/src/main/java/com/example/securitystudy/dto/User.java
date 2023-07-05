package com.example.securitystudy.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Long userUuid;
    private String userRole;

}
