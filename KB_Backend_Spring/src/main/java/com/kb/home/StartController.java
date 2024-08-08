package com.kb.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {
  // 시작 화면 세팅
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String start() {
    return "start";
  }
}
