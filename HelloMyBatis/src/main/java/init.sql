-- database
CREATE DATABASE hellomybatis;

USE hellomybatis;

-- table users
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    `id` int(255) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL COMMENT 'user name',
    `gender` int(1) DEFAULT 0 COMMENT 'user gender',
    PRIMARY KEY(`id`),
    INDEX `index_users_gender` (`gender`)
) ENGINE=InnoDB CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hello MyBatis';

INSERT INTO users(name, gender) VALUES('m', 0), ('f', 1);
INSERT INTO users(name, gender) VALUES('u', 1), ('me', 0);
INSERT INTO users(name, gender) VALUES('s', 1);