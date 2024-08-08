package com.kb.record.service;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class RecordVo {
  private Integer recordId;  // record 번호
  private Integer amount;     // 금액
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;  // 시작 날짜
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate; // 종료 날짜
  private Integer memberId; // 멤버 ID
  private Integer categoryIdx;  // 카테고리 번호
  private Integer categoryType;  // 카테고리 타입
  private String recordMemo; // 메모 ( 타이틀 )
  private String recordDetails;  // 메모 ( 상세 내용 )
  private Integer delYn;  // 삭제 여부
  private Integer checkDate;

  @Override
  public String toString() {
    return "RecordVo{" +
        "recordId=" + recordId +
        ", amount=" + amount +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", memberId=" + memberId +
        ", categoryIdx=" + categoryIdx +
        ", categoryType=" + categoryType +
        ", recordMemo='" + recordMemo + '\'' +
        ", recordDetails='" + recordDetails + '\'' +
        ", delYn=" + delYn +
        ", checkDate=" + checkDate +
        '}';
  }

  public Integer getRecordId() {
    return recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Integer getMemberId() {
    return memberId;
  }

  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  public Integer getCategoryIdx() {
    return categoryIdx;
  }

  public void setCategoryIdx(Integer categoryIdx) {
    this.categoryIdx = categoryIdx;
  }

  public Integer getCategoryType() {
    return categoryType;
  }

  public void setCategoryType(Integer categoryType) {
    this.categoryType = categoryType;
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

  public Integer getDelYn() {
    return delYn;
  }

  public void setDelYn(Integer delYn) {
    this.delYn = delYn;
  }

  public Integer getCheckDate() {
    return checkDate;
  }

  public void setCheckDate(Integer checkDate) {
    this.checkDate = checkDate;
  }
}