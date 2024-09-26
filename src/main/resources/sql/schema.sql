CREATE TABLE IF NOT EXISTS book(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL ,
    author VARCHAR(255) DEFAULT 'Unknown Author',
    rating INTEGER DEFAULT 0 CHECK (rating < 11),
    description VARCHAR(500)
);