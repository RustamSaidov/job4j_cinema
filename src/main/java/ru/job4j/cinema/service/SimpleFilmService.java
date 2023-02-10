package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FileDto;
import ru.job4j.cinema.dto.FilmDTO;
import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.repository.FilmRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleFilmService implements FilmService {

    private final FilmRepository filmRepository;

    private final FileService fileService;

    private final GenreService genreService;

    public SimpleFilmService(FilmRepository sql2oFilmRepository, FileService fileService, GenreService genreService) {
        this.filmRepository = sql2oFilmRepository;
        this.fileService = fileService;
        this.genreService = genreService;

    }

    @Override
    public Film save(Film film, FileDto image) {
        saveNewFile(film, image);
        return filmRepository.save(film);
    }

    private void saveNewFile(Film film, FileDto image) {
        var file = fileService.save(image);
        film.setFileId(file.getId());
    }

//    @Override
//    public Optional<FilmDTO> findById(int id) {
//        Film film = filmRepository.findById(id).get();
//        return Optional.of(new FilmDTO(film.getId(), film.getName(), film.getDescription(), film.getYear(),
//                getGenreNameById(film.getGenreId()), film.getMinimalAge(), film.getDurationInMinutes(),
//                fileService.getFileById(film.getFileId()).get().getContent()));
//    }

    private String getGenreNameById(int id){
        return genreService.findById(id).get().getName();
    }

    @Override
    public Collection<FilmDTO> findAll() {
        List<Film> list = (List<Film>) filmRepository.findAll();
        List<FilmDTO> listOfFilmDTO = new ArrayList<>();
        for(int i =0; i<list.size(); i++){
            listOfFilmDTO.add(new FilmDTO(list.get(i).getId(), list.get(i).getName(), list.get(i).getDescription(), list.get(i).getYear(),
                    getGenreNameById(list.get(i).getGenreId()), list.get(i).getMinimalAge(), list.get(i).getDurationInMinutes(),
                    fileService.getFileById(list.get(i).getFileId()).get().getContent()));
        }
        return listOfFilmDTO;
    }

}
