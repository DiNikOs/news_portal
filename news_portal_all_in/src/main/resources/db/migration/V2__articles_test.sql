DROP TABLE IF EXISTS articles;

CREATE TABLE articles (
    id                    bigserial,
    created               timestamp,
    title                 VARCHAR(255) UNIQUE ,
    text                  VARCHAR(10000),
    PRIMARY KEY (id)
);

INSERT INTO articles (created, title, text)
VALUES
(current_date, 'Заголовок1', '<p>TEXT</p> <img src="http://localhost:8199/news/image_repository/pic1.jpg"/> <p>TEXT</p>'),
(current_date, 'Заголовок2', '<p>TEXT</p> <img src="http://localhost:8199/news/image_repository/pic1.jpg"/> <p>TEXT</p>');
