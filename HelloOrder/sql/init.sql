-- database
CREATE DATABASE hello_order;

USE hello_order;

-- table channel_order
DROP TABLE IF EXISTS channel_order;

CREATE TABLE channel_order (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_code` VARCHAR(255) DEFAULT NULL COMMENT 'source code from channel',
  `source_content` TEXT DEFAULT Null COMMENT 'source content, ebay is xml',
  `gmt_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(`id`),
  INDEX `index_order_code` (`order_code`)
) ENGINE=InnoDB CHARSET=utf8 COLLATE=utf8_bin COMMENT='Channel order from other platforms';

-- init channel_order
INSERT INTO channel_order(order_code, source_content) VALUES
  ('EBAY_1', '<order><code>EBAY-1</code></order>'),
  ('EBAY_2', '<order><code>EBAY-2</code></order>');

INSERT INTO channel_order(order_code, source_content) VALUES
  ('EBAY_11', '<order><code>EBAY-11</code></order>'),
  ('EBAY_12', '<order><code>EBAY-12</code></order>');

-- table system_order
DROP TABLE IF EXISTS system_order;

CREATE TABLE system_order (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_code` VARCHAR(255) DEFAULT NULL COMMENT 'source code from channel',
  `parent_order_code` VARCHAR(255) DEFAULT NULL COMMENT 'parent order code',
  `is_leaf` BOOLEAN DEFAULT FALSE COMMENT 'divided order or not. Parent is false',
  `gmt_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `index_order_code` (`order_code`)
) ENGINE=InnoDB CHARSET=utf8 COLLATE=utf8_bin COMMENT='System order, synced from channel_order';
