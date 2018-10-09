/*
SQLyog Enterprise - MySQL GUI v8.1 
MySQL - 5.5.60-log : Database - magalufinder
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`magalufinder` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `magalufinder`;

/*Table structure for table `tab_product` */

DROP TABLE IF EXISTS `tab_product`;

CREATE TABLE `tab_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `value` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tab_product` */

/*Table structure for table `tab_product_stores` */

DROP TABLE IF EXISTS `tab_product_stores`;

CREATE TABLE `tab_product_stores` (
  `id_product` bigint(20) NOT NULL,
  `id_store` bigint(20) NOT NULL,
  PRIMARY KEY (`id_product`,`id_store`),
  KEY `FKj24b3tx2o7ulehg6j8y87cm0b` (`id_store`),
  CONSTRAINT `FKmaunoy12jinlqb20ob5i9nlw0` FOREIGN KEY (`id_product`) REFERENCES `tab_product` (`id`),
  CONSTRAINT `FKj24b3tx2o7ulehg6j8y87cm0b` FOREIGN KEY (`id_store`) REFERENCES `tab_stores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tab_product_stores` */

/*Table structure for table `tab_stores` */

DROP TABLE IF EXISTS `tab_stores`;

CREATE TABLE `tab_stores` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cep` varchar(255) DEFAULT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tab_stores` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
