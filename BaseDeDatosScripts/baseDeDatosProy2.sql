-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: progra3_proy2
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `bien`
--

DROP TABLE IF EXISTS `bien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bien` (
  `bien_id` int(11) NOT NULL AUTO_INCREMENT,
  `bien_descripcion` varchar(100) DEFAULT NULL,
  `bien_marca` varchar(50) DEFAULT NULL,
  `bien_modelo` varchar(50) DEFAULT NULL,
  `bien_precio` double NOT NULL,
  `bien_codigo` varchar(100) DEFAULT NULL,
  `bien_categoria` int(11) DEFAULT NULL,
  `bien_solicitud` int(11) NOT NULL,
  `bien_cantidad` int(11) NOT NULL,
  `bien_activo_universitario` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`bien_id`),
  KEY `fk_solicitud_bien_idx` (`bien_solicitud`),
  KEY `fk_categoria_bien_idx` (`bien_categoria`),
  CONSTRAINT `fk_categoria_bien` FOREIGN KEY (`bien_categoria`) REFERENCES `categoria` (`categoria_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_bien` FOREIGN KEY (`bien_solicitud`) REFERENCES `solicitud` (`solicitud_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bien`
--

LOCK TABLES `bien` WRITE;
/*!40000 ALTER TABLE `bien` DISABLE KEYS */;
/*!40000 ALTER TABLE `bien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `categoria_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_nombre` varchar(50) NOT NULL,
  `categoria_descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobante`
--

DROP TABLE IF EXISTS `comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprobante` (
  `comprobante_id` int(11) NOT NULL AUTO_INCREMENT,
  `comprobante_fecha_de_adquisicion` datetime NOT NULL,
  `comprobante_tipo_de_adquisicion` int(11) NOT NULL,
  `comprobante_cant_bienes` int(11) NOT NULL,
  `comprobante_monto_total` double NOT NULL,
  PRIMARY KEY (`comprobante_id`),
  KEY `fk_adquisicion_comprobante_idx` (`comprobante_tipo_de_adquisicion`),
  CONSTRAINT `fk_adquisicion_comprobante` FOREIGN KEY (`comprobante_tipo_de_adquisicion`) REFERENCES `tipodeadquisicion` (`tipoDeAdquisicion_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobante`
--

LOCK TABLES `comprobante` WRITE;
/*!40000 ALTER TABLE `comprobante` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependencia`
--

DROP TABLE IF EXISTS `dependencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dependencia` (
  `dependencia_id` int(11) NOT NULL AUTO_INCREMENT,
  `dependencia_nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`dependencia_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependencia`
--

LOCK TABLES `dependencia` WRITE;
/*!40000 ALTER TABLE `dependencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `dependencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `empleado_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`empleado_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `funcionario_id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario_nombre` varchar(50) NOT NULL,
  `funcionario_descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`funcionario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud` (
  `solicitud_id` int(11) NOT NULL AUTO_INCREMENT,
  `solicitud_comprobante` int(11) DEFAULT NULL,
  `solicitud_estado` varchar(50) DEFAULT NULL,
  `solicitud_registrador_de_bienes` int(11) DEFAULT NULL,
  `solicitud_dependencia` int(11) DEFAULT NULL,
  `solicitud_tramite_asociado` int(11) DEFAULT NULL,
  PRIMARY KEY (`solicitud_id`),
  KEY `fk_dependencia_solicitud_idx` (`solicitud_dependencia`),
  KEY `fk_registrado_solicitud_idx` (`solicitud_registrador_de_bienes`),
  KEY `fk_comprobante_solicitud_idx` (`solicitud_comprobante`),
  KEY `fk_tramite_solicitud_idx` (`solicitud_tramite_asociado`),
  CONSTRAINT `fk_comprobante_solicitud` FOREIGN KEY (`solicitud_comprobante`) REFERENCES `comprobante` (`comprobante_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dependencia_solicitud` FOREIGN KEY (`solicitud_dependencia`) REFERENCES `dependencia` (`dependencia_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_registrado_solicitud` FOREIGN KEY (`solicitud_registrador_de_bienes`) REFERENCES `usuario` (`usuario_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tramite_solicitud` FOREIGN KEY (`solicitud_tramite_asociado`) REFERENCES `tramites` (`tramites_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud`
--

LOCK TABLES `solicitud` WRITE;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodeadquisicion`
--

DROP TABLE IF EXISTS `tipodeadquisicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipodeadquisicion` (
  `tipoDeAdquisicion_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipodeadquisicion_nombre` varchar(50) NOT NULL,
  `tipodeadquisicion_despcripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`tipoDeAdquisicion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodeadquisicion`
--

LOCK TABLES `tipodeadquisicion` WRITE;
/*!40000 ALTER TABLE `tipodeadquisicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipodeadquisicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tramites`
--

DROP TABLE IF EXISTS `tramites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tramites` (
  `tramites_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`tramites_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tramites`
--

LOCK TABLES `tramites` WRITE;
/*!40000 ALTER TABLE `tramites` DISABLE KEYS */;
/*!40000 ALTER TABLE `tramites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_username` varchar(50) NOT NULL,
  `usuario_password` varchar(50) NOT NULL,
  `usuario_rol` varchar(50) NOT NULL,
  PRIMARY KEY (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-12 15:20:44
