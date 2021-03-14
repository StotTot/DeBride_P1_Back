package dev.debride.utiltests;

import dev.debride.entities.Employee;
import dev.debride.util.HibernateUtil;
import dev.debride.util.PasswordCheckingUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordCheckingUtilTest {

    @Test
    void check_password(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Employee employee = sess.get(Employee.class, 1);
        System.out.println(employee);

        sess.close();
        Assertions.assertTrue(PasswordCheckingUtil.checkPass("test01", employee.getPhash()));
    }

}
