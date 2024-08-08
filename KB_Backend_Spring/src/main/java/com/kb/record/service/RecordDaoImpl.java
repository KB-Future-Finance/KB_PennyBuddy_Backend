package com.kb.record.service;

import com.kb.record.service.TotalRecordVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RecordDaoImpl implements RecordDao {

  @Autowired
  private SqlSession sm;

  @Override
  public List<TotalRecordVo> getList(Map<String, Object> params) {
    return sm.selectList("Record.getList", params);
  }

  @Override
  public int getTotalCount(TotalRecordVo vo) {
    return sm.selectOne("Record.getTotalCount", vo);
  }

  @Override
  public List<TotalRecordVo> getCategory(TotalRecordVo vo) {
    return sm.selectList("Record.getCategory", vo);
  }

  @Override
  public List<TotalRecordVo> getTotalAmount(TotalRecordVo vo) {
    return sm.selectList("Record.getTotalAmount", vo);
  }

  @Override
  public void deleteRecord(TotalRecordVo vo) {
    sm.update("Record.deleteRecord", vo);
  }

  @Override
  public void insertRecord(TotalRecordVo vo) {
    sm.insert("Record.insertRecord", vo);
  }

  @Override
  public List<TotalRecordVo> getYear(TotalRecordVo vo){
    return sm.selectList("Record.getYear", vo);
  }

  @Override
  public List<TotalRecordVo> getChartMonth(TotalRecordVo vo) {
    return sm.selectList("Record.getChartMonth", vo);
  }

  @Override
  public List<TotalRecordVo> getChartName(TotalRecordVo vo) {
    return sm.selectList("Record.getChartName", vo);
  }

  @Override
  public TotalRecordVo getResultAmount(TotalRecordVo vo) {
    return sm.selectOne("Record.getResultAmount", vo);
  }

  @Override
  public TotalRecordVo getDetail(TotalRecordVo vo) {
    return sm.selectOne("Record.getDetail", vo);
  }

  @Override
  public void updateRecord(TotalRecordVo vo) {
    sm.update("Record.updateRecord", vo);
  }
}
