package com.example.securitystudy.security;

import com.example.securitystudy.repository.MemberRepository;
import com.example.securitystudy.repository.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberPrincipalDetailService implements UserDetailsService {

    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 넘겨받은 id 로 DB 에서 회원 정보를 찾음
        Member member = memberRepository.findByLoginId(username);
        System.out.println("username : " + username);
        System.out.println("member : " + member);
        // 없을경우 에러 발생
        if(member == null)
            throw new UsernameNotFoundException(username + "을 찾을 수 없습니다.");

        if(!"Y".equals(member.getIsUsed()))
            throw new UsernameNotFoundException("사용할 수 없는 계정입니다.");

//        if(!"N".equals(member.getIsDel()))
//            throw new UsernameNotFoundException("삭제된 계정입니다.");

        // MemberPrincipalDetails 에 Member 객체를 넘겨줌
        return new MemberPrincipalDetails(member);
    }

}
