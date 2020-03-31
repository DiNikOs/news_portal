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
    status_id             bigint NULL,
    PRIMARY KEY (id)
);





