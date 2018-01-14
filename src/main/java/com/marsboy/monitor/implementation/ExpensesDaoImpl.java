package com.marsboy.monitor.implementation;

import com.marsboy.monitor.dao.ExpensesDao;
import com.marsboy.monitor.model.Expenses;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ExpensesDaoImpl extends AbstractDesignDaoImpl<Expenses,Integer> implements ExpensesDao{
    public ExpensesDaoImpl() {
        super(Expenses.class);
    }

    @Override
    public List<Expenses> getAllExpensesActive(Long userId) {
        Query query = getCurrentSession().createQuery("from Expenses exp where exp.status = 1 and exp.user = ?").setLong(0,userId);
        return query.list();
    }
}
