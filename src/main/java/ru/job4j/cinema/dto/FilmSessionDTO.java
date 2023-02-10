package ru.job4j.cinema.dto;

import java.time.LocalDateTime;

public class FilmSessionDTO {

    private int id;
    private String filmName;
    private int hallsId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public FilmSessionDTO(int id, String filmName, int hallsId, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.filmName = filmName;
        this.hallsId = hallsId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getHallsId() {
        return hallsId;
    }

    public void setHallsId(int hallsId) {
        this.hallsId = hallsId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
