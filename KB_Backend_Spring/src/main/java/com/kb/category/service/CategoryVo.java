package com.kb.category.service;


public class CategoryVo {
  private String categoryIdx;
  private String categoryName;
  private String categoryType;

  @Override
  public String toString() {
    return "CategoryVo{" +
        "categoryIdx='" + categoryIdx + '\'' +
        ", categoryName='" + categoryName + '\'' +
        ", categoryType='" + categoryType + '\'' +
        '}';
  }

  public String getCategoryIdx() {
    return categoryIdx;
  }

  public void setCategoryIdx(String categoryIdx) {
    this.categoryIdx = categoryIdx;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getCategoryType() {
    return categoryType;
  }

  public void setCategoryType(String categoryType) {
    this.categoryType = categoryType;
  }
}
