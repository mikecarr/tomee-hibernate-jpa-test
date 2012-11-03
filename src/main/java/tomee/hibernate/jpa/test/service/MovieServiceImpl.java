package tomee.hibernate.jpa.test.service;

import org.springframework.stereotype.Service;
import tomee.hibernate.jpa.test.entity.Movie;

import java.util.List;

/**
 * User: mcarr
 * Date: 10/31/12
 */
@Service
public class MovieServiceImpl extends HibernateBaseService<Movie> implements MovieService {

    @Override
    public void addMovie(Movie movie) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteMovie(Movie movie) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Movie> getMovies() throws Exception {
        List<Movie> movies = findAll(Movie.class);
        return movies;
    }
}
