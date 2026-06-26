CREATE DATABASE IF NOT EXISTS game_project;

USE game_project;

CREATE TABLE players (

                         id INT AUTO_INCREMENT PRIMARY KEY,

                         username VARCHAR(50) NOT NULL UNIQUE,

                         password VARCHAR(100) NOT NULL,

                         wins INT DEFAULT 0,

                         losses INT DEFAULT 0,

                         draws INT DEFAULT 0,

                         score INT DEFAULT 0

);

INSERT INTO players(username,password,wins,losses,draws,score)
VALUES
    ('admin','admin',5,2,1,53),
    ('farhan','123',0,0,0,0);