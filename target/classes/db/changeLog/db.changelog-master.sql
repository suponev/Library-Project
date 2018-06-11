CREATE TABLE user (
  id       BIGSERIAL NOT NULL,
  username CHARACTER NOT NULL,
  password CHARACTER,
  PRIMARY KEY (id)
);

INSERT INTO user (id, username, password) VALUES (0, 'admin', 'admin');
INSERT INTO user (id, username, password) VALUES (1, 'user', 'user');

CREATE TABLE publications (
  publication_id       BIGSERIAL NOT NULL,
  text     TEXT                  NOT NULL,
  image_id BIGINT                NOT NULL,
  time_key TIMESTAMP  NOT NULL DEFAULT   CURRENT_TIMESTAMP() ,
  PRIMARY KEY (publication_id)
);

CREATE TABLE image (
  id       BIGSERIAL NOT NULL,
  bytes BLOB         NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE votes (
  user_id        BIGINT NOT NULL,
  publication_id BIGINT NOT NULL,
  vote           INT    NOT NULL,
  PRIMARY KEY (user_id, publication_id),
  FOREIGN KEY (publication_id) REFERENCES publications (publication_id)
);

