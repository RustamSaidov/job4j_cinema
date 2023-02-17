package ru.job4j.cinema.repository;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.cinema.model.Hall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Repository
public class Sql2oHallRepository implements HallRepository {
    private final Sql2o sql2o;

    public Sql2oHallRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Hall> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM halls WHERE id = :id");
            query.addParameter("id", id);
            var hall = query.setColumnMappings(Hall.COLUMN_MAPPING).executeAndFetchFirst(Hall.class);
            return Optional.ofNullable(hall);
        }
    }

    @Override
    public Collection<Integer> getRowCountByHallId(int hallId) {
        Collection <Integer> listOfRows = new ArrayList<>();
        int rowCount = findById(hallId).get().getRowCount();
        for(int i=1; i<rowCount+1; i++){
            listOfRows.add(i);
        }
        return listOfRows;
    }

    @Override
    public Collection<Integer> getPlaceCountByHallId(int hallId) {
        Collection <Integer> listOfPlaces = new ArrayList<>();
        int placeCount = findById(hallId).get().getPlaceCount();
        for(int i=1; i<placeCount+1; i++){
            listOfPlaces.add(i);
        }
        return listOfPlaces;
    }
}
