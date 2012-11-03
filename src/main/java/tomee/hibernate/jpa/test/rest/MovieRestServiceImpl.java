package tomee.hibernate.jpa.test.rest;

import tomee.hibernate.jpa.test.entity.Movie;
import tomee.hibernate.jpa.test.service.MovieServiceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * User: mcarr
 * Date: 10/31/12
 */
@Stateless
@Path("/movies")
@Produces({"text/xml", "application/json"})
public class MovieRestServiceImpl implements MovieRestService{

    @EJB
    MovieServiceImpl movieService;

    @Override
    @GET
    @Path("/list")
    @Produces("application/xml")
    public List<Movie> list() throws Exception {

        List<Movie> movies = movieService.getMovies();
        return movies;
    }
}
