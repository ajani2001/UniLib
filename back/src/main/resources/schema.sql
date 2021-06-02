CREATE TABLE IF NOT EXISTS reader (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    acceptation_date DATE NOT NULL,
    retirement_date DATE,
    CHECK ( first_name NOT SIMILAR TO '(\r|\n|\t| )+' ),
    CHECK ( last_name NOT SIMILAR TO  '(\r|\n|\t| )+' ),
    CHECK ( retirement_date IS NULL OR acceptation_date < reader.retirement_date )
);

CREATE TABLE IF NOT EXISTS faculty (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    CHECK ( name NOT SIMILAR TO '(\r|\n|\t| )+' )
);

CREATE TABLE IF NOT EXISTS group_table (
    id BIGSERIAL PRIMARY KEY,
    number INTEGER UNIQUE NOT NULL,
    year INTEGER NOT NULL,
    faculty_id BIGINT NOT NULL REFERENCES faculty(id)
);

CREATE TABLE IF NOT EXISTS student (
    reader_id BIGINT PRIMARY KEY REFERENCES reader(id),
    group_id BIGINT NOT NULL REFERENCES group_table(id)
);

CREATE TABLE IF NOT EXISTS rank (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    CHECK ( name NOT SIMILAR TO '(\r|\n|\t| )+' )
);

CREATE TABLE IF NOT EXISTS degree (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    CHECK ( name NOT SIMILAR TO '(\r|\n|\t| )+' )
);

CREATE TABLE IF NOT EXISTS chair (
    id BIGSERIAL PRIMARY KEY,
    faculty_id BIGINT NOT NULL REFERENCES faculty(id),
    name VARCHAR(50) NOT NULL,
    CHECK ( name NOT SIMILAR TO '(\r|\n|\t| )+' )
);

CREATE TABLE IF NOT EXISTS professor (
    reader_id BIGINT PRIMARY KEY REFERENCES reader(id),
    degree_id BIGINT NOT NULL references degree(id),
    rank_id BIGINT NOT NULL references rank(id),
    chair_id BIGINT NOT NULL references chair(id)
);

CREATE TABLE IF NOT EXISTS employee (
    reader_id BIGINT PRIMARY KEY REFERENCES reader(id)
);

CREATE TABLE IF NOT EXISTS point (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    is_subscription BOOLEAN NOT NULL,
    CHECK ( name NOT SIMILAR TO '(\r|\n|\t| )+' )
);

CREATE TABLE IF NOT EXISTS author (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    CHECK ( name NOT SIMILAR TO '(\r|\n|\t| )+' )
);

CREATE TABLE IF NOT EXISTS publishing (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    CHECK ( name NOT SIMILAR TO '(\r|\n|\t| )+' )
);

CREATE TABLE IF NOT EXISTS edition (
    id BIGSERIAL PRIMARY KEY,
    author_id BIGINT NOT NULL REFERENCES author(id),
    publishing_id BIGINT NOT NULL REFERENCES publishing(id),
    title VARCHAR(50) NOT NULL,
    cost INTEGER NOT NULL,
    CHECK ( title NOT SIMILAR TO '(\r|\n|\t| )+' )
);

CREATE TABLE IF NOT EXISTS book (
    id BIGSERIAL PRIMARY KEY,
    edition_id BIGINT NOT NULL REFERENCES edition(id),
    point_id BIGINT NOT NULL REFERENCES point(id),
    issue_date DATE NOT NULL,
    acquisition_date DATE NOT NULL,
    decommission_date DATE,
    CHECK ( decommission_date IS NULL OR acquisition_date < decommission_date )
);

CREATE TABLE IF NOT EXISTS borrowing (
    id BIGSERIAL PRIMARY KEY,
    reader_id BIGINT NOT NULL REFERENCES reader(id),
    book_id BIGINT NOT NULL REFERENCES book(id),
    point_id BIGINT NOT NULL REFERENCES point(id),
    begin_date DATE NOT NULL,
    end_date DATE,
    until_date DATE NOT NULL,
    CHECK ( begin_date < until_date ),
    CHECK ( end_date IS NULL OR begin_date < end_date )
);

CREATE TABLE IF NOT EXISTS order_table (
    borrowing_id BIGINT PRIMARY KEY REFERENCES borrowing(id),
    supply_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS penalty (
    id BIGSERIAL PRIMARY KEY,
    reader_id BIGINT NOT NULL REFERENCES reader(id),
    date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS property_compensation (
    penalty_id BIGINT PRIMARY KEY REFERENCES penalty(id),
    old_book_id BIGINT NOT NULL REFERENCES book(id),
    new_book_id BIGINT NOT NULL REFERENCES book(id)
);

CREATE TABLE IF NOT EXISTS cost_compensation (
    penalty_id BIGINT PRIMARY KEY REFERENCES penalty(id),
    book_id BIGINT NOT NULL REFERENCES book(id)
);

CREATE TABLE IF NOT EXISTS ban (
    penalty_id BIGINT PRIMARY KEY REFERENCES penalty(id),
    end_date DATE NOT NULL--,
    --CHECK ( (SELECT date FROM penalty WHERE id = penalty_id) < end_date )
);

CREATE TABLE IF NOT EXISTS fine (
    penalty_id BIGINT PRIMARY KEY REFERENCES penalty(id),
    amount INTEGER NOT NULL,
    CHECK ( amount > 0 )
);