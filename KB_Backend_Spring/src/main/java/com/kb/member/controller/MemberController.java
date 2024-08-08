package com.kb.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kb.member.service.MemberService;
import com.kb.member.service.MemberVo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
  List<MemberVo> voList = new ArrayList<MemberVo>();
  MemberVo vo = new MemberVo();

 @Autowired
  MemberService memberService;
  @RequestMapping("/member")
  @ResponseBody
  public String home(){
    voList.toString();
    List<MemberVo> lst = memberService.getList(vo);
    ObjectMapper objectMapper = new ObjectMapper();

    String jsonString="";

    // Java 객체를 JSON 문자열로 변환
    try {

      jsonString= objectMapper.writeValueAsString(lst);

    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    for(int i=0; i<lst.size(); i++){
      System.out.println(lst.get(i).getUsername());
    }
    return jsonString;
  } // home fin




}
