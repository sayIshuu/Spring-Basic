package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired // 매번 생성하지말고 스프링 컨테이너에 등록을 해두고 쓰자.
    // Autowired 어노테이션을 생성자에 해두면 memberService를 스프링 컨테이너에서 가져와서 연결해준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}