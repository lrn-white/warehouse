/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : warehouse

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-09 17:23:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
  `dishID` int(11) NOT NULL AUTO_INCREMENT,
  `dishName` varchar(50) DEFAULT NULL,
  `totalPrice` double(10,2) DEFAULT '0.00',
  PRIMARY KEY (`dishID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dish
-- ----------------------------
INSERT INTO `dish` VALUES ('1', '辣子鸡丁', '10.28');
INSERT INTO `dish` VALUES ('3', '宫保鸡丁', '0.00');
INSERT INTO `dish` VALUES ('5', '红烧肉', '0.00');
INSERT INTO `dish` VALUES ('6', '东坡肉', '0.00');
INSERT INTO `dish` VALUES ('7', '红烧肘子', '0.00');

-- ----------------------------
-- Table structure for dishandmaterial
-- ----------------------------
DROP TABLE IF EXISTS `dishandmaterial`;
CREATE TABLE `dishandmaterial` (
  `dishID` int(11) DEFAULT NULL,
  `materialID` int(11) DEFAULT NULL,
  `amount` int(50) DEFAULT NULL,
  `materialName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dishandmaterial
-- ----------------------------
INSERT INTO `dishandmaterial` VALUES ('1', '1', '4', '食盐');
INSERT INTO `dishandmaterial` VALUES ('1', '8', '200', '鸡肉');
INSERT INTO `dishandmaterial` VALUES ('1', '7', '20', '料酒');
INSERT INTO `dishandmaterial` VALUES ('1', '6', '40', '生抽酱油');
INSERT INTO `dishandmaterial` VALUES ('1', null, '700', '大米');

-- ----------------------------
-- Table structure for dishandmenu
-- ----------------------------
DROP TABLE IF EXISTS `dishandmenu`;
CREATE TABLE `dishandmenu` (
  `dishID` int(11) DEFAULT NULL,
  `menuID` int(11) DEFAULT NULL,
  `dishName` varchar(255) DEFAULT NULL,
  `totalPrice` double(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dishandmenu
-- ----------------------------
INSERT INTO `dishandmenu` VALUES ('1', '2', '辣子鸡丁', '10.28');
INSERT INTO `dishandmenu` VALUES ('3', '2', '宫保鸡丁', '0.00');
INSERT INTO `dishandmenu` VALUES (null, '2', '红烧肉', '0.00');
INSERT INTO `dishandmenu` VALUES (null, '2', '东坡肉', null);

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `materialID` int(11) NOT NULL AUTO_INCREMENT,
  `materialName` varchar(50) DEFAULT NULL,
  `materialPrice` double(50,0) DEFAULT NULL,
  `materialStock` int(11) DEFAULT NULL,
  PRIMARY KEY (`materialID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', '食盐', '20', '50000');
INSERT INTO `material` VALUES ('2', '食用油', '8', '50000');
INSERT INTO `material` VALUES ('3', '大米', '8', '40000');
INSERT INTO `material` VALUES ('4', '面粉', '4', '20000');
INSERT INTO `material` VALUES ('5', '黑米', '20', '5000');
INSERT INTO `material` VALUES ('6', '生抽酱油', '10', '10000');
INSERT INTO `material` VALUES ('7', '料酒', '10', '5000');
INSERT INTO `material` VALUES ('8', '鸡肉', '20', '2000');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuID` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(50) DEFAULT NULL,
  `totalMenuPrice` double(50,0) DEFAULT '0',
  PRIMARY KEY (`menuID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('2', '婚宴', '0');
INSERT INTO `menu` VALUES ('4', '喜宴', '0');
