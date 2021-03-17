package dev.debride.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.interfaces.DecodedJWT;

import dev.debride.daos.EmployeeDaoHibernate;

import dev.debride.services.EmployeeService;
import dev.debride.services.EmployeeServiceImpl;

public class JwtUtil {



    private static final String secret ="super secret string no one else should ever have";
    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

    private static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDaoHibernate());

    public static String generate(String uName, String pPass){

        if(PasswordCheckingUtil.checkPass(pPass, employeeService.getEmp(uName).getPhash())){
            String token = JWT.create()
                    .withClaim("userName", uName)
                    .withClaim("manFlag", employeeService.getEmp(uName).isManflag())
                    .withClaim("id", employeeService.getEmp(uName).getId())
                    .sign(algorithm);
            return token;
        }else{
            return null;
        }

    }

    public static DecodedJWT isValidJWT(String token){
        //DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
        DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
        return jwt;
    }


}
