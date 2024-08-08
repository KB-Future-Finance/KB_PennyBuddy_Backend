package com.kb.record.service;

import com.kb.record.service.TotalRecordVo;
import java.util.List;
import java.util.Map;

public interface RecordDao {
  List<TotalRecordVo> getList(Map<String, Object> params);
  int getTotalCount(TotalRecordVo vo);
  List<TotalRecordVo> getCategory(TotalRecordVo vo);
  List<TotalRecordVo> getTotalAmount(TotalRecordVo vo);
  void deleteRecord(TotalRecordVo vo);
  void insertRecord(TotalRecordVo vo);
  List<TotalRecordVo> getYear(TotalRecordVo vo);
  List<TotalRecordVo> getChartMonth(TotalRecordVo vo);
  List<TotalRecordVo> getChartName(TotalRecordVo vo);
  TotalRecordVo getResultAmount(TotalRecordVo vo);
  TotalRecordVo getDetail(TotalRecordVo vo);
  void updateRecord(TotalRecordVo vo);
}
