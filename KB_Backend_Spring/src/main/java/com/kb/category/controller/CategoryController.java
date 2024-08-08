package com.kb.category.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.kb.category.service.CategoryService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "/api")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  // 카테고리 내역 출력
  @GetMapping("/category/list")
  public ResponseEntity<String> getList(){
    try {
      System.out.println("Category List 호출");
      Map<String, Object> result = categoryService.getList();

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




}
