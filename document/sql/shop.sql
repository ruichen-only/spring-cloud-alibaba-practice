/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 14/12/2021 23:35:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shop_order
-- ----------------------------
DROP TABLE IF EXISTS `shop_order`;
CREATE TABLE `shop_order`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_product
-- ----------------------------
DROP TABLE IF EXISTS `shop_product`;
CREATE TABLE `shop_product`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `stock` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_user
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
