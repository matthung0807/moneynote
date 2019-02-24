package idv.matt.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import idv.matt.application.MoneynoteApplication;
import idv.matt.entity.Member;

@SpringBootTest(classes = { MoneynoteApplication.class })
@Transactional
public class MemberMapperTest {

    @Autowired
    private MemberMapper mapper;
    
    Member member;

    @BeforeEach
    public void setupMember() {
        member = new Member();
        member.setMemberAccount("alice@abc.com");
        member.setMemberName("Alice");
        member.setMemberPassword("12345");
        member.setMemberStatus("1");
    }
    
    @Disabled
    @Test
    @Rollback
    public void testInsert() {
        mapper.insert(member);
        Member result = mapper.selectByNaturalKey(member.getMemberAccount());
        Assertions.assertEquals(result.getMemberAccount(), member.getMemberAccount());
    }

    @Disabled
    @Test
    public void testUpdate() {
        mapper.insert(member);
        Member result1 = mapper.selectByNaturalKey(member.getMemberAccount());
        result1.setMemberName("AliceWang");
        
        mapper.updateByPrimaryKey(result1);
        Member result2 = mapper.selectByNaturalKey(member.getMemberAccount());
        
        String expectedName = result1.getMemberName();
        String actualName = result2.getMemberName();
        System.out.println("result1.memberName:" + result1.getMemberName());
        System.out.println("result2.memberName:" + result2.getMemberName());
        Assertions.assertAll(
                () -> Assertions.assertEquals(result1, result2),
                () -> Assertions.assertEquals(expectedName, actualName));
    }
    
}
