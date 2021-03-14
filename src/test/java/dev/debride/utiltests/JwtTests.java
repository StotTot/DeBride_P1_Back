package dev.debride.utiltests;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.debride.util.JwtUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JwtTests {

    @Test
    void creates_jwt(){
        String jwt = JwtUtil.generate("ADeBride","test01");
        System.out.println(jwt);
    }

    @Test
    void decode_jwt(){
        DecodedJWT jwt = JwtUtil.isValidJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtYW5GbGFnIjp0cnVlLCJ1c2VyTmFtZSI6IkFEZUJyaWRlIn0.ONOH5AQ8s6SxNNqoZHha1-AphqBcZccdx1Abn5pjfjY");
        System.out.println(jwt);
        Boolean role = jwt.getClaim("manFlag").asBoolean();

        System.out.println(role);
        Assertions.assertTrue(role);
    }
}
