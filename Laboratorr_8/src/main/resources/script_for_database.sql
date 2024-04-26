CREATE TABLE Authors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE Genre (
    id SERIAL PRIMARY KEY,
    book_genre VARCHAR(255) NOT NULL
);

CREATE TABLE Books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    id_author INTEGER NOT NULL,
    id_genre INTEGER NOT NULL,
    publication_year INTEGER,
    language VARCHAR(50),
    number_of_pages INTEGER,
    FOREIGN KEY (id_author) REFERENCES Authors(id),
    FOREIGN KEY (id_genre) REFERENCES Genre(id)
);

--alte script uri oe care le-am folosit pentru a schimba structura unor tabele

ALTER TABLE Books
DROP COLUMN publication_year;

ALTER TABLE Books
ADD COLUMN publisher_date DATE,
ADD COLUMN average_rating DECIMAL(3, 2),
ADD COLUMN isbn INTEGER,
ADD COLUMN isbn13 INTEGER,
ADD COLUMN rating_count INTEGER,
ADD COLUMN test_reviews_count INTEGER,
ADD COLUMN publisher VARCHAR2(225);

ALTER SEQUENCE id RESTART WITH 1;
ALTER SEQUENCE Books_id_seq RESTART WITH 1;

ALTER TABLE Books
DROP COLUMN id_genre,
DROP COLUMN id_author;

CREATE TABLE BookAuthors (
    book_id INTEGER,
    author_id INTEGER,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES Books(id),
    FOREIGN KEY (author_id) REFERENCES Authors(id)
);

ALTER TABLE Books
DROP COLUMN isbn;

ALTER TABLE Books
DROP COLUMN isbn13;

ALTER TABLE Books
ADD COLUMN isbn VARCHAR(50);

ALTER TABLE Books
ADD COLUMN isbn13 VARCHAR(50);

TRUNCATE TABLE books, authors, bookauthors CASCADE;