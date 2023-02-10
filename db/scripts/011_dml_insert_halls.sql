create table halls
(
    id          serial primary key,
    name        varchar not null,
    row_count   int     not null,
    place_count int     not null,
    description varchar not null
);

INSERT INTO films(name, row_count, place_count, description)
VALUES ('Красный зал', 10, 10, 'Маленький уютный зал повышенного комфорта');
INSERT INTO films(name, row_count, place_count, description)
VALUES ('Белый зал', 20, 20, 'Большой зал');