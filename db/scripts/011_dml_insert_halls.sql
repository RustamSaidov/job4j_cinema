create table halls
(
    id          serial primary key,
    name        varchar not null,
    row_count   int     not null,
    place_count int     not null,
    description varchar not null
);

INSERT INTO films(name, row_count, place_count, description)
VALUES ('������� ���', 10, 10, '��������� ������ ��� ����������� ��������');
INSERT INTO films(name, row_count, place_count, description)
VALUES ('����� ���', 20, 20, '������� ���');