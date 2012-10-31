package tomee.hibernate.jpa.test.rest;

import tomee.hibernate.jpa.test.entity.Movie;

import java.util.List;

/**
 * User: mcarr
 * Date: 10/31/12
 */
public interface MovieRestService {

    public List<Movie> list() throws Exception;
}
