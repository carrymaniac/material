/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : material

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 25/06/2018 15:27:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `appointmentId` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作的id',
  `appointTime` datetime(0) DEFAULT NULL COMMENT '操作时间',
  `goodId` int(11) NOT NULL COMMENT '操作的商品id',
  `operator` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `company` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出库入库的单位',
  `number` int(11) DEFAULT NULL COMMENT '出库入库的数量',
  `state` int(1) NOT NULL COMMENT '出库入库的状态',
  PRIMARY KEY (`appointmentId`) USING BTREE,
  INDEX `fk_goodid`(`goodId`) USING BTREE,
  CONSTRAINT `fk_goodid` FOREIGN KEY (`goodId`) REFERENCES `good` (`good_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES (1, '2018-06-10 14:56:57', 1, '测试数据1', '测试数据1', 100, 0);
INSERT INTO `appointment` VALUES (2, '2018-06-10 15:06:22', 1, '测试数据2', '测试数据2', 100, 1);
INSERT INTO `appointment` VALUES (3, '2018-06-10 15:23:09', 1, '测试数据3', '测试数据3', 100, 1);
INSERT INTO `appointment` VALUES (4, '2018-06-10 15:24:47', 1, '测试数据3', '测试数据3', 100, 1);
INSERT INTO `appointment` VALUES (5, '2018-06-15 12:27:20', 1, '测试数据5', '测试数据6', 100, 1);
INSERT INTO `appointment` VALUES (6, '2018-06-15 15:01:08', 3, '大番薯', '海大开发', 1000, 1);
INSERT INTO `appointment` VALUES (7, '2018-06-15 15:20:19', 3, 'dd', '湛江石油', 1000, 0);
INSERT INTO `appointment` VALUES (8, '2018-06-24 20:19:53', 1, '大番薯', '海大开发', 1000, 1);
INSERT INTO `appointment` VALUES (9, '2018-06-25 12:28:25', 3, '大番薯', '海大开发', 10000, 1);
INSERT INTO `appointment` VALUES (10, '2018-06-25 12:39:32', 1, '大番薯', '海大开发', 1000, 0);
INSERT INTO `appointment` VALUES (11, '2018-06-25 14:20:34', 4, '小地瓜', '北大青鸟', 1000, 1);

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `good_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `factory` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品生产厂家',
  `specifications` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品规格',
  `number` int(11) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`good_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES (1, '塑料', '湛江海大化工厂', '聚氯乙烯', 98900);
INSERT INTO `good` VALUES (2, '测试数据3', '小米', '6G内存', 1000);
INSERT INTO `good` VALUES (3, '华为手机', '华为', '6g', 11000);
INSERT INTO `good` VALUES (4, '小米手机6', '小米', '8g内存', 101000);
INSERT INTO `good` VALUES (5, '华为手机5', '华为', '5g', 10000);
INSERT INTO `good` VALUES (6, '一加手机3', '一加', '6g', 2000);
INSERT INTO `good` VALUES (7, '联想手机', '联想', '2g', 20000);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orderid` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作的id',
  `ordertime` datetime(0) DEFAULT NULL COMMENT '操作时间',
  `goodid` int(11) NOT NULL COMMENT '订单的商品id',
  `operator` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作人',
  `company` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单的相关单位',
  `number` int(11) DEFAULT NULL COMMENT '订单的商品数量',
  `state` int(1) NOT NULL COMMENT '订单的出库入库状态(0表示出库，1表示入库)',
  `sign` int(1) NOT NULL COMMENT '订单的审核状态(0表示待审核，1表示审核通过，-1表示没能通过审核)',
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '2018-06-22 15:54:34', 1, NULL, '海大', 1000, 0, 1);
INSERT INTO `orders` VALUES (2, '2018-06-24 19:13:21', 1, '大番薯', '海大开发', 1000, 1, 1);
INSERT INTO `orders` VALUES (3, '2018-06-25 12:20:23', 3, '大番薯', '海大开发', 10000, 1, 1);
INSERT INTO `orders` VALUES (4, '2018-06-25 12:39:18', 1, '大番薯', '海大开发', 1000, 0, 1);
INSERT INTO `orders` VALUES (5, '2018-06-25 12:40:15', 4, '大番薯', '海大开发', 1000, 1, -1);
INSERT INTO `orders` VALUES (6, '2018-06-25 14:20:00', 4, '小地瓜', '北大青鸟', 1000, 1, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `identity` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '身份标识:0代表普通用户，1代表管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '最高管理员', '21232F297A57A5A743894A0E4A801FC3', '1');
INSERT INTO `user` VALUES ('digua', '小地瓜', 'E10ADC3949BA59ABBE56E057F20F883E', '0');
INSERT INTO `user` VALUES ('fanshu', '大番薯', 'E10ADC3949BA59ABBE56E057F20F883E', '0');

SET FOREIGN_KEY_CHECKS = 1;
