package hello.hellospring.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Member save(Member member) {
        //insert into table values (columnname)
        // "insert into member1 (id,name) values ("+member.getId()+","+"\'"+member.getName()+"\')";
        jdbcTemplate.execute( "insert into member1 values ("+member.getId()+","+"\'"+member.getName()+"\')");
        return member;

    }

    /***
     *
     * My name is penguin
     *
     * -> "My name is " + member.getName();
     * */
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    //Select id, name from Table where id = ?
    public Optional<Member> findById(Long id) {

        Member member = objectMapper.convertValue(
                jdbcTemplate.queryForMap("select * from member1 where id = id"),
                Member.class
        );
        return Optional.ofNullable(member);
    }

    @Override
    //Select id, name from Table where name = ?

    public Optional<Member> findByName(String name) {
        System.out.println(name);
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
