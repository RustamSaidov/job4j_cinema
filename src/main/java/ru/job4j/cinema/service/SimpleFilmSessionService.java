package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.repository.FilmRepository;
import ru.job4j.cinema.repository.FilmSessionRepository;

import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleFilmSessionService implements FilmSessionService {

    private final FilmSessionRepository filmSessionRepository;

    public SimpleFilmSessionService(FilmSessionRepository sql2oFilmSessionRepository) {
        this.filmSessionRepository = sql2oFilmSessionRepository;

    }
    @Override
    public FilmSession save(FilmSession filmSession) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean update(FilmSession filmSession) {
        return false;
    }

    @Override
    public Optional<FilmSession> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<FilmSession> findAll() {
        return filmSessionRepository.findAll();
    }
}
