package dev.debride.services;

import dev.debride.entities.Employee;
import dev.debride.entities.Expense;

import java.util.List;


public interface ExpenseService {

    // CREATE
    Expense createRequest(Expense expense);

    // READ
    List<Expense> getAllRequests();
    List<Expense> getAllRequestsForEmployee(int id);
    Expense getRequestById(Employee eid, int rid);
    // UPDATE
    Expense updateRequest(Expense expense, String reason, String status);
    Expense updateRequest(Expense expense);




}
