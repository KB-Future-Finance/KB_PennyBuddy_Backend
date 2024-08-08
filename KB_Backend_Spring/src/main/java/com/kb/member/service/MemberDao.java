package com.kb.member.service;

import java.util.List;

public interface MemberDao {
  public List<MemberVo> getList(MemberVo vo);
}
