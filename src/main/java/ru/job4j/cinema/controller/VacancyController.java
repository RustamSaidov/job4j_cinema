//package ru.job4j.dreamjob.controller;
//
//import net.jcip.annotations.ThreadSafe;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import ru.job4j.dreamjob.dto.FileDto;
//import ru.job4j.dreamjob.model.Vacancy;
//import ru.job4j.dreamjob.service.CityService;
//import ru.job4j.dreamjob.service.VacancyService;
//
//@ThreadSafe
//@Controller
//@RequestMapping("/vacancies") /* Работать с кандидатами будем по URI /vacancies/** */
//public class VacancyController {
//
//    private final VacancyService vacancyService;
//
//    private final CityService cityService;
//
//    public VacancyController(VacancyService vacancyService, CityService cityService) {
//        this.vacancyService = vacancyService;
//        this.cityService = cityService;
//    }
//
//    /*Оттестено*/
//    @GetMapping
//    public String getAll(Model model) {
//        model.addAttribute("vacancies", vacancyService.findAll());
//        return "vacancies/list";
//    }
//
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
//    /* Старый вариант до эпохи Spring
//    @PostMapping("/create")
//    public String create(HttpServletRequest request) {
//        var title = request.getParameter("title");
//        var description = request.getParameter("description");
//        vacancyRepository.save(new Vacancy(0, title, description, LocalDateTime.now()));
//        return "redirect:/vacancies";
//    }*/
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
//}