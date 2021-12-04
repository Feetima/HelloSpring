package hello.hellospring.mapper;

import hello.hellospring.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface MemberMapper {
    List<Member> findAll();
    Member findById(Long id);
    Long countAll();
    List<Member> findByName(String name);

}
