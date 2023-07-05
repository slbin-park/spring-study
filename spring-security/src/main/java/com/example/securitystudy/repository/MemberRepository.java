package com.example.securitystudy.repository;

import com.example.securitystudy.repository.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Long, Member> {
    Member findByLoginId(String username);
}
