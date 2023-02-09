package ru.job4j.cinema.service;

import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.model.Genre;

import java.util.Collection;
import java.util.Optional;

public interface GenreService {

    Genre save(Genre genre);

//    boolean deleteById(int id);
//
//    boolean update(Genre genre);

    Optional<Genre> findById(int id);

    Collection<Genre> findAll();
}
