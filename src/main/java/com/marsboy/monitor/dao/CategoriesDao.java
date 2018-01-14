package com.marsboy.monitor.dao;

import com.marsboy.monitor.model.Categories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesDao extends AbstractDesignDao<Categories,Integer> {
    List<Categories> getAllCategories();
}
