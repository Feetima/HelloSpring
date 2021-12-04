package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController2 {


    @GetMapping(value = "/hello")
    public String test(Model model) {
        Member m5 = new Member(5L, "yang", "sadang");
        Member m6 = new Member(6L, "kwon", "suwon");
        Member m7 = new Member(7L, "jun", "nowon");
        List<Member> list = new ArrayList<>();
        list.add(m5);
        list.add(m6);
        list.add(m7);
        model.addAttribute("list", list);
        return "hello444";
    }



    @GetMapping(value = "/button")
    public String test() {
        return "helloj";
    }


    @GetMapping(value = "/findMember")
    public String test1() {
        return "hello_exam";
    }


}
