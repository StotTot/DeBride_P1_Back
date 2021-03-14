package dev.debride.controllers;

import dev.debride.util.JwtUtil;
import io.javalin.http.Handler;
import org.apache.log4j.Logger;

public class LoginController {


    private static Logger logger = Logger.getLogger("Login");

    public Handler loginHandler = (ctx) -> {
        String uname = ctx.pathParam("uname");
        String pass = ctx.pathParam("pass");
        String jwt = JwtUtil.generate(uname, pass);
        logger.info(uname + " has logged on.");
        ctx.result(jwt);
        ctx.status(201);
    };

}
