package com.kb.record.service;

import java.util.List;
import java.util.Map;

public interface RecordService {
  Map<String, Object> getList(int page, int size, TotalRecordVo vo);
  int getTotalCount(TotalRecordVo vo);
  Map<String, Object> getCategory(TotalRecordVo vo);
  Map<String, Object> getTotalAmount(TotalRecordVo vo);
  void deleteRecord(TotalRecordVo vo);
  void insertRecord(TotalRecordVo vo);
  Map<String, Object> getYear(TotalRecordVo vo);
  Map<String, Object> getChartMonth(TotalRecordVo vo);
  Map<String, Object> getChartName(TotalRecordVo vo);
  Map<String, Object> getResultAmount(TotalRecordVo vo);
  Map<String, Object> getDetail(TotalRecordVo vo);
  void updateRecord(TotalRecordVo vo);
}
