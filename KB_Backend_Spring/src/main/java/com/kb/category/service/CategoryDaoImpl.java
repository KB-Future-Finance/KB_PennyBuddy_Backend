package com.kb.category.service;


import com.kb.record.service.TotalRecordVo;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

  @Autowired
  SqlSessionTemplate sm;

  @Override
  public List<CategoryVo> getList() {
    return sm.selectList("Category.getList");
  }
}
