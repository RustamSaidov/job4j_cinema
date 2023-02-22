package ru.job4j.cinema.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.cinema.configuration.DatasourceConfiguration;
import ru.job4j.cinema.model.File;
import ru.job4j.cinema.model.FilmSession;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;

import static java.time.LocalDateTime.now;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Sql2oFilmSessionRepositoryTest {
    private static Sql2oFilmSessionRepository sql2oFilmSessionRepository;

    private static Sql2oFileRepository sql2oFileRepository;

    private static File file;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oFilmSessionRepositoryTest.class.getClassLoader().getResourceAsStream("connection.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");

        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        var sql2o = configuration.databaseClient(datasource);

        sql2oFilmSessionRepository = new Sql2oFilmSessionRepository(sql2o);
        sql2oFileRepository = new Sql2oFileRepository(sql2o);

        file = new File("test", "test");
        sql2oFileRepository.save(file);
    }

    @AfterAll
    public static void deleteFile() {
        sql2oFileRepository.deleteById(file.getId());
    }

    @AfterEach
    public void clearFilmSessions() {
        var filmSessions = sql2oFilmSessionRepository.findAll();
        for (var filmSession : filmSessions) {
            sql2oFilmSessionRepository.deleteById(filmSession.getId());
        }
    }

    @Test
    public void whenSaveThenGetSame() {
        var startTime = now().truncatedTo(ChronoUnit.MINUTES);
        var endTime = startTime.plusMinutes(90).truncatedTo(ChronoUnit.MINUTES);
        var filmSession = sql2oFilmSessionRepository.save(new FilmSession(1, 1, 1, startTime, endTime));
        var savedFilmSession = sql2oFilmSessionRepository.findById(filmSession.getId()).get();
        assertThat(savedFilmSession).usingRecursiveComparison().isEqualTo(filmSession);
    }

    @Test
    public void whenSaveSeveralThenGetAll() {
        var startTime = now().truncatedTo(ChronoUnit.MINUTES);
        var endTime = startTime.plusMinutes(90).truncatedTo(ChronoUnit.MINUTES);
        var filmSession1 = sql2oFilmSessionRepository.save(new FilmSession(1, 1, 1, startTime, endTime));
        var filmSession2 = sql2oFilmSessionRepository.save(new FilmSession(2, 2, 2, startTime, endTime));
        var filmSession3 = sql2oFilmSessionRepository.save(new FilmSession(3, 1, 1, startTime, endTime));
        var result = sql2oFilmSessionRepository.findAll();
        assertThat(result).isEqualTo(List.of(filmSession1, filmSession2, filmSession3));
    }

    @Test
    public void whenDontSaveThenNothingFound() {
        assertThat(sql2oFilmSessionRepository.findAll()).isEqualTo(emptyList());
        assertThat(sql2oFilmSessionRepository.findById(0)).isEqualTo(empty());
    }

    @Test
    public void whenDeleteThenGetEmptyOptional() {
        var startTime = now().truncatedTo(ChronoUnit.MINUTES);
        var endTime = startTime.plusMinutes(90).truncatedTo(ChronoUnit.MINUTES);
        var filmSession = sql2oFilmSessionRepository.save(new FilmSession(1, 1, 1, startTime, endTime));
        var isDeleted = sql2oFilmSessionRepository.deleteById(filmSession.getId());
        var savedFilmSession = sql2oFilmSessionRepository.findById(filmSession.getId());
        assertThat(isDeleted).isTrue();
        assertThat(savedFilmSession).isEqualTo(empty());
    }

    @Test
    public void whenDeleteByInvalidIdThenGetFalse() {
        assertThat(sql2oFilmSessionRepository.deleteById(0)).isFalse();
    }
}