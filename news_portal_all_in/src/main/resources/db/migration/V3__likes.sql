-- @Author Farida Gareeva
-- Created 14/03/2020

DROP TABLE IF EXISTS article_likes;
CREATE TABLE article_likes (
  id bigserial NOT NULL,
  article_id            bigint NOT NULL,
  user_id               bigint NOT NULL,
  value                 integer NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(article_id)
  REFERENCES articles (id),
  FOREIGN KEY (user_id)
  REFERENCES users (id)
);

DROP TABLE IF EXISTS comments;
CREATE TABLE comments (
    id                    bigserial,
    created               timestamp,
    article_id            bigint NOT NULL,
    user_id               bigint NOT NULL,
    text                  VARCHAR(10000),
    PRIMARY KEY (id),
    FOREIGN KEY(article_id)
    REFERENCES articles (id),
    FOREIGN KEY (user_id)
    REFERENCES users (id)
);

DROP TABLE IF EXISTS comment_likes;
CREATE TABLE comment_likes (
  id bigserial NOT NULL,
  comment_id            bigint NOT NULL,
  user_id               bigint NOT NULL,
  value                 integer NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(comment_id)
  REFERENCES comments (id),
  FOREIGN KEY (user_id)
  REFERENCES users (id)
);

