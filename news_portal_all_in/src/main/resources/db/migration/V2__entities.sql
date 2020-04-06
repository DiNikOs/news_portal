DROP TABLE IF EXISTS articles;

CREATE TABLE articles (
    id                    bigserial,
    created               timestamp,
    title                 VARCHAR(255),
    text                  VARCHAR(10000),
    published             timestamp NULL,
    category_id           bigint NULL,
    total_views           bigint NULL,
    last_view_date        timestamp NULL,
    main_picture_url      VARCHAR(300) NULL,
    status                VARCHAR(25) NULL,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS article_likes;
CREATE TABLE article_likes (
  article_id            bigint NOT NULL,
  user_id               bigint NOT NULL,
  value                 integer NOT NULL,
  PRIMARY KEY (article_id,user_id),
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
  comment_id            bigint NOT NULL,
  user_id               bigint NOT NULL,
  value                 integer NOT NULL,
  PRIMARY KEY (comment_id,user_id),
  FOREIGN KEY(comment_id)
  REFERENCES comments (id),
  FOREIGN KEY (user_id)
  REFERENCES users (id)
);

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


ALTER TABLE articles
ADD CONSTRAINT fk_categories
  FOREIGN KEY (category_id)
  REFERENCES article_categories (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

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


