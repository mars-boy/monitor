package com.marsboy.monitor.dao;

import com.marsboy.monitor.model.Expenses;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesDao extends AbstractDesignDao<Expenses,Integer> {
}
