CREATE DATABASE IF NOT EXISTS `online_polyclinic`;
USE `online_polyclinic`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `admininstrator`;

--
-- Table structure for table `admininstrator`
--

CREATE TABLE `admininstrator` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `specialty`;

--
-- Table structure for table `specialty`
--

CREATE TABLE `specialty` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `doctor`;

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `specialty_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_SPECIALTY_idx` (`specialty_id`),
    CONSTRAINT `FK_SPECIALTY` FOREIGN KEY (`specialty_id`) REFERENCES `specialty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `patient`;

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `service`;

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `visit`;

--
-- Table structure for table `visit`
--

CREATE TABLE `visit` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;