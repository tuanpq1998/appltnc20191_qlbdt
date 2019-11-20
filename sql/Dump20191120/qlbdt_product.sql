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
  PRIMARY KEY (`product_id`),
  KEY `FK_product_manufacturer` (`manufacturer_id`),
  CONSTRAINT `FK_product_manufacturer` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`manufacturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Điện thoại iPhone 11 Pro Max 256GB',2,'Màn hình:	OLED, 6.5\", Super Retina XDR','iPhone 11 Pro Max 256GB là chiếc iPhone cao cấp nhất trong bộ 3 iPhone Apple giới thiệu trong năm 2019 và quả thực chiếc smartphone này mang trong mình nhiều trang bị xứng đáng với tên gọi \"Pro\".','2019-11-13',1),(2,'Điện thoại Samsung Galaxy A7 (2018)',3,'Màn hình:	Super AMOLED, 6.0\", Full HD+','Samsung Galaxy A7 (2018) lột xác với nhiều thay đổi mới mẻ từ thiết kế đến hiệu năng. Bên cạnh đó, đây cũng là chiếc smartphone đầu tiên của Samsung sở hữu cụm camera sau với 3 thấu kính ấn tượng.','2018-10-15',1),(5,'Điện thoại Samsung Galaxy Note 10+',3,'Màn hình:	Dynamic AMOLED, 6.8\", Quad HD+ (2K+)','Trông ngoại hình khá giống nhau, tuy nhiên Samsung Galaxy Note 10+ sở hữu khá nhiều điểm khác biệt so với Galaxy Note 10 và đây được xem là một trong những chiếc máy đáng mua nhất trong năm 2019, đặc biệt dành cho những người thích một chiếc máy màn hình lớn, camera chất lượng hàng đầu.','2019-08-01',1),(6,'Điện thoại BlackBerry KEY2',8,'Màn hình:	IPS LCD, 4.5\", Full HD','BlackBerry Key2 là một bản nâng cấp toàn diện cho chiếc KeyOne với rất nhiều thay đổi và điều đáng mừng là yếu tố đặc trưng nhất của dòng điện thoại BlackBerry là bàn phím vật lý cổ điển vẫn được giữ lại.','2018-11-16',1),(7,'Điện thoại OPPO K3',1,'Màn hình:	AMOLED, 6.5\", Full HD+','OPPO K3 là một chiếc smartphone tầm trung với khá nhiều tính năng cao cấp như màn hình không \"tai thỏ\" hay cảm biến vân tay bên trong màn hình.','2019-08-22',1),(10,'Điện thoại OPPO A9 (2020)',1,'Màn hình:	TFT, 6.5\", HD+','Kế thừa phiên bản OPPO A7 đã từng gây hot trước đó, OPPO A9 (2020) có nhiều sự cải tiến hơn về màn hình, camera và hiệu năng trải nghiệm.','2019-09-01',0),(11,'Điện thoại Samsung Galaxy S10+',3,'Màn hình:	Dynamic AMOLED, 6.4\", Quad HD+ (2K+)','Samsung Galaxy S10+ 128GB là một trong những chiếc smartphone được trông chờ nhiều nhất trong năm 2019 và không phụ sự kỳ vọng của mọi người thì chiếc Galaxy S thứ 10 của Samsung thực sự gây ấn tượng mạnh cho người dùng.','2019-02-02',1),(12,'Điện thoại Realme 5 (4GB/128GB)',1,'Màn hình:	IPS LCD, 6.5\", HD+ 	Camera sau:	Chính 12 MP & Phụ 8 MP, 2 MP, 2 MP','Bạn sẽ khó có thể tìm được một chiếc máy nào \"hoàn hảo\" hơn Realme 5 4GB/128GB trong tầm giá với một thiết kế đẹp, hiệu năng ấn tượng cùng camera chất lượng \"vượt tầm giá\".','2019-10-10',1),(13,'Điện thoại Vivo Y19',9,'Màn hình:	IPS LCD, 6.53\", Full HD+','Vivo Y19 là chiếc smartphone tập trung mạnh vào khả năng chụp ảnh ở camera chính lẫn camera selfie với công nghệ AI, hứa hẹn sẽ nhận được sự đón nhận tới từ người dùng là những bạn trẻ năng động và cá tính.','2019-11-11',1),(14,'Điện thoại OPPO A5 (2020) 64GB',1,'Màn hình:	TFT, 6.5\", HD+','OPPO A5 (2020) 64GB là mẫu smartphone tầm trung với giá thành phải chăng nhưng được trang bị nhiều công nghệ hấp dẫn hứa hẹn sẽ \"lấy được lòng\" các bạn trẻ năng động, thời trang.','2019-10-07',1),(15,'Điện thoại OPPO Reno2 F Xanh Tinh Vân',1,'Màn hình:	AMOLED, 6.53\", Full HD+','Sau một thời gian ra mắt chiếc OPPO Reno2 F thì mới đây OPPO đã bổ sung thêm vào bộ sưu tập này phiên bản OPPO Reno2 F Xanh Tinh Vân hứa hẹn sẽ làm xiêu lòng giới trẻ.','2019-10-06',1);
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

-- Dump completed on 2019-11-20 22:18:47
