package com.mftplus.model.dao;

import com.mftplus.model.entity.Gender;
import com.mftplus.model.entity.Member;
import com.mftplus.model.mapper.MemberMapper;
import com.mftplus.model.utils.ConnectionProvider;
import com.mftplus.model.utils.SqlCommands;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDa implements DataAccessObject<Member,Long> {
    @Override
    public void save(Member member) throws Exception {
        try(Connection connection = ConnectionProvider.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Member.MEMBER_INSERT)
        ){
            member.setId(ConnectionProvider.getInstance().getNextId("MEMBER_SEQ"));
            preparedStatement.setLong(1, member.getId());
            preparedStatement.setString(2, member.getName());
            preparedStatement.setString(3, member.getFamily());
            preparedStatement.setDate(4, Date.valueOf(member.getBirthDate()));
            preparedStatement.setString(5, member.getGender().name());
            preparedStatement.setString(6, member.getCity().name());
            preparedStatement.execute();
        }
    }

    @Override
    public void update(Member member) throws Exception {
        try(Connection connection = ConnectionProvider.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Member.MEMBER_UPDATE)
        ){
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getFamily());
            preparedStatement.setDate(3, Date.valueOf(member.getBirthDate()));
            preparedStatement.setString(4, member.getGender().name());
            preparedStatement.setString(5, member.getCity().name());
            preparedStatement.setLong(6, member.getId());
            preparedStatement.execute();
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        try(Connection connection = ConnectionProvider.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Member.MEMBER_DELETE)
        ){
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }

    @Override
    public Member findById(Long id) throws Exception {
        try(Connection connection = ConnectionProvider.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Member.MEMBER_SELECT_BY_ID)
        ){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return MemberMapper.map(resultSet);
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() throws Exception {
        List<Member>  memberList = new ArrayList<>();
        try(Connection connection = ConnectionProvider.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Member.MEMBER_SELECT_ALL)
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Member member = MemberMapper.map(resultSet);
                memberList.add(member);
            }
        }
        return memberList;
    }
}
