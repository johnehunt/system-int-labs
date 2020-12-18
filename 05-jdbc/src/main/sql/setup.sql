CREATE SCHEMA `bookshop` ;

USE bookshop;

CREATE TABLE books (
  `isbn` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `author` VARCHAR(45) NULL,
  PRIMARY KEY (`isbn`));

INSERT INTO `books` VALUES (1,'Java Unleased','Technical','Pete Smith'),
                           (2,'Advanced Java','Technical','Adam Cooke'),
                           (3,'Shakespeares Plays','Drama','Gryff Moore'),
                           (4,'The History of Bath','Historical','Jasmine Jones');

SELECT * FROM books WHERE category = 'Technical' ORDER BY title;

INSERT INTO books VALUES ('5', 'Learn Python', 'Technical', 'John Smith');


DELETE FROM books WHERE isbn = 5;