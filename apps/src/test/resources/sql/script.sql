CREATE DATABASE  IF NOT EXISTS `apps` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `apps`;
-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: apps
-- ------------------------------------------------------
-- Server version	5.5.40-0ubuntu0.14.04.1

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
-- Table structure for table `ADDRESS`
--

DROP TABLE IF EXISTS `ADDRESS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ADDRESS` (
  `ADDRESS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LINE1` varchar(255) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `DISTRICT` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `PIN` varchar(6) DEFAULT NULL,
  `RESI_PHONE` varchar(45) DEFAULT NULL,
  `OFF_PHONE` varchar(45) DEFAULT NULL,
  `MOB` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `AREA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADDRESS`
--

LOCK TABLES `ADDRESS` WRITE;
/*!40000 ALTER TABLE `ADDRESS` DISABLE KEYS */;
INSERT INTO `ADDRESS` VALUES (1,'56 Church Street','Kolkata','west-singhbhum','Karnataka','india','560067','022-12345432','022-12345678','9463554385','test@test.com','qweqwe'),(2,'56 Church Street','Kolkata','west-singhbhum','Karnataka','india','560067','022-12345432','022-12345678','9463554385','test@test.com','north'),(7,NULL,NULL,'Kolkata','West Bengal',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'asdasd',NULL,'Howrah','Delhi',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'asdasd',NULL,'Howrah','Delhi',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'hjkhjkhj',NULL,'Kolkata','West Bengal',NULL,NULL,NULL,'8678678678',NULL,NULL,NULL),(15,'Maniktala more','Kolkata','Kolkata','West Bengal',NULL,NULL,NULL,'123123123',NULL,NULL,'north'),(16,'Maniktala more',NULL,'Kolkata','West Bengal',NULL,NULL,NULL,'1312312313',NULL,NULL,NULL),(38,NULL,'Durgapur',NULL,'J & K','India','345345','345345345','5345345','345345345','pratik_chess@hotmail.com',NULL),(39,'m, j,kj,kj ,k j,','Kolkata',NULL,'West','India','455432',NULL,NULL,NULL,NULL,NULL),(40,'jkljlkjl jlkjlj l','Kolkata',NULL,'West','India','345345',NULL,NULL,NULL,NULL,NULL),(41,'asdasdasd','Kolkata',NULL,'West','India','455432',NULL,NULL,NULL,NULL,NULL),(42,'presidentName','Kolkata',NULL,'West','India','455432',NULL,NULL,NULL,NULL,NULL),(43,'52 Itkhola Birati','Kolkata',NULL,'West','India','700049',NULL,NULL,NULL,NULL,'Itkhola'),(44,'hjgghjg','Kolkata',NULL,'West','India','455432',NULL,NULL,NULL,NULL,'Itkhola'),(45,'jkghhkjhhjk','Kolkata',NULL,'West','India','455432',NULL,NULL,NULL,NULL,'asdasdasd'),(46,'asdasdasd dfdsg dghfd','Kolkata',NULL,'West','India','455432',NULL,NULL,NULL,NULL,'asdasdasd'),(47,'52 Itkhola, Nimta, Birati','Kolkata',NULL,'West','India','700049',NULL,NULL,NULL,NULL,'Itkhola'),(48,'52 Itkhola, Nimta, Birati','Kolkata',NULL,'West','India','700049',NULL,NULL,NULL,NULL,'Itkhola'),(49,'52 Itkhola Nimta Birati','Kolkata',NULL,'West','India','700049',NULL,NULL,NULL,NULL,'Itkhola'),(50,NULL,'Kolkata',NULL,'West Bengal','India','876543','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(51,NULL,'Kolkata',NULL,'West Bengal','India','876543','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(52,NULL,'Kolkata',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(53,NULL,'Kolkata',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(54,NULL,'Kolkata',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(55,NULL,'Kolkata',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(56,NULL,'Kolkata',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(57,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(58,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(59,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(60,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(61,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(62,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(63,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(64,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(65,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(66,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(67,NULL,'',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(68,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(69,NULL,'',NULL,'West','India','','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(70,'','',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(71,'','',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(72,'','',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(73,'','Asansol',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(74,'fg','Kolkata',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(75,'fg','Kolkata',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(76,'Itkhola','Kolkata',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(77,'Itkhola','Kolkata',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(78,'Itkhola','Kolkata',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(79,'Itkhola','Asansol',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(80,'Itkhola','Asansol',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(81,'Itkhola','Durgapur',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(82,'Itkhola','Durgapur',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(83,'Itkhola',NULL,NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(84,'Itkhola',NULL,NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(85,'Itkhola',NULL,NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(86,'Itkhola','Kolkata',NULL,'West','India','123123','033 2000 6636','033 2353 1262','9432669873','pratik006@gmail.com',NULL),(87,'Maniktala more',NULL,'Kolkata','Delhi',NULL,NULL,NULL,'033 2353 1262',NULL,'pratik006@gmail.com',NULL),(88,NULL,'Asansol',NULL,'Andhra Pradesh','India','345345','033 2000 6636','033 2353 1262','9432669873','pratik_chess@hotmail.com',NULL),(89,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'test area'),(90,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Itkhola'),(91,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Itkhola'),(92,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'dfsfd'),(93,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ttry'),(94,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ghjghj'),(95,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'fghfg'),(96,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'test123'),(97,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'rtyrty'),(98,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'test'),(99,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'jhgjh'),(100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hjkhjj');
/*!40000 ALTER TABLE `ADDRESS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BLOOD_BANK`
--

DROP TABLE IF EXISTS `BLOOD_BANK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BLOOD_BANK` (
  `BANK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BANK_NAME` varchar(255) DEFAULT NULL,
  `BANK_ADDRESS_ID` int(11) DEFAULT NULL,
  `CMO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BANK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BLOOD_BANK`
--

LOCK TABLES `BLOOD_BANK` WRITE;
/*!40000 ALTER TABLE `BLOOD_BANK` DISABLE KEYS */;
INSERT INTO `BLOOD_BANK` VALUES (1,'Birati Rakto Kendro',NULL,'Dr. ABC'),(2,'Apollo Blood Bank',NULL,'Dr. XYZ'),(3,'Maniktala',15,'QWE');
/*!40000 ALTER TABLE `BLOOD_BANK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BLOOD_STOCK`
--

DROP TABLE IF EXISTS `BLOOD_STOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BLOOD_STOCK` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BLOOD_GROUP` varchar(5) DEFAULT NULL,
  `RECV_DATE` datetime DEFAULT NULL,
  `ENTRY_DATE` datetime NOT NULL,
  `BATCH` varchar(45) NOT NULL,
  `BLOOD_BANK_ID` int(11) NOT NULL,
  `ISSUED` binary(1) DEFAULT '0',
  `ISSUE_DATE` datetime DEFAULT NULL,
  `EXPIRY_DATE` datetime NOT NULL,
  `TYPE` varchar(45) NOT NULL,
  `PATIENT_NAME` varchar(255) DEFAULT NULL,
  `HOSPITAL_NAME` varchar(255) DEFAULT NULL,
  `DOCTOR_NAME` varchar(255) DEFAULT NULL,
  `BED_NUMBER` varchar(255) DEFAULT NULL,
  `REMARKS` varchar(255) DEFAULT NULL,
  `VERIFIED_BY` varchar(255) DEFAULT NULL,
  `VERIFIED_TS` datetime DEFAULT NULL,
  `VERIFIER_REMARKS` varchar(255) DEFAULT NULL,
  `APPROVED_BY` varchar(255) DEFAULT NULL,
  `APPROVED_TS` datetime DEFAULT NULL,
  `APPROVER_REMARKS` varchar(255) DEFAULT NULL,
  `CREATED_TS` timestamp NULL DEFAULT NULL,
  `UPDATED_TS` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `VERIFIED` binary(1) DEFAULT '0',
  `APPROVED` binary(1) DEFAULT '0',
  `CREATED_BY` varchar(255) NOT NULL,
  `UPDATED_BY` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BATCH_UNIQUE` (`BATCH`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BLOOD_STOCK`
--

LOCK TABLES `BLOOD_STOCK` WRITE;
/*!40000 ALTER TABLE `BLOOD_STOCK` DISABLE KEYS */;
INSERT INTO `BLOOD_STOCK` VALUES (115,'A+','2014-08-21 13:57:00','2014-08-21 13:58:12','P-R-AB123123',2,'1',NULL,'2014-09-30 13:57:00','PLASMA','aa','asdas d','asdas d','a sdasd','asd asd','approver','2014-06-21 13:58:31','test verify','approver','2014-06-21 13:58:44','test approve','2014-06-21 08:28:12','2014-07-16 17:07:31','1','1','approver','approver'),(116,'A+','2014-08-21 13:57:00','2014-08-21 13:58:16','W-R-AB123123',2,'0',NULL,'2014-09-30 13:57:00','WBC',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2014-06-21 08:28:16','2014-07-16 17:07:31','0','0','approver','approver'),(117,'A+','2014-08-21 13:57:00','2014-08-21 13:58:16','T-R-AB123123',2,'0',NULL,'2014-09-30 13:57:00','PLATELETS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2014-06-21 08:28:16','2014-07-16 17:07:31','0','0','approver','approver'),(118,'A+','2014-08-21 13:57:00','2014-08-21 13:58:16','R-R-AB123123',2,'0',NULL,'2014-09-30 13:57:00','RBC',NULL,NULL,NULL,NULL,NULL,'approver','2014-06-21 14:03:27','test',NULL,NULL,NULL,'2014-06-21 08:28:16','2014-07-16 17:07:31','1','0','approver','approver'),(119,'A+','2014-08-21 14:02:00','2014-08-21 14:02:20','T-R-AB124124',2,'1',NULL,'2014-09-30 14:02:00','PLATELETS','Pradeepta','apollo','Doc','123','testing','approver','2014-06-21 14:02:39','Verifying this','approver','2014-06-21 14:02:50','approving this','2014-06-21 08:32:20','2014-07-16 17:07:31','1','1','approver','approver'),(120,'A+','2014-08-21 14:02:00','2014-08-21 14:02:20','W-R-AB124124',2,'0',NULL,'2014-09-30 14:02:00','WBC',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2014-06-21 08:32:20','2014-07-16 17:07:31','0','0','approver','approver'),(121,'A+','2014-08-21 14:02:00','2014-08-21 14:02:20','R-R-AB124124',2,'0',NULL,'2014-09-30 14:02:00','RBC',NULL,NULL,NULL,NULL,NULL,'approver','2014-06-21 14:03:33','test',NULL,NULL,NULL,'2014-06-21 08:32:20','2014-07-16 17:07:31','1','0','approver','approver'),(122,'A+','2014-08-21 14:02:00','2014-08-21 14:02:20','P-R-AB124124',2,'0',NULL,'2014-09-30 14:02:00','PLASMA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2014-06-21 08:32:20','2014-07-16 17:07:31','0','0','approver','approver');
/*!40000 ALTER TABLE `BLOOD_STOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAMP_DONOR`
--

DROP TABLE IF EXISTS `CAMP_DONOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CAMP_DONOR` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `CAMP_ID` int(11) DEFAULT NULL,
  `DONOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAMP_DONOR`
--

LOCK TABLES `CAMP_DONOR` WRITE;
/*!40000 ALTER TABLE `CAMP_DONOR` DISABLE KEYS */;
/*!40000 ALTER TABLE `CAMP_DONOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DONOR`
--

DROP TABLE IF EXISTS `DONOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DONOR` (
  `DONOR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(255) NOT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `GENDER` varchar(45) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `BLOOD_GROUP` varchar(45) DEFAULT NULL,
  `LAST_DON_DATE` datetime DEFAULT NULL,
  `HEIGHT` varchar(45) DEFAULT NULL,
  `WEIGHT` varchar(45) DEFAULT NULL,
  `BP` varchar(45) DEFAULT NULL,
  `COMMENTS` varchar(1024) DEFAULT NULL,
  `DONOR_ADDRESS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DONOR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DONOR`
--

LOCK TABLES `DONOR` WRITE;
/*!40000 ALTER TABLE `DONOR` DISABLE KEYS */;
INSERT INTO `DONOR` VALUES (1,'Pratik','Sengupta','M','2014-01-10','A+','2014-05-23 00:00:00','172','68','120/80','ok',86),(2,'gdfgd','test','',NULL,'A+',NULL,'172','68','120/80','dfghd g dfg',88);
/*!40000 ALTER TABLE `DONOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EVENT`
--

DROP TABLE IF EXISTS `EVENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENT` (
  `EVENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EVENT_DATE` date NOT NULL,
  `REQUIREMENT` varchar(255) DEFAULT NULL,
  `FULFILMENT` varchar(255) DEFAULT NULL,
  `EXP_DONOR_COUNT` int(11) DEFAULT NULL,
  `BLOOD_BANK_ID` int(11) DEFAULT NULL,
  `ADDRESS_ID` int(11) DEFAULT NULL,
  `ORGANIZATION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`EVENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENT`
--

LOCK TABLES `EVENT` WRITE;
/*!40000 ALTER TABLE `EVENT` DISABLE KEYS */;
INSERT INTO `EVENT` VALUES (1,'2014-03-02','jhgjhg','jghjgj',90,1,99,6),(13,'2014-03-02','jhjhjh','khkjhkjhkj',998,1,100,6);
/*!40000 ALTER TABLE `EVENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MASTER_CONFIG`
--

DROP TABLE IF EXISTS `MASTER_CONFIG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MASTER_CONFIG` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONFIG_TYPE` varchar(45) DEFAULT NULL,
  `CODE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `CODE_UNIQUE` (`CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MASTER_CONFIG`
--

LOCK TABLES `MASTER_CONFIG` WRITE;
/*!40000 ALTER TABLE `MASTER_CONFIG` DISABLE KEYS */;
INSERT INTO `MASTER_CONFIG` VALUES (1,'STATE','WB','West Bengal'),(2,'STATE','JH','Jharkhand'),(3,'STATE','BH','Bihar'),(4,'STATE','DL','Delhi'),(5,'STATE','OR','Orissa'),(6,'CITY','KOL','Kolkata'),(7,'CITY','DGR','Durgapur'),(8,'CITY','ASN','Asansol'),(9,'CITY','NJP','New Jalpaiguri'),(10,'COUNTRY','IN','India');
/*!40000 ALTER TABLE `MASTER_CONFIG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ONGC_PERFORMANCE`
--

DROP TABLE IF EXISTS `ONGC_PERFORMANCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ONGC_PERFORMANCE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TMT_NAME` varchar(255) DEFAULT NULL,
  `TMT_DATE` date DEFAULT NULL,
  `TMT_VENUE` varchar(255) DEFAULT NULL,
  `RANK` varchar(45) DEFAULT NULL,
  `SCORE` varchar(45) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `REMARKS` varchar(255) DEFAULT NULL,
  `TMT_END_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_ONGC_PERFORMANCE_1_idx` (`USER_ID`),
  CONSTRAINT `fk_ONGC_PERFORMANCE_1` FOREIGN KEY (`USER_ID`) REFERENCES `USER` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ONGC_PERFORMANCE`
--

LOCK TABLES `ONGC_PERFORMANCE` WRITE;
/*!40000 ALTER TABLE `ONGC_PERFORMANCE` DISABLE KEYS */;
INSERT INTO `ONGC_PERFORMANCE` VALUES (54,'asdasd','2014-10-06','asd','asd','asdasd',2002,'asdasd','2014-10-06'),(55,'gggg','2014-10-06','gfhfgh','fghfgh','fghfgh',2002,'fghfg','2014-10-22');
/*!40000 ALTER TABLE `ONGC_PERFORMANCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORGANIZATION`
--

DROP TABLE IF EXISTS `ORGANIZATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ORGANIZATION` (
  `ORG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BANK_ID` int(11) DEFAULT NULL,
  `DONOR_ID` int(11) DEFAULT NULL,
  `ORG_NAME` varchar(255) DEFAULT NULL,
  `CAMP_DATE` date DEFAULT NULL,
  `SEC_NAME` varchar(255) DEFAULT NULL,
  `PRESI_NAME` varchar(255) DEFAULT NULL,
  `CONTACT_PERSON` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(1024) DEFAULT NULL,
  `ADDRESS_ID` int(11) DEFAULT NULL,
  `REGISTRATION_DATE` timestamp NULL DEFAULT NULL,
  `ORGANIZATION_CODE` varchar(255) NOT NULL,
  PRIMARY KEY (`ORG_ID`),
  UNIQUE KEY `CAMP_ID_UNIQUE` (`ORG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORGANIZATION`
--

LOCK TABLES `ORGANIZATION` WRITE;
/*!40000 ALTER TABLE `ORGANIZATION` DISABLE KEYS */;
INSERT INTO `ORGANIZATION` VALUES (6,1,NULL,'Itkhola Kishore Sangha',NULL,'Arun Pal','Subhash Das','Chotu','ok',49,'2014-03-01 18:30:00','YAV/2014-JAN/West Bengal/6');
/*!40000 ALTER TABLE `ORGANIZATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERMISSION`
--

DROP TABLE IF EXISTS `PERMISSION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PERMISSION` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERMISSION`
--

LOCK TABLES `PERMISSION` WRITE;
/*!40000 ALTER TABLE `PERMISSION` DISABLE KEYS */;
INSERT INTO `PERMISSION` VALUES (1,'READ'),(2,'WRITE'),(3,'EDIT');
/*!40000 ALTER TABLE `PERMISSION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROLES`
--

DROP TABLE IF EXISTS `ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLES` (
  `ROLE_ID` int(6) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `ROLE_DESC` varchar(45) DEFAULT NULL,
  `APP_CODE` varchar(45) DEFAULT 'yavni',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROLES`
--

LOCK TABLES `ROLES` WRITE;
/*!40000 ALTER TABLE `ROLES` DISABLE KEYS */;
INSERT INTO `ROLES` VALUES (1,'ROLE_SUPER_USER',NULL,'yavni'),(2,'ROLE_BANK_USER',NULL,'yavni'),(3,'ROLE_CALL_CENTER_USER',NULL,'yavni'),(4,'ROLE_VERIFIER',NULL,'yavni'),(5,'ROLE_APPROVER',NULL,'yavni'),(6,'ROLE_CMO',NULL,'yavni'),(7,'ROLE_BLOOD_BANK_ADMIN','','yavni'),(11,'ROLE_MNGR',NULL,'ONGC'),(12,'ROLE_PLAYER',NULL,'');
/*!40000 ALTER TABLE `ROLES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROLE_PERMISSION`
--

DROP TABLE IF EXISTS `ROLE_PERMISSION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLE_PERMISSION` (
  `ROLE_PERMISSION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(11) NOT NULL,
  `PERMISSION_ID` int(11) NOT NULL,
  PRIMARY KEY (`ROLE_PERMISSION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROLE_PERMISSION`
--

LOCK TABLES `ROLE_PERMISSION` WRITE;
/*!40000 ALTER TABLE `ROLE_PERMISSION` DISABLE KEYS */;
INSERT INTO `ROLE_PERMISSION` VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,1),(5,3,1),(6,2,2),(7,2,3);
/*!40000 ALTER TABLE `ROLE_PERMISSION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `APP_CODE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_NAME_UNIQUE` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=2009 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (1001,'superuser','Admin','Admin','password','YAVNI'),(1002,'bankuser','bankuser','bankuser','password','YAVNI'),(1003,'prodeepta','Prodeepta','Dasgupta','password','YAVNI'),(1004,'Deep123','Deep','Sengupta','password','YAVNI'),(1005,'verifier','verifier','verifier','password','YAVNI'),(1006,'approver','approver','approver','password','YAVNI'),(1007,'cmo','cmo','cmo','password','YAVNI'),(1008,'bbAdmin','bbAdmin','bbAdmin','password','YAVNI'),(2001,'82891','Konguvel','P','password','ONGC'),(2002,'122971','Deep','Sengupta','password','ONGC'),(2003,'73757','Sasikiran','K','password','ONGC'),(2004,'94860','Humpy','K','password','ONGC'),(2005,'123197','Sethuramsn','S.P','password','ONGC'),(2006,'77050','Ravi','Lanka','password','ONGC'),(2007,'77056','Neelotpal','Das','password','ONGC'),(2008,NULL,'Vidit','Gujarathi','password','ONGC');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ATTR`
--

DROP TABLE IF EXISTS `USER_ATTR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ATTR` (
  `ATTR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ATTR_NAME` varchar(45) NOT NULL,
  `ATTR_VALUE` varchar(45) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`ATTR_ID`),
  KEY `fk_USER_ATTR_1_idx` (`USER_ID`),
  CONSTRAINT `fk_USER_ATTR_1` FOREIGN KEY (`USER_ID`) REFERENCES `USER` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ATTR`
--

LOCK TABLES `USER_ATTR` WRITE;
/*!40000 ALTER TABLE `USER_ATTR` DISABLE KEYS */;
INSERT INTO `USER_ATTR` VALUES (1,'DESIGNATION','F&A Officer/ ONGC Kolkata',2002),(2,'DOB','30/06/1988',2002),(3,'DOJ','23/02/2012',2002),(4,'EDU_QUAL','B.COM (H)',2002),(59,'DESIGNATION','SE (E&T)/ GC-Chess/ ONGC Chennai',2001),(60,'DOB','',2001),(61,'DOJ','',2001),(62,'EDU_QUAL','',2001),(63,'DESIGNATION','Fire Officer/ ONGC Chennai',2007),(64,'DOB','',2007),(65,'DOJ','',2007),(66,'EDU_QUAL','',2007),(67,'DESIGNATION','Manager (HR)/ ONGC Rajahmundry',2006),(68,'DOB','',2006),(69,'DOJ','',2006),(70,'EDU_QUAL','',2006),(71,'DESIGNATION','AG II/ ONGC Chennai',2005),(72,'DOB','',2005),(73,'DOJ','',2005),(74,'EDU_QUAL','',2005),(75,'DESIGNATION','Manager (HR)/ ONGC Hyderabad',2004),(76,'DOB','',2004),(77,'DOJ','',2004),(78,'EDU_QUAL','',2004),(79,'DESIGNATION','Manager (HR)/ ONGC Chennai',2003),(80,'DOB','',2003),(81,'DOJ','',2003),(82,'EDU_QUAL','',2003),(83,'DESIGNATION','',2008),(84,'DOB','',2008),(85,'DOJ','',2008),(86,'EDU_QUAL','',2008);
/*!40000 ALTER TABLE `USER_ATTR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_BANK_XREF`
--

DROP TABLE IF EXISTS `USER_BANK_XREF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_BANK_XREF` (
  `USER_ID` int(11) NOT NULL,
  `BANK_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`BANK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_BANK_XREF`
--

LOCK TABLES `USER_BANK_XREF` WRITE;
/*!40000 ALTER TABLE `USER_BANK_XREF` DISABLE KEYS */;
INSERT INTO `USER_BANK_XREF` VALUES (1006,2);
/*!40000 ALTER TABLE `USER_BANK_XREF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ROLES`
--

DROP TABLE IF EXISTS `USER_ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ROLES` (
  `USER_ID` int(6) NOT NULL,
  `ROLE_ID` int(6) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  KEY `user` (`USER_ID`),
  KEY `role` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ROLES`
--

LOCK TABLES `USER_ROLES` WRITE;
/*!40000 ALTER TABLE `USER_ROLES` DISABLE KEYS */;
INSERT INTO `USER_ROLES` VALUES (100008,3,1),(100009,3,2),(1004,3,3),(1001,1,4),(1002,2,5),(1003,3,6),(1005,2,7),(1005,4,8),(1006,2,10),(1006,4,11),(1006,5,12),(1007,2,13),(1007,2,14),(1007,5,15),(1007,6,16),(1008,7,17),(2001,11,101),(2002,12,102);
/*!40000 ALTER TABLE `USER_ROLES` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-28  0:33:59
