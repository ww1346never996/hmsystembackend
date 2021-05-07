/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : hmsystem

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-05-07 09:26:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for alarmtable
-- ----------------------------
DROP TABLE IF EXISTS `alarmtable`;
CREATE TABLE `alarmtable` (
  `medicinenum` int(11) NOT NULL,
  `alarmstoragenum` int(11) DEFAULT NULL,
  PRIMARY KEY (`medicinenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alarmtable
-- ----------------------------
INSERT INTO `alarmtable` VALUES ('1', '15');
INSERT INTO `alarmtable` VALUES ('2', '10');
INSERT INTO `alarmtable` VALUES ('3', '210');
INSERT INTO `alarmtable` VALUES ('4', '20');
INSERT INTO `alarmtable` VALUES ('5', '350');

-- ----------------------------
-- Table structure for docinfotable
-- ----------------------------
DROP TABLE IF EXISTS `docinfotable`;
CREATE TABLE `docinfotable` (
  `docinfonum` int(11) NOT NULL AUTO_INCREMENT,
  `docnum` int(11) DEFAULT NULL,
  `medicinenum` int(11) DEFAULT NULL,
  `medicinenumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`docinfonum`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of docinfotable
-- ----------------------------
INSERT INTO `docinfotable` VALUES ('1', '1', '1', '10');
INSERT INTO `docinfotable` VALUES ('2', '1', '2', '10');
INSERT INTO `docinfotable` VALUES ('5', '3', '4', '12');
INSERT INTO `docinfotable` VALUES ('6', '3', '1', '20');
INSERT INTO `docinfotable` VALUES ('9', '1', '4', '100');
INSERT INTO `docinfotable` VALUES ('18', '1575778860', '3', '200');
INSERT INTO `docinfotable` VALUES ('19', '1575778860', '5', '460');
INSERT INTO `docinfotable` VALUES ('21', '1214221792', '1', '30');
INSERT INTO `docinfotable` VALUES ('22', '226840622', '1', '10');
INSERT INTO `docinfotable` VALUES ('23', '226840622', '2', '10');
INSERT INTO `docinfotable` VALUES ('24', '226840622', '4', '100');
INSERT INTO `docinfotable` VALUES ('25', '226840622', '5', '120');
INSERT INTO `docinfotable` VALUES ('26', '1575778860', '1', '170');
INSERT INTO `docinfotable` VALUES ('33', '1035125404', '3', '200');
INSERT INTO `docinfotable` VALUES ('34', '1035125404', '5', '460');
INSERT INTO `docinfotable` VALUES ('35', '1035125404', '1', '170');
INSERT INTO `docinfotable` VALUES ('47', '998348048', '5', '30');
INSERT INTO `docinfotable` VALUES ('50', '998580294', '2', '120');
INSERT INTO `docinfotable` VALUES ('51', '998910319', '3', '12');
INSERT INTO `docinfotable` VALUES ('52', '1068419192', '5', '30');
INSERT INTO `docinfotable` VALUES ('53', '1575778860', '2', '160');
INSERT INTO `docinfotable` VALUES ('54', '1104533161', '3', '420');

-- ----------------------------
-- Table structure for documenttable
-- ----------------------------
DROP TABLE IF EXISTS `documenttable`;
CREATE TABLE `documenttable` (
  `docnum` int(11) NOT NULL AUTO_INCREMENT,
  `docid` int(11) DEFAULT NULL,
  `docstate` int(11) DEFAULT NULL,
  `doccreator` varchar(255) DEFAULT NULL,
  `doccreatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`docnum`)
) ENGINE=InnoDB AUTO_INCREMENT=1575778861 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of documenttable
-- ----------------------------
INSERT INTO `documenttable` VALUES ('1', '1', '2', 'admin', '2021-04-21 17:18:36');
INSERT INTO `documenttable` VALUES ('3', '3', '2', 'admin', '2021-04-10 17:02:11');
INSERT INTO `documenttable` VALUES ('226840622', '2', '2', 'admin', '2021-04-27 17:09:31');
INSERT INTO `documenttable` VALUES ('998348048', '3', '2', 'admin', '2021-05-05 15:50:19');
INSERT INTO `documenttable` VALUES ('998580294', '3', '2', 'admin', '2021-05-05 15:54:11');
INSERT INTO `documenttable` VALUES ('998910319', '3', '2', 'admin', '2021-05-05 15:59:41');
INSERT INTO `documenttable` VALUES ('1035125404', '2', '2', 'admin', '2021-04-29 16:51:08');
INSERT INTO `documenttable` VALUES ('1068419192', '3', '1', 'admin', '2021-05-06 11:18:10');
INSERT INTO `documenttable` VALUES ('1104533161', '1', '1', 'admin', '2021-05-06 21:20:04');
INSERT INTO `documenttable` VALUES ('1214221792', '2', '2', 'admin', '2021-04-27 16:53:00');
INSERT INTO `documenttable` VALUES ('1575778860', '1', '2', 'admin', '2021-05-06 21:18:55');

-- ----------------------------
-- Table structure for manufacturetable
-- ----------------------------
DROP TABLE IF EXISTS `manufacturetable`;
CREATE TABLE `manufacturetable` (
  `manufacturenum` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`manufacturenum`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manufacturetable
-- ----------------------------
INSERT INTO `manufacturetable` VALUES ('1', 'test');
INSERT INTO `manufacturetable` VALUES ('2', 'test2');
INSERT INTO `manufacturetable` VALUES ('3', '3');

-- ----------------------------
-- Table structure for medicinetable
-- ----------------------------
DROP TABLE IF EXISTS `medicinetable`;
CREATE TABLE `medicinetable` (
  `medicinenum` int(11) NOT NULL AUTO_INCREMENT,
  `medicinename` varchar(255) NOT NULL,
  `manufacturername` varchar(255) NOT NULL,
  `storagedate` datetime DEFAULT NULL,
  `purchaseprice` float DEFAULT NULL,
  `storagenum` int(11) DEFAULT NULL,
  PRIMARY KEY (`medicinenum`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicinetable
-- ----------------------------
INSERT INTO `medicinetable` VALUES ('1', '板蓝根', '白云山', '2021-04-29 16:52:32', '14', '390');
INSERT INTO `medicinetable` VALUES ('2', '新冠疫苗', '国药', '2021-05-05 15:54:49', '130', '1210');
INSERT INTO `medicinetable` VALUES ('3', '镇痛喷雾', '云南白药', '2021-05-05 15:59:46', '20', '205');
INSERT INTO `medicinetable` VALUES ('4', '创口贴', '云南白药', '2021-04-27 17:09:39', '0.8', '400');
INSERT INTO `medicinetable` VALUES ('5', 'test1', 'test', '2021-05-05 15:58:25', '12.8', '750');

-- ----------------------------
-- Table structure for rationinfotable
-- ----------------------------
DROP TABLE IF EXISTS `rationinfotable`;
CREATE TABLE `rationinfotable` (
  `departmentnum` int(12) DEFAULT NULL,
  `medicinenum` int(12) DEFAULT NULL,
  `rationinfonum` int(12) NOT NULL AUTO_INCREMENT,
  `medicinenumber` int(12) NOT NULL,
  PRIMARY KEY (`rationinfonum`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rationinfotable
-- ----------------------------
INSERT INTO `rationinfotable` VALUES ('1', '5', '1', '30');
INSERT INTO `rationinfotable` VALUES ('2', '3', '2', '12');
INSERT INTO `rationinfotable` VALUES ('3', '2', '3', '120');

-- ----------------------------
-- Table structure for rationtable
-- ----------------------------
DROP TABLE IF EXISTS `rationtable`;
CREATE TABLE `rationtable` (
  `departmentnum` int(12) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`departmentnum`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rationtable
-- ----------------------------
INSERT INTO `rationtable` VALUES ('1', '儿科');
INSERT INTO `rationtable` VALUES ('2', '急诊科');
INSERT INTO `rationtable` VALUES ('3', '门诊部');

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `username` varchar(255) NOT NULL,
  `userpassword` varchar(255) NOT NULL,
  `useridentity` int(11) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO `usertable` VALUES ('admin', '574bbecbb2b183d46cdfb765fd711283', '1', '2021-04-01 17:49:51', '系统管理员', 'https://raw.githubusercontent.com/ww1346never996/ww1346PicForBlog/master/small_20210210112721737.jpeg');
INSERT INTO `usertable` VALUES ('test1', '574bbecbb2b183d46cdfb765fd711283', '2', '2021-04-10 17:06:57', '测试库存管理员', 'https://raw.githubusercontent.com/ww1346never996/ww1346PicForBlog/master/small_20210210112721737.jpeg');
INSERT INTO `usertable` VALUES ('test2', '574bbecbb2b183d46cdfb765fd711283', '3', '2021-04-15 11:35:10', '测试采购管理员', '');
