/*
Navicat MySQL Data Transfer

Source Server         : lq
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : furuifengyuan

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-11-08 21:00:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for frfy_activity
-- ----------------------------
DROP TABLE IF EXISTS `frfy_activity`;
CREATE TABLE `frfy_activity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of frfy_activity
-- ----------------------------

-- ----------------------------
-- Table structure for frfy_advertisement
-- ----------------------------
DROP TABLE IF EXISTS `frfy_advertisement`;
CREATE TABLE `frfy_advertisement` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL,
  `url` varchar(20) NOT NULL,
  `orders` int(11) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of frfy_advertisement
-- ----------------------------

-- ----------------------------
-- Table structure for frfy_article
-- ----------------------------
DROP TABLE IF EXISTS `frfy_article`;
CREATE TABLE `frfy_article` (
  `id` varchar(32) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `status` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of frfy_article
-- ----------------------------

-- ----------------------------
-- Table structure for frfy_commoditycategories
-- ----------------------------
DROP TABLE IF EXISTS `frfy_commoditycategories`;
CREATE TABLE `frfy_commoditycategories` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of frfy_commoditycategories
-- ----------------------------

-- ----------------------------
-- Table structure for frfy_farm
-- ----------------------------
DROP TABLE IF EXISTS `frfy_farm`;
CREATE TABLE `frfy_farm` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `hrefName` varchar(50) DEFAULT NULL,
  `url` varchar(20) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of frfy_farm
-- ----------------------------

-- ----------------------------
-- Table structure for frfy_product
-- ----------------------------
DROP TABLE IF EXISTS `frfy_product`;
CREATE TABLE `frfy_product` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL,
  `price` float DEFAULT NULL,
  `discount` float NOT NULL,
  `orders` int(11) NOT NULL,
  `description` text,
  `relatedMenu` text,
  `formats` varchar(50) DEFAULT NULL,
  `origin` varchar(100) DEFAULT NULL,
  `category` bigint(20) NOT NULL,
  `status` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `userId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of frfy_product
-- ----------------------------

-- ----------------------------
-- Table structure for frfy_user
-- ----------------------------
DROP TABLE IF EXISTS `frfy_user`;
CREATE TABLE `frfy_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(20) NOT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of frfy_user
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '18867101839', '123456');
