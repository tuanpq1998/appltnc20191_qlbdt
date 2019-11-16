CREATE DATABASE IF NOT EXISTS `qlbdt`;
USE `qlbdt`;

--
-- Table structure for table `student`
--

CREATE TABLE Customer(
	`customer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `fullname` nvarchar(25) NOT NULL,
    `address` nvarchar(100) default NULL,
    `phone` varchar(15) default null,
    PRIMARY KEY (`customer_id`)
);

CREATE TABLE Employee(
	`employee_id` INT(11) NOT NULL AUTO_INCREMENT,
    `fullname` nvarchar(25) NOT NULL,
    `address` nvarchar(100) default NULL,
    `phone` varchar(15) default null,
    `identity_card` varchar(15) default Null,
    `username` varchar(10) NOT NULL UNIQUE,
    `password` varchar(80) NOT NULL,
    `role` varchar(10) default "employee",
    `active` boolean default true,
    PRIMARY KEY (`employee_id`)
);

CREATE TABLE Bill(
	`bill_id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT default NULL,
    `create_date` DATETIME,
    `employee_id` INT NOT NULL,
    `total` DECIMAL(10,4) default NULL,
    
    PRIMARY KEY (`bill_id`),
    constraint `FK_bill_customer` foreign key (`customer_id`) references `Customer`(`customer_id`),
    constraint `FK_bill_employee` foreign key (`employee_id`) references `Employee`(`employee_id`)
);

CREATE TABLE Manufacturer(
	`manufacturer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(10) default NULL UNIQUE,
    `country` NVARCHAR(10) default NULL,
    
    PRIMARY KEY (`manufacturer_id`)
);

CREATE TABLE Product(
	`product_id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` NVARCHAR(100) NOT NULL,
    `manufacturer_id` INT default null,
    `specifications` NVARCHAR(1000) default NULL,
    `description` NVARCHAR(1000) default NULL,
    `release_date` DATE default NULL,
    `available` boolean default true,
    
    PRIMARY KEY (`product_id`),
    constraint `FK_product_manufacturer` foreign key (`manufacturer_id`) references `Manufacturer`(`manufacturer_id`)    
);

CREATE TABLE Bill_detail (
	`bill_detail_id` INT(11) NOT NULL AUTO_INCREMENT,
    `bill_id` INT NOT null,
    `product_id` INT NOT null,
    `quantity` SMALLINT Default 1,
    `sub_total` DECIMAL(10,4),
    `note` NVARCHAR(50),
    
    UNIQUE (`bill_id`, `product_id`),
    PRIMARY KEY (`bill_detail_id`),
    constraint `FK_bill_detail_bill` foreign key (`bill_id`) references `Bill`(`bill_id`)    ,
    constraint `FK_bill_detail_product` foreign key (`product_id`) references `Product`(`product_id`)    
);

CREATE TABLE Price (
	`price_id` INT(11) NOT NULL AUTO_INCREMENT,
    `product_id` INT NOT null,
    `value` DECIMAL(10,4),
    `start_date` DATETIME NOT NULL,
    `end_date` DATETIME default NULL,
    PRIMARY KEY (`price_id`),
    constraint `FK_price_product` foreign key (`product_id`) references `Product`(`product_id`)    
)


