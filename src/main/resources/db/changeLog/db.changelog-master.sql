CREATE TABLE user (
  id       BIGSERIAL NOT NULL,
  username CHARACTER NOT NULL,
  password CHARACTER,
);

INSERT INTO user (id, username, password) VALUES (1, 'admin', 'admin');

CREATE TABLE images (
  id    BIGSERIAL NOT NULL,
  base64 TEXT     NOT NULL,
);

CREATE TABLE publications (
  id       BIGSERIAL NOT NULL,
  text     TEXT      NOT NULL,
  image_id BIGINT    NOT NULL,

  FOREIGN KEY (image_id) REFERENCES images (id)
);

