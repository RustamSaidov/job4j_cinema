package ru.job4j.cinema.repository;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.cinema.model.FilmSession;

import java.util.Collection;

@ThreadSafe
@Repository
public class Sql2oFilmSessionRepository implements FilmSessionRepository {

    private final Sql2o sql2o;

    public Sql2oFilmSessionRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

//    @Override
//    public FilmSession save(FilmSession filmSession) {
//        try (var connection = sql2o.open()) {
//            var sql = """
//                    INSERT INTO vacancies(title, description, creation_date, visible, city_id, file_id)
//                    VALUES (:title, :description, :creationDate, :visible, :cityId, :fileId)
//                    """;
//            var query = connection.createQuery(sql, true)
//                    .addParameter("title", vacancy.getTitle())
//                    .addParameter("description", vacancy.getDescription())
//                    .addParameter("creationDate", vacancy.getCreationDate())
//                    .addParameter("visible", vacancy.getVisible())
//                    .addParameter("cityId", vacancy.getCityId())
//                    .addParameter("fileId", vacancy.getFileId());
//            int generatedId = query.executeUpdate().getKey(Integer.class);
//            vacancy.setId(generatedId);
//            return filmSession;
//        }
//    }
//
//    @Override
//    public boolean deleteById(int id) {
//        try (var connection = sql2o.open()) {
//            var query = connection.createQuery("DELETE FROM vacancies WHERE id = :id");
//            query.addParameter("id", id);
//            var affectedRows = query.executeUpdate().getResult();
//            return affectedRows > 0;
//        }
//    }
//
//    @Override
//    public boolean update(Vacancy vacancy) {
//        try (var connection = sql2o.open()) {
//            var sql = """
//                    UPDATE vacancies
//                    SET title = :title, description = :description, creation_date = :creationDate,
//                        visible = :visible, city_id = :cityId, file_id = :fileId
//                    WHERE id = :id
//                    """;
//            var query = connection.createQuery(sql)
//                    .addParameter("title", vacancy.getTitle())
//                    .addParameter("description", vacancy.getDescription())
//                    .addParameter("creationDate", vacancy.getCreationDate())
//                    .addParameter("visible", vacancy.getVisible())
//                    .addParameter("cityId", vacancy.getCityId())
//                    .addParameter("fileId", vacancy.getFileId())
//                    .addParameter("id", vacancy.getId());
//            var affectedRows = query.executeUpdate().getResult();
//            return affectedRows > 0;
//        }
//    }
//
//    @Override
//    public Optional<Vacancy> findById(int id) {
//        try (var connection = sql2o.open()) {
//            var query = connection.createQuery("SELECT * FROM vacancies WHERE id = :id");
//            query.addParameter("id", id);
//            var vacancy = query.setColumnMappings(Vacancy.COLUMN_MAPPING).executeAndFetchFirst(Vacancy.class);
//            return Optional.ofNullable(vacancy);
//        }
//    }

    @Override
    public Collection<FilmSession> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM film film_sessions");
            return query.setColumnMappings(FilmSession.COLUMN_MAPPING).executeAndFetch(FilmSession.class);
        }
    }
}
