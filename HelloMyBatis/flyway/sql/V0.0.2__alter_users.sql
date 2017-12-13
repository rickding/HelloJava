-- database
CREATE DATABASE IF NOT EXISTS hellomybatis;

USE hellomybatis;

-- table users
ALTER TABLE users
  ADD COLUMN
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp,
  ADD COLUMN
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp;
