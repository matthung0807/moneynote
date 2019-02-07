package idv.matt.dao;

import idv.matt.entity.Member;
import java.util.List;

public interface MemberMapper {
    int deleteByPrimaryKey(Long memberId);

    int insert(Member record);

    Member selectByPrimaryKey(Long memberId);

    List<Member> selectAll();

    int updateByPrimaryKey(Member record);
}