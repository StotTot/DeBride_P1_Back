package dev.debride.app;

import dev.debride.controllers.ExpenseController;
import dev.debride.controllers.LoginController;
import io.javalin.Javalin;


public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create(
                config ->{
                    config.enableCorsForAllOrigins();
                }
        );

        ExpenseController expenseController = new ExpenseController();
        LoginController loginController = new LoginController();

        // GET all requests for that id
        app.get("/users/:uname/:eid/requests", expenseController.getAllRequestsForIdHandler);

        // GET all requests
        app.get("/users/:uname/requests", expenseController.getAllRequestsHandler);

        // GET request by id
        app.get("/users/:uname/requests/:rid", expenseController.getRequestByIdHandler);

        // POST create new request
        app.post("/users/:uname/requests", expenseController.createRequestHandler);

        // PUT update request
        app.put("/users/:uname/requests/:rid", expenseController.updateRequestHandler);

        // POST login
        app.post("/users/login/:uname/:pass", loginController.loginHandler);

        app.start(7000);
    }
}
