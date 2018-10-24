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
-- Table structure for table `activo_universitario`
--

DROP TABLE IF EXISTS `activo_universitario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activo_universitario` (
  `activos_universitario_id` int(11) NOT NULL AUTO_INCREMENT,
  `activo_universitario_bien` int(11) DEFAULT NULL,
  `activo_universitario_categoria` int(11) DEFAULT NULL,
  `activo_universitario_responsable` int(11) DEFAULT NULL,
  `activo_universitario_codigo` varchar(50) DEFAULT NULL,
  `activo_universitario_descripcion` varchar(100) DEFAULT NULL,
  `activo_universitario_registrado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`activos_universitario_id`),
  UNIQUE KEY `activos_universitario_id_UNIQUE` (`activos_universitario_id`),
  KEY `fk_bien_activo_idx` (`activo_universitario_bien`),
  KEY `fk_categoria_idx` (`activo_universitario_categoria`),
  KEY `fk_funcionario_activo_idx` (`activo_universitario_responsable`),
  CONSTRAINT `fk_bien_activo` FOREIGN KEY (`activo_universitario_bien`) REFERENCES `bien` (`bien_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria_activo` FOREIGN KEY (`activo_universitario_categoria`) REFERENCES `categoria` (`categoria_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_labor_activo` FOREIGN KEY (`activo_universitario_responsable`) REFERENCES `labor` (`labor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activo_universitario`
--

LOCK TABLES `activo_universitario` WRITE;
/*!40000 ALTER TABLE `activo_universitario` DISABLE KEYS */;
/*!40000 ALTER TABLE `activo_universitario` ENABLE KEYS */;
UNLOCK TABLES;

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
  `bien_solicitud` int(11) NOT NULL,
  `bien_cantidad` int(11) NOT NULL,
  PRIMARY KEY (`bien_id`),
  UNIQUE KEY `bien_id_UNIQUE` (`bien_id`),
  KEY `fk_solicitud_bien_idx` (`bien_solicitud`),
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
  PRIMARY KEY (`categoria_id`),
  UNIQUE KEY `categoria_id_UNIQUE` (`categoria_id`)
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
  UNIQUE KEY `comprobante_id_UNIQUE` (`comprobante_id`),
  KEY `fk_adquisicion_comprobante_idx` (`comprobante_tipo_de_adquisicion`),
  CONSTRAINT `fk_adquisicion_comprobante` FOREIGN KEY (`comprobante_tipo_de_adquisicion`) REFERENCES `tipo_de_adquisicion` (`tipo_de_adquisicion_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `dependencia_administrador` int(11) DEFAULT NULL,
  PRIMARY KEY (`dependencia_id`),
  UNIQUE KEY `dependencia_id_UNIQUE` (`dependencia_id`),
  KEY `fk_funcionario_dependencia_idx` (`dependencia_administrador`),
  CONSTRAINT `fk_funcionario_dependencia` FOREIGN KEY (`dependencia_administrador`) REFERENCES `funcionario` (`funcionario_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `funcionario_id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario_nombre` varchar(50) NOT NULL,
  `funcionario_recibe_solicitud` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`funcionario_id`),
  UNIQUE KEY `funcionario_id_UNIQUE` (`funcionario_id`)
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
-- Table structure for table `labor`
--

DROP TABLE IF EXISTS `labor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `labor` (
  `labor_id` int(11) NOT NULL AUTO_INCREMENT,
  `labor_puesto` int(11) NOT NULL,
  `labor_dependencia` int(11) NOT NULL,
  `labor_funcionario` int(11) NOT NULL,
  PRIMARY KEY (`labor_id`),
  UNIQUE KEY `labor_id_UNIQUE` (`labor_id`),
  KEY `fk_puesto_labor_idx` (`labor_puesto`),
  KEY `fk_dependencia_labor_idx` (`labor_dependencia`),
  KEY `fk_funcionario_labor_idx` (`labor_funcionario`),
  CONSTRAINT `fk_dependencia_labor` FOREIGN KEY (`labor_dependencia`) REFERENCES `dependencia` (`dependencia_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_labor` FOREIGN KEY (`labor_funcionario`) REFERENCES `funcionario` (`funcionario_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_puesto_labor` FOREIGN KEY (`labor_puesto`) REFERENCES `puesto` (`puesto_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labor`
--

LOCK TABLES `labor` WRITE;
/*!40000 ALTER TABLE `labor` DISABLE KEYS */;
/*!40000 ALTER TABLE `labor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puesto` (
  `puesto_id` int(11) NOT NULL AUTO_INCREMENT,
  `puesto_nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`puesto_id`),
  UNIQUE KEY `puesto_id_UNIQUE` (`puesto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES (6,'1'),(7,'2'),(8,'3'),(9,'4'),(10,'6'),(11,'67');
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
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
  `solicitud_descripcion_de_rechazo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`solicitud_id`),
  UNIQUE KEY `solicitud_id_UNIQUE` (`solicitud_id`),
  UNIQUE KEY `solicitud_comprobante_UNIQUE` (`solicitud_comprobante`),
  KEY `fk_dependencia_solicitud_idx` (`solicitud_dependencia`),
  KEY `fk_registrado_solicitud_idx` (`solicitud_registrador_de_bienes`),
  KEY `fk_comprobante_solicitud_idx` (`solicitud_comprobante`),
  CONSTRAINT `fk_comprobante_solicitud` FOREIGN KEY (`solicitud_comprobante`) REFERENCES `comprobante` (`comprobante_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dependencia_solicitud` FOREIGN KEY (`solicitud_dependencia`) REFERENCES `dependencia` (`dependencia_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_registrado_solicitud` FOREIGN KEY (`solicitud_registrador_de_bienes`) REFERENCES `funcionario` (`funcionario_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `tipo_de_adquisicion`
--

DROP TABLE IF EXISTS `tipo_de_adquisicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_de_adquisicion` (
  `tipo_de_adquisicion_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_de_adquisicion_nombre` varchar(50) NOT NULL,
  `tipo_de_adquisicion_despcripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`tipo_de_adquisicion_id`),
  UNIQUE KEY `tipoDeAdquisicion_id_UNIQUE` (`tipo_de_adquisicion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_de_adquisicion`
--

LOCK TABLES `tipo_de_adquisicion` WRITE;
/*!40000 ALTER TABLE `tipo_de_adquisicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_de_adquisicion` ENABLE KEYS */;
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
  `usuario_funcionario` int(11) NOT NULL,
  PRIMARY KEY (`usuario_id`),
  UNIQUE KEY `usuario_id_UNIQUE` (`usuario_id`),
  KEY `fk_funcionario_usuario_idx` (`usuario_funcionario`),
  CONSTRAINT `fk_funcionario_usuario` FOREIGN KEY (`usuario_funcionario`) REFERENCES `funcionario` (`funcionario_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

-- Dump completed on 2018-10-23 19:19:05
