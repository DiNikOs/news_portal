-- @Author Farida Gareeva
-- Created 16/03/2020
DROP TABLE IF EXISTS links;
CREATE TABLE links (
  id                    bigserial,
  url                  VARCHAR(300) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS pictures;
CREATE TABLE pictures (
  id                    bigserial,
  name                  VARCHAR(100) NOT NULL,
  url                  VARCHAR(300) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tags;
CREATE TABLE tags (
    id                    bigserial,
    name                  VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS articles_tags;
CREATE TABLE articles_tags (
  article_id           bigint NOT NULL,
  tag_id               bigint NOT NULL,
  PRIMARY KEY (article_id, tag_id),
  FOREIGN KEY (article_id)
  REFERENCES articles (id),
  FOREIGN KEY (tag_id)
  REFERENCES tags (id)
);

DROP TABLE IF EXISTS article_rating;
CREATE TABLE article_rating (
    id                    bigserial,
    article_id            bigint NOT NULL,
    user_id               bigint NOT NULL,
    value                 integer NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(article_id)
    REFERENCES articles (id),
    FOREIGN KEY (user_id)
    REFERENCES users (id)
);

DROP TABLE IF EXISTS article_categories;
CREATE TABLE article_categories (
  id                    bigserial,
  name                  VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS statuses;
CREATE TABLE statuses (
  id                    bigserial,
  name                  VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

-- ALTER TABLE articles
-- ADD COLUMN published timestamp NULL,
-- ADD COLUMN category_id bigint NULL,
-- ADD COLUMN total_views bigint NULL,
-- ADD COLUMN last_view_date timestamp NULL,
-- ADD COLUMN main_picture_url VARCHAR(300) NULL,
-- ADD COLUMN status_id bigint NULL;

ALTER TABLE articles
ADD CONSTRAINT fk_categories
  FOREIGN KEY (category_id)
  REFERENCES article_categories (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE articles
ADD CONSTRAINT fk_statuses
  FOREIGN KEY (status_id)
  REFERENCES statuses (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

 INSERT INTO statuses (name)
 VALUES ('В работе'),('Опубликована'),('В архиве');

 INSERT INTO article_categories (name)
 VALUES ('В мире'),('Экономика'),('Киберспорт'),('Культура'),('Происшествия'), ('Технолгии'), ('Программирование'),('Путешествия'),('Стиль жизни'),('Статьи');
--мне кажется, что названия статей вполне могут быть неуникальными
--ALTER TABLE articles
--DROP CONSTRAINT articles_title_key;

DROP TABLE IF EXISTS contacts;
CREATE TABLE contacts (
    id                    bigserial,
    name                  VARCHAR (50) NOT NULL UNIQUE,
    subject               VARCHAR(50) UNIQUE,
    email                 VARCHAR(50) UNIQUE,
    created               timestamp,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS messages;
CREATE TABLE messages (
    id                    bigserial,
    created               timestamp,
    contact_id            bigint NOT NULL,
    text                  VARCHAR(10000),
    PRIMARY KEY (id),
    FOREIGN KEY (contact_id)
    REFERENCES contacts (id)
);

