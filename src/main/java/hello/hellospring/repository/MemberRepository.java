package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberRepository {
    @Autowired
    MemberMapper memberMapper;

    public Member findById(Long id){
        return memberMapper.findById(id);
    }

    public Long countAll(){
        return memberMapper.countAll();
    }

    public List<Member> findAll(){
        return memberMapper.findAll();
    }

    public List<Member> findByName(String name){
        return memberMapper.findByName(name);
    }

}
