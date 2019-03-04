CREATE DATABASE IF NOT exists `medical_database`;
USE `medical_database`;

DROP TABLE IF EXISTS `pharmacy`;

CREATE TABLE `pharmacy` (
`id` int NOT NULL auto_increment PRIMARY KEY,
`medicine` varchar(20),
`mfg` varchar(20),
`exp` varchar(20),
`cost` varchar(20));