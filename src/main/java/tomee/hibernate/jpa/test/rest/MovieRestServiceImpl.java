package tomee.hibernate.jpa.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import tomee.hibernate.jpa.test.entity.Movie;
import tomee.hibernate.jpa.test.service.MovieServiceImpl;

import javax.annotation.Resource;
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


public class MovieRestServiceImpl implements MovieRestService{

    @Autowired
    MovieServiceImpl movieService;

    public List<Movie> list() throws Exception {

        List<Movie> movies = movieService.getMovies();
        return movies;
    }
}
