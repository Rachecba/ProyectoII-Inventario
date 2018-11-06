-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: progra3_proy2
-- ------------------------------------------------------
-- Server version	5.7.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
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
  CONSTRAINT `fk_bien_activo` FOREIGN KEY (`activo_universitario_bien`) REFERENCES `bien` (`bien_id`),
  CONSTRAINT `fk_categoria_activo` FOREIGN KEY (`activo_universitario_categoria`) REFERENCES `categoria` (`categoria_id`),
  CONSTRAINT `fk_labor_activo` FOREIGN KEY (`activo_universitario_responsable`) REFERENCES `labor` (`labor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activo_universitario`
--

LOCK TABLES `activo_universitario` WRITE;
/*!40000 ALTER TABLE `activo_universitario` DISABLE KEYS */;
INSERT INTO `activo_universitario` VALUES (2,20,98,NULL,'123','Desc',1);
/*!40000 ALTER TABLE `activo_universitario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bien`
--

DROP TABLE IF EXISTS `bien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bien` (
  `bien_id` int(11) NOT NULL AUTO_INCREMENT,
  `bien_descripcion` varchar(100) DEFAULT NULL,
  `bien_marca` varchar(50) DEFAULT NULL,
  `bien_modelo` varchar(50) DEFAULT NULL,
  `bien_precio` double NOT NULL,
  `bien_solicitud` int(11) DEFAULT NULL,
  `bien_cantidad` int(11) NOT NULL,
  `bien_categoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`bien_id`),
  UNIQUE KEY `bien_id_UNIQUE` (`bien_id`),
  KEY `fk_solicitud_bien_idx` (`bien_solicitud`),
  KEY `fk_categoria_bien_idx` (`bien_categoria`),
  CONSTRAINT `fk_categoria_bien` FOREIGN KEY (`bien_categoria`) REFERENCES `categoria` (`categoria_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_bien` FOREIGN KEY (`bien_solicitud`) REFERENCES `comprobante` (`comprobante_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bien`
--

LOCK TABLES `bien` WRITE;
/*!40000 ALTER TABLE `bien` DISABLE KEYS */;
INSERT INTO `bien` VALUES (20,'1','1','1',10,7,3,NULL),(21,'2','2','2',20,7,3,NULL),(22,'122','22','2',20,8,3,NULL),(23,'55','3','3',30,8,3,NULL),(24,'4','4','4',40,2,3,NULL),(25,'411','4','4',40,2,3,NULL),(26,'2643','2','2',20,2,3,NULL);
/*!40000 ALTER TABLE `bien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoria` (
  `categoria_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_nombre` varchar(50) NOT NULL,
  `categoria_descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`categoria_id`),
  UNIQUE KEY `categoria_id_UNIQUE` (`categoria_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (2,'silla','sillas de escritorio'),(98,'compus','compus');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobante`
--

DROP TABLE IF EXISTS `comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comprobante` (
  `comprobante_id` int(11) NOT NULL AUTO_INCREMENT,
  `comprobante_fecha_de_adquisicion` datetime NOT NULL,
  `comprobante_tipo_de_adquisicion` int(11) NOT NULL,
  `comprobante_cant_bienes` int(11) NOT NULL,
  `comprobante_monto_total` double NOT NULL,
  `comprobante_numero` varchar(100) NOT NULL,
  PRIMARY KEY (`comprobante_id`),
  UNIQUE KEY `comprobante_id_UNIQUE` (`comprobante_id`),
  KEY `fk_adquisicion_comprobante_idx` (`comprobante_tipo_de_adquisicion`),
  CONSTRAINT `fk_adquisicion_comprobante` FOREIGN KEY (`comprobante_tipo_de_adquisicion`) REFERENCES `tipo_de_adquisicion` (`tipo_de_adquisicion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobante`
--

LOCK TABLES `comprobante` WRITE;
/*!40000 ALTER TABLE `comprobante` DISABLE KEYS */;
INSERT INTO `comprobante` VALUES (1,'2017-07-10 20:38:17',1,10,24000,''),(2,'2018-11-08 22:26:23',1,3,20,'1'),(3,'2018-11-15 17:19:02',1,0,0,'22'),(4,'2018-11-13 00:00:00',1,0,0,'bien'),(5,'2018-11-14 18:41:42',1,6,65,'123'),(6,'2018-11-07 00:00:00',1,6,50,'5'),(7,'2018-11-13 22:23:12',1,6,30,'2'),(8,'2018-11-22 22:24:57',1,6,50,'3');
/*!40000 ALTER TABLE `comprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependencia`
--

DROP TABLE IF EXISTS `dependencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dependencia` (
  `dependencia_id` int(11) NOT NULL AUTO_INCREMENT,
  `dependencia_nombre` varchar(50) NOT NULL,
  `dependencia_administrador` int(11) DEFAULT NULL,
  PRIMARY KEY (`dependencia_id`),
  UNIQUE KEY `dependencia_id_UNIQUE` (`dependencia_id`),
  KEY `fk_funcionario_dependencia_idx` (`dependencia_administrador`),
  CONSTRAINT `fk_funcionario_dependencia` FOREIGN KEY (`dependencia_administrador`) REFERENCES `funcionario` (`funcionario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependencia`
--

LOCK TABLES `dependencia` WRITE;
/*!40000 ALTER TABLE `dependencia` DISABLE KEYS */;
INSERT INTO `dependencia` VALUES (2,'Escuela Ciencias Salud',4),(3,'Escuela Veterinaria',3),(5,'Escuela Informatica',8),(6,'Escuela Letras',13);
/*!40000 ALTER TABLE `dependencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funcionario` (
  `funcionario_id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario_nombre` varchar(50) NOT NULL,
  `funcionario_recibe_solicitud` tinyint(1) DEFAULT NULL,
  `funcionario_cedula` varchar(45) NOT NULL,
  PRIMARY KEY (`funcionario_id`),
  UNIQUE KEY `funcionario_id_UNIQUE` (`funcionario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Rachel',0,''),(3,'Jose',0,''),(4,'Maria',1,''),(5,'Manuel',1,'11'),(8,'Sara',0,'222'),(13,'JuanaLaCubana',1,'555'),(14,'Paola',1,'555555'),(15,'Lea',1,'116870078');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `labor`
--

DROP TABLE IF EXISTS `labor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
  CONSTRAINT `fk_dependencia_labor` FOREIGN KEY (`labor_dependencia`) REFERENCES `dependencia` (`dependencia_id`),
  CONSTRAINT `fk_funcionario_labor` FOREIGN KEY (`labor_funcionario`) REFERENCES `funcionario` (`funcionario_id`),
  CONSTRAINT `fk_puesto_labor` FOREIGN KEY (`labor_puesto`) REFERENCES `puesto` (`puesto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labor`
--

LOCK TABLES `labor` WRITE;
/*!40000 ALTER TABLE `labor` DISABLE KEYS */;
INSERT INTO `labor` VALUES (1,60,5,3),(2,60,5,14),(3,70,5,13),(4,55,5,4);
/*!40000 ALTER TABLE `labor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `puesto` (
  `puesto_id` int(11) NOT NULL AUTO_INCREMENT,
  `puesto_nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`puesto_id`),
  UNIQUE KEY `puesto_id_UNIQUE` (`puesto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES (6,'1'),(7,'Comedor'),(8,'caca'),(9,'4'),(10,'6'),(11,'67'),(55,'director'),(60,'secretaria'),(70,'profesora');
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
  CONSTRAINT `fk_comprobante_solicitud` FOREIGN KEY (`solicitud_comprobante`) REFERENCES `comprobante` (`comprobante_id`),
  CONSTRAINT `fk_dependencia_solicitud` FOREIGN KEY (`solicitud_dependencia`) REFERENCES `dependencia` (`dependencia_id`),
  CONSTRAINT `fk_registrado_solicitud` FOREIGN KEY (`solicitud_registrador_de_bienes`) REFERENCES `funcionario` (`funcionario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud`
--

LOCK TABLES `solicitud` WRITE;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` VALUES (1,3,'Recibida',NULL,2,NULL),(2,4,'Recibida',NULL,2,NULL),(4,2,'Recibida',NULL,2,NULL),(5,6,'Recibida',NULL,2,NULL),(6,7,'Recibida',NULL,2,NULL),(7,8,'Recibida',NULL,2,NULL);
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_de_adquisicion`
--

DROP TABLE IF EXISTS `tipo_de_adquisicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_de_adquisicion` (
  `tipo_de_adquisicion_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_de_adquisicion_nombre` varchar(50) NOT NULL,
  `tipo_de_adquisicion_despcripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`tipo_de_adquisicion_id`),
  UNIQUE KEY `tipoDeAdquisicion_id_UNIQUE` (`tipo_de_adquisicion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_de_adquisicion`
--

LOCK TABLES `tipo_de_adquisicion` WRITE;
/*!40000 ALTER TABLE `tipo_de_adquisicion` DISABLE KEYS */;
INSERT INTO `tipo_de_adquisicion` VALUES (1,'Tipo','Tipo');
/*!40000 ALTER TABLE `tipo_de_adquisicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_username` varchar(50) NOT NULL,
  `usuario_password` varchar(50) NOT NULL,
  `usuario_rol` varchar(50) NOT NULL,
  `usuario_funcionario` int(11) NOT NULL,
  PRIMARY KEY (`usuario_id`),
  UNIQUE KEY `usuario_id_UNIQUE` (`usuario_id`),
  KEY `fk_funcionario_usuario_idx` (`usuario_funcionario`),
  CONSTRAINT `fk_funcionario_usuario` FOREIGN KEY (`usuario_funcionario`) REFERENCES `funcionario` (`funcionario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=894 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (888,'rachel','rachel','Jefe RRHH',1),(889,'lea','lea','Jefe RRHH',15),(890,'admin','admin','Administrador',3),(891,'secre','secre','Secretaria OCCB',4),(892,'jefe','jefe','Jefe OCCB',5),(893,'registrador','registrador','Registrador de bienes',8);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'progra3_proy2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-05 23:48:32
