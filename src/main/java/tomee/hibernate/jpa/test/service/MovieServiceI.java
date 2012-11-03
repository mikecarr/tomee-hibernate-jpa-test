package tomee.hibernate.jpa.test.service;

import tomee.hibernate.jpa.test.entity.Movie;

import java.util.List;

/**
 * User: mcarr
 * Date: 10/31/12
 */
public interface MovieServiceI {
    void addMovie(Movie movie) throws Exception;

    void deleteMovie(Movie movie) throws Exception;

    List<Movie> getMovies() throws Exception;
}
