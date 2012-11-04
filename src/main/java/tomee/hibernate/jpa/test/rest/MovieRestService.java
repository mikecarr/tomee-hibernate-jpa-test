package tomee.hibernate.jpa.test.rest;

import tomee.hibernate.jpa.test.entity.Movie;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * User: mcarr
 * Date: 10/31/12
 */

@Path("/movies")
@Produces({"text/xml", "application/json"})
public interface MovieRestService {

    @GET
    @Path("/list")
    @Produces("application/xml")
    public List<Movie> list() throws Exception;
}
