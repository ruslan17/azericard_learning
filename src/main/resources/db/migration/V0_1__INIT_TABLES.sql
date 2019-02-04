CREATE TABLE users
(
  id         SERIAL PRIMARY KEY,
  name       VARCHAR(100),
  username   VARCHAR(25) UNIQUE,
  email      VARCHAR(50) UNIQUE,
  birth_date DATE
);