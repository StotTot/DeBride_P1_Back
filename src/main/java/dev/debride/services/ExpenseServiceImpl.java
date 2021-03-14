package dev.debride.services;

import dev.debride.daos.ExpenseDAO;
import dev.debride.entities.Employee;
import dev.debride.entities.Expense;

import java.util.List;

public class ExpenseServiceImpl implements ExpenseService{


    private ExpenseDAO edao;

    public ExpenseServiceImpl(ExpenseDAO expenseDAO) { this.edao = expenseDAO; }

    @Override
    public Expense createRequest(Expense expense) {
        expense.setStatus("pending");
        expense.setSubmitted(System.currentTimeMillis() / 1000);
        expense.setApprovedordenied(0);
        this.edao.createRequest(expense);
        return expense;
    }

    @Override
    public List<Expense> getAllRequests() {
        return this.edao.getAllRequests();
    }

    @Override
    public List<Expense> getAllRequestsForEmployee(int id) {
        return this.edao.getAllRequestsForEmployee(id);
    }

    @Override
    public Expense getRequestById(Employee e, int rid) {
        return this.edao.getRequestById(e,rid);
    }

    @Override
    public Expense updateRequest(Expense expense, String reason, String status) {
        expense.setReason(reason);
        expense.setStatus(status);
        expense.setApprovedordenied(System.currentTimeMillis() / 1000);

        return edao.updateRequest(expense);
    }

    @Override
    public Expense updateRequest(Expense expense) {
        expense.setApprovedordenied(System.currentTimeMillis() / 1000);

        return edao.updateRequest(expense);
    }
}
