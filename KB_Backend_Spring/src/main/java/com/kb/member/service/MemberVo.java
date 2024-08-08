package com.kb.member.service;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class MemberVo {
  private int userIdx;
  private String username;
  private String userPw;
  private String userPn;
  private String userMail;
  private int avatar_id;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date userDate; // 수정 날짜
  private String delYn;


  public int getUserIdx() {
    return userIdx;
  }

  public void setUserIdx(int userIdx) {
    this.userIdx = userIdx;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserPw() {
    return userPw;
  }

  public void setUserPw(String userPw) {
    this.userPw = userPw;
  }

  public String getUserPn() {
    return userPn;
  }

  public void setUserPn(String userPn) {
    this.userPn = userPn;
  }

  public String getUserMail() {
    return userMail;
  }

  public void setUserMail(String userMail) {
    this.userMail = userMail;
  }

  public int getAvatar_id() {
    return avatar_id;
  }

  public void setAvatar_id(int avatar_id) {
    this.avatar_id = avatar_id;
  }

  public Date getUserDate() {
    return userDate;
  }

  public void setUserDate(Date userDate) {
    this.userDate = userDate;
  }

  public String getDelYn() {
    return delYn;
  }

  public void setDelYn(String delYn) {
    this.delYn = delYn;
  }

  @Override
  public String toString() {
    return "MemberVo{" +
        "userIdx=" + userIdx +
        ", username='" + username + '\'' +
        ", userPw='" + userPw + '\'' +
        ", userPn='" + userPn + '\'' +
        ", userMail='" + userMail + '\'' +
        ", avatar_id=" + avatar_id +
        ", userDate=" + userDate +
        ", delYn='" + delYn + '\'' +
        '}';
  }
}
