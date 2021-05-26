CREATE TABLE IF NOT EXISTS author (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE
);

CREATE TABLE IF NOT EXISTS publishing (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS edition (
    id BIGSERIAL PRIMARY KEY,
    author_id BIGINT REFERENCES author(id),
    publishing_id BIGINT REFERENCES publishing(id),
    title VARCHAR(50),
    cost INTEGER
);

CREATE TABLE IF NOT EXISTS reader (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    acceptation_date DATE,
    retirement_date DATE
);

CREATE TABLE IF NOT EXISTS faculty (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS group_table (
    id BIGSERIAL PRIMARY KEY,
    number INTEGER,
    faculty_id BIGINT REFERENCES faculty(id)
);

CREATE TABLE IF NOT EXISTS student (
    reader_id BIGINT PRIMARY KEY REFERENCES reader(id),
    group_id BIGINT REFERENCES group_table(id)
);