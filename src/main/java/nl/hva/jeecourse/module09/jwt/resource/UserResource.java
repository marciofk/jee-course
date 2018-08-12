package nl.hva.jeecourse.module09.jwt.resource;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nl.hva.jeecourse.module09.jwt.JWTUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.security.Key;
import java.util.Date;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;


@Path("login")
public class UserResource {

    @POST
    @Consumes(APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("login") String login,
                                     @FormParam("password") String password,
                                     @Context UriInfo uri) {
        try {

            // Authenticate the user using the credentials provided
            if(!"admin".equals(login) || !"master".equals(password)) {
                System.out.println(login);
                System.out.println(password);
                throw new IllegalAccessException("Not authorized!");
            }

            // Issue a token for the user
            String token = issueToken(login,uri);

            // Return the token on the response
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return Response.status(UNAUTHORIZED).build();
        }
    }

    private String issueToken(String login, UriInfo uri) {
        Key key = JWTUtils.getKey();

        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uri.getPath())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+15*60*1000)) // 15 minutes
                .signWith(SignatureAlgorithm.HS512,key)
                .compact();

        return jwtToken;
    }
}
