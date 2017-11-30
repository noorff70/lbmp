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
-- Table structure for table `topicdetail`
--

DROP TABLE IF EXISTS `topicdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topicdetail` (
  `TOPICDETAILID` int(11) NOT NULL,
  `TOPICDETAILNAME` varchar(45) NOT NULL,
  `TOPICID` int(11) NOT NULL,
  `CLASSNAME` varchar(500) NOT NULL,
  PRIMARY KEY (`TOPICDETAILID`),
  KEY `FK_TOPICID_ON_TOPIC_idx` (`TOPICID`),
  CONSTRAINT `FK_TOPICID_ON_TOPIC` FOREIGN KEY (`TOPICID`) REFERENCES `topic` (`TOPICID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topicdetail`
--

LOCK TABLES `topicdetail` WRITE;
/*!40000 ALTER TABLE `topicdetail` DISABLE KEYS */;
INSERT INTO `topicdetail` VALUES (7112,'Factors',711,'Grade7Factors'),(7113,'Prime Factors',711,'Grade7PrimeFactors'),(7114,'Highest Common Factors',711,'Grade7HCF'),(7115,'LCM',711,'Grade7LCM'),(7116,'Exponentials',711,'Grade7Exponents'),(7131,'Simple Fraction Addition',713,'Grade7AddFraction'),(7132,'Fraction Addition & Subtraction',713,'Grade7AddSubFraction'),(7133,'Mixed Type Add & Sub',713,'Grade7FractionMixedNumber'),(7134,'Find the Missing Fraction',713,'Grade7FractionMissingNumber'),(7135,'Add Fraction with Whole Number',713,'G7AddFracWholeNumber'),(7141,'Multiply Simple Fraction',714,'Grade7MultiplyFraction'),(7142,'Find Missing Fraction',714,'G7MultiplyMissingFrac'),(7143,'Fraction Statement Evaluation',714,'G7FracStmtEval'),(7144,'Mixed Fraction Operation',714,'G7DivisionFraction'),(7145,'Divide Simple Fraction',714,'G7DivideSimpleFraction'),(7151,'Simplify Fraction',715,'G7SimplifyFraction'),(7152,'Compare Fraction',715,'G7CompareFraction'),(7153,'Convert to Mixed Fraction',715,'G7ConvToMixedFraction'),(7154,'Identify Type of Fraction',715,'G7IdentifyFractionType'),(7155,'Convert Decimal to Fraction',715,'G7ConvtDecimalToFraction'),(7161,'Decimal Addition',716,'G7DecimalAddition'),(7162,'Decimal Subtraction',716,'G7DecimalSubtraction'),(7163,'Decimal Multiplication',716,'G7DecimalMultiplication'),(7164,'Decimal Division',716,'G7DecimalDivision'),(7171,'Exponent Evaluation',717,'G7ExponentEvaluation'),(7172,'Solve Equation with Exponents',717,'G7SolveExponentEquation'),(7173,'Base of Exponent',717,'G7ExponentBase'),(7174,'Exponent of Negative Numbers',717,'G7ExponentNegative'),(7175,'Exponent Expression',717,'G7ExponentExpression'),(7176,'Exponent of Decimals & Fractions',717,'G7ExponentDecimalFraction'),(7181,'Area of Triangle',718,'G7GeoAreaTriangle'),(7191,'Integer Percent',719,'G7PCTInteger'),(7192,'Percentage in Decimal',719,'G7PCTDecimal'),(7193,'Percent of Fraction',719,'G7PCTFraction'),(7201,'Conversion of Length Units',720,'G7UnitLnConv'),(8111,'Square Roots of Integers',811,'G8SqrInteger'),(8112,'Square Root of Fractions',811,'G8SqrFrac'),(8113,'Square Root of Decimals',811,'G8SqrDecimal');
/*!40000 ALTER TABLE `topicdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-30 23:59:18
