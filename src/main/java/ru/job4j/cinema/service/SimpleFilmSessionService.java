package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FilmSessionDTO;
import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.repository.FilmRepository;
import ru.job4j.cinema.repository.FilmSessionRepository;
import ru.job4j.cinema.repository.HallRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleFilmSessionService implements FilmSessionService {

    private final FilmSessionRepository filmSessionRepository;
    private final FilmRepository filmRepository;
    private final HallRepository hallRepository;

    public SimpleFilmSessionService(FilmSessionRepository sql2oFilmSessionRepository, FilmRepository sql2oFilmRepository, HallRepository sql2oHallRepository) {
        this.filmSessionRepository = sql2oFilmSessionRepository;
        this.filmRepository = sql2oFilmRepository;
        this.hallRepository = sql2oHallRepository;

    }

    @Override
    public Optional<FilmSession> findById(int id) {
        return filmSessionRepository.findById(id);
    }


    @Override
    public Collection<FilmSessionDTO> findAll() {
        List<FilmSession> list = (List<FilmSession>) filmSessionRepository.findAll();
        List<FilmSessionDTO> listOfFilmSessionDTO = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listOfFilmSessionDTO.add(new FilmSessionDTO(list.get(i).getId(),
                    filmRepository.findById(list.get(i).getFilmId()).get().getName(),
                    hallRepository.findById(list.get(i).getHallsId()).get().getName(),
                    list.get(i).getStartTime(),
                    list.get(i).getEndTime()
            ));
        }
        return listOfFilmSessionDTO;
    }
}
