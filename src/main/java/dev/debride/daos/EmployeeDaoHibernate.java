package dev.debride.daos;

import dev.debride.entities.Employee;


import dev.debride.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoHibernate implements EmployeeDAO{

    private SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public Employee getEmp(String uname) {
        try(Session sess = sf.openSession()){
            String hql = "FROM Employee e WHERE e.uname = :uname";
            Query query = sess.createQuery(hql);
            query.setParameter("uname", uname);

            List<Employee> employeeList = query.getResultList();
            System.out.println(employeeList.get(0));
            if (employeeList.get(0).getUname().equals(uname)){
                System.out.println(employeeList.get(0).getUname());
                System.out.println(employeeList.get(0).getPhash());
                sess.close();
                return employeeList.get(0);
            }else{
                sess.close();
                return null;
            }

        }catch (SessionException s){
            s.printStackTrace();
            return null;
        }
    }
}
