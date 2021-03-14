package dev.debride.servicetests;

import dev.debride.daos.ExpenseDaoHibernate;
import dev.debride.entities.Expense;
import dev.debride.services.ExpenseService;
import dev.debride.services.ExpenseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ExpenseServiceTest {


    private ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDaoHibernate());



    @Test
    void create_request(){
        Expense e1 = new Expense(1, 500.00, "", "pending", 0, 0, 1);
        expenseService.createRequest(e1);
        System.out.println(e1);
        Assertions.assertNotEquals(0, e1.getSubmitted());
    }

    @Test
    void update_request(){
        Expense e = new Expense(2, 10.00, "", "pending", 0, 0, 1);

        e.setStatus("approved");
        e.setReason("mockito");


        System.out.println(expenseService.updateRequest(e));
        Assertions.assertNotEquals(0, expenseService.updateRequest(e).getApprovedordenied());


    }
}
