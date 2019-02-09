CREATE SCHEMA IF NOT EXISTS Banner
  DEFAULT CHARACTER SET utf8;
USE Banner;

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS users (
  id       BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name     VARCHAR(100) NOT NULL,
  login    VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  enabled  TINYINT      NOT NULL
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS roles (
  users_id BIGINT      NOT NULL,
  roles    VARCHAR(50) NOT NULL,
  FOREIGN KEY (users_id)
  REFERENCES users (id)
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Banners (
  id      BIGINT       NOT NULL  AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR(255) NOT NULL,
  type    VARCHAR(10),
  user_id BIGINT       NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id)
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
CREATE TABLE persistent_logins (
  username  VARCHAR(64) NOT NULL,
  series    VARCHAR(64) NOT NULL PRIMARY KEY,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL
)





