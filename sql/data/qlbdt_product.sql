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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Điện thoại iPhone 11 Pro Max 256GB',2,'Màn hình:	OLED, 6.5\", Super Retina XDR','iPhone 11 Pro Max 256GB là chiếc iPhone cao cấp nhất trong bộ 3 iPhone Apple giới thiệu trong năm 2019 và quả thực chiếc smartphone này mang trong mình nhiều trang bị xứng đáng với tên gọi \"Pro\".','2019-11-13',1),(2,'Điện thoại Samsung Galaxy A7 (2018)',3,'Màn hình:	Super AMOLED, 6.0\", Full HD+','Samsung Galaxy A7 (2018) lột xác với nhiều thay đổi mới mẻ từ thiết kế đến hiệu năng. Bên cạnh đó, đây cũng là chiếc smartphone đầu tiên của Samsung sở hữu cụm camera sau với 3 thấu kính ấn tượng.','2018-10-15',1),(5,'Điện thoại Samsung Galaxy Note 10+',3,'Màn hình:	Dynamic AMOLED, 6.8\", Quad HD+ (2K+)','Trông ngoại hình khá giống nhau, tuy nhiên Samsung Galaxy Note 10+ sở hữu khá nhiều điểm khác biệt so với Galaxy Note 10 và đây được xem là một trong những chiếc máy đáng mua nhất trong năm 2019, đặc biệt dành cho những người thích một chiếc máy màn hình lớn, camera chất lượng hàng đầu.','2019-08-01',1),(6,'Điện thoại BlackBerry KEY2',8,'Màn hình:	IPS LCD, 4.5\", Full HD','BlackBerry Key2 là một bản nâng cấp toàn diện cho chiếc KeyOne với rất nhiều thay đổi và điều đáng mừng là yếu tố đặc trưng nhất của dòng điện thoại BlackBerry là bàn phím vật lý cổ điển vẫn được giữ lại.','2018-11-16',1),(7,'Điện thoại OPPO K3',1,'Màn hình:	AMOLED, 6.5\", Full HD+','OPPO K3 là một chiếc smartphone tầm trung với khá nhiều tính năng cao cấp như màn hình không \"tai thỏ\" hay cảm biến vân tay bên trong màn hình.','2019-08-22',1),(10,'Điện thoại OPPO A9 (2020)',1,'Màn hình:	TFT, 6.5\", HD+','Kế thừa phiên bản OPPO A7 đã từng gây hot trước đó, OPPO A9 (2020) có nhiều sự cải tiến hơn về màn hình, camera và hiệu năng trải nghiệm.','2019-09-01',0),(11,'Điện thoại Samsung Galaxy S10+',3,'Màn hình: Dynamic AMOLED, 6.4\", Quad HD+ (2K+)\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 12 MP & Phụ 12 MP, 16 MP\nCamera trước: Chính 10 MP & Phụ 8 MP\nCPU: Exynos 9820 8 nhân 64-bit\nRAM: 8 GB\nBộ nhớ trong: 128 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nThẻ SIM: 2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','Samsung Galaxy S10+ 128GB là một trong những chiếc smartphone được trông chờ nhiều nhất trong năm 2019 và không phụ sự kỳ vọng của mọi người thì chiếc Galaxy S thứ 10 của Samsung thực sự gây ấn tượng mạnh cho người dùng.','2019-02-04',1),(12,'Điện thoại Realme 5 (4GB/128GB)',1,'Màn hình:	IPS LCD, 6.5\", HD+ 	Camera sau:	Chính 12 MP & Phụ 8 MP, 2 MP, 2 MP','Bạn sẽ khó có thể tìm được một chiếc máy nào \"hoàn hảo\" hơn Realme 5 4GB/128GB trong tầm giá với một thiết kế đẹp, hiệu năng ấn tượng cùng camera chất lượng \"vượt tầm giá\".','2019-10-10',1),(13,'Điện thoại Vivo Y19',9,'Màn hình:	IPS LCD, 6.53\", Full HD+','Vivo Y19 là chiếc smartphone tập trung mạnh vào khả năng chụp ảnh ở camera chính lẫn camera selfie với công nghệ AI, hứa hẹn sẽ nhận được sự đón nhận tới từ người dùng là những bạn trẻ năng động và cá tính.','2019-11-11',1),(14,'Điện thoại OPPO A5 (2020) 64GB',1,'Màn hình:	TFT, 6.5\", HD+','OPPO A5 (2020) 64GB là mẫu smartphone tầm trung với giá thành phải chăng nhưng được trang bị nhiều công nghệ hấp dẫn hứa hẹn sẽ \"lấy được lòng\" các bạn trẻ năng động, thời trang.','2019-10-07',1),(15,'Điện thoại OPPO Reno2 F Xanh Tinh Vân',1,'Màn hình:	AMOLED, 6.53\", Full HD+','Sau một thời gian ra mắt chiếc OPPO Reno2 F thì mới đây OPPO đã bổ sung thêm vào bộ sưu tập này phiên bản OPPO Reno2 F Xanh Tinh Vân hứa hẹn sẽ làm xiêu lòng giới trẻ.','2019-10-06',1),(16,'Điện thoại Vivo V17 Pro',9,'Màn hình:	Super AMOLED, 6.44\", Full HD+\r\nHệ điều hành: Android 9.0 (Pie)\r\nCamera sau: Chính 48 MP & Phụ 8 MP, 2 MP, 2 MP\r\nCamera trước: Chính 32 MP & Phụ 8 MP\r\nCPU: Snapdragon 675 8 nhân 64-bit\r\nRAM: 8 GB\r\nBộ nhớ trong: 128 GB\r\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G','Bắt kịp xu thế smartphone có nhiều camera thì Vivo đã nhanh chóng giới thiệu chiếc Vivo V17 Pro với tổng cộng tới 6 camera trên một chiếc máy.','2019-10-10',1),(20,'Điện thoại Vivo S1',9,'Màn hình: Super AMOLED, 6.38\", Full HD+\r\nHệ điều hành: Android 9.0 (Pie)\r\nCamera sau: Chính 16 MP & Phụ 8 MP, 2 MP\r\nCamera trước: 32 MP\r\nCPU: MediaTek MT6768 8 nhân (Helio P65)\r\nRAM: 6 GB\r\nBộ nhớ trong: 128 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 256 GB\r\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G','Vivo S1 là chiếc smartphone S series mới sở hữu thiết kế tuyệt đẹp, đi kèm hệ thống 3 camera sau, cùng giá bán khá hấp dẫn.','2019-11-08',1),(23,'Điện thoại Vivo Y91C',9,'Màn hình: IPS LCD, 6.22\", HD+\r\nHệ điều hành: Android 8.1 (Oreo)\r\nCamera sau: 13 MP\r\nCamera trước: 5 MP\r\nCPU: MediaTek MT6762R 8 nhân\r\nRAM: 2 GB\r\nBộ nhớ trong: 32 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 256 GB\r\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G','Sở hữu thiết kế trẻ trung, năng động cùng kiểu màn hình Halo Fullview độc đáo với mức giá \"hạt dẻ\", chiếc điện thoại Vivo Y91C hứa hẹn sẽ tạo cơn sốt trong thời gian tới.','2019-03-21',1),(24,'Điện thoại Vivo Y93',9,'Màn hình: IPS LCD, 6.2\", HD+\r\nHệ điều hành: Android 8.1 (Oreo)\r\nCamera sau: Chính 13 MP & Phụ 2 MP\r\nCamera trước: 8 MP\r\nCPU: Qualcomm Snapdragon 439 8 nhân 64-bit\r\nRAM: 3 GB\r\nBộ nhớ trong: 32 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 256 GB\r\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G','Vivo Y93 32GB là chiếc smartphone giá rẻ, nhưng vẫn sở hữu nhiều ưu điểm mới nhất cho người dùng hiện nay như pin khủng, màn hình tràn giọt nước hay camera kép xoá phông.','2018-11-11',1),(25,'Điện thoại Samsung Galaxy A10',3,'Màn hình: IPS LCD, 6.2\", HD+\r\nHệ điều hành: Android 9.0 (Pie)\r\nCamera sau: 13 MP\r\nCamera trước: 5 MP\r\nCPU: Exynos 7884 8 nhân\r\nRAM: 2 GB\r\nBộ nhớ trong: 32 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB','Galaxy A10 - chiếc smartphone rẻ nhất ở dòng A của Samsung vừa được trình làng nhưng sở hữu nhiều đặc điểm ưu việt về thiết kế màn hình và hiệu năng với chip Exynos 7884.','2019-04-28',0),(26,'Điện thoại Samsung Galaxy A20',3,'Màn hình: Super AMOLED, 6.4\", HD+\r\nHệ điều hành: Android 9.0 (Pie)\r\nCamera sau: Chính 13 MP & Phụ 5 MP\r\nCamera trước: 8 MP\r\nCPU: Exynos 7884 8 nhân\r\nRAM: 3 GB\r\nBộ nhớ trong: 32 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB','Samsung Galaxy A20 là chiếc máy rẻ nhất trong dòng Galaxy A của Samsung mang lại cho người dùng những trải nghiệm cao cấp của những chiếc máy tới từ Samsung nhưng vẫn không phải bỏ ra số tiền quá lớn.','2019-04-25',1),(27,'Điện thoại Samsung Galaxy A20s 32GB',3,'Màn hình: IPS LCD, 6.5\", HD+\nHệ điều hành: Android 9.0 (Pie)\nCamera sau: Chính 13 MP & Phụ 8 MP, 5 MP\nCamera trước: 8 MP\nCPU: Qualcomm Snapdragon 450 8 nhân 64-bit\nRAM: 3 GB\nBộ nhớ trong: 32 GB\nThẻ nhớ: MicroSD, hỗ trợ tối đa 512 GB\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G','Samsung Galaxy A20s 32GB là một chiếc máy tầm trung tới từ thương hiệu Samsung, máy sở hữu những trang bị khá tốt để bạn có thể sử dụng mượt mà và ổn định hằng ngày.','2019-10-10',1),(28,'Điện thoại Vsmart Live (6GB/64GB)',4,'Màn hình: AMOLED, 6.2\", Full HD+\nHệ điều hành: Android 9.0 (Pie)','Vsmart Live (6GB/64GB) là chiếc smartphone thế hệ thứ 2 của Vsmart vừa ra mắt với nhiều ưu điểm rất hấp dẫn hứa hẹn sẽ mang lại sự thành công cho hãng smartphone Việt này.','2019-08-24',0);
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

-- Dump completed on 2019-11-22 23:39:23
