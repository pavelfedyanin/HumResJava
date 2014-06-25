/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : humanres

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2014-06-25 21:25:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `departments`
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES ('1', 'Accounting');
INSERT INTO `departments` VALUES ('2', 'Development');
INSERT INTO `departments` VALUES ('3', 'Human Resources');
INSERT INTO `departments` VALUES ('4', 'Support');
INSERT INTO `departments` VALUES ('5', 'Management');

-- ----------------------------
-- Table structure for `employees`
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `birthday` date NOT NULL,
  `passport` varchar(200) NOT NULL,
  `salary` decimal(8,2) NOT NULL,
  `departmentId` int(11) NOT NULL,
  `positionId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('1', 'Pavel Fedynin', '1981-07-14', 'VW 1235678912', '10000.00', '5', '1');
INSERT INTO `employees` VALUES ('2', 'Anonymous', '2014-06-03', 'Multipassport', '7000.00', '5', '2');
INSERT INTO `employees` VALUES ('6', 'John Smith', '1976-10-12', 'MO1231111', '2000.00', '2', '9');
INSERT INTO `employees` VALUES ('8', 'Boris Godunov', '1981-01-01', 'Passport data 111', '1200.00', '1', '6');
INSERT INTO `employees` VALUES ('9', 'Alex Godun', '1981-01-02', '123123123123', '1200.00', '1', '6');
INSERT INTO `employees` VALUES ('10', 'Sergey Mushin', '1976-10-12', 'Multipassport', '1000.00', '1', '12');
INSERT INTO `employees` VALUES ('11', 'Vasiliy Rud', '2014-06-10', 'MD18582448', '3000.00', '2', '7');
INSERT INTO `employees` VALUES ('12', 'Alex Voroshilov', '1977-08-12', 'kk112f23', '900.00', '4', '11');
INSERT INTO `employees` VALUES ('13', 'Nataliya Alex', '1999-01-01', 'fff12334', '300.00', '3', '5');
INSERT INTO `employees` VALUES ('14', 'Fake User', '2014-06-13', '12341234', '4000.00', '3', '4');

-- ----------------------------
-- Table structure for `positions`
-- ----------------------------
DROP TABLE IF EXISTS `positions`;
CREATE TABLE `positions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `minSalary` decimal(8,2) NOT NULL,
  `maxSalary` decimal(8,1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of positions
-- ----------------------------
INSERT INTO `positions` VALUES ('1', 'CEO', '5000.00', '10000.0');
INSERT INTO `positions` VALUES ('2', 'CTO', '4000.00', '8000.0');
INSERT INTO `positions` VALUES ('3', 'Senior Manager', '3000.00', '6000.0');
INSERT INTO `positions` VALUES ('4', 'Manager', '2500.00', '5000.0');
INSERT INTO `positions` VALUES ('5', 'Office Manager', '2000.00', '4000.0');
INSERT INTO `positions` VALUES ('6', 'Accountant', '2500.00', '5000.0');
INSERT INTO `positions` VALUES ('7', 'Project Manager', '2500.00', '5000.0');
INSERT INTO `positions` VALUES ('8', 'Senior Developer', '2500.00', '4000.0');
INSERT INTO `positions` VALUES ('9', 'Developer', '1200.00', '2000.0');
INSERT INTO `positions` VALUES ('10', 'Junior Develeper', '600.00', '8000.0');
INSERT INTO `positions` VALUES ('11', 'Support Operator', '500.00', '700.0');
INSERT INTO `positions` VALUES ('12', 'Cleaner', '200.00', '300.0');
