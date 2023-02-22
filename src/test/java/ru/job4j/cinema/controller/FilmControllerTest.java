package ru.job4j.cinema.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import ru.job4j.cinema.dto.FilmDTO;
import ru.job4j.cinema.service.FilmService;
import ru.job4j.cinema.service.GenreService;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilmControllerTest {

    private FilmService filmService;

    private GenreService genreService;

    private FilmController filmController;

    @BeforeEach
    public void initServices() {
        filmService = mock(FilmService.class);
        genreService = mock(GenreService.class);
        filmController = new FilmController(filmService, genreService);
    }

    @Test
    public void whenRequestFilmListPageThenGetPageWithFilmsDTO() {
        var film1DTO = new FilmDTO(1, "name1", "desc1", 1987, "genre1", 13, 90, 1);
        var film2DTO = new FilmDTO(2, "name2", "desc2", 1987, "genre1", 18, 120, 1);
        var expectedFilmsDTO = List.of(film1DTO, film2DTO);
        when(filmService.findAll()).thenReturn(expectedFilmsDTO);

        var model = new ConcurrentModel();
        var view = filmController.getAll(model);
        var actualFilmsDTO = model.getAttribute("DTOfilms");

        assertThat(view).isEqualTo("films/list");
        assertThat(actualFilmsDTO).isEqualTo(expectedFilmsDTO);
    }
}
