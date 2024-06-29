CREATE TABLE feriados (
    id_feriado binary(16) default (uuid_to_bin(uuid())) not null PRIMARY KEY,
    data_feriado DATE NOT NULL
);