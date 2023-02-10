create table film_sessions
(
    id         serial primary key,
    film_id    int references films (id) not null,
    halls_id   int references halls (id) not null,
    start_time timestamp,
    end_time   timestamp
);

INSERT INTO film_sessions(film_id, halls_id, start_time, end_time)
VALUES (1, 1, );
INSERT INTO film_sessions(film_id, halls_id, start_time, end_time)
VALUES (1, 2, );
INSERT INTO film_sessions(film_id, halls_id, start_time, end_time)
VALUES (2, 1, );
INSERT INTO film_sessions(film_id, halls_id, start_time, end_time)
VALUES (3, 2, );
INSERT INTO film_sessions(film_id, halls_id, start_time, end_time)
VALUES (4, 1, );

INSERT INTO film_sessions(name, description, year, genre_id, minimal_age, duration_in_minutes, file_id)
VALUES ('Терминатор', 'Фильм про ополоумевших машин', '1984', 1, 12, 90, 1);
INSERT INTO film_sessions(name, description, year, genre_id, minimal_age, duration_in_minutes, file_id)
VALUES ('Аватар', 'Фильм про синих индейцев', '2009', 2, 6, 180, 2);
INSERT INTO film_sessions(name, description, year, genre_id, minimal_age, duration_in_minutes, file_id)
VALUES ('Американский пирог', 'Фильм про четырех подростков', '1999', 3, 12, 90, 3);
INSERT INTO film_sessions(name, description, year, genre_id, minimal_age, duration_in_minutes, file_id)
VALUES ('Проклятый остров', 'Фильм про безумие главного героя', '2012', 1, 18, 120, 4);