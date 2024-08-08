package com.kb.record.service;

import java.util.List;

public class TotalRecordVo {
  private String recordIdx;
  private String delYn;
  private String memberId;
  private String categoryType;
  private String categoryName;
  private List<String> categories; // 배열 형태로 받을 필드 추가
  private String categoryIdx;
  private Integer amount;
  private String startDate; // 필드 이름 수정
  private String endDate; // 필드 이름 수정
  private String regDate;
  public String recordMemo;
  public String recordDetails;
  public String year; // id 별 가지고 있는 년도 체크
  public String months; // 년도별 월 체크

  @Override
  public String toString() {
    return "TotalRecordVo{" +
        "recordIdx='" + recordIdx + '\'' +
        ", delYn='" + delYn + '\'' +
        ", memberId='" + memberId + '\'' +
        ", categoryType='" + categoryType + '\'' +
        ", categoryName='" + categoryName + '\'' +
        ", categories=" + categories +
        ", categoryIdx='" + categoryIdx + '\'' +
        ", amount=" + amount +
        ", startDate='" + startDate + '\'' +
        ", endDate='" + endDate + '\'' +
        ", regDate='" + regDate + '\'' +
        ", recordMemo='" + recordMemo + '\'' +
        ", recordDetails='" + recordDetails + '\'' +
        ", year='" + year + '\'' +
        ", months='" + months + '\'' +
        '}';
  }

  public String getRecordIdx() {
    return recordIdx;
  }

  public void setRecordIdx(String recordIdx) {
    this.recordIdx = recordIdx;
  }

  public String getDelYn() {
    return delYn;
  }

  public void setDelYn(String delYn) {
    this.delYn = delYn;
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getCategoryType() {
    return categoryType;
  }

  public void setCategoryType(String categoryType) {
    this.categoryType = categoryType;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public List<String> getCategories() {
    return categories;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public String getCategoryIdx() {
    return categoryIdx;
  }

  public void setCategoryIdx(String categoryIdx) {
    this.categoryIdx = categoryIdx;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getRegDate() {
    return regDate;
  }

  public void setRegDate(String regDate) {
    this.regDate = regDate;
  }

  public String getRecordMemo() {
    return recordMemo;
  }

  public void setRecordMemo(String recordMemo) {
    this.recordMemo = recordMemo;
  }

  public String getRecordDetails() {
    return recordDetails;
  }

  public void setRecordDetails(String recordDetails) {
    this.recordDetails = recordDetails;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getMonths() {
    return months;
  }

  public void setMonths(String months) {
    this.months = months;
  }
}