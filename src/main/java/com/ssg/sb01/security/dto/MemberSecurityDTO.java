package com.ssg.sb01.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class MemberSecurityDTO extends User {
    private String mid;
    private String mpw;
    private String email;
    private String username;


    public MemberSecurityDTO(String username, String password, String email, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);

        this.mid = username;
        this.mpw = password;
        this.email = email;
        this.username = username;
    }

    public String getName() {
        return mid;
    }

    public String getUserName() {
        return this.mid;
    }
}
