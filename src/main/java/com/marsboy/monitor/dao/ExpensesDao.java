package com.marsboy.monitor.dao;

import com.marsboy.monitor.model.Expenses;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ExpensesDao extends AbstractDesignDao<Expenses,Integer> {
    List<Expenses> getAllExpensesActive(Long userId);

    List<Expenses> getUserExpenseToCategoryActive(Long userId);

    List<Expenses> getAllExpensesActiveFromTo(Long userid, String from, String to);
}
