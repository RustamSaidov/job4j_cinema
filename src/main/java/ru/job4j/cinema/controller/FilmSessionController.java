package ru.job4j.cinema.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cinema.service.FilmService;
import ru.job4j.cinema.service.FilmSessionService;
import ru.job4j.cinema.service.HallService;

@ThreadSafe
@Controller
@RequestMapping("/filmSessions")
public class FilmSessionController {

    private final FilmSessionService filmSessionService;
    private final FilmService filmService;
    private final HallService hallService;


    public FilmSessionController(FilmSessionService filmSessionService, FilmService filmService, HallService hallService) {
        this.filmSessionService = filmSessionService;
        this.filmService = filmService;
        this.hallService = hallService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("DTOfilmSessions", filmSessionService.findAll());
        return "filmSessions/list";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        var filmSessionOptional = filmSessionService.findById(id);
        if (filmSessionOptional.isEmpty()) {
            model.addAttribute("message", "Сеанс с указанным идентификатором не найден");
            return "errors/404";
        }
        var filmSession = filmSessionOptional.get();
        model.addAttribute("sessionId", filmSession.getId());
        model.addAttribute("rows", hallService.getRowCountByHallId(filmSession.getHallsId()));
        model.addAttribute("places", hallService.getPlaceCountByHallId(filmSession.getHallsId()));
        model.addAttribute("filmName", filmService.findById(filmSession.getFilmId()).get().getName());
        return "tickets/buy";
    }
}
