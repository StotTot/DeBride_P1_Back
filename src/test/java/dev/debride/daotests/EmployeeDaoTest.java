package dev.debride.daotests;

import dev.debride.daos.EmployeeDAO;
import dev.debride.daos.EmployeeDaoHibernate;
import dev.debride.entities.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeDaoTest {

    private static EmployeeDAO edao = new EmployeeDaoHibernate();

    @Test
    void get_pass(){
        System.out.println(edao.getEmp("ADeBride"));

        Assertions.assertEquals("$2a$04$k6lDiMZ2LJZqdz8ga/qS1ev1PpabYbdLiCebjd2BBqrgp1SCqIDni", edao.getEmp("ADeBride").getPhash());

    }
}
