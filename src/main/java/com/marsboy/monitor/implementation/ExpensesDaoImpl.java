package com.marsboy.monitor.implementation;

import com.marsboy.monitor.dao.ExpensesDao;
import com.marsboy.monitor.model.Expenses;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ExpensesDaoImpl extends AbstractDesignDaoImpl<Expenses,Integer> implements ExpensesDao{
    public ExpensesDaoImpl() {
        super(Expenses.class);
    }
}
