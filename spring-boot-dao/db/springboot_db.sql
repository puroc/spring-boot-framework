/*
 Navicat Premium Data Transfer

 Source Server         : localhost mysql
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : springboot_db

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 21/09/2018 16:11:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for component
-- ----------------------------
DROP TABLE IF EXISTS `component`;
CREATE TABLE `component` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `component_id` varchar(255) NOT NULL,
  `page_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `attributes` json DEFAULT NULL,
  `codes` json DEFAULT NULL,
  `datas` json DEFAULT NULL,
  `events` json DEFAULT NULL,
  `layout` json DEFAULT NULL,
  `params` json DEFAULT NULL,
  `styles` json DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component
-- ----------------------------
BEGIN;
INSERT INTO `component` VALUES (19, 'preview-main-row', 2, 'preview-main-row', 'srkj-layout', '{\"row\": {\"gutter\": 0}, \"cols\": [{\"id\": \"0\", \"span\": 24}]}', '{}', '{}', '{}', '{\"0\": [{\"componentId\": \"srkj-layout-223\", \"componentType\": \"srkj-layout\"}]}', '{\"componentId\": \"preview-main-row\", \"componentName\": \"preview-main-row\", \"componentType\": \"srkj-layout\"}', '{}');
INSERT INTO `component` VALUES (20, 'srkj-layout-223', 2, 'srkj-layout-223', 'srkj-layout', '{\"row\": {}, \"cols\": [{\"id\": \"0\", \"span\": 12}, {\"id\": \"1\", \"span\": 12}]}', '{}', '{}', '{}', '{\"0\": [{\"componentId\": \"srkj-button-46\", \"componentType\": \"srkj-button\"}], \"1\": [{\"componentId\": \"srkj-button-555\", \"componentType\": \"srkj-button\"}, {\"componentId\": \"srkj-button-520\", \"componentType\": \"srkj-button\"}, {\"componentId\": \"srkj-button-158\", \"componentType\": \"srkj-button\"}]}', '{\"colId\": \"0\", \"rowId\": \"preview-main-row\", \"componentId\": \"srkj-layout-223\", \"componentName\": \"srkj-layout-223\", \"componentType\": \"srkj-layout\"}', '{}');
INSERT INTO `component` VALUES (21, 'srkj-button-46', 2, 'srkj-button-46', 'srkj-button', '{\"name\": \"按钮\", \"size\": \"medium\", \"type\": \"primary\", \"plain\": false, \"nativeType\": \"button\"}', '{}', '{}', '{}', '{}', '{\"colId\": \"0\", \"rowId\": \"srkj-layout-223\", \"componentId\": \"srkj-button-46\", \"componentName\": \"srkj-button-46\", \"componentType\": \"srkj-button\"}', '{}');
INSERT INTO `component` VALUES (22, 'srkj-button-555', 2, 'srkj-button-555', 'srkj-button', '{\"name\": \"按钮\", \"size\": \"medium\", \"type\": \"primary\", \"plain\": false, \"nativeType\": \"button\"}', '{}', '{}', '{}', '{}', '{\"colId\": \"1\", \"rowId\": \"srkj-layout-223\", \"componentId\": \"srkj-button-555\", \"componentName\": \"srkj-button-555\", \"componentType\": \"srkj-button\"}', '{\"top\": \"\", \"left\": \"\", \"clear\": \"\", \"color\": \"\", \"float\": \"\", \"right\": \"\", \"width\": \"\", \"bottom\": \"\", \"height\": \"\", \"margin\": \"\", \"zIndex\": 0, \"display\": \"\", \"padding\": \"\", \"fontSize\": \"\", \"overflow\": \"\", \"position\": \"\", \"fontStyle\": \"\", \"marginTop\": \"\", \"textAlign\": \"\", \"fontFamily\": \"\", \"fontWeight\": \"\", \"lineHeight\": \"\", \"marginLeft\": \"\", \"paddingTop\": \"\", \"textIndent\": \"\", \"visibility\": \"\", \"borderColor\": \"\", \"borderStyle\": \"\", \"borderWidth\": \"\", \"fontVariant\": \"\", \"marginRight\": \"\", \"paddingLeft\": \"\", \"wordSpacing\": \"\", \"marginBottom\": \"\", \"paddingRight\": \"\", \"letterSpacing\": \"\", \"paddingBottom\": \"\", \"textTransform\": \"\", \"verticalAlign\": \"\", \"borderTopColor\": \"\", \"borderTopStyle\": \"\", \"borderTopWidth\": \"\", \"textDecoration\": \"\", \"backgroundColor\": \"\", \"backgroundImage\": \"\", \"borderLeftColor\": \"\", \"borderLeftStyle\": \"\", \"borderLeftWidth\": \"\", \"backgroundRepeat\": \"\", \"borderRightColor\": \"\", \"borderRightStyle\": \"\", \"borderRightWidth\": \"\", \"borderBottomColor\": \"\", \"borderBottomStyle\": \"\", \"borderBottomWidth\": \"\", \"backgroundPosition\": \"\", \"backgroundAttachment\": \"\"}');
INSERT INTO `component` VALUES (23, 'srkj-button-158', 2, 'srkj-button-158', 'srkj-button', '{\"name\": \"按钮\", \"size\": \"medium\", \"type\": \"primary\", \"plain\": false, \"nativeType\": \"button\"}', NULL, '{}', NULL, '{}', '{\"colId\": \"1\", \"rowId\": \"srkj-layout-223\", \"componentId\": \"srkj-button-158\", \"componentName\": \"srkj-button-158\", \"componentType\": \"srkj-button\"}', '{}');
INSERT INTO `component` VALUES (24, 'srkj-button-520', 2, 'srkj-button-520', 'srkj-button', '{\"name\": \"按钮\", \"size\": \"medium\", \"type\": \"primary\", \"plain\": false, \"nativeType\": \"button\"}', '{}', '{}', '{}', '{}', '{\"colId\": \"1\", \"rowId\": \"srkj-layout-223\", \"componentId\": \"srkj-button-520\", \"componentName\": \"srkj-button-520\", \"componentType\": \"srkj-button\"}', '{\"top\": \"\", \"left\": \"\", \"clear\": \"\", \"color\": \"\", \"float\": \"\", \"right\": \"\", \"width\": \"\", \"bottom\": \"\", \"height\": \"\", \"margin\": \"\", \"zIndex\": 0, \"display\": \"\", \"padding\": \"\", \"fontSize\": \"\", \"overflow\": \"\", \"position\": \"\", \"fontStyle\": \"\", \"marginTop\": \"\", \"textAlign\": \"\", \"fontFamily\": \"\", \"fontWeight\": \"\", \"lineHeight\": \"\", \"marginLeft\": \"\", \"paddingTop\": \"\", \"textIndent\": \"\", \"visibility\": \"\", \"borderColor\": \"\", \"borderStyle\": \"\", \"borderWidth\": \"\", \"fontVariant\": \"\", \"marginRight\": \"\", \"paddingLeft\": \"\", \"wordSpacing\": \"\", \"marginBottom\": \"\", \"paddingRight\": \"\", \"letterSpacing\": \"\", \"paddingBottom\": \"\", \"textTransform\": \"\", \"verticalAlign\": \"\", \"borderTopColor\": \"\", \"borderTopStyle\": \"\", \"borderTopWidth\": \"\", \"textDecoration\": \"\", \"backgroundColor\": \"\", \"backgroundImage\": \"\", \"borderLeftColor\": \"\", \"borderLeftStyle\": \"\", \"borderLeftWidth\": \"\", \"backgroundRepeat\": \"\", \"borderRightColor\": \"\", \"borderRightStyle\": \"\", \"borderRightWidth\": \"\", \"borderBottomColor\": \"\", \"borderBottomStyle\": \"\", \"borderBottomWidth\": \"\", \"backgroundPosition\": \"\", \"backgroundAttachment\": \"\"}');
COMMIT;

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of org
-- ----------------------------
BEGIN;
INSERT INTO `org` VALUES (1, '测试科技有限公司', 0, '2018-04-13 10:24:44');
INSERT INTO `org` VALUES (2, '前端开发部', 1, '2018-04-13 10:24:44');
INSERT INTO `org` VALUES (3, '后端开发部', 1, '2018-05-05 23:08:52');
INSERT INTO `org` VALUES (4, '项目开发部', 1, '2018-06-05 17:40:44');
COMMIT;

-- ----------------------------
-- Table structure for page
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `component` varchar(255) NOT NULL,
  `hidden` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='0:不隐藏\n1:隐藏';

-- ----------------------------
-- Records of page
-- ----------------------------
BEGIN;
INSERT INTO `page` VALUES (2, 'a', '/a', '@/views/a', 0, 1, '2018-08-03 16:03:49');
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
INSERT INTO `permission` VALUES (1, '仪表盘', NULL, 'dashboard', 'menu', NULL);
INSERT INTO `permission` VALUES (2, '用户管理', NULL, 'user', 'menu', NULL);
INSERT INTO `permission` VALUES (3, '角色管理', NULL, 'role', 'menu', NULL);
INSERT INTO `permission` VALUES (4, '测试页面', NULL, 'test', 'menu', NULL);
COMMIT;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `desc` varchar(500) DEFAULT NULL,
  `template_id` int(11) NOT NULL,
  `timestamp` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
BEGIN;
INSERT INTO `project` VALUES (1, 'p1', 'p1', 1, '2018-08-03 15:26:34', 1);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `org_id` int(11) NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, '管理员', 1, '2018-04-13 10:24:44');
INSERT INTO `role` VALUES (3, '操作员', 1, '2018-09-20 16:57:21');
COMMIT;

-- ----------------------------
-- Table structure for role_permission_bind
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_bind`;
CREATE TABLE `role_permission_bind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_role_permission_role_id` (`role_id`) USING BTREE,
  KEY `fk_role_permission_permission_id` (`permission_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role_permission_bind
-- ----------------------------
BEGIN;
INSERT INTO `role_permission_bind` VALUES (61, 1, 1);
INSERT INTO `role_permission_bind` VALUES (62, 1, 2);
INSERT INTO `role_permission_bind` VALUES (63, 1, 3);
INSERT INTO `role_permission_bind` VALUES (64, 1, 4);
COMMIT;

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `org_id` int(11) NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'admin', '18840640000', '471049000@qq.com', 1, '2018-04-13 10:24:44');
INSERT INTO `user` VALUES (35, 'suna', 'admin', '孙爱', '13800000001', 'suna@emrubik.com', 1, '2018-06-05 17:42:21');
INSERT INTO `user` VALUES (36, 'zhubz', '123456', '朱柄政', '13900000001', 'zhubz@emrubik.com', 1, '2018-06-05 17:42:45');
INSERT INTO `user` VALUES (38, 'fengj', '123456', '冯建', '13800000001', 'fengj@emrubik.com', 1, '2018-06-05 18:15:46');
INSERT INTO `user` VALUES (39, 'sunch', '123456', '孙长浩', '13800000001', 'sunch@emrubik.com', 1, '2018-06-05 18:16:18');
INSERT INTO `user` VALUES (40, 'niuk', '123456', '牛坤', '13900000001', 'niuk@emrubik.com', 1, '2018-06-05 18:16:50');
INSERT INTO `user` VALUES (41, 'liuqy', '123456', '刘启洋', '13800000001', 'liuqy@emrubik.com', 1, '2018-06-05 18:17:19');
INSERT INTO `user` VALUES (42, 'jinp', '123456', '金鹏', '13900000001', 'jinp@emrubik.com', 1, '2018-06-05 18:17:44');
INSERT INTO `user` VALUES (43, 'wangjh', '123456', '王江欢', '13800000001', 'wangjh@emrubik.com', 1, '2018-06-05 18:24:57');
INSERT INTO `user` VALUES (44, 'maab', '123456', '马奥博', '13800000001', 'maab@emrubik.com', 1, '2018-06-05 18:36:09');
INSERT INTO `user` VALUES (45, 'pud', '123456', '蒲冬', '18840645281', 'pud@emrubik.com', 1, '2018-09-20 15:31:25');
COMMIT;

-- ----------------------------
-- Table structure for user_role_bind
-- ----------------------------
DROP TABLE IF EXISTS `user_role_bind`;
CREATE TABLE `user_role_bind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `org_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_user_role_bind_user_id` (`user_id`) USING BTREE,
  KEY `fk_user_role_bind_role_id` (`role_id`) USING BTREE,
  KEY `fk_user_role_bind_org_id` (`org_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_role_bind
-- ----------------------------
BEGIN;
INSERT INTO `user_role_bind` VALUES (1, 1, 1, 1);
INSERT INTO `user_role_bind` VALUES (2, 45, 1, 1);
INSERT INTO `user_role_bind` VALUES (3, 53, 1, 1);
INSERT INTO `user_role_bind` VALUES (4, 53, 3, 1);
INSERT INTO `user_role_bind` VALUES (5, 54, 1, 1);
INSERT INTO `user_role_bind` VALUES (6, 55, 3, 1);
INSERT INTO `user_role_bind` VALUES (7, 56, 1, 1);
INSERT INTO `user_role_bind` VALUES (8, 57, 1, 1);
INSERT INTO `user_role_bind` VALUES (9, 58, 1, 1);
INSERT INTO `user_role_bind` VALUES (10, 59, 3, 1);
COMMIT;

-- ----------------------------
-- Table structure for user_token_bind
-- ----------------------------
DROP TABLE IF EXISTS `user_token_bind`;
CREATE TABLE `user_token_bind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `expire` int(11) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_token_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_token_bind
-- ----------------------------
BEGIN;
INSERT INTO `user_token_bind` VALUES (18, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1Mzc1NTM0ODk5MTEsInBheWxvYWQiOiJ7XCJ1c2VyTmFtZVwiOlwiYWRtaW5cIixcInVzZXJJZFwiOlwiMVwiLFwiY3VycmVudFRpbWVcIjoxNTM3NTE3NDg5OTExfSJ9.HIT8q8_vr_PSiWdAyaPpmqqeUqjFr7WoyX9Y6esjHqQ', 36000, '2018-09-21 16:11:30');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
