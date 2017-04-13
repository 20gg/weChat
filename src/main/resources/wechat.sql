/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : wechat

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-04-13 15:44:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(15) DEFAULT NULL,
  `password` char(15) DEFAULT NULL,
  `OBJECT_VERSION_NUMBER` int(11) DEFAULT '-1',
  `REQUEST_ID` int(11) DEFAULT '-1',
  `PROGRAM_ID` int(11) DEFAULT '-1',
  `CREATED_BY` int(11) DEFAULT '-1',
  `CREATION_DATE` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_UPDATED_BY` int(11) DEFAULT '-1',
  `LAST_UPDATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10012 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10000', '张三', '123', '-1', '-1', '-1', null, null, '-1', '2017-04-13 14:42:41');
INSERT INTO `user` VALUES ('10001', '李四', '1234', '-1', '-1', '-1', null, null, '-1', '2017-04-13 14:42:41');
INSERT INTO `user` VALUES ('10004', '阿猫', '123', null, '-1', '-1', null, null, null, null);
INSERT INTO `user` VALUES ('10005', '阿猫', '123', null, '-1', '-1', null, null, null, null);
