/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : car_booking

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 14/02/2022 00:45:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car_model
-- ----------------------------
DROP TABLE IF EXISTS `car_model`;
CREATE TABLE `car_model` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `model_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of car_model
-- ----------------------------
BEGIN;
INSERT INTO `car_model` (`id`, `name`, `stock`, `model_desc`) VALUES (1, 'BMW 650', 2, 'BMW 650');
INSERT INTO `car_model` (`id`, `name`, `stock`, `model_desc`) VALUES (2, 'Toyota Camry', 2, 'Toyota Camry');
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `model_id` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` (`id`, `model_id`, `start_date`, `end_date`) VALUES (1, 1, '2022-02-10', '2022-02-12');
INSERT INTO `order` (`id`, `model_id`, `start_date`, `end_date`) VALUES (2, 1, '2022-02-10', '2022-02-10');
INSERT INTO `order` (`id`, `model_id`, `start_date`, `end_date`) VALUES (4, 2, '2022-02-14', '2022-02-14');
INSERT INTO `order` (`id`, `model_id`, `start_date`, `end_date`) VALUES (5, 2, '2022-02-14', '2022-02-14');
INSERT INTO `order` (`id`, `model_id`, `start_date`, `end_date`) VALUES (6, 2, '2022-02-15', '2022-02-15');
COMMIT;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `model_id` int DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
BEGIN;
INSERT INTO `order_detail` (`id`, `model_id`, `order_id`, `date`) VALUES (1, 1, 1, '2022-02-10');
INSERT INTO `order_detail` (`id`, `model_id`, `order_id`, `date`) VALUES (2, 1, 1, '2022-02-11');
INSERT INTO `order_detail` (`id`, `model_id`, `order_id`, `date`) VALUES (3, 1, 1, '2022-02-12');
INSERT INTO `order_detail` (`id`, `model_id`, `order_id`, `date`) VALUES (4, 1, 2, '2022-02-10');
INSERT INTO `order_detail` (`id`, `model_id`, `order_id`, `date`) VALUES (5, 2, 4, '2022-02-14');
INSERT INTO `order_detail` (`id`, `model_id`, `order_id`, `date`) VALUES (6, 2, 5, '2022-02-14');
INSERT INTO `order_detail` (`id`, `model_id`, `order_id`, `date`) VALUES (7, 2, 6, '2022-02-15');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
