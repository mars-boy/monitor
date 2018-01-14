package com.marsboy.monitor.implementation;

import com.marsboy.monitor.dao.CategoriesDao;
import com.marsboy.monitor.model.Categories;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoriesDaoImpl extends AbstractDesignDaoImpl<Categories,Integer> implements CategoriesDao {
    public CategoriesDaoImpl() {
        super(Categories.class);
    }

    @Override
    public List<Categories> getAllCategories() {
        Query query = getCurrentSession().createQuery("from Categories cat");
        return query.list();
    }
}
