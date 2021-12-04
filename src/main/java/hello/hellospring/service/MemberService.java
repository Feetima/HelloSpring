package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member findById(Long id){
        return memberRepository.findById(id);
    }

    public Long countAll(){
        return memberRepository.countAll();
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public List<Member> findByName(String name){
        return memberRepository.findByName(name);
    }

}
