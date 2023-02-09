package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FileDto;
import ru.job4j.cinema.dto.FilmDTO;
import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.repository.FilmRepository;

import java.util.Collection;
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

    @Override
    public boolean deleteById(int id) {
        var fileOptional = findById(id);
        if (fileOptional.isEmpty()) {
            return false;
        }
        var isDeleted = filmRepository.deleteById(id);
        fileService.deleteById(fileOptional.get().getFileId());
        return isDeleted;
    }

    @Override
    public boolean update(Film film, FileDto image) {
        var isNewFileEmpty = image.getContent().length == 0;
        if (isNewFileEmpty) {
            return filmRepository.update(film);
        }
        /* если передан новый не пустой файл, то старый удаляем, а новый сохраняем */
        var oldFileId = film.getFileId();
        saveNewFile(film, image);
        var isUpdated = filmRepository.update(film);
        fileService.deleteById(oldFileId);
        return isUpdated;
    }

//    @Override
//    public Optional<Film> findById(int id) {
//        return filmRepository.findById(id);
//    }
//
//    @Override
//    public Collection<Film> findAll() {
//        return filmRepository.findAll();
//    }

    @Override
    public Optional<FilmDTO> findById(int id) {
        Film film = filmRepository.findById(id);
        return new FilmDTO(film.getId(), film.getName(),film.getDescription(),film.getYear(),
                getGenreNameById(film.getGenreId()), film.getMinimalAge(), film.getDurationInMinutes(),
                );
        private String name;
        private String description;
        private int year;
        private String genre;
        private int minimalAge;
        private int durationInMinutes;
        private byte[] content;)
    }

    private String getGenreNameById(int id){
        return genreService.findById(id).get().getName();
    }

    @Override
    public Collection<FilmDTO> findAll() {
        return filmRepository.findAll();
    }

}
