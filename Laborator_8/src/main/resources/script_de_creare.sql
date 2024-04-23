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
