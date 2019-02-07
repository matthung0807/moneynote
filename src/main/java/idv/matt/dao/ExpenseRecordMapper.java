package idv.matt.dao;

import idv.matt.entity.ExpenseRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpenseRecordMapper {
    int deleteByPrimaryKey(@Param("expenseId") Long expenseId, @Param("memberId") Long memberId);

    int insert(ExpenseRecord record);

    ExpenseRecord selectByPrimaryKey(@Param("expenseId") Long expenseId, @Param("memberId") Long memberId);

    List<ExpenseRecord> selectAll();

    int updateByPrimaryKey(ExpenseRecord record);
}