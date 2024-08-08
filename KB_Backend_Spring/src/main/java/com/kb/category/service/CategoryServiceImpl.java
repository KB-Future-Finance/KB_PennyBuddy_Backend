package com.kb.category.service;

import com.kb.record.service.TotalRecordVo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryDao categoryDao;

  @Override
  public Map<String, Object> getList(){
    List<CategoryVo> categories =categoryDao.getList();
    Map<String, Object> response = new HashMap<>();
    response.put("categories", categories);
    return response;
  }
}
