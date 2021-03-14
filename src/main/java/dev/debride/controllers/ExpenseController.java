package dev.debride.controllers;

import com.google.gson.Gson;
import dev.debride.daos.EmployeeDaoHibernate;
import dev.debride.daos.ExpenseDaoHibernate;
import dev.debride.entities.Employee;
import dev.debride.entities.Expense;
import dev.debride.services.EmployeeService;
import dev.debride.services.EmployeeServiceImpl;
import dev.debride.services.ExpenseService;
import dev.debride.services.ExpenseServiceImpl;
import io.javalin.http.Handler;
import org.apache.log4j.Logger;

import java.util.List;

public class ExpenseController {

    private ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDaoHibernate());
    private EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDaoHibernate());
    private static Logger logger = Logger.getLogger("Login");

    public Handler getAllRequestsForIdHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("eid"));
        String uname = ctx.pathParam("uname");
        Employee employee = this.employeeService.getEmp(uname);
        if(employee.getId() == id || employee.isManflag()){
            List<Expense> requests = this.expenseService.getAllRequestsForEmployee(id);
            if(requests == null){
                ctx.result("No requests found.");
                logger.info("No requests found");
                ctx.status(404);
            }else{
                Gson gson = new Gson();
                String requestsJSON = gson.toJson(requests);
                logger.info("Got requests");
                ctx.result(requestsJSON);
                ctx.status(200);
            }
        }else{
            ctx.result("You don't have access");
            ctx.status(403);
        }


    };

    public Handler getAllRequestsHandler = (ctx) -> {
        String uname = ctx.pathParam("uname");
        Employee employee = this.employeeService.getEmp(uname);
        if(employee.isManflag()){
            List<Expense> requests = this.expenseService.getAllRequests();
            if(requests == null){
                ctx.result("No requests found.");
                logger.info("No requests found");
                ctx.status(404);
            }else{
                Gson gson = new Gson();
                String requestsJSON = gson.toJson(requests);
                ctx.result(requestsJSON);
                ctx.status(200);
            }
        }else{
            ctx.result("You don't have access");
            ctx.status(403);
        }
    };

    public Handler getRequestByIdHandler = (ctx) -> {
        String uname = ctx.pathParam("uname");
        int id = Integer.parseInt(ctx.pathParam("rid"));
        Employee employee = this.employeeService.getEmp(uname);

        Expense expense = this.expenseService.getRequestById(employee, id);
        if(expense == null){
            ctx.result("No requests found.");
            logger.info("No requests found");
            ctx.status(404);
        }else{
            Gson gson = new Gson();
            String requestsJSON = gson.toJson(expense);
            ctx.result(requestsJSON);
            ctx.status(200);
        }

    };

    public Handler createRequestHandler = (ctx) -> {
        String uname = ctx.pathParam("uname");
        Employee employee = this.employeeService.getEmp(uname);
        String body = ctx.body();
        Gson gson = new Gson();

        Expense expense = gson.fromJson(body, Expense.class);
        System.out.println(expense);

        if(expense.getEmployeeId() == employee.getId() || employee.isManflag()){
            this.expenseService.createRequest(expense);
            String json = gson.toJson(expense);
            logger.info("Created new request");
            ctx.result("Request created\n" + json);
            ctx.status(201);
        }else{
            ctx.result("Can not create request due to you are either not a manager or not the user stated in this expense.");
            ctx.status(403);
        }

    };

    public Handler updateRequestHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("rid"));
        String uname = ctx.pathParam("uname");
        Employee employee = this.employeeService.getEmp(uname);
        String body = ctx.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(body, Expense.class);
        expense.setId(id);
        if(employee.isManflag()){
            this.expenseService.updateRequest(expense);
            logger.info("Expense " + expense.getId() + " was updated");
            ctx.result("Expense was updated");
            ctx.status(200);
        }else{
            ctx.result("You are not a manager. Only managers can modify requests.");
            ctx.status(403);
        }

    };

}
