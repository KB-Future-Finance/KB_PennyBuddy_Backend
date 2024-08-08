package com.kb.member.service;


import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

  @Autowired
  SqlSessionTemplate sm;

  @Override
  public List<MemberVo> getList(MemberVo vo) {
    System.out.println("MemberdaoImpl호출");
    return sm.selectList("Member.getList");
  }
}
