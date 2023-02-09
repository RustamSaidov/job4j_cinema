package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Genre;
import ru.job4j.cinema.repository.GenreRepository;

import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleGenreService implements GenreService {

        private final GenreRepository genreRepository;


    public SimpleGenreService(GenreRepository sql2oGenreRepository) {
        this.genreRepository = sql2oGenreRepository;
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

//    @Override
//    public boolean deleteById(int id) {
//        var fileOptional = findById(id);
//        if (fileOptional.isEmpty()) {
//            return false;
//        }
//        var isDeleted = genreRepository.deleteById(id);
//        fileService.deleteById(fileOptional.get().getFileId());
//        return isDeleted;
//    }
//
//    @Override
//    public boolean update(Genre genre) {
//        var isNewFileEmpty = image.getContent().length == 0;
//        if (isNewFileEmpty) {
//            return vacancyRepository.update(vacancy);
//        }
//        /* если передан новый не пустой файл, то старый удаляем, а новый сохраняем */
//        var oldFileId = vacancy.getFileId();
//        saveNewFile(vacancy, image);
//        var isUpdated = vacancyRepository.update(vacancy);
//        fileService.deleteById(oldFileId);
//        return isUpdated;
//    }

    @Override
    public Optional<Genre> findById(int id) {
        return genreRepository.findById(id);
    }

    @Override
    public Collection<Genre> findAll() {
        return genreRepository.findAll();
    }

}
