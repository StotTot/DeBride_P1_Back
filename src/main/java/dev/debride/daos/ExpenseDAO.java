package dev.debride.daos;

import dev.debride.entities.Employee;
import dev.debride.entities.Expense;

import java.util.List;


public interface ExpenseDAO {

    // CREATE
    Expense createRequest(Expense expense);

    // READ
    List<Expense> getAllRequests();
    List<Expense> getAllRequestsForEmployee(int id);
    Expense getRequestById(Employee e, int rid);
    // UPDATE
    Expense updateRequest(Expense expense);


}
