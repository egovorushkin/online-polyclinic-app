CREATE DATABASE IF NOT EXISTS `online_polyclinic`;
USE `online_polyclinic`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `admininstrator`;

--
-- Table structure for table `admininstrator`
--

CREATE TABLE `administrator` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `speciality`;

--
-- Table structure for table `speciality`
--

CREATE TABLE `speciality` (
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
    `speciality_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_SPECIALITY_idx` (`speciality_id`),
    CONSTRAINT `FK_SPECIALITY` FOREIGN KEY (`speciality_id`) REFERENCES `speciality` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `patient`;

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) DEFAULT NULL,
    `last_name` VARCHAR(45) DEFAULT NULL,
    `address` VARCHAR(100) DEFAULT NULL,
    `day_of_birth` DATE DEFAULT NULL,
    `phone_number` VARCHAR(10) DEFAULT NULL,
    `note` VARCHAR(254) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `medical_service`;

--
-- Table structure for table `medical_service`
--

CREATE TABLE `medical_service` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `diagnosis`;

--
-- Table structure for table `diagnosis`
--

CREATE TABLE `diagnosis` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL,
    `description` text DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `visit`;

--
-- Table structure for table `visit`
--

CREATE TABLE `visit` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `patient_id` int(11) DEFAULT NULL,
    `doctor_id` int(11) DEFAULT NULL,
    `date` datetime DEFAULT NULL,
    `medical_service_id` int(11) DEFAULT NULL,
    `diagnosis_id` int(11) DEFAULT NULL,
    
    PRIMARY KEY (`id`),
    
    CONSTRAINT `FK_PATIENT` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    CONSTRAINT `FK_DOCTOR` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    CONSTRAINT `FK_MEDICAL_SERVICE` FOREIGN KEY (`medical_service_id`) REFERENCES `medical_service` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    CONSTRAINT `FK_DIAGNOSIS` FOREIGN KEY (`diagnosis_id`) REFERENCES `diagnosis` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
    
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
