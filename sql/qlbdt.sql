CREATE DATABASE  IF NOT EXISTS `qlbdt` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `qlbdt`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: qlbdt
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bill` (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `employee_id` int(11) NOT NULL,
  `total` decimal(10,4) DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `FK_bill_customer` (`customer_id`),
  KEY `FK_bill_employee` (`employee_id`),
  CONSTRAINT `FK_bill_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FK_bill_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_detail`
--

DROP TABLE IF EXISTS `bill_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bill_detail` (
  `bill_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` smallint(6) DEFAULT '1',
  `sub_total` decimal(10,4) DEFAULT NULL,
  `note` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`bill_detail_id`),
  UNIQUE KEY `bill_id` (`bill_id`,`product_id`),
  KEY `FK_bill_detail_product` (`product_id`),
  CONSTRAINT `FK_bill_detail_bill` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`bill_id`),
  CONSTRAINT `FK_bill_detail_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_detail`
--

LOCK TABLES `bill_detail` WRITE;
/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (3,'Tuan','Ha Noi','090909090'),(4,'Linh','Hà Nội','0989898989');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `male` tinyint(1) NOT NULL DEFAULT '1',
  `identity_card` varchar(15) DEFAULT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(80) NOT NULL,
  `admin` tinyint(1) DEFAULT '0',
  `active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Admin','Ha Noi','0989898989',1,'099898989','admin','$2a$12$yZ5RvgLnIDiOK9/X2CC5zeTSA4f.Jxnzh7bWvgi5CUUPnU07vjCeK',1,1),(2,'Disable Admin','Ha Noi','012121212',1,'012121221','adminold','$2a$12$7oh8QTspcMvrD8zBjWW4NePLXm2Xf.ffFfXqj5CbLIf.elGx9A9Ce',1,0),(3,'EmployeeDemo','Ha Noi','011111111',1,'011111111','empldemo','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(4,'Employee1','Thai Nguyen','111111111',0,'222222222','employee1','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(5,'Employee2','Hai Phong','222222222',1,NULL,'employee2','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,0),(6,'Employee3','Số 1 Trần Đại Nghĩa, Bách Khoa, Hai Bà Trưng, Hà Nội','0123456789',0,'0123456789','employee3','$2a$12$hQfHy7vFcEKWVOXabs0FUu1m6pIXwo0M9kq.3JKhGHa/uspBKkz62',0,1),(7,'Employee4',NULL,NULL,1,NULL,'employee4','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,0),(8,'Employee5',NULL,NULL,0,NULL,'employee5','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(9,'Employee6',NULL,NULL,1,NULL,'employee6','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(10,'Employee7',NULL,NULL,0,NULL,'employee7','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,0),(11,'Employee8',NULL,NULL,1,NULL,'employee8','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(12,'Employee9',NULL,NULL,1,NULL,'employee9','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(13,'Employee10',NULL,NULL,1,NULL,'employee10','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(14,'Employee11',NULL,NULL,1,NULL,'employee11','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,0),(15,'Employee12',NULL,NULL,0,NULL,'employee12','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(16,'Employee13',NULL,NULL,0,NULL,'employee13','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(17,'Employee14',NULL,NULL,0,NULL,'employee14','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(18,'Employee15',NULL,NULL,0,NULL,'employee15','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,0),(19,'Employee16',NULL,NULL,1,NULL,'employee16','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,0),(20,'Employee17',NULL,NULL,1,NULL,'employee17','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(21,'Employee18',NULL,NULL,0,NULL,'employee18','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,1),(22,'Employee19',NULL,NULL,1,NULL,'employee19','$2a$12$tVbpkyY7goorJzMHTKYm5uNuj2nAbczlbUhHZ856d5WecPPOhopE6',0,0),(25,'Nhân viên 2',NULL,'0987654321',0,'0987654321','nhanvien2','$2a$12$TN/i2HsOYQRKXu8ham2s8uUefPX89CJktpzD/7PfGi4wdc8.5PhU.',0,0),(26,'Nhân viên 5','Ngõ 30 Hoàng Quốc Việt','0909090909',1,'0909090909','nhanvien5','$2a$12$LLeKV7rbDHuDbdItsGBGZerssSpoDr5mBLBFm.c8S3VoeOMUZYHK.',0,1),(27,'nhan vien 10','Đường 10 Quận 4 Thành phố HCM','0898989898',0,'0898989898','nhanvien10','$2a$12$mdy9wI/j2ShrqafeIXuJZeH5CX0P8AV5OU9TS1nntBcTK1HsruF1G',0,1),(28,'Nhân viên nữ','Nguyễn Hiền, Bách Khoa','0909090909',0,'0909090909','nhanviennu','$2a$12$4hkA0AmaNpYTsrYo/.e58el3BAsv3qXiK8ggABEw5TtrqBfsfClxC',0,1),(29,'Nhan vien nam','ko nói','09898989898',1,'09898989898','nvnam','$2a$12$CQ.G7lnHJgXrzkRqmh4rd.IW9Uy4mpwNOhzQezkIQ3HT141hFRT1.',0,0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `manufacturer` (
  `manufacturer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `country` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`manufacturer_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (1,'Oppo','Trung Quốc'),(2,'Apple','Mỹ'),(3,'Samsung','Hàn Quốc'),(4,'Vsmart','Việt Nam'),(5,'Xiaomi','Trung Quốc'),(6,'Sony','Nhật Bản'),(7,'Nokia','Trung Quốc'),(8,'BlackBerry','Trung Quốc'),(9,'ViVo','Trung Quốc'),(12,'BKAV','Việt Nam'),(13,'OnePlus','Trung Quốc');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `price` (
  `price_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `value` decimal(19,4) DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime DEFAULT NULL,
  `current` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`price_id`),
  KEY `FK_price_product` (`product_id`),
  CONSTRAINT `FK_price_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,1,37990000.0000,'2019-11-20 00:00:00',NULL,1),(2,2,4090000.0000,'2019-11-20 00:00:00',NULL,1),(3,5,24990000.0000,'2019-11-20 00:00:00',NULL,1),(4,6,15990000.0000,'2019-11-20 00:00:00','2019-11-27 09:06:23',0),(5,7,5990000.0000,'2019-11-20 00:00:00',NULL,1),(6,10,6990000.0000,'2019-11-11 00:00:00','2019-11-18 00:00:00',0),(7,10,6490000.0000,'2019-11-20 00:00:00',NULL,1),(8,20,5990000.0000,'2019-11-22 00:00:00',NULL,1),(9,20,5990000.0000,'2019-11-22 00:00:00',NULL,1),(10,24,2990000.0000,'2019-11-22 00:00:00',NULL,1),(11,25,3090000.0000,'2019-11-22 00:00:00',NULL,1),(12,26,3590000.0000,'2019-11-22 00:00:00',NULL,1),(13,27,4390000.0000,'2019-11-22 00:00:00',NULL,1),(15,11,22990000.0000,'2019-11-22 23:17:22',NULL,1),(16,12,4690000.0000,'2019-11-22 23:24:56',NULL,1),(17,16,9990000.0000,'2019-11-22 23:25:22',NULL,1),(18,13,8900000.0000,'2019-11-26 10:44:48',NULL,1),(19,29,22990000.0000,'2019-11-26 16:35:17',NULL,1),(20,30,22990000.0000,'2019-11-26 16:37:02',NULL,1),(21,31,20990000.0000,'2019-11-26 16:38:16',NULL,1),(22,32,14990000.0000,'2019-11-26 16:39:28',NULL,1),(23,33,10990000.0000,'2019-11-26 16:41:03',NULL,1),(24,34,8790000.0000,'2019-11-26 16:42:20',NULL,1),(25,35,6490000.0000,'2019-11-26 16:43:26',NULL,1),(26,36,6990000.0000,'2019-11-26 16:44:27',NULL,1),(27,37,5490000.0000,'2019-11-26 16:45:28',NULL,1),(28,38,6290000.0000,'2019-11-26 16:46:25',NULL,1),(29,39,4790000.0000,'2019-11-26 16:47:20',NULL,1),(30,40,5390000.0000,'2019-11-26 16:48:26',NULL,1),(32,6,14990000.0000,'2019-11-27 09:06:23',NULL,1);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `manufacturer_id` int(11) DEFAULT NULL,
  `specifications` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `available` tinyint(1) DEFAULT '1',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`product_id`),
  KEY `FK_product_manufacturer` (`manufacturer_id`),
  CONSTRAINT `FK_product_manufacturer` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`manufacturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Điện thoại iPhone 11 Pro Max 256GB',2,'Màn hình:	OLED, 6.5\", Super Retina XDR','iPhone 11 Pro Max 256GB là chiếc iPhone cao cấp nhất trong bộ 3 iPhone Apple giới thiệu trong năm 2019 và quả thực chiếc smartphone này mang trong mình nhiều trang bị xứng đáng với tên gọi \"Pro\".','2019-11-13',1,0),(2,'Điện thoại Samsung Galaxy A7 (2018)',3,'Màn hình:	Super AMOLED, 6.0\", Full HD+','Samsung Galaxy A7 (2018) lột xác với nhiều thay đổi mới mẻ từ thiết kế đến hiệu năng. Bên cạnh đó, đây cũng là chiếc smartphone đầu tiên của Samsung sở hữu cụm camera sau với 3 thấu kính ấn tượng.','2018-10-15',1,0),(5,'Điện thoại Samsung Galaxy Note 10+',3,'Màn hình:	Dynamic AMOLED, 6.8\", Quad HD+ (2K+)','Trông ngoại hình khá giống nhau, tuy nhiên Samsung Galaxy Note 10+ sở hữu khá nhiều điểm khác biệt so với Galaxy Note 10 và đây được xem là một trong những chiếc máy đáng mua nhất trong năm 2019, đặc biệt dành cho những người thích một chiếc máy màn hình lớn, camera chất lượng hàng đầu.','2019-08-01',1,0),(6,'Điện thoại BlackBerry KEY2',8,'Màn hình:	IPS LCD, 4.5\", Full HD','BlackBerry Key2 là một bản nâng cấp toàn diện cho chiếc KeyOne với rất nhiều thay đổi và điều đáng mừng là yếu tố đặc trưng nhất của dòng điện thoại BlackBerry là bàn phím vật lý cổ điển vẫn được giữ lại.','2018-11-16',1,0),(7,'Điện thoại OPPO K3',1,'Màn hình:	AMOLED, 6.5\", Full HD+','OPPO K3 là một chiếc smartphone tầm trung với khá nhiều tính năng cao cấp như màn hình không \"tai thỏ\" hay cảm biến vân tay bên trong màn hình.','2019-08-22',1,0),(10,'Điện thoại OPPO A9 (2020)',1,'Màn hình:	TFT, 6.5\", HD+','Kế thừa phiên bản OPPO A7 đã từng gây hot trước đó, OPPO A9 (2020) có nhiều sự cải tiến hơn về màn hình, camera và hiệu năng trải nghiệm.','2019-09-01',0,0),(11,'Điện thoại Samsung Galaxy S10+',3,'Màn hình: Dynamic AMOLED, 6.4\", Quad HD+ (2K+)\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 12 MP & Phụ 12 MP, 16 MP\nCamera trước: Chính 10 MP & Phụ 8 MP\nCPU: Exynos 9820 8 nhân 64-bit\nRAM: 8 GB\nBộ nhớ trong: 128 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nThẻ SIM: 2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','Samsung Galaxy S10+ 128GB là một trong những chiếc smartphone được trông chờ nhiều nhất trong năm 2019 và không phụ sự kỳ vọng của mọi người thì chiếc Galaxy S thứ 10 của Samsung thực sự gây ấn tượng mạnh cho người dùng.','2019-02-04',1,0),(12,'Điện thoại Realme 5 (4GB/128GB)',1,'Màn hình:	IPS LCD, 6.5\", HD+ 	Camera sau:	Chính 12 MP & Phụ 8 MP, 2 MP, 2 MP','Bạn sẽ khó có thể tìm được một chiếc máy nào \"hoàn hảo\" hơn Realme 5 4GB/128GB trong tầm giá với một thiết kế đẹp, hiệu năng ấn tượng cùng camera chất lượng \"vượt tầm giá\".','2019-10-10',1,0),(13,'Điện thoại Vivo Y19',9,'Màn hình:	IPS LCD, 6.53\", Full HD+','Vivo Y19 là chiếc smartphone tập trung mạnh vào khả năng chụp ảnh ở camera chính lẫn camera selfie với công nghệ AI, hứa hẹn sẽ nhận được sự đón nhận tới từ người dùng là những bạn trẻ năng động và cá tính.','2019-11-11',0,0),(14,'Điện thoại OPPO A5 (2020) 64GB',1,'Màn hình:	TFT, 6.5\", HD+','OPPO A5 (2020) 64GB là mẫu smartphone tầm trung với giá thành phải chăng nhưng được trang bị nhiều công nghệ hấp dẫn hứa hẹn sẽ \"lấy được lòng\" các bạn trẻ năng động, thời trang.','2019-10-07',1,0),(15,'Điện thoại OPPO Reno2 F Xanh Tinh Vân',1,'Màn hình:	AMOLED, 6.53\", Full HD+','Sau một thời gian ra mắt chiếc OPPO Reno2 F thì mới đây OPPO đã bổ sung thêm vào bộ sưu tập này phiên bản OPPO Reno2 F Xanh Tinh Vân hứa hẹn sẽ làm xiêu lòng giới trẻ.','2019-10-06',1,0),(16,'Điện thoại Vivo V17 Pro',9,'Màn hình:	Super AMOLED, 6.44\", Full HD+\r\nHệ điều hành: Android 9.0 (Pie)\r\nCamera sau: Chính 48 MP & Phụ 8 MP, 2 MP, 2 MP\r\nCamera trước: Chính 32 MP & Phụ 8 MP\r\nCPU: Snapdragon 675 8 nhân 64-bit\r\nRAM: 8 GB\r\nBộ nhớ trong: 128 GB\r\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G','Bắt kịp xu thế smartphone có nhiều camera thì Vivo đã nhanh chóng giới thiệu chiếc Vivo V17 Pro với tổng cộng tới 6 camera trên một chiếc máy.','2019-10-10',1,0),(20,'Điện thoại Vivo S1',9,'Màn hình: Super AMOLED, 6.38\", Full HD+\r\nHệ điều hành: Android 9.0 (Pie)\r\nCamera sau: Chính 16 MP & Phụ 8 MP, 2 MP\r\nCamera trước: 32 MP\r\nCPU: MediaTek MT6768 8 nhân (Helio P65)\r\nRAM: 6 GB\r\nBộ nhớ trong: 128 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 256 GB\r\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G','Vivo S1 là chiếc smartphone S series mới sở hữu thiết kế tuyệt đẹp, đi kèm hệ thống 3 camera sau, cùng giá bán khá hấp dẫn.','2019-11-08',1,0),(23,'Điện thoại Vivo Y91C',9,'Màn hình: IPS LCD, 6.22\", HD+\r\nHệ điều hành: Android 8.1 (Oreo)\r\nCamera sau: 13 MP\r\nCamera trước: 5 MP\r\nCPU: MediaTek MT6762R 8 nhân\r\nRAM: 2 GB\r\nBộ nhớ trong: 32 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 256 GB\r\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G','Sở hữu thiết kế trẻ trung, năng động cùng kiểu màn hình Halo Fullview độc đáo với mức giá \"hạt dẻ\", chiếc điện thoại Vivo Y91C hứa hẹn sẽ tạo cơn sốt trong thời gian tới.','2019-03-21',1,0),(24,'Điện thoại Vivo Y93',9,'Màn hình: IPS LCD, 6.2\", HD+\r\nHệ điều hành: Android 8.1 (Oreo)\r\nCamera sau: Chính 13 MP & Phụ 2 MP\r\nCamera trước: 8 MP\r\nCPU: Qualcomm Snapdragon 439 8 nhân 64-bit\r\nRAM: 3 GB\r\nBộ nhớ trong: 32 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 256 GB\r\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G','Vivo Y93 32GB là chiếc smartphone giá rẻ, nhưng vẫn sở hữu nhiều ưu điểm mới nhất cho người dùng hiện nay như pin khủng, màn hình tràn giọt nước hay camera kép xoá phông.','2018-11-11',1,0),(25,'Điện thoại Samsung Galaxy A10',3,'Màn hình: IPS LCD, 6.2\", HD+\r\nHệ điều hành: Android 9.0 (Pie)\r\nCamera sau: 13 MP\r\nCamera trước: 5 MP\r\nCPU: Exynos 7884 8 nhân\r\nRAM: 2 GB\r\nBộ nhớ trong: 32 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB','Galaxy A10 - chiếc smartphone rẻ nhất ở dòng A của Samsung vừa được trình làng nhưng sở hữu nhiều đặc điểm ưu việt về thiết kế màn hình và hiệu năng với chip Exynos 7884.','2019-04-28',0,0),(26,'Điện thoại Samsung Galaxy A20',3,'Màn hình: Super AMOLED, 6.4\", HD+\r\nHệ điều hành: Android 9.0 (Pie)\r\nCamera sau: Chính 13 MP & Phụ 5 MP\r\nCamera trước: 8 MP\r\nCPU: Exynos 7884 8 nhân\r\nRAM: 3 GB\r\nBộ nhớ trong: 32 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB','Samsung Galaxy A20 là chiếc máy rẻ nhất trong dòng Galaxy A của Samsung mang lại cho người dùng những trải nghiệm cao cấp của những chiếc máy tới từ Samsung nhưng vẫn không phải bỏ ra số tiền quá lớn.','2019-04-25',1,0),(27,'Điện thoại Samsung Galaxy A20s 32GB',3,'Màn hình: IPS LCD, 6.5\", HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 13 MP & Phụ 8 MP, 5 MP\nCamera trước: 8 MP\nCPU: Qualcomm Snapdragon 450 8 nhân 64-bit\nRAM: 3 GB\nBộ nhớ trong: 32 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G','Samsung Galaxy A20s 32GB là một chiếc máy tầm trung tới từ thương hiệu Samsung, máy sở hữu những trang bị khá tốt để bạn có thể sử dụng mượt mà và ổn định hằng ngày.','2019-10-10',1,0),(28,'Điện thoại Vsmart Live (6GB/64GB)',4,'Màn hình: AMOLED, 6.2\", Full HD+\nHệ điều hành: Android 9.0 (Pie)','Vsmart Live (6GB/64GB) là chiếc smartphone thế hệ thứ 2 của Vsmart vừa ra mắt với nhiều ưu điểm rất hấp dẫn hứa hẹn sẽ mang lại sự thành công cho hãng smartphone Việt này.','2019-08-24',0,0),(29,'Điện thoại Samsung Galaxy Note 10',3,'Màn hình: Dynamic AMOLED, 6.3\", Full HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: 12 MP & Phụ 12 MP, 16 MP\nCamera trước: 10 MP\nCPU: Exynos 9825 8 nhân\nRAM: 8 GB\nBộ nhớ trong: 256 GB\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G\nDung lượng pin: 3500 mAh, có sạc nhanh','Nếu như từ trước tới nay dòng Galaxy Note của Samsung thường ít được các bạn nữ sử dụng bởi kích thước màn hình khá lớn khiến việc cầm nắm trở nên khó khăn thì Samsung Galaxy Note 10 sẽ là chiếc smartphone nhỏ gọn, phù hợp với cả những bạn có bàn tay nhỏ.','2019-08-11',1,0),(30,'Điện thoại Samsung Galaxy Note 9',3,'Màn hình: Super AMOLED, 6.4\", Quad HD+ (2K+)\nHệ điều hành: Android 8.1 (Oreo)\nCamera sau: Chính 12 MP & Phụ 12 MP\nCamera trước: 8 MP\nCPU: Exynos 9810 8 nhân 64-bit\nRAM: 6 GB\nBộ nhớ trong: 128 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nDung lượng pin: 4000 mAh, có sạc nhanh','Mang lại sự cải tiến đặc biệt trong cây bút S Pen, siêu phẩm Samsung Galaxy Note 9 còn sở hữu dung lượng pin khủng lên tới 4.000 mAh cùng hiệu năng mạnh mẽ vượt bậc, xứng đáng là một trong những chiếc điện thoại cao cấp nhất của Samsung.','2018-08-08',1,0),(31,'Điện thoại Samsung Galaxy S10',3,'Màn hình: Dynamic AMOLED, 6.1\", Quad HD+ (2K+)\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 12 MP & Phụ 12 MP, 16 MP\nCamera trước: 10 MP\nCPU: Exynos 9820 8 nhân\nRAM: 8 GB\nBộ nhớ trong: 128 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nDung lượng pin: 3400 mAh, có sạc nhanh','Samsung Galaxy S10 là chiếc smartphone kỉ niệm 10 năm ngày kể từ ngày đầu tiên Samsung ra mắt chiếc Galaxy S và không phụ sự chờ đợi của người dùng thì Samsung Galaxy S10 thực sự rất ấn tượng.','2019-02-13',1,0),(32,'Điện thoại Samsung Galaxy A80',3,'Màn hình: Super AMOLED, 6.7\", Full HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 48 MP & Phụ 8 MP, TOF 3D\nCamera trước: Chính 48 MP & Phụ 8 MP, TOF 3D\nCPU: Snapdragon 730 8 nhân\nRAM: 8 GB\nBộ nhớ trong: 128 GB\nDung lượng pin: 3700 mAh, có sạc nhanh','Samsung Galaxy A80 là chiếc smartphone mang trong mình rất nhiều đột phá của Samsung và hứa hẹn sẽ là \"ngọn cờ đầu\" cho những chiếc smartphone sở hữu một màn hình tràn viền thật sự.','2019-06-27',1,0),(33,'Điện thoại Samsung Galaxy A9 (2018)',3,'Màn hình: Super AMOLED, 6.3\", Full HD+\nHệ điều hành: Android 8.0 (Oreo)\nCamera sau: Chính 24 MP & Phụ 10 MP, 8 MP, 5 MP\nCamera trước: 24 MP\nCPU: Snapdragon 660 8 nhân\nRAM: 6 GB\nBộ nhớ trong: 128 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G\nDung lượng pin: 3800 mAh, có sạc nhanh','Samsung Galaxy A9 (2018) là chiếc điện thoại đầu tiên của Samsung sở hữu hệ thống camera ấn tượng với 4 thấu kính cùng hàng loạt các nâng cấp đáng giá về cấu hình và tính năng hiện đại khác.','2018-11-11',1,0),(34,'Điện thoại Samsung Galaxy A70',3,'Màn hình: Super AMOLED, 6.7\", Full HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 32 MP & Phụ 8 MP, 5 MP\nCamera trước: 32 MP\nCPU: Snapdragon 675 8 nhân\nRAM: 6 GB\nBộ nhớ trong: 128 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nDung lượng pin: 4500 mAh, có sạc nhanh','Samsung Galaxy A70 là một phiên bản phóng to của chiếc Samsung Galaxy A50 đã ra mắt trước đó với nhiều cải tiến tới từ bên trong.','2019-04-05',1,0),(35,'Điện thoại Samsung Galaxy A50 128GB',3,'Màn hình: Super AMOLED, 6.4\", Full HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 25 MP & Phụ 8 MP, 5 MP\nCamera trước: 25 MP\nCPU: Exynos 9610 8 nhân 64-bit\nRAM: 6 GB\nBộ nhớ trong: 128 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G\nDung lượng pin:	4000 mAh, có sạc nhanh','Samsung Galaxy A50 128GB là mẫu smartphone dòng A mới trong năm 2019 và đặc biệt máy sở hữu công nghệ cảm biến vân tay trong màn hình lần đầu tiên xuất hiện trên một chiếc máy tầm trung tới từ Samsung.','2019-03-14',1,0),(36,'Điện thoại Samsung Galaxy A50s',3,'Màn hình: Super AMOLED, 6.4\", Full HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 48 MP & Phụ 8 MP, 5 MP\nCamera trước: 32 MP\nCPU: Exynos 9610 8 nhân\nRAM: 4 GB\nBộ nhớ trong: 64 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nDung lượng pin: 4000 mAh, có sạc nhanh','Nằm trong sứ mệnh nâng cao khả năng cạnh tranh với các smartphone đến từ nhiều nhà sản xuất Trung Quốc, mới đây Samsung tiếp tục giới thiệu phiên bản Samsung Galaxy A50s với nhiều tính năng mà trước đây chỉ xuất hiện trên dòng cao cấp.','2019-09-20',1,0),(37,'Điện thoại Samsung Galaxy A50 64GB',3,'Màn hình: Super AMOLED, 6.4\", Full HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 25 MP & Phụ 8 MP, 5 MP\nCamera trước: 25 MP\nCPU: Exynos 9610 8 nhân\nRAM: 4 GB\nBộ nhớ trong: 64 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nDung lượng pin:	4000 mAh, có sạc nhanh','Samsung Galaxy A50 64GB là chiếc smartphone tầm trung mới của Samsung trong năm 2019 với nhiều tính năng hấp dẫn, đặc biệt là có cả cảm biến vân tay dưới màn hình.','2019-03-21',1,0),(38,'Điện thoại Samsung Galaxy A30s',3,'Màn hình: Super AMOLED, 6.4\", HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 25 MP & Phụ 8 MP, 5 MP\nCamera trước: 16 MP\nCPU: Exynos 7904 8 nhân 64-bit\nRAM: 4 GB\nBộ nhớ trong: 64 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nDung lượng pin: 4000 mAh, có sạc nhanh','Samsung Galaxy A30s, chiếc smartphone mới ra mắt sở hữu nhiều ưu điểm nổi bật trong phân khúc, nổi bật nhất phải kể đến là dung lượng pin lên tới 4000 mAh,bộ 3 camera cùng vi xử lý đủ mạnh, ổn định.','2019-09-11',1,0),(39,'Điện thoại Samsung Galaxy A30',3,'Màn hình: Super AMOLED, 6.4\", Full HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 16 MP & Phụ 5 MP\nCamera trước: 16 MP\nCPU: Exynos 7904 8 nhân\nRAM: 4 GB\nBộ nhớ trong: 64 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nDung lượng pin:	4000 mAh, có sạc nhanh','Samsung Galaxy A30 64GB là một chiếc máy khá hấp dẫn, dành cho các bạn yêu thích thương hiệu Samsung, muốn sở hữu một sản phẩm có nhiều tính năng hấp dẫn mà không cần phải bỏ ra nhiều tiền.','2019-03-24',1,0),(40,'Điện thoại Samsung Galaxy A20s 64GB',3,'Màn hình: IPS LCD, 6.5\", HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 13 MP & Phụ 8 MP, 5 MP\nCamera trước: 8 MP\nCPU: Snapdragon 450 8 nhân\nRAM: 4 GB\nBộ nhớ trong: 64 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nDung lượng pin:	4000 mAh, có sạc nhanh','Samsung Galaxy A20s 64GB là phiên bản cải tiến của chiếc Samsung Galaxy A20 64GB  đã ra mắt trước đó với những nâng cấp về mặt camera và kích thước màn hình.','2019-10-10',1,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-01 23:07:53
