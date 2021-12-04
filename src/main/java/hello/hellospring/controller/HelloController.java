package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    MemberService memberService;

    @GetMapping(value = "hello124", produces = "application/json")
    public Member findByid(Long id){
        return memberService.findById(id);
    }

    @GetMapping("count")
    public Long countAll(){
        return memberService.countAll();
    }


    @GetMapping("all")
    public List<Member> findAll(){
        return memberService.findAll();
    }

    @GetMapping("findByName")
    public List<Member> findByName(String name){
        return memberService.findByName(name);
    }

}
