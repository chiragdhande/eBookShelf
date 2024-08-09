CREATE DATABASE  IF NOT EXISTS `ebook3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ebook3`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bookworm
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author_master`
--

DROP TABLE IF EXISTS `author_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author_master` (
  `authorid` bigint NOT NULL AUTO_INCREMENT,
  `authorcharges` double NOT NULL,
  `authorname` varchar(255) DEFAULT NULL,
  `pdfurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`authorid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author_master`
--

LOCK TABLES `author_master` WRITE;
/*!40000 ALTER TABLE `author_master` DISABLE KEYS */;
INSERT INTO `author_master` VALUES (1,0.2,'Tom Bell','/Author/Ruskin-Bond.jpg'),(2,0.25,'Nirav Bhargav','/Author/09-10-2022-20-14-18.webp');
/*!40000 ALTER TABLE `author_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `backup_user_buyed_shelf`
--

DROP TABLE IF EXISTS `backup_user_buyed_shelf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `backup_user_buyed_shelf` (
  `backup_users_buyshelfid` bigint NOT NULL AUTO_INCREMENT,
  `myshelf_shelf_id` bigint DEFAULT NULL,
  `product_master_product_id` bigint DEFAULT NULL,
  `buydate` date DEFAULT NULL,
  PRIMARY KEY (`backup_users_buyshelfid`),
  KEY `FKqbh62vlnx7g4ia1inuqv0shil` (`myshelf_shelf_id`),
  KEY `FKe317nfa78fjhckiq9tlscvmfe` (`product_master_product_id`),
  CONSTRAINT `FKe317nfa78fjhckiq9tlscvmfe` FOREIGN KEY (`product_master_product_id`) REFERENCES `product_master` (`product_id`),
  CONSTRAINT `FKqbh62vlnx7g4ia1inuqv0shil` FOREIGN KEY (`myshelf_shelf_id`) REFERENCES `myshelf` (`shelf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backup_user_buyed_shelf`
--

LOCK TABLES `backup_user_buyed_shelf` WRITE;
/*!40000 ALTER TABLE `backup_user_buyed_shelf` DISABLE KEYS */;
INSERT INTO `backup_user_buyed_shelf` VALUES (1,1,1,'2024-01-12'),(2,23,1,'2024-01-13'),(3,3,1,'2024-01-13'),(4,1,4,'2024-01-13'),(5,26,1,'2024-01-13');
/*!40000 ALTER TABLE `backup_user_buyed_shelf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `backup_user_rent_shelf`
--

DROP TABLE IF EXISTS `backup_user_rent_shelf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `backup_user_rent_shelf` (
  `backupuser_rent_shelfid` bigint NOT NULL AUTO_INCREMENT,
  `exp_date` date DEFAULT NULL,
  `days` bigint NOT NULL,
  `rentamount` bigint NOT NULL,
  `start_date` date DEFAULT NULL,
  `product_master_product_id` bigint DEFAULT NULL,
  `rent_shelf_rent_shelf` bigint DEFAULT NULL,
  PRIMARY KEY (`backupuser_rent_shelfid`),
  KEY `FKp4i47emeiyte9u1n2wpsgc4xo` (`product_master_product_id`),
  KEY `FKtnldovleqkwsxxjevv13seamu` (`rent_shelf_rent_shelf`),
  CONSTRAINT `FKp4i47emeiyte9u1n2wpsgc4xo` FOREIGN KEY (`product_master_product_id`) REFERENCES `product_master` (`product_id`),
  CONSTRAINT `FKtnldovleqkwsxxjevv13seamu` FOREIGN KEY (`rent_shelf_rent_shelf`) REFERENCES `rent_shelf` (`rent_shelf`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backup_user_rent_shelf`
--

LOCK TABLES `backup_user_rent_shelf` WRITE;
/*!40000 ALTER TABLE `backup_user_rent_shelf` DISABLE KEYS */;
INSERT INTO `backup_user_rent_shelf` VALUES (1,'2024-01-27',15,112,'2024-01-12',4,1),(2,'2024-01-20',7,56,'2024-01-13',4,23),(3,'2024-01-31',18,133,'2024-01-13',4,3),(4,'2024-01-30',17,126,'2024-01-13',4,26);
/*!40000 ALTER TABLE `backup_user_rent_shelf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_id` bigint NOT NULL AUTO_INCREMENT,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  UNIQUE KEY `UK_867x3yysb1f3jk41cv3vsoejj` (`customer_id`),
  CONSTRAINT `FKdebwvad6pp1ekiqy5jtixqbaj` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,4),(2,5),(3,6),(4,7),(5,8),(6,9),(7,10),(8,11),(9,12),(10,13),(11,14),(12,15),(13,16),(14,17),(15,18),(16,19),(17,20),(18,21),(19,22),(20,23),(21,24),(22,25),(23,26),(24,27),(25,28),(26,29),(27,30),(28,31);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `contact_no` bigint NOT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pincode` bigint NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `primium` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (2,0,'mayur@example.com','Mayur','$2a$10$HusJAt.sOcWmwt6nYvDP4upQ8sia129HyfiubCl3PmN7zCsXnYRzq',NULL,NULL,NULL,0,NULL,NULL,NULL),(3,1234567890,'john.doe@example.com','John Doe','$2a$10$j0PPhwz8igyD7tYvmbWwyesegz6wfzlB2CZeM5FwuoMIvkK3vZlne',NULL,NULL,NULL,0,NULL,NULL,NULL),(4,0,'rajesh@gmail.com','Rajesh Dalwe','$2a$10$9xqcbpyPWJLehzUqeeKWk.ZdXHkBOwfGJj1D9kE8lu3EDjSSu.ttW',NULL,NULL,NULL,0,NULL,NULL,NULL),(5,0,'Mayur@123','Mayur Patil','$2a$10$4tz4.Yuo5dN704Wx8D1R1emJEea2Tk0CQ0I8S6FxdBlqXcTsf1/BK',NULL,NULL,NULL,0,'M','user','yes'),(6,9730491553,NULL,'Kamesh Patil','$2a$10$AvXnN3Lh5fKfAU1SoHx2o.PzL4xciCXCNGeNf2xCkEIkGP3pBfxPi','At post Nashik','Mumbai',NULL,400049,'Male',NULL,NULL),(7,9730491551,'Rajesh@123','Rajesh','$2a$10$oCu6tkJjSehhi0ixd/y2DeLZK112s90WJ6e/wyOyB7jY.kOCyiP4O','Sainath Nagar, MHADA Colony, Vile Parle West, Mumbai, Maharashtra','Mumbai',NULL,400049,'Male',NULL,NULL),(8,9730491554,'Admin@123','Mayur Vasudeo Patil','$2a$10$l6cPgphTogkEqwYHhssOoOni984u7lmna58kuif26f8ZgrY6pcMiq','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon',NULL,425309,'Male',NULL,NULL),(9,9730491554,'Admin@1234','Mayur Vasudeo Patil','$2a$10$jEloLACUXx7cTfqFds4YV.AgmM.ZWVRqABg11ulZ9JYhpw5sGCqPW','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon',NULL,425309,'Male','admin',NULL),(10,9730491554,'Admin@12345','Mayur Vasudeo Patil','$2a$10$wibYhFs80AzQRKgbxIo3T.d7ZYyZ/0EBekGPlYUTp/Vd2KEf0e78O','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon',NULL,425309,'Male','admin',NULL),(11,9730491551,'Kamesh1234','Kamesh Patil','$2a$10$h3etTWg9KfLKv315/AgloOI/3/nS9uoT34rj8Azho7KdD4SCCAJgC','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','kamesh@gmail,.com',425309,'Male','user',NULL),(12,9730491551,'Kamesh1234','Kamesh Patil','$2a$10$HmmyWawDBLJjYaWaL5.SHONKKPpp9NWgkHa29oJQLnT8d/QYwzB/q','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','kamesh@gmail,.com',425309,'Male','user',NULL),(13,9730491551,'Kamesh1234','Kamesh Patil','$2a$10$4b.XeajwsPi5WRSr5bpdf.hyAhXAtpS09hPZ9gmjqH87PcfAaAxmS','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','kamesh@gmail.com',425309,'Male','user',NULL),(14,9730491551,'Kamesh1234','Kamesh Patil','$2a$10$tlkUuS.wQi6K7civMjMD7e9dFtFdilZqyC70Cf8diMnyaJgWxiqmO','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','kamesh@gmail.com',425309,'Male','user',NULL),(15,9730491551,'Kamesh1234','Kamesh Patil','$2a$10$AYizMXURE0/jFSReenL6SuJTb3lCoXPbPeYZOl/BjNYn2Ze9fMF/G','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','kamesh@gmail.com',425309,'Male','user',NULL),(16,9730491554,'piyush123','Piyush patil','$2a$10$q2X2Ovaq3a.SDti06F9X8.559cDB6l1pOzlReyn3Y8dVkksT8nR1O','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','patil@gmail.com',425309,'Male','user',NULL),(17,9730491554,'piyush123','Piyush patil','$2a$10$su/ekyuhRlcR2p3BfhlM8OdUwCi42ZSSr2drS8nIjRlR0WVRuhi7e','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','patil@gmail.com',425309,'Male','user',NULL),(18,9730491553,'mayur123','Mayur Patil','$2a$10$O0.58m0p8v6KT.n/msr2OuDVJX8EVb0zxFQjh837IugGCZGpvq2C.','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','mayurvasudeopatil@gmail.com',425309,'Male','user',NULL),(19,9730491553,'mayur123','Mayur Patil','$2a$10$1LzlTAHPfgx9ZoCQW7vbdu69rCSQpCHRhmXmoCAw9AZuZLq6ND96u','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','mayurvasudeopatil@gmail.com',425309,'Male','user',NULL),(20,9730491553,'mayur123','Mayur Patil','$2a$10$iwruEKAHxFVHReqDyFx.COfuHssZfpfLDobUHVxd5FYFa5kbw6CWS','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','mayurvasudeopatil@gmail.com',425309,'Male','user',NULL),(21,9730491552,' sjd','Mayur Vasudeo Patil','$2a$10$QO4r0ec9D34T/rd6ZYu.0.wRftrEOCuS2W7h5iUn6EMsMlK7NTGza','atpostsunsgaon','44049515-927C-4E21-99A3-CC8A4357BAD0','mayurvasudeopatil@gmail.com',425309,'Male','user',NULL),(22,9730491554,'mayurvasude','Mayur Patil','$2a$10$q88VBD2KmH8CdOMlddEXnOnhZO/lphZ2eKZF4yRktrScU3sRVLeTq','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','mayurvasudeopatil@gmail.com',425309,'Male','user',NULL),(23,9730491553,'wd','nndcsjc','$2a$10$RIIReFsEM7fXOpl49B99dOEpDoz/tBHuukN.CiZjXAiyuChgJAhua','Sainath Nagar, MHADA Colony, Vile Parle West, Mumbai, Maharashtra','Mumbai',' csdmsc',400049,'Male','user','Yes'),(24,9730491554,'Patil@12345','Mayur Patil','$2a$10$XF/ZSDbFmLMBHZDEWf7P4Oa/LaSU2YvViTkxibrbQxvfAvAVWaKDi','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','mayurvasudeopatil@gmail.com',425309,'Male','user','Yes'),(25,9730491555,'shri@123','Shrinavs','$2a$10$rRrs7d4nvUKTVrX7R40VTegAuLOya4l9F963IjXfiYPk6WfaKNieq','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','shri@gmail.com',425309,'Male','user','No'),(26,9730491554,'KAdmin@123','Kamesh patil','$2a$10$42JHy5FJxNis04qFHNT1Me5GmyqvYu3I5aeXxX0ehplUJGV243rPW','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','k@gmail.com',425309,'Male','admin',NULL),(27,9730491553,'Mayur@1234','Mayur Patil','$2a$10$56uSV9tDtpakrQCfnwvQveMSuXjc6L0o.NKgrJiAcL/gLVX8W3Y.G','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','patil@gmail.com',425309,'Male','user',NULL),(28,9730491558,'Rajesh@1234','Rajesh Patil','$2a$10$BsnA0En37QtFJi8C8UTHT..siiikgkBkqLgLv3aVgEmQruiVRkeOe','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','rajesh@gmail.com',425309,'Male','user',NULL),(29,9730491553,'Mayur_Admin@123','Mayur Patil','$2a$10$r.rmrO5FraQ1ul/iZVcJCeecfyPirUqIgorkYdXRiV.MVRgZuNq.6','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','mayurvasudeopatil@gmail.com',425309,'Male','admin',NULL),(30,9730491554,'Mayur@1235','Mayur Patil','$2a$10$RIETVHP4hY9pQPJc73oK1Oo/FadsvX0kF6HFcX8LVZWv1qRf25Vvq','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','mayurvasudeopatil@gmail.com',425309,'Male','user',NULL),(31,9730493563,'PAdmin@123','Piyush Patil','$2a$10$CRESlV1bma05gIk4fgUg3O6FuWRi.XHkjl1bszarRUKL.GrOlv32G','at post sunsgaon dist -jalgaon ,Tal -Bhusawal','Jalgaon','piyush@gmail.com',425309,'Male','admin',NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `hid` bigint NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `product_price` bigint NOT NULL,
  `customer` bigint NOT NULL,
  `date` date DEFAULT NULL,
  `image_ppath` varchar(255) DEFAULT NULL,
  `productisbn` bigint NOT NULL,
  `time` time(6) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'The Silent Observer',250,5,'2024-01-12','https://m.media-amazon.com/images/I/51hrAyhfXUL._SY466_.jpg',9781542309876,'18:34:30.038000','Buy'),(2,'The Vikings',112,5,'2024-01-12','/product_img/project_img.jpg',9781987654321,'18:34:50.469000','Rent'),(3,'The Silent Observer',250,27,'2024-01-13','https://m.media-amazon.com/images/I/51hrAyhfXUL._SY466_.jpg',9781542309876,'11:20:35.534000','Buy'),(4,'The Vikings',56,27,'2024-01-13','/product_img/project_img.jpg',9781987654321,'11:21:25.201000','Rent'),(5,'The Silent Observer',250,7,'2024-01-13','https://m.media-amazon.com/images/I/51hrAyhfXUL._SY466_.jpg',9781542309876,'11:31:04.956000','Buy'),(6,'The Vikings',133,7,'2024-01-13','/product_img/project_img.jpg',9781987654321,'11:31:39.886000','Rent'),(7,'The Vikings',30,5,'2024-01-13','/product_img/project_img.jpg',9781987654321,'12:21:16.653000','Buy'),(8,'The Silent Observer',250,30,'2024-01-13','https://m.media-amazon.com/images/I/51hrAyhfXUL._SY466_.jpg',9781542309876,'12:25:57.919000','Buy'),(9,'The Vikings',126,30,'2024-01-13','/product_img/project_img.jpg',9781987654321,'12:26:35.279000','Rent');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language_master`
--

DROP TABLE IF EXISTS `language_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `language_master` (
  `language_id` bigint NOT NULL AUTO_INCREMENT,
  `language_desc` varchar(255) DEFAULT NULL,
  `type_id` bigint DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`language_id`),
  KEY `FKjsk2oy39x5e0lm5mhhongfvoa` (`type_id`),
  CONSTRAINT `FKjsk2oy39x5e0lm5mhhongfvoa` FOREIGN KEY (`type_id`) REFERENCES `product_type_master` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language_master`
--

LOCK TABLES `language_master` WRITE;
/*!40000 ALTER TABLE `language_master` DISABLE KEYS */;
INSERT INTO `language_master` VALUES (2,'Marathi',1,'/Languages/Marathi.jpg'),(3,'English',1,'/Languages/English.jpg'),(4,'Hindi',1,'/Languages/hindi.jpg'),(5,'Telgue',1,'/Languages/Telgue.jpg'),(6,'Marathi',3,'/Languages/Marathi.jpg'),(7,'English',3,'/Languages/English.jpg');
/*!40000 ALTER TABLE `language_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myshelf`
--

DROP TABLE IF EXISTS `myshelf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `myshelf` (
  `shelf_id` bigint NOT NULL AUTO_INCREMENT,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`shelf_id`),
  UNIQUE KEY `UK_3x5ckqpxrsc0jb9g1ajay71aj` (`customer_id`),
  CONSTRAINT `FKesdpapp1trds5bwhibycn0n6w` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myshelf`
--

LOCK TABLES `myshelf` WRITE;
/*!40000 ALTER TABLE `myshelf` DISABLE KEYS */;
INSERT INTO `myshelf` VALUES (1,5),(2,6),(3,7),(4,8),(5,9),(6,10),(7,11),(8,12),(9,13),(10,14),(11,15),(12,16),(13,17),(14,18),(15,19),(16,20),(17,21),(18,22),(19,23),(20,24),(21,25),(22,26),(23,27),(24,28),(25,29),(26,30),(27,31);
/*!40000 ALTER TABLE `myshelf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_master`
--

DROP TABLE IF EXISTS `product_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_master` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `image_ppath` varchar(255) DEFAULT NULL,
  `product_author` varchar(255) DEFAULT NULL,
  `product_base_price` bigint NOT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_english_name` varchar(255) DEFAULT NULL,
  `product_expiry_date` datetime(6) DEFAULT NULL,
  `productisbn` bigint NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `language_id` bigint DEFAULT NULL,
  `type_id` bigint DEFAULT NULL,
  `pdfurl` varchar(255) DEFAULT NULL,
  `author_master_authorid` bigint DEFAULT NULL,
  `publisher_master_publisherid` bigint DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK98ccg011o5dskuffl8qf7o7kk` (`language_id`),
  KEY `FKkqx9yklv6gwn0rx53udabv5bd` (`type_id`),
  KEY `FKot4vt57tvuxqyuqmolm65gg73` (`author_master_authorid`),
  KEY `FKdd0dks8mfle752pbriw8ltpq8` (`publisher_master_publisherid`),
  CONSTRAINT `FK98ccg011o5dskuffl8qf7o7kk` FOREIGN KEY (`language_id`) REFERENCES `language_master` (`language_id`),
  CONSTRAINT `FKdd0dks8mfle752pbriw8ltpq8` FOREIGN KEY (`publisher_master_publisherid`) REFERENCES `publisher_master` (`publisherid`),
  CONSTRAINT `FKkqx9yklv6gwn0rx53udabv5bd` FOREIGN KEY (`type_id`) REFERENCES `product_type_master` (`type_id`),
  CONSTRAINT `FKot4vt57tvuxqyuqmolm65gg73` FOREIGN KEY (`author_master_authorid`) REFERENCES `author_master` (`authorid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_master`
--

LOCK TABLES `product_master` WRITE;
/*!40000 ALTER TABLE `product_master` DISABLE KEYS */;
INSERT INTO `product_master` VALUES (1,'https://m.media-amazon.com/images/I/51hrAyhfXUL._SY466_.jpg','Alice Smith',250,'A thrilling mystery novel.','The Silent Observer','2023-11-15 05:30:00.000000',9781542309876,'The Silent Observer',2,1,'/Ebook/Stuck-with-a-Billionaire.pdf',2,2),(2,'/product_img/images (1).jpg','John Doe',30,'An epic fantasy adventure.','The Lost Kingdom','2023-10-31 05:30:00.000000',9781987654321,'The Lost Kingdom',3,1,'/Ebook/Stuck-with-a-Billionaire.pdf',2,2),(4,'/product_img/project_img.jpg','John Doe',30,'An epic fantasy adventure.','The Lost Kingdom','2023-10-31 05:30:00.000000',9781987654321,'The Vikings',2,1,'/Ebook/space_viking.pdf',1,1),(5,'https://m.media-amazon.com/images/S/pv-target-images/5a585a2b446d3e634b4a7511ea1cf2e96cbee7b11b72e65309b124ed274c14fc._AC_SX480_FMwebp_.jpg','Emily Rogers',20,'A gripping espionage thriller.','Code Breaker','2023-12-20 05:30:00.000000',9781234567890,'Code Breaker',2,1,'/Ebook/Stuck-with-a-Billionaire.pdf',1,1),(6,'dnjknkdn',NULL,300,'Money - investing, personal finance, and business decisions - is typically taught as a math-based field, where data and formulas tell us exactly what to do. But in the real world people don?t make financial decisions on a spreadsheet',NULL,NULL,12344488,'The Psychology of Money',5,3,'jnnjknk',1,2),(7,'https://m.media-amazon.com/images/I/51jRBz6Ug3L._SL500_.jpg',NULL,300,'For David Goggins, childhood was a nightmare--poverty, prejudice, and physical abuse colored his days and haunted his nights. But through self-discipline, mental toughness, and hard work, Goggins transformed himself from a depressed',NULL,NULL,12344488,'Can\'t Hurt Me',6,3,'https://m.media-amazon.com/images/I/51jRBz6Ug3L._SL500_.jpg',2,2),(8,'/product_img/51c4H3VBciL._SL500_.jpg',NULL,300,'For David Goggins, childhood was a nightmare--poverty, prejudice, and physical abuse colored his days and haunted his nights. But through self-discipline, mental toughness, and hard work, Goggins transformed himself from a depressed',NULL,NULL,12344488,'Can\'t Hurt Me',7,3,'/product_img/51c4H3VBciL._SL500_.jpg',2,2);
/*!40000 ALTER TABLE `product_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type_master`
--

DROP TABLE IF EXISTS `product_type_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_type_master` (
  `type_id` bigint NOT NULL AUTO_INCREMENT,
  `type_desc` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type_master`
--

LOCK TABLES `product_type_master` WRITE;
/*!40000 ALTER TABLE `product_type_master` DISABLE KEYS */;
INSERT INTO `product_type_master` VALUES (1,'Engilsh','/Types/ebook.webp'),(2,'Ebook','/Types/audiobook.jpg'),(3,'AudioBook','/Types/book-video.jpg');
/*!40000 ALTER TABLE `product_type_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher_master`
--

DROP TABLE IF EXISTS `publisher_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher_master` (
  `publisherid` bigint NOT NULL AUTO_INCREMENT,
  `publisher_name` varchar(255) DEFAULT NULL,
  `publishercharges` double NOT NULL,
  `pdfurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`publisherid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher_master`
--

LOCK TABLES `publisher_master` WRITE;
/*!40000 ALTER TABLE `publisher_master` DISABLE KEYS */;
INSERT INTO `publisher_master` VALUES (1,'Tata Sons',0.15,'/Publisher/download.jpg'),(2,'Nirali',0.2,'/Publisher/images.jpg');
/*!40000 ALTER TABLE `publisher_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purches_cart`
--

DROP TABLE IF EXISTS `purches_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purches_cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cart_cart_id` bigint DEFAULT NULL,
  `product_master_product_id` bigint DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKagxm23vbbr7aaed8e1ahjvepm` (`cart_cart_id`),
  KEY `FK8e264i1a2g4yeigq3pgkt2ex9` (`product_master_product_id`),
  CONSTRAINT `FK8e264i1a2g4yeigq3pgkt2ex9` FOREIGN KEY (`product_master_product_id`) REFERENCES `product_master` (`product_id`),
  CONSTRAINT `FKagxm23vbbr7aaed8e1ahjvepm` FOREIGN KEY (`cart_cart_id`) REFERENCES `cart` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purches_cart`
--

LOCK TABLES `purches_cart` WRITE;
/*!40000 ALTER TABLE `purches_cart` DISABLE KEYS */;
INSERT INTO `purches_cart` VALUES (3,1,2,NULL),(116,23,1,'Buy'),(117,23,1,'Buy'),(118,23,1,'Rent'),(119,23,1,'Buy');
/*!40000 ALTER TABLE `purches_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_shelf`
--

DROP TABLE IF EXISTS `rent_shelf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_shelf` (
  `rent_shelf` bigint NOT NULL AUTO_INCREMENT,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`rent_shelf`),
  UNIQUE KEY `UK_glpuoj8jnuexvxc2ycd6f16vj` (`customer_id`),
  CONSTRAINT `FK1xfpixhdytxko7anlah1hp6kc` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_shelf`
--

LOCK TABLES `rent_shelf` WRITE;
/*!40000 ALTER TABLE `rent_shelf` DISABLE KEYS */;
INSERT INTO `rent_shelf` VALUES (1,5),(2,6),(3,7),(4,8),(5,9),(6,10),(7,11),(8,12),(9,13),(10,14),(11,15),(12,16),(13,17),(14,18),(15,19),(16,20),(17,21),(18,22),(19,23),(20,24),(21,25),(22,26),(23,27),(24,28),(25,29),(26,30),(27,31);
/*!40000 ALTER TABLE `rent_shelf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `royalty_master`
--

DROP TABLE IF EXISTS `royalty_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `royalty_master` (
  `royaltyid` bigint NOT NULL AUTO_INCREMENT,
  `author_amount` double NOT NULL,
  `publisher_amount` double NOT NULL,
  `author_master_authorid` bigint DEFAULT NULL,
  `publisher_master_publisherid` bigint DEFAULT NULL,
  `customer_customer_id` bigint DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `product_master_product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`royaltyid`),
  KEY `FKmw74fn0ngj7vstpws69okt51s` (`author_master_authorid`),
  KEY `FK8822wxiemee53hsh37pb2q26i` (`publisher_master_publisherid`),
  KEY `FK6x3373e12vsadrfnsgbwo36mp` (`customer_customer_id`),
  KEY `FKs2j3cxxv9c4du6wiw4jurqfgu` (`product_master_product_id`),
  CONSTRAINT `FK6x3373e12vsadrfnsgbwo36mp` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FK8822wxiemee53hsh37pb2q26i` FOREIGN KEY (`publisher_master_publisherid`) REFERENCES `publisher_master` (`publisherid`),
  CONSTRAINT `FKmw74fn0ngj7vstpws69okt51s` FOREIGN KEY (`author_master_authorid`) REFERENCES `author_master` (`authorid`),
  CONSTRAINT `FKs2j3cxxv9c4du6wiw4jurqfgu` FOREIGN KEY (`product_master_product_id`) REFERENCES `product_master` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `royalty_master`
--

LOCK TABLES `royalty_master` WRITE;
/*!40000 ALTER TABLE `royalty_master` DISABLE KEYS */;
INSERT INTO `royalty_master` VALUES (1,62.5,50,2,2,5,'Buy',1),(2,22.400000000000002,16.8,1,1,5,'Rent',4),(3,62.5,50,2,2,27,'Buy',1),(4,11.200000000000001,8.4,1,1,27,'Rent',4),(5,62.5,50,2,2,7,'Buy',1),(6,26.6,19.95,1,1,7,'Rent',4),(7,6,4.5,1,1,5,'Buy',4),(8,62.5,50,2,2,30,'Buy',1),(9,25.200000000000003,18.9,1,1,30,'Rent',4);
/*!40000 ALTER TABLE `royalty_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_rent_shelf`
--

DROP TABLE IF EXISTS `user_rent_shelf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_rent_shelf` (
  `user_rent_shelfid` bigint NOT NULL AUTO_INCREMENT,
  `product_master_product_id` bigint DEFAULT NULL,
  `rent_shelf_rent_shelf` bigint DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  `days` bigint NOT NULL,
  `rentamount` bigint NOT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`user_rent_shelfid`),
  KEY `FK1h9q9onvitnf6wn6xs1mw829s` (`product_master_product_id`),
  KEY `FKrm6n9arb9hwmve8kal29oo5mo` (`rent_shelf_rent_shelf`),
  CONSTRAINT `FK1h9q9onvitnf6wn6xs1mw829s` FOREIGN KEY (`product_master_product_id`) REFERENCES `product_master` (`product_id`),
  CONSTRAINT `FKrm6n9arb9hwmve8kal29oo5mo` FOREIGN KEY (`rent_shelf_rent_shelf`) REFERENCES `rent_shelf` (`rent_shelf`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rent_shelf`
--

LOCK TABLES `user_rent_shelf` WRITE;
/*!40000 ALTER TABLE `user_rent_shelf` DISABLE KEYS */;
INSERT INTO `user_rent_shelf` VALUES (1,4,1,'2024-01-27',15,112,'2024-01-12'),(2,4,23,'2024-01-20',7,56,'2024-01-13'),(3,4,3,'2024-01-31',18,133,'2024-01-13'),(4,4,26,'2024-01-30',17,126,'2024-01-13');
/*!40000 ALTER TABLE `user_rent_shelf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_myshelf`
--

DROP TABLE IF EXISTS `users_myshelf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_myshelf` (
  `users_myshelfid` bigint NOT NULL AUTO_INCREMENT,
  `myshelf_shelf_id` bigint DEFAULT NULL,
  `product_master_product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`users_myshelfid`),
  KEY `FKggbdaufvliv0bunhjho06q1am` (`myshelf_shelf_id`),
  KEY `FKlck28coxikq35btip128nyo9l` (`product_master_product_id`),
  CONSTRAINT `FKggbdaufvliv0bunhjho06q1am` FOREIGN KEY (`myshelf_shelf_id`) REFERENCES `myshelf` (`shelf_id`),
  CONSTRAINT `FKlck28coxikq35btip128nyo9l` FOREIGN KEY (`product_master_product_id`) REFERENCES `product_master` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_myshelf`
--

LOCK TABLES `users_myshelf` WRITE;
/*!40000 ALTER TABLE `users_myshelf` DISABLE KEYS */;
INSERT INTO `users_myshelf` VALUES (1,1,1),(2,23,1),(3,3,1),(4,1,4),(5,26,1);
/*!40000 ALTER TABLE `users_myshelf` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-07 11:30:21
