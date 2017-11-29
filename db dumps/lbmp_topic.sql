-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: lbmp
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `TOPICID` int(11) NOT NULL,
  `GRADEID` int(11) NOT NULL,
  `SUBJECTID` int(11) NOT NULL,
  `TOPICNAME` varchar(45) NOT NULL,
  `GRADESUBJECT` varchar(45) NOT NULL,
  PRIMARY KEY (`TOPICID`),
  KEY `FK_SUBJECTID_ON_SUBJECT_idx` (`SUBJECTID`),
  KEY `FK_GRADEID_ON_GRADE_idx` (`GRADEID`),
  CONSTRAINT `FK_GRADEID_ON_GRADE` FOREIGN KEY (`GRADEID`) REFERENCES `grade` (`GRADEID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SUBJECTID_ON_SUBJECT` FOREIGN KEY (`SUBJECTID`) REFERENCES `subject` (`SUBJECTID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (711,7,1,'Number  Concepts','gradesevenmath'),(713,7,1,'Fraction- Addition & Subtraction','gradesevenmath'),(714,7,1,'Fraction-Multiplication & Division','gradesevenmath'),(715,7,1,'Fraction','gradesevenmath'),(716,7,1,'Decimals','gradesevenmath'),(717,7,1,'Exponents & Roots','gradesevenmath'),(718,7,1,'Geometry','gradesevenmath'),(719,7,1,'Concept of Percent','gradesevenmath'),(720,7,1,'Conversion of Units','gradesevenmath'),(811,8,1,'Roots','gradeeightmath');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-30 23:59:17
