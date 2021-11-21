package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.AccountService;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class HelloController2 {

    @Autowired
    AccountService as;

    @Autowired
    MemoryMemberRepository mmr;

    @Autowired
    MemberService ms;

    @GetMapping("hello122")
    public String hello2(Model model){
        as.test();
        return "hello444";
    }

    @PostMapping("hello123")
    public String hello3(@RequestBody Member name){
        ms.join(name);
        return "hello444";
    }

    @GetMapping("hello124")
    public String hello4(Model model){
        ms.findMembers();
        return "hello444";
    }


}
