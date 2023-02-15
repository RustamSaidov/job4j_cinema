package ru.job4j.cinema.service;

import ru.job4j.cinema.dto.FilmSessionDTO;

import java.util.Collection;

public interface FilmSessionService {

    Collection<FilmSessionDTO> findAll();
}
