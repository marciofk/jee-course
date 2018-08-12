package nl.hva.jeecourse.module09.jwt.resource;

import nl.hva.jeecourse.module09.jwt.filter.JwtTokenMandatory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/echo")
@Produces(TEXT_PLAIN)
public class EchoResource {

    @GET
    public Response echo(@QueryParam("message") String message) {
        return Response.ok().entity(message == null ? "no message" : message).build();
    }

    @GET
    @Path("jwt")
    @JwtTokenMandatory
    public Response echoWithJWTToken(@QueryParam("message") String message) {
        return Response.ok().entity(message == null ? "no message" : message).build();
    }
}