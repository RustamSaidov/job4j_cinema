package ru.job4j.cinema.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.cinema.service.FilmService;
import ru.job4j.cinema.service.GenreService;

@ThreadSafe
@Controller
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    private final GenreService genreService;

    public FilmController(FilmService filmService, GenreService genreService) {
        this.filmService = filmService;
        this.genreService = genreService;
    }

    /*Оттестено*/
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("films", filmService.findAll());
        return "films/list";
    }

//    /*Оттестено*/
//    @GetMapping("/create")
//    public String getCreationPage(Model model) {
//        model.addAttribute("cities", cityService.findAll());
//        return "vacancies/create";
//    }
//
//    /*Оттестено*/
//    @PostMapping("/create")
//    public String create(@ModelAttribute Vacancy vacancy, @RequestParam MultipartFile file, Model model) {
//        try {
//            vacancyService.save(vacancy, new FileDto(file.getOriginalFilename(), file.getBytes()));
//            return "redirect:/vacancies";
//        } catch (Exception exception) {
//            model.addAttribute("message", exception.getMessage());
//            return "errors/404";
//        }
//    }
//
//    /*Оттестено*/
//    @GetMapping("/{id}")
//    public String getById(Model model, @PathVariable int id) {
//        var vacancyOptional = vacancyService.findById(id);
//        if (vacancyOptional.isEmpty()) {
//            model.addAttribute("message", "Вакансия с указанным идентификатором не найдена");
//            return "errors/404";
//        }
//        model.addAttribute("cities", cityService.findAll());
//        model.addAttribute("vacancy", vacancyOptional.get());
//        return "vacancies/one";
//    }
//
//    /*Оттестено*/
//    @PostMapping("/update")
//    public String update(@ModelAttribute Vacancy vacancy, @RequestParam MultipartFile file, Model model) {
//        try {
//            var isUpdated = vacancyService.update(vacancy, new FileDto(file.getOriginalFilename(), file.getBytes()));
//            if (!isUpdated) {
//                model.addAttribute("message", "Вакансия с указанным идентификатором не найдена");
//                return "errors/404";
//            }
//            return "redirect:/vacancies";
//        } catch (Exception exception) {
//            model.addAttribute("message", exception.getMessage());
//            return "errors/404";
//        }
//    }
//
//    /*Оттестено*/
//    @GetMapping("/delete/{id}")
//    public String delete(Model model, @PathVariable int id) {
//        var isDeleted = vacancyService.deleteById(id);
//        if (!isDeleted) {
//            model.addAttribute("message", "Вакансия с указанным идентификатором не найдена");
//            return "errors/404";
//        }
//        return "redirect:/vacancies";
//    }
}
