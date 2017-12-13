-- database
CREATE DATABASE if not EXISTS hellomybatis;

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

-- table channel_order
DROP TABLE IF EXISTS channel_order;

CREATE TABLE channel_order (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_code` VARCHAR(255) DEFAULT NULL COMMENT 'source code from channel',
  `source_content` TEXT DEFAULT Null COMMENT 'source content, ebay is xml',
  PRIMARY KEY(`id`),
  INDEX `index_order_code` (`order_code`)
) ENGINE=InnoDB CHARSET=utf8 COLLATE=utf8_bin COMMENT='Channel order from other platforms';

-- init channel_order
INSERT INTO channel_order(order_code, source_content) VALUES
  ('EBAY_1', '<order><code>EBAY_1</code></order>'),
  ('EBAY_2', '<order><code>EBAY_2</code></order>');

-- table system_order
DROP TABLE IF EXISTS system_order;

CREATE TABLE system_order (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_code` VARCHAR(255) DEFAULT NULL COMMENT 'source code from channel',
  `is_leaf` BOOLEAN DEFAULT FALSE COMMENT 'divided order or not. Parent is false',
  PRIMARY KEY (`id`),
  INDEX `index_order_code` (`order_code`)
) ENGINE=InnoDB CHARSET=utf8 COLLATE=utf8_bin COMMENT='System order, synced from channel_order';
