package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Ticket;

import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleTicketService implements TicketService {
    @Override
    public Ticket save(Ticket ticket) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean update(Ticket ticket) {
        return false;
    }

    @Override
    public Optional<Ticket> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Ticket> findAll() {
        return null;
    }
}
