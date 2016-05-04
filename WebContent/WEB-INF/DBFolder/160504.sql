-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: KBMS
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `file_folder`
--

DROP TABLE IF EXISTS `file_folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_folder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `f_id` char(32) NOT NULL,
  `fd_id` char(20) NOT NULL,
  `modified` varchar(17) NOT NULL,
  `modifier` varchar(255) NOT NULL,
  `deleted` varchar(17) DEFAULT NULL,
  `deleter` varchar(255) DEFAULT NULL,
  `delete_flag` smallint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_folder`
--

LOCK TABLES `file_folder` WRITE;
/*!40000 ALTER TABLE `file_folder` DISABLE KEYS */;
INSERT INTO `file_folder` VALUES (1,'1','1','1','1','1','1',0),(2,'2','1','1','1','1','1',0),(3,'3','1','1','1','1','1',0);
/*!40000 ALTER TABLE `file_folder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file_user`
--

DROP TABLE IF EXISTS `file_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `f_id` char(32) NOT NULL,
  `f_name` varchar(255) NOT NULL,
  `descrp` varchar(255) DEFAULT NULL,
  `fd_owner` varchar(255) NOT NULL,
  `modified` varchar(17) NOT NULL,
  `modifier` varchar(255) NOT NULL,
  `deleted` varchar(17) DEFAULT NULL,
  `deleter` varchar(255) DEFAULT NULL,
  `delete_flag` smallint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_user`
--

LOCK TABLES `file_user` WRITE;
/*!40000 ALTER TABLE `file_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `file_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `files`
--

DROP TABLE IF EXISTS `files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `f_id` char(32) NOT NULL,
  `mime_type` smallint(4) NOT NULL,
  `size` double NOT NULL,
  `real_path` varchar(255) NOT NULL,
  `transition_path` varchar(255) DEFAULT NULL,
  `thumb_path` varchar(255) DEFAULT NULL,
  `descrp` varchar(255) DEFAULT NULL,
  `retain` double NOT NULL DEFAULT '1',
  `modified` varchar(17) NOT NULL,
  `modifier` varchar(255) NOT NULL,
  `deleted` varchar(17) DEFAULT NULL,
  `deleter` varchar(255) DEFAULT NULL,
  `delete_flag` smallint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `f_id_UNIQUE` (`f_id`),
  UNIQUE KEY `transition_path_UNIQUE` (`transition_path`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `files`
--

LOCK TABLES `files` WRITE;
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
INSERT INTO `files` VALUES (1,'1',1,123,'dd','d','fdfd',NULL,1,'1','1',NULL,NULL,1),(2,'2',1,123,'dd','fa','fdfd',NULL,1,'1','1',NULL,NULL,1),(3,'3',1,123,'dd','fd','fdfd',NULL,1,'1','1',NULL,NULL,1);
/*!40000 ALTER TABLE `files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `folder`
--

DROP TABLE IF EXISTS `folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `folder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fd_id` char(20) NOT NULL,
  `fd_name` varchar(255) NOT NULL,
  `fd_owner` varchar(255) NOT NULL,
  `fd_super` char(20) NOT NULL,
  `modified` varchar(17) NOT NULL,
  `modifier` varchar(255) NOT NULL,
  `deleted` varchar(17) DEFAULT NULL,
  `deleter` varchar(255) DEFAULT NULL,
  `delete_flag` smallint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fd_id_UNIQUE` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `folder`
--

LOCK TABLES `folder` WRITE;
/*!40000 ALTER TABLE `folder` DISABLE KEYS */;
/*!40000 ALTER TABLE `folder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `perm` smallint(2) NOT NULL DEFAULT '2',
  `nick_name` varchar(45) DEFAULT NULL,
  `level` int(11) NOT NULL DEFAULT '0',
  `grade` int(11) NOT NULL DEFAULT '0',
  `e_mail` varchar(255) NOT NULL,
  `modified` varchar(45) NOT NULL,
  `modifier` varchar(255) NOT NULL,
  `deleted` varchar(45) DEFAULT NULL,
  `deleter` varchar(45) DEFAULT NULL,
  `delete_flag` smallint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'123','123',2,'333',0,0,'dsfkasldfkj@foxmail.com','20160405103843829','123',NULL,NULL,0),(6,'12s3','123',2,NULL,0,0,'dsfkasldfkj@foxmail.com','20160405115532725','12s3',NULL,NULL,0);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-04 10:29:45
