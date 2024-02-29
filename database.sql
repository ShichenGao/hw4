CREATE DATABASE  IF NOT EXISTS `springbook`;
USE `springbook`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `name`varchar(45) Not NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`name`)
) ;
INSERT INTO book (name, price) VALUES ('book1',1);
INSERT INTO book (name, price) VALUES ('book2',2);
INSERT INTO book (name, price) VALUES ('book3',3);

DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
`id` int NOT NULL AUTO_INCREMENT,
  `name`varchar(45) Not NULL,
  `title` varchar(45) Not NULL,
   `content` varchar(45) Not NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (name) REFERENCES book(name)
) ;
INSERT INTO chapter (name, title,content) VALUES ('book1','title1','content1');
INSERT INTO chapter (name, title,content) VALUES ('book1','title2','content2');
INSERT INTO chapter (name, title,content) VALUES ('book1','title3','content3');
INSERT INTO chapter (name, title,content) VALUES ('book2','title1','content1');
INSERT INTO chapter (name, title,content) VALUES ('book2','title2','content2');
INSERT INTO chapter (name, title,content) VALUES ('book2','title3','content3');
INSERT INTO chapter (name, title,content) VALUES ('book3','title1','content1');
INSERT INTO chapter (name, title,content) VALUES ('book3','title2','content2');
INSERT INTO chapter (name, title,content) VALUES ('book3','title3','content3');
