package io.welldev.dao;

import io.welldev.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@RequiredArgsConstructor
@Component
@Transactional
public class MovieDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void add(Movie movie) {
        entityManager.persist(movie);
    }

    public Movie get(Long id) {
        Movie movie = entityManager.find(Movie.class, id);

        return movie;
    }

    public void delete(Long id) {
        entityManager.remove(entityManager.find(Movie.class, id));
    }

    public List<Movie> getAll() {
        List<Movie> movies = entityManager.createQuery("FROM Movie").getResultList();

        return movies;
    }

    public void update(Movie movie) {
        entityManager.merge(movie);

    }
}
