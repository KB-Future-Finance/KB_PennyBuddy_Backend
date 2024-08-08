package com.kb.record.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {

  @Autowired
  private RecordDao recordDao;

  /**
   * 거래 내역 조회
   * @param page
   * @param size
   * @param vo
   * @return : 거래 리스트
   */
  @Override
  public Map<String, Object> getList(int page, int size, TotalRecordVo vo) {
    int offset = (page - 1) * size;
    Map<String, Object> params = new HashMap<>();
    params.put("offset", offset);
    params.put("pageSize", size);
    params.put("delYn", vo.getDelYn());
    params.put("memberId", vo.getMemberId());
    params.put("categoryType", vo.getCategoryType());
    params.put("categories", vo.getCategories());
    params.put("startDate", vo.getStartDate());
    params.put("endDate", vo.getEndDate());
    List<TotalRecordVo> records = recordDao.getList(params);
    int totalRecords = recordDao.getTotalCount(vo);
    int totalPages = (int) Math.ceil((double) totalRecords / size);

    Map<String, Object> response = new HashMap<>();
    response.put("records", records);
    response.put("currentPage", page);
    response.put("totalPages", totalPages);

    return response;
  }

  /**
   * 조회에 따른 총 필터 개수 체크, 나중에 size랑 나눠서 페이징 처리에 사용
   * @param vo
   * @return 총 리스트 개수
   */
  @Override
  public int getTotalCount(TotalRecordVo vo) {
    return recordDao.getTotalCount(vo);
  }

  /**
   * 아이디, 날짜 기준으로 카테고리(수입,지출) 및 카테고리명 체크
   * @param vo
   * @return
   */
  @Override
  public Map<String, Object> getCategory(TotalRecordVo vo){
    List<TotalRecordVo> categories = recordDao.getCategory(vo);
    Map<String, Object> response = new HashMap<>();
    response.put("haveCategories", categories);
    return response;
  }
  
  /**
   * 필터링 기준 총 수입, 지출 출력
   * @param vo
   * @return
   */
  @Override
  public Map<String, Object> getTotalAmount(TotalRecordVo vo) {
    List<TotalRecordVo> totalAmountList = recordDao.getTotalAmount(vo);
    int totalIncome = 0;
    int totalExpense = 0;

    for (TotalRecordVo totalRecord : totalAmountList) {
      if ("1".equals(totalRecord.getCategoryType())) { // 1이 수입
        totalIncome += totalRecord.getAmount();
      } else if ("2".equals(totalRecord.getCategoryType())) { // 2가 지출
        totalExpense += totalRecord.getAmount();
      }
    }

    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("totalIncome", totalIncome);
    resultMap.put("totalExpense", totalExpense);

    return resultMap;
  }

  /**
   * 데이터 삭제
   * @param vo
   */
  @Override
  public void deleteRecord(TotalRecordVo vo){
    recordDao.deleteRecord(vo);
  }

  /**
   * 데이터 삽입
   * @param vo
   */
  @Override
  public void insertRecord(TotalRecordVo vo){
    recordDao.insertRecord(vo);
  }

  /**
   * 아이디 별 데이터 보유 년도 return
   * @param vo
   * @return
   */
  @Override
  public Map<String, Object> getYear(TotalRecordVo vo){
    List<TotalRecordVo> years =recordDao.getYear(vo);
    Map<String, Object> response = new HashMap<>();
    response.put("haveYears", years);
    return response;
  }

  /**
   * 년도, 아이디 기준 월 별 데이터 구하기
   * @param vo
   * @return
   */
  @Override
  public Map<String, Object> getChartMonth(TotalRecordVo vo){
    List<TotalRecordVo> chartMonth =recordDao.getChartMonth(vo);
    Map<String, Object> response = new HashMap<>();
    response.put("chartMonth", chartMonth);
    return response;
  }

  /**
   * 년도, 아이디 기준 카테고리 종류별 데이터 구하기
   * @param vo
   * @return
   */
  @Override
  public Map<String, Object> getChartName(TotalRecordVo vo){
    List<TotalRecordVo> chartName =recordDao.getChartName(vo);
    Map<String, Object> response = new HashMap<>();
    response.put("chartName", chartName);
    return response;
  }

  /**
   * 아이디 별 총 수입, 지출 구하기
   * @param vo
   * @return
   */
  @Override
  public Map<String, Object> getResultAmount(TotalRecordVo vo){
    TotalRecordVo amount =recordDao.getResultAmount(vo);
    Map<String, Object> response = new HashMap<>();
    response.put("amount", amount);
    return response;
  }

  /**
   * 레코드 번호 이용 상세 페이지 구하기
   * @param vo
   * @return
   */
  @Override
  public Map<String, Object> getDetail(TotalRecordVo vo){
    TotalRecordVo detail =recordDao.getDetail(vo);
    Map<String, Object> response = new HashMap<>();
    response.put("detail", detail);
    return response;
  }

  /**
   * 업데이트 구문
   * @param vo
   */
  @Override
  public void updateRecord(TotalRecordVo vo){
    recordDao.updateRecord(vo);
  }
}
