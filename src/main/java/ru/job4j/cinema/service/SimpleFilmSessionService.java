package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.FilmSession;

import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleFilmSessionService implements FilmSessionService {
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
        return null;
    }
}
