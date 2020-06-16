package com.xcu.ssm.dao;

import com.xcu.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;
}
