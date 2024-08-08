package com.kb.record.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.kb.record.service.RecordService;
import com.kb.record.service.TotalRecordVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "/api")
public class RecordController {

  @Autowired
  private RecordService recordService;

  // 거래내역 출력
  @GetMapping("/record/list")
  public ResponseEntity<String> getList(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size,
      @ModelAttribute TotalRecordVo vo) {

    System.out.println("Received filter data: " + vo.toString());

    if (vo.getCategories() != null && vo.getCategories().isEmpty()) {
      vo.setCategories(null);
    }

    try {
      Map<String, Object> result = recordService.getList(page, size, vo);
      int totalRecords = recordService.getTotalCount(vo);
      int totalPages = (int) Math.ceil((double) totalRecords / size);

      System.out.println("Total Records: " + totalRecords); // 총 레코드 수 확인
      System.out.println("Total Pages: " + totalPages); // 총 페이지 수 확인
      System.out.println("Current Page: " + page); // 현재 페이지 확인

      result.put("currentPage", page);
      result.put("totalPages", totalPages);

      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      objectMapper.setDateFormat(new StdDateFormat());

      String jsonString = objectMapper.writeValueAsString(result);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(new MediaType("application", "json", java.nio.charset.StandardCharsets.UTF_8));

      return new ResponseEntity<>(jsonString, headers, HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }



  // 총 수입, 지출 구하기
  @GetMapping("/record/totalAmount")
  public ResponseEntity<String> getTotalAmount(TotalRecordVo vo) {
    try {
      Map<String, Object> result = recordService.getTotalAmount(vo);

      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      objectMapper.setDateFormat(new StdDateFormat());

      String jsonString = objectMapper.writeValueAsString(result);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(new MediaType("application", "json", java.nio.charset.StandardCharsets.UTF_8));

      return new ResponseEntity<>(jsonString, headers, HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // 아이디별 가지고 있는 카테고리 타입(수입,지출), 카테고리 명 출력
  @GetMapping("/record/category")
  public ResponseEntity<String> getCategory(TotalRecordVo vo) {
    try {
      Map<String, Object> result = recordService.getCategory(vo);

      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      objectMapper.setDateFormat(new StdDateFormat());

      String jsonString = objectMapper.writeValueAsString(result);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(new MediaType("application", "json", java.nio.charset.StandardCharsets.UTF_8));

      return new ResponseEntity<>(jsonString, headers, HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // 삭제 버튼 클릭 시 id기준으로 삭제(delYn 타입 변경).
  @GetMapping("/record/delete")
  public void getDeleteRecord(TotalRecordVo vo) {
    System.out.println("Delete Record: " + vo.toString());
    System.out.println("RecordIdx : " +vo.getRecordIdx());
    System.out.println("Member_Id : " +vo.getMemberId());
    recordService.deleteRecord(vo);
  }
  // insert
  @GetMapping("/record/insert")
  public void insert(TotalRecordVo vo){
    System.out.println("Insert Record : " + vo.toString());
    recordService.insertRecord(vo);
  }
  // 아이디별 데이터 있는 년도 출력
  @GetMapping("/record/year")
  public ResponseEntity<String> getYear(TotalRecordVo vo){
    try {
      System.out.println("Year 호출, MemberId : " +vo.getMemberId());
      Map<String, Object> result = recordService.getYear(vo);

      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      objectMapper.setDateFormat(new StdDateFormat());

      String jsonString = objectMapper.writeValueAsString(result);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(new MediaType("application", "json", java.nio.charset.StandardCharsets.UTF_8));

      return new ResponseEntity<>(jsonString, headers, HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

//  차트 출력 년도랑 ID 파라미터로 받아서
//  월 별 합계 출력
  @GetMapping("/record/chartMonth")
  public ResponseEntity<String> getChartMonth(TotalRecordVo vo){
    try {
      System.out.println("chartMonth 호출, MemberId : " +vo.getMemberId());
      System.out.println("chartMonth 호출, Year : " +vo.getYear());
      Map<String, Object> result = recordService.getChartMonth(vo);

      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      objectMapper.setDateFormat(new StdDateFormat());

      String jsonString = objectMapper.writeValueAsString(result);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(new MediaType("application", "json", java.nio.charset.StandardCharsets.UTF_8));

      return new ResponseEntity<>(jsonString, headers, HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //  차트 출력 년도랑 ID 파라미터로 받아서
  //  카테고리 이름 별 합계 출력
  @GetMapping("/record/chartName")
  public ResponseEntity<String> getChartName(TotalRecordVo vo){
    try {
      System.out.println("ChartName 호출, MemberId : " +vo.getMemberId());
      System.out.println("ChartName 호출, Year : " +vo.getYear());
      Map<String, Object> result = recordService.getChartName(vo);

      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      objectMapper.setDateFormat(new StdDateFormat());

      String jsonString = objectMapper.writeValueAsString(result);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(new MediaType("application", "json", java.nio.charset.StandardCharsets.UTF_8));

      return new ResponseEntity<>(jsonString, headers, HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // 아이디별, 기록한 총 수입-지출 결과 return
  @GetMapping("/record/resultAmount")
  public ResponseEntity<String> getResultAmount(TotalRecordVo vo){
    try {
      System.out.println("resultAmount 호출, MemberId : " +vo.getMemberId());
      Map<String, Object> result = recordService.getResultAmount(vo);

      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      objectMapper.setDateFormat(new StdDateFormat());

      String jsonString = objectMapper.writeValueAsString(result);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(new MediaType("application", "json", java.nio.charset.StandardCharsets.UTF_8));

      return new ResponseEntity<>(jsonString, headers, HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

//   상세 페이지
//   거래내역 출력
  @GetMapping("/record/detail")
  public ResponseEntity<String> getDetail(TotalRecordVo vo){
    try {
      System.out.println("getDetail 호출, MemberId : " +vo.getMemberId());
      System.out.println("getDetail 호출, Record_id : " +vo.getMemberId());
      Map<String, Object> result = recordService.getDetail(vo);

      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      objectMapper.setDateFormat(new StdDateFormat());

      String jsonString = objectMapper.writeValueAsString(result);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(new MediaType("application", "json", java.nio.charset.StandardCharsets.UTF_8));

      return new ResponseEntity<>(jsonString, headers, HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // update
  @GetMapping("/record/update")
  public void update(TotalRecordVo vo){
    System.out.println("update Record : " + vo.toString());
    recordService.updateRecord(vo);
  }


}
