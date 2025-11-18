package com.mftplus.model.mapper;

import com.mftplus.model.entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMapper {
    public static Member map(ResultSet resultSet) throws SQLException {
        return Member
                .builder()
                .id(resultSet.getLong("MEMBER_ID"))
                .name(resultSet.getString("MEMBER_NAME"))
                .family(resultSet.getString("MEMBER_FAMILY"))
                .build();
    }
}
