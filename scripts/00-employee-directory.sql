CREATE DATABASE  IF NOT EXISTS `testapp`;
USE `testapp`;

SET FOREIGN_KEY_CHECKS = 0;
--
-- Table structure for table `companies`
--
DROP TABLE IF EXISTS `companies`;

CREATE TABLE `companies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `departments`
--
DROP TABLE IF EXISTS `departments`;

CREATE TABLE `departments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COMPANY_idx` (`company_id`),
    CONSTRAINT `FK_COMPANY` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `employee_detail`;
--
-- Table structure for table `employee_detail`
--
CREATE TABLE `employee_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
--
-- Table structure for table `employee`
--
DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `employee_detail_id` int DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DEPARTMENT_idx` (`department_id`),
    CONSTRAINT `FK_DEPARTMENT` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_DETAIL_idx` (`employee_detail_id`),
    CONSTRAINT `FK_DETAIL` FOREIGN KEY (`employee_detail_id`) REFERENCES `employee_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
--
-- Data for table `employee_detail + employees`
--
INSERT INTO `companies` VALUES
	(1, 'Nationale Politie'),
	(2, 'McDonalds');

INSERT INTO `departments` VALUES
	(1, 'Algmene Opsporing', 1),
	(2, 'Predevelopment', 1),
    (3, 'Balie', 2),
	(4, 'Keuken', 2);

INSERT INTO `employee_detail` VALUES
    (1, 'https://www.youtube.com/', 'racen'),
    (2, 'https://www.youtube.com/', 'tekenen'),
    (3, 'https://www.youtube.com/', 'muziek'),
    (4, 'https://www.youtube.com/', 'tekenen'),
    (5, 'https://www.youtube.com/', 'racen');

INSERT INTO `employees` VALUES
	(1,'Leslie','Andrews','leslie@luv2code.com', 1, 1),
	(2,'Emma','Baumgarten','emma@luv2code.com', 2, 2),
	(3,'Avani','Gupta','avani@luv2code.com', 3, 1),
	(4,'Yuri','Petrov','yuri@luv2code.com', 4, 2),
	(5,'Juan','Vega','juan@luv2code.com', 5, 1);

SET FOREIGN_KEY_CHECKS = 1;