package dev.debride.daos;

import dev.debride.entities.Employee;
import dev.debride.entities.Expense;
import dev.debride.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class ExpenseDaoHibernate implements ExpenseDAO{

    private SessionFactory sf = HibernateUtil.getSessionFactory();


    @Override
    public Expense createRequest(Expense expense) {

        try(Session sess = sf.openSession()){

            sess.getTransaction().begin();
            sess.save(expense);
            sess.getTransaction().commit();
            sess.close();
            return expense;

        }catch (SessionException s){
            s.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Expense> getAllRequests() {

        try(Session sess = sf.openSession()){
            String hql = "FROM Expense e";
            Query query = sess.createQuery(hql);

            List<Expense> expenses = query.list();
            System.out.println(expenses);
            sess.close();
            return expenses;
        }catch (SessionException s){
            s.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Expense> getAllRequestsForEmployee(int id) {
        try(Session sess = sf.openSession()){
            String hql = "FROM Expense e WHERE e.employeeId = :id";
            Query query = sess.createQuery(hql);
            query.setParameter("id", id);

            List<Expense> expenses = query.list();
            System.out.println(expenses);
            sess.close();
            return expenses;
        }catch (SessionException s){
            s.printStackTrace();
            return null;
        }

    }

    @Override
    public Expense getRequestById(Employee e, int rid) {
        try(Session sess = sf.openSession()){
            Expense expense = sess.get(Expense.class, rid);
            if (expense.getEmployeeId() == e.getId() || e.isManflag()){
                System.out.println(expense);
                sess.close();
                return expense;
            }else{
                sess.close();
                return null;
            }

        }catch (SessionException s){
            s.printStackTrace();
            return null;
        }
    }

    @Override
    public Expense updateRequest(Expense expense) {
        try(Session sess = sf.openSession()){
            sess.getTransaction().begin();
            sess.update(expense);
            sess.getTransaction().commit();
            sess.close();
            return expense;
        }catch (SessionException s){
            s.printStackTrace();
            return null;
        }

    }
}
