package ru.job4j.cinema.repository;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;

@ThreadSafe
@Repository
public class Sql2oFilmSessionRepository implements FilmSessionRepository {
}
