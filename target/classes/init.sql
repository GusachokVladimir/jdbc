CREATE SCHEMA IF NOT EXISTS test;
USE test;

DROP TABLE IF EXISTS staff;
CREATE TABLE staffs (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(80), surname VARCHAR(80), age TINYINT, post VARCHAR(100), specialty VARCHAR(100));

INSERT INTO staffs(name, surname, age, post, specialty) VALUES ('Alex', 'Petrov', 25, 'doctor', 'pediatrician')