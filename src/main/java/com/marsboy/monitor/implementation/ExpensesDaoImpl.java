package com.marsboy.monitor.implementation;

import com.marsboy.monitor.dao.ExpensesDao;
import com.marsboy.monitor.model.Categories;
import com.marsboy.monitor.model.Expenses;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class ExpensesDaoImpl extends AbstractDesignDaoImpl<Expenses,Integer> implements ExpensesDao {
    public ExpensesDaoImpl() {
        super(Expenses.class);
    }

    @Override
    public List<Expenses> getAllExpensesActive(Long userId) {
        Query query = getCurrentSession().createQuery("from Expenses exp where exp.status = 1 and exp.user = ?").setLong(0, userId);
        return query.list();
    }

    @Override
    public List<Expenses> getUserExpenseToCategoryActive(Long userId) {
        StringBuilder sb = new StringBuilder("select cat.categoryname category, IFNULL(sum(exp.amount),0) amount from monitor.categories cat " +
                "left outer join monitor.expenses exp on cat.categoryid = exp.categoryid and exp.status = 1 " +
                "left join monitor.user usr on usr.userid = " + userId + " and usr.userid = exp.userid group by cat.categoryname,usr.userid;");
        SQLQuery query = getCurrentSession().createSQLQuery(sb.toString());
        List<Object[]> rows = query.list();
        List<Expenses> expensesList = new ArrayList<Expenses>();
        for (Object[] row : rows) {
            Expenses expense = new Expenses();
            Categories categories = new Categories();
            categories.setCategoryname(row[0].toString());
            expense.setCategories(categories);
            expense.setAmount(Integer.parseInt(row[1].toString()));
            expensesList.add(expense);
        }
        return expensesList;
    }

    @Override
    public List<Expenses> getAllExpensesActiveFromTo(Long userid, String from, String to) {
        Query query = getCurrentSession().createQuery("from Expenses exp where exp.status = 1 and exp.user = ? and actionmadedate between ? and ?").
                setLong(0, userid).setString(1,from).setString(2,to);
        return query.list();
    }
}
