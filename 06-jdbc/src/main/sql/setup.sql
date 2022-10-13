CREATE SCHEMA `bookshop` ;

GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

CREATE USER 'user'@'localhost' IDENTIFIED BY 'user123';
GRANT ALL PRIVILEGES ON *.* TO 'user'@'localhost' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON familytree.* TO 'user'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

USE bookshop;

CREATE TABLE books (
  `isbn` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `author` VARCHAR(45) NULL,
  PRIMARY KEY (`isbn`));

INSERT INTO `books` VALUES (1,'Java Unleased','Technical','Pete Smith'),
                           (2,'Advanced Java','Technical','Adam Cooke'),
                           (3,'Shakespeare\'s Plays','Drama','Gryff Moore'),
                           (4,'The History of Bath','Historical','Jasmine Jones');

SELECT * FROM books WHERE category = 'Technical' ORDER BY title;

INSERT INTO books VALUES ('5', 'Learn Python', 'Technical', 'John Smith');


DELETE FROM books WHERE isbn = 5;