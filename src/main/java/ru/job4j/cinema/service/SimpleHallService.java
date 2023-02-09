package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Hall;

import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleHallService implements HallService {
    @Override
    public Hall save(Hall hall) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean update(Hall hall) {
        return false;
    }

    @Override
    public Optional<Hall> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Hall> findAll() {
        return null;
    }
}
