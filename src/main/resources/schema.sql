CREATE TABLE country (
    id integer identity NOT NULL,
    name varchar(88) NOT NULL,
    population integer,
    gdp integer,
    CONSTRAINT country_id PRIMARY KEY (id)
);