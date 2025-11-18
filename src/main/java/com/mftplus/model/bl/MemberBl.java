package com.mftplus.model.bl;

import com.mftplus.model.dao.MemberDa;
import com.mftplus.model.entity.Member;
import lombok.Getter;

import java.util.List;

public class MemberBl implements BusinessLogic<Member, Long> {
    @Getter
    private final static MemberBl instance = new MemberBl();
    private final MemberDa memberDa = new MemberDa();

    private MemberBl() {
    }

    @Override
    public void save(Member member) throws Exception {
        memberDa.save(member);
    }

    @Override
    public void update(Member member) throws Exception {
        memberDa.update(member);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        memberDa.deleteById(id);
    }

    @Override
    public Member findById(Long id) throws Exception {
        return memberDa.findById(id);
    }

    @Override
    public List<Member> findAll() throws Exception {
        return memberDa.findAll();
    }
}
