package dev.debride.daotests;


import dev.debride.daos.EmployeeDAO;
import dev.debride.daos.EmployeeDaoHibernate;
import dev.debride.daos.ExpenseDAO;
import dev.debride.daos.ExpenseDaoHibernate;
import dev.debride.entities.Employee;
import dev.debride.entities.Expense;
import dev.debride.services.ExpenseService;
import dev.debride.services.ExpenseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class ExpenseDaoTest {


    private static ExpenseDAO edao = new ExpenseDaoHibernate();
    private static EmployeeDAO employeeDAO = new EmployeeDaoHibernate();
    private ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDaoHibernate());


    @Test
    void create_request(){
        Expense expense = new Expense(1, 500.00, "", "pending", 0, 0, 2);
        expenseService.createRequest(expense);
        System.out.println(expense);

        Assertions.assertNotEquals(0, expense.getSubmitted());

    }

    @Test
    void get_all(){
        List<Expense> expenses = expenseService.getAllRequests();
        System.out.println(expenses);
        Assertions.assertTrue(expenses.size() > 1);
    }

    @Test
    void get_all_for_employee(){
        List<Expense> expenses = expenseService.getAllRequestsForEmployee(2);
        System.out.println(expenses);
        Assertions.assertTrue(expenses.size() > 1);
    }

    @Test
    void get_by_id(){
        Employee employee = employeeDAO.getEmp("ADeBride");
        Expense expense = expenseService.getRequestById(employee, 1);
        //System.out.println(expense);
        Assertions.assertEquals(1, expense.getId());
        Assertions.assertEquals(1, expense.getEmployeeId());
    }

    @Test
    void update_request(){
        Employee employee = employeeDAO.getEmp("ADeBride");
        Expense expense = expenseService.getRequestById(employee, 2);
        expenseService.updateRequest(expense, "Testing reasons thats why.","Approved");
        System.out.println(expense);
        Assertions.assertNotEquals(0, expense.getApprovedordenied());
        Assertions.assertNotEquals("pending", expense.getStatus());
    }



}
