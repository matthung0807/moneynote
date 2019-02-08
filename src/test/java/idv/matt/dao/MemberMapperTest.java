package idv.matt.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import idv.matt.application.MoneynoteApplication;
import idv.matt.entity.Member;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MoneynoteApplication.class })
@Transactional
public class MemberMapperTest {

    @Autowired
    private MemberMapper mapper;

    @Test
    @Rollback
    public void testInsert() {
        Member member = new Member();
        member.setMemberAccount("alice@abc.com");
        member.setMemberName("Alice");
        member.setMemberPassword("12345");
        member.setMemberStatus("1");
        mapper.insert(member);
        Member result = mapper.selectByNaturalKey(member.getMemberAccount());
        Assert.assertEquals(result.getMemberAccount(), member.getMemberAccount());
    }

}
