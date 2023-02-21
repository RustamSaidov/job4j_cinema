package ru.job4j.cinema.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.cinema.configuration.DatasourceConfiguration;
import ru.job4j.cinema.model.File;
import ru.job4j.cinema.model.Film;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;

import static java.time.LocalDateTime.now;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Sql2oFilmRepositoryTest {
    private static Sql2oFilmRepository sql2oFilmRepository;

//    private static Sql2oFileRepository sql2oFileRepository;

//    private static File file;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oFilmRepositoryTest.class.getClassLoader().getResourceAsStream("connection.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");

        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        var sql2o = configuration.databaseClient(datasource);

        sql2oFilmRepository = new Sql2oFilmRepository(sql2o);
//        sql2oFileRepository = new Sql2oFileRepository(sql2o);

//        file = new File("test", "test");
//        sql2oFileRepository.save(file);
    }

//    @AfterAll
//    public static void deleteFile() {
//        sql2oFileRepository.deleteById(file.getId());
//    }

    @AfterEach
    public void clearFilms() {
        var films = sql2oFilmRepository.findAll();
        for (var film : films) {
            sql2oFilmRepository.deleteById(film.getId());
        }
    }

    @Test
    public void whenSaveThenGetSame() {
        var film = sql2oFilmRepository.save(new Film(1, "test", "test", 1, 1, 1, 1, 1));
        var savedFilm = sql2oFilmRepository.findById(film.getId()).get();
        assertThat(savedFilm).usingRecursiveComparison().isEqualTo(film);
    }

    @Test
    public void whenSaveSeveralThenGetAll() {
        var film1 = sql2oFilmRepository.save(new Film(0, "test1", "test1", 1, 1, 1, 1, 1));
        var film2 = sql2oFilmRepository.save(new Film(0, "test2", "test2", 1, 1, 1, 1, 1));
        var film3 = sql2oFilmRepository.save(new Film(0, "test3", "test3", 1, 1, 1, 1, 1));
        var result = sql2oFilmRepository.findAll();
        assertThat(result).isEqualTo(List.of(film1, film2, film3));
    }

    @Test
    public void whenDontSaveThenNothingFound() {
        assertThat(sql2oFilmRepository.findAll()).isEqualTo(emptyList());
        assertThat(sql2oFilmRepository.findById(0)).isEqualTo(empty());
    }

    @Test
    public void whenDeleteThenGetEmptyOptional() {
        var creationDate = now().truncatedTo(ChronoUnit.MINUTES);
        var film = sql2oFilmRepository.save(new Film(1, "test", "test", 1, 1, 1, 1, 1));
        var isDeleted = sql2oFilmRepository.deleteById(film.getId());
        var savedFilm = sql2oFilmRepository.findById(film.getId());
        assertThat(isDeleted).isTrue();
        assertThat(savedFilm).isEqualTo(empty());
    }

    @Test
    public void whenDeleteByInvalidIdThenGetFalse() {
        assertThat(sql2oFilmRepository.deleteById(0)).isFalse();
    }
}
