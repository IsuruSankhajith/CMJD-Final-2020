-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: db_payroll
-- ------------------------------------------------------
-- Server version	5.5.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_attendance`
--

DROP TABLE IF EXISTS `tb_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_attendance` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT,
  `in_time` datetime DEFAULT NULL,
  `out_time` datetime DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `fk_1_idx` (`employee_id`),
  CONSTRAINT `fk_1` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_attendance`
--

LOCK TABLES `tb_attendance` WRITE;
/*!40000 ALTER TABLE `tb_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_employee`
--

DROP TABLE IF EXISTS `tb_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(150) DEFAULT NULL,
  `contact_no` varchar(45) DEFAULT NULL,
  `nic` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `is_active` int(1) DEFAULT NULL,
  `created_date_time` datetime DEFAULT NULL,
  `employee_type` int(11) DEFAULT NULL,
  `employee_category` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `fk_2_idx` (`employee_type`),
  KEY `fk_2_idx1` (`employee_category`),
  CONSTRAINT `fk_2` FOREIGN KEY (`employee_category`) REFERENCES `tb_employee_category` (`employee_category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_9` FOREIGN KEY (`employee_type`) REFERENCES `tb_employee_type` (`employee_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_employee`
--

LOCK TABLES `tb_employee` WRITE;
/*!40000 ALTER TABLE `tb_employee` DISABLE KEYS */;
INSERT INTO `tb_employee` VALUES (1,'Nuwan','weerasinghe','0714245557','900954727V','Matara',1,'2020-04-10 00:00:00',1,1);
/*!40000 ALTER TABLE `tb_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_employee_category`
--

DROP TABLE IF EXISTS `tb_employee_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_employee_category` (
  `employee_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) DEFAULT NULL,
  `is_ot_allowed` int(1) DEFAULT NULL,
  PRIMARY KEY (`employee_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_employee_category`
--

LOCK TABLES `tb_employee_category` WRITE;
/*!40000 ALTER TABLE `tb_employee_category` DISABLE KEYS */;
INSERT INTO `tb_employee_category` VALUES (1,'test',0);
/*!40000 ALTER TABLE `tb_employee_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_employee_leave`
--

DROP TABLE IF EXISTS `tb_employee_leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_employee_leave` (
  `employee_leave_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `create_date_time` varchar(45) DEFAULT NULL,
  `leave_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_leave_id`),
  KEY `fk_3_idx` (`employee_id`),
  KEY `fk_4_idx` (`leave_type_id`),
  CONSTRAINT `fk_3` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_4` FOREIGN KEY (`leave_type_id`) REFERENCES `tb_leave_type` (`leave_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_employee_leave`
--

LOCK TABLES `tb_employee_leave` WRITE;
/*!40000 ALTER TABLE `tb_employee_leave` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_employee_leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_employee_type`
--

DROP TABLE IF EXISTS `tb_employee_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_employee_type` (
  `employee_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) DEFAULT NULL,
  `leave_count` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`employee_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_employee_type`
--

LOCK TABLES `tb_employee_type` WRITE;
/*!40000 ALTER TABLE `tb_employee_type` DISABLE KEYS */;
INSERT INTO `tb_employee_type` VALUES (1,'test',0);
/*!40000 ALTER TABLE `tb_employee_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_leave_type`
--

DROP TABLE IF EXISTS `tb_leave_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_leave_type` (
  `leave_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) DEFAULT NULL,
  `no_of_hour` int(11) DEFAULT NULL,
  PRIMARY KEY (`leave_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_leave_type`
--

LOCK TABLES `tb_leave_type` WRITE;
/*!40000 ALTER TABLE `tb_leave_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_leave_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_settings`
--

DROP TABLE IF EXISTS `tb_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_settings` (
  `settings_id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(45) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`settings_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_settings`
--

LOCK TABLES `tb_settings` WRITE;
/*!40000 ALTER TABLE `tb_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_shift`
--

DROP TABLE IF EXISTS `tb_shift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_shift` (
  `shift_id` int(11) NOT NULL AUTO_INCREMENT,
  `shift_name` varchar(100) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`shift_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_shift`
--

LOCK TABLES `tb_shift` WRITE;
/*!40000 ALTER TABLE `tb_shift` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_transaction`
--

DROP TABLE IF EXISTS `tb_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `gross_salary` int(11) DEFAULT NULL,
  `net_salary` int(11) DEFAULT NULL,
  `salary_for` date DEFAULT NULL,
  `transaction_time` datetime DEFAULT NULL,
  `is_active` int(1) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `fk_5_idx` (`employee_id`),
  CONSTRAINT `fk_5` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_transaction`
--

LOCK TABLES `tb_transaction` WRITE;
/*!40000 ALTER TABLE `tb_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_transaction_detail`
--

DROP TABLE IF EXISTS `tb_transaction_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_transaction_detail` (
  `transaction_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`transaction_detail_id`),
  KEY `fk_6_idx` (`transaction_id`),
  CONSTRAINT `fk_6` FOREIGN KEY (`transaction_id`) REFERENCES `tb_transaction` (`transaction_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_transaction_detail`
--

LOCK TABLES `tb_transaction_detail` WRITE;
/*!40000 ALTER TABLE `tb_transaction_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_transaction_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `created_date_time` datetime DEFAULT NULL,
  `is_active` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_7_idx` (`type_id`),
  CONSTRAINT `fk_7` FOREIGN KEY (`type_id`) REFERENCES `tb_user_type` (`type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (2,1,'test','test','123','2020-03-18 00:00:00',1);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_type`
--

DROP TABLE IF EXISTS `tb_user_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_type`
--

LOCK TABLES `tb_user_type` WRITE;
/*!40000 ALTER TABLE `tb_user_type` DISABLE KEYS */;
INSERT INTO `tb_user_type` VALUES (1,'admin');
/*!40000 ALTER TABLE `tb_user_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-10 20:14:43
