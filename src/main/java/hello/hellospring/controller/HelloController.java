package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.AccountService;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class HelloController {

    @Autowired
    MemberRepository memberRepository;


    @Autowired
    AccountService as;

    AccountService as1 = new AccountService();
    //**
    // 1. hello 를 콜하면
    /*
     * |------|----|
     * 정수양 | 생명보험협회
     * 권장혁 | 쿠팡
     * 이상준 | 오토에버
     * |----|----|
     *
     * */
    // */


    @GetMapping("hello2")
    public String hello2(Model model) {
        as.test();
        return "hello444";
    }

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "penguin!!");
        model.addAllAttributes(Stream.of("name1", "name2").collect(Collectors.toList()));
        model.addAttribute("name2", "권장혁");
        return "hello333";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name, Model model) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    @GetMapping("api/member")
    @ResponseBody
    public Member pengApi(@RequestParam("id") Long id) {
        return memberRepository.findById(id).get();
    }


}
