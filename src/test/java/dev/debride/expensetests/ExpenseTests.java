package dev.debride.expensetests;


import dev.debride.entities.Expense;
import dev.debride.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ExpenseTests {


    @Test
    void get_requests(){
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try(Session sess = sf.openSession()){
            String hql = "FROM Expense e WHERE e.status = 'pending'";
            Query query = sess.createQuery(hql);

            List<Expense> expenses = query.list();
            System.out.println(expenses);

            sess.close();

            Assertions.assertTrue(expenses.size() > 1);
        }catch (SessionException s){
            s.printStackTrace();
        }


    }



}
