package com.ssg.sb01.security.handler;

import com.ssg.sb01.domain.Member;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class CustomUserDetailService implements UserDetailsService {
    private PasswordEncoder passwordEncoder;

    public CustomUserDetailService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("user name " + username);

        // ds를 통해서 db에 저장된 사용자의 정보를 조회
//        Optional<Member> result = m


        UserDetails userDetails = User.builder().username("user1").password(passwordEncoder.encode("1111"))
                .authorities("ROLE_USER")
                .build();

        return userDetails;
    }
}

// UserDetails 인터페이스에 맞는 객체가 필요하고, CustomUserDetailService 반환하