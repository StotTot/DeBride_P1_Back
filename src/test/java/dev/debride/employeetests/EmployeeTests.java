package dev.debride.employeetests;

import dev.debride.entities.Employee;
import dev.debride.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTests {
    @Test
    void get_employee(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Employee employee = sess.get(Employee.class, 1);
        System.out.println(employee);
        sess.close();
        Assertions.assertEquals(1, employee.getId());
    }
}
