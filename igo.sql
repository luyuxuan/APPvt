/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : igo

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2014-12-18 15:58:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` int(11) NOT NULL auto_increment,
  `managerName` varchar(20) NOT NULL,
  `managerpassword` int(11) default NULL,
  PRIMARY KEY  (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '123', '123');
INSERT INTO `manager` VALUES ('2', '234', '234');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL auto_increment,
  `productId` int(11) default NULL,
  `userId` int(11) default NULL,
  `orderState` varchar(6) NOT NULL,
  `orderTurnovertime` varchar(20) NOT NULL,
  PRIMARY KEY  (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productId` int(11) NOT NULL auto_increment,
  `productName` varchar(20) character set utf8 NOT NULL,
  `productprice` int(11) NOT NULL,
  `productpicture` varchar(50) default NULL,
  `productInventory` int(11) default '0',
  `productSales` int(11) default '0',
  `productIntroduction` varchar(500) character set utf8 default NULL,
  `posttime` varchar(50) character set utf8 default NULL,
  `discount` int(11) default NULL,
  `producttypeId` int(10) NOT NULL,
  PRIMARY KEY  (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('4', '6', '555', 'D:\\upload\\b1.png', '0', '0', '2', '2', '2', '2');
INSERT INTO `product` VALUES ('5', '5', '231', 'D:\\upload\\b1.png', '0', '0', '5', '5', '5', '2');
INSERT INTO `product` VALUES ('6', '123', '123', 'd:/upload/x222.png', '12', '0', 'xxx', '21', '1', '4');

-- ----------------------------
-- Table structure for `producttype`
-- ----------------------------
DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `producttypeId` int(11) NOT NULL,
  `typeParentid` int(10) NOT NULL,
  `producttypeName` varchar(20) character set utf8 NOT NULL,
  `producttypepicture` varchar(20) default NULL,
  PRIMARY KEY  (`producttypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of producttype
-- ----------------------------
INSERT INTO `producttype` VALUES ('1', '0', '服装1', 'd:/upload/w3.png');
INSERT INTO `producttype` VALUES ('2', '1', '皮靴', null);
INSERT INTO `producttype` VALUES ('3', '0', '家电', 'd:/upload/w4.png');
INSERT INTO `producttype` VALUES ('4', '3', '彩电', null);
INSERT INTO `producttype` VALUES ('5', '1', '皮包', null);
INSERT INTO `producttype` VALUES ('10', '0', '美妆', 'd:/upload/w2.png');
INSERT INTO `producttype` VALUES ('11', '0', '母婴', 'd:/upload/w6.png');
INSERT INTO `producttype` VALUES ('12', '0', '皮具', 'd:/upload/w1.png');
INSERT INTO `producttype` VALUES ('13', '0', '食品', 'd:/upload/w5.png');

-- ----------------------------
-- Table structure for `shoppingcart`
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `productId` int(11) NOT NULL,
  `usersId` int(11) NOT NULL,
  `productnum` int(10) NOT NULL,
  `shoppingCartId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart` VALUES ('1', '1', '1', '1');
INSERT INTO `shoppingcart` VALUES ('2', '1', '1', '1');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `usersId` int(11) NOT NULL auto_increment,
  `userName` varchar(20) NOT NULL,
  `userPassword` varchar(20) NOT NULL,
  `userIntegration` int(11) default '0',
  `userEmail` varchar(20) NOT NULL,
  `userState` varchar(30) character set utf8 default NULL,
  `shoppingCartId` int(11) default NULL,
  `userpicture` varchar(50) default NULL,
  PRIMARY KEY  (`usersId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
