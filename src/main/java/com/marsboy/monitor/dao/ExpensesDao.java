package com.marsboy.monitor.dao;

import com.marsboy.monitor.model.Expenses;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesDao extends AbstractDesignDao<Expenses,Integer> {
    List<Expenses> getAllExpensesActive(Long userId);
}
