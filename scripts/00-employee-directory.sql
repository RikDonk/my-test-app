CREATE DATABASE  IF NOT EXISTS `testapp`;
USE `testapp`;

DROP TABLE IF EXISTS `employee_detail`;

--
-- Table structure for table `employee_detail`
--

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `employee_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `employee`
--
DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `employee_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`employee_detail_id`),
    CONSTRAINT `FK_DETAIL` FOREIGN KEY (`employee_detail_id`) REFERENCES `employee_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee_detail + employee`
--

INSERT INTO `employee_detail` VALUES
    (1, 'https://www.youtube.com/', 'racen'),
    (2, 'https://www.youtube.com/', 'tekenen'),
    (3, 'https://www.youtube.com/', 'muziek'),
    (4, 'https://www.youtube.com/', 'tekenen'),
    (5, 'https://www.youtube.com/', 'racen');

INSERT INTO `employee` VALUES
	(1,'Leslie','Andrews','leslie@luv2code.com', 1),
	(2,'Emma','Baumgarten','emma@luv2code.com', 2),
	(3,'Avani','Gupta','avani@luv2code.com', 3),
	(4,'Yuri','Petrov','yuri@luv2code.com', 4),
	(5,'Juan','Vega','juan@luv2code.com', 5);

SET FOREIGN_KEY_CHECKS = 1;