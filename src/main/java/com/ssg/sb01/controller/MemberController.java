package com.ssg.sb01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {
//    private final MemberService memberService;

    @GetMapping("/join")
    public void joinGet() {

    }

    @GetMapping("/login")
    public void loginGet(String error, String logout) {
        log.info("login");
        log.info("logout " + logout);
    }
}
