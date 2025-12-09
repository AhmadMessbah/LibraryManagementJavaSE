package com.mftplus.model.mapper;

import com.mftplus.model.entity.City;
import com.mftplus.model.entity.Gender;
import com.mftplus.model.entity.Member;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMapper {
    public static Member map(ResultSet resultSet) throws SQLException {
        Date birthDate = resultSet.getDate("MEMBER_BIRTH_DATE");
        return Member
                .builder()
                .id(resultSet.getLong("MEMBER_ID"))
                .name(resultSet.getString("MEMBER_NAME"))
                .family(resultSet.getString("MEMBER_FAMILY"))
                .birthDate((birthDate==null)?null:birthDate.toLocalDate())
                .gender(Gender.valueOf(resultSet.getString("MEMBER_GENDER")))
                .city(City.valueOf(resultSet.getString("MEMBER_CITY")))
                .build();
    }
}
