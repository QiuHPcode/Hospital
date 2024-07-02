/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : hos

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 17/06/2024 20:31:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `aid` int NOT NULL AUTO_INCREMENT,
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9002 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (9001, 'admin', '123456');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `did` int NOT NULL AUTO_INCREMENT COMMENT '医生id',
  `dname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '医生姓名',
  `gender` int NULL DEFAULT NULL COMMENT '性别 1男 2女',
  `hid` int NULL DEFAULT NULL COMMENT '院区',
  `specialty` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '专长',
  `pmid` bigint NULL DEFAULT NULL COMMENT '所属部门id',
  `jt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职称',
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (10001, '朱思', 1, 1001, '幼儿感冒、发烧', 2002, '主治医师');
INSERT INTO `doctor` VALUES (10002, '李燕', 2, 1001, '外伤', 2002, ' 主治医师');

-- ----------------------------
-- Table structure for fj
-- ----------------------------
DROP TABLE IF EXISTS `fj`;
CREATE TABLE `fj`  (
  `id` int NOT NULL,
  `uid` int NULL DEFAULT NULL,
  `dd` date NULL DEFAULT NULL COMMENT '封禁日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fj
-- ----------------------------

-- ----------------------------
-- Table structure for hyq
-- ----------------------------
DROP TABLE IF EXISTS `hyq`;
CREATE TABLE `hyq`  (
  `hid` int NOT NULL AUTO_INCREMENT COMMENT '院区id',
  `hname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名字',
  `hloc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '位置',
  `hpo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '图片url',
  `info` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '简介',
  `device` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '设施',
  PRIMARY KEY (`hid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hyq
-- ----------------------------
INSERT INTO `hyq` VALUES (1001, '江苏省中医院', '江苏省南京市 秦淮区 汉中路 155号', 'D:/ylzhfwxx/hos/src/main/resources/hyqimg/center1.jpg', '江苏省中医院（南京中医药大学附属医院）位于江苏省南京市秦淮区汉中路155号，始建于1954年10月，是一所集医疗、康复、教学、科研于一体的三级甲等中医院，是南京市医保和新农合定点医院。2020年11月，被评为江苏省抗击新冠肺炎疫情先进集体。', '医院编制病床2500张，配有包括磁共振、全身螺旋CT、数字DR、直线加速器、美国飞利浦公司SKYLIGHT双探头SPECT、全激光飞秒、高端体外碎石机、数字化钼靶及胃肠机、大平板数字血管造影（DSA）成像仪、生化分析仪、化学发光仪、全自动酶免分析仪、实时荧光定量PCR仪、流式细胞仪、全自动细菌鉴定仪、血培养仪、五分类血细胞分析仪、尿沉渣分析仪等医疗设施。');
INSERT INTO `hyq` VALUES (1002, '江苏省中医院紫东院区', '江苏省南京市 栖霞区 仙林大道 200号', 'D:/ylzhfwxx/hos/src/main/resources/hyqimg/center2.jpg', '2022年2月22日，位于栖霞区仙林大道200号（仙林万达茂对面）江苏省中医院（南京中医药大学附属医院）紫东院区全面启用。', '紫东院区配备达芬奇手术机器人、PET-CT、直线加速器、后装治疗机、彩超、生化免疫流水线、核磁、CT、DSA等设备；设有杂交手术室、数字化手术间。设有ICU、日间病房、麻醉科、手术室、营养科，舒适化、人性化、智能化是紫东院区病区的共同特点，从病房的布局到中央空调、数字电视、淋浴间的配备，从以暖色调设计建设病区再到为住院患者准备公共休闲区等，这一切都能让患者感受到在这里住院治疗用心、服务贴心、环境舒心。');

-- ----------------------------
-- Table structure for pm
-- ----------------------------
DROP TABLE IF EXISTS `pm`;
CREATE TABLE `pm`  (
  `pmid` int NOT NULL AUTO_INCREMENT COMMENT '部门Id',
  `pname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门名称',
  `hid` int NULL DEFAULT NULL COMMENT '所属院区',
  PRIMARY KEY (`pmid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2009 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pm
-- ----------------------------
INSERT INTO `pm` VALUES (2001, '儿科', 1001);
INSERT INTO `pm` VALUES (2002, '外科', 1001);
INSERT INTO `pm` VALUES (2003, '内科', 1001);
INSERT INTO `pm` VALUES (2004, '儿科', 1002);
INSERT INTO `pm` VALUES (2005, '外科', 1002);
INSERT INTO `pm` VALUES (2006, '内科', 1002);
INSERT INTO `pm` VALUES (2007, '神经科', 1001);
INSERT INTO `pm` VALUES (2008, '内分泌科', 1001);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` int NULL DEFAULT NULL COMMENT '性别',
  `iden` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `ph` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码也是登录账号',
  `pw` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `score` int NULL DEFAULT NULL COMMENT '信用分',
  `md` int NULL DEFAULT NULL COMMENT '0封禁,1授权',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1010 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1001, '王二', 1, '371524200312022021', '12345678910', '123456', 60, 1);
INSERT INTO `user` VALUES (1002, '李四', 2, '321548200310215201', '13354788521', '666666', 100, 1);

-- ----------------------------
-- Table structure for yycount
-- ----------------------------
DROP TABLE IF EXISTS `yycount`;
CREATE TABLE `yycount`  (
  `yyid` int NOT NULL AUTO_INCREMENT COMMENT '可预约预约id',
  `did` int NULL DEFAULT NULL COMMENT '医生id',
  `daytime` date NULL DEFAULT NULL COMMENT '可预约时间',
  `infotime` int NULL DEFAULT NULL COMMENT '1上午或2下午',
  `people` int NULL DEFAULT NULL COMMENT '可预约人数',
  PRIMARY KEY (`yyid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40014 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yycount
-- ----------------------------
INSERT INTO `yycount` VALUES (40001, 10001, '2024-06-07', 1, 5);
INSERT INTO `yycount` VALUES (40002, 10001, '2024-06-08', 1, 1);
INSERT INTO `yycount` VALUES (40003, 10001, '2024-06-09', 1, 6);
INSERT INTO `yycount` VALUES (40004, 10002, '2024-06-07', 1, 8);
INSERT INTO `yycount` VALUES (40005, 10002, '2024-06-09', 1, 4);
INSERT INTO `yycount` VALUES (40006, 10001, '2024-06-07', 2, 2);
INSERT INTO `yycount` VALUES (40007, 10001, '2024-06-08', 2, 2);
INSERT INTO `yycount` VALUES (40008, 10001, '2024-06-09', 2, 5);
INSERT INTO `yycount` VALUES (40009, 10002, '2024-06-07', 2, 2);
INSERT INTO `yycount` VALUES (40010, 10002, '2024-06-09', 2, 6);
INSERT INTO `yycount` VALUES (40011, 10001, '2024-06-11', 1, 5);
INSERT INTO `yycount` VALUES (40012, 10001, '2024-06-11', 2, 4);
INSERT INTO `yycount` VALUES (40013, 10001, '2024-06-12', 1, 4);

-- ----------------------------
-- Table structure for yyrecord
-- ----------------------------
DROP TABLE IF EXISTS `yyrecord`;
CREATE TABLE `yyrecord`  (
  `yid` int NOT NULL AUTO_INCREMENT COMMENT '预约单id',
  `uid` int NULL DEFAULT NULL COMMENT '用户id',
  `did` int NULL DEFAULT NULL COMMENT '医生id',
  `daytime` date NULL DEFAULT NULL COMMENT '预约日期',
  `infotime` int NULL DEFAULT NULL COMMENT '具体时间段(1上午/2下午)',
  `yon` int NULL DEFAULT NULL COMMENT '是否完成预约(1完成 2 违约 3 待完成 4想取消 5 已取消)',
  `canceltext` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '取消理由信息',
  `sc` int NULL DEFAULT NULL COMMENT '完成后/违约加分或减分记录',
  PRIMARY KEY (`yid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 600023 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yyrecord
-- ----------------------------
INSERT INTO `yyrecord` VALUES (600001, 1001, 10001, '2024-06-03', 1, 3, NULL, -10);
INSERT INTO `yyrecord` VALUES (600002, 1001, 10002, '2024-06-04', 2, 3, NULL, -10);
INSERT INTO `yyrecord` VALUES (600019, 1001, 10001, '2024-06-08', 1, 3, '', 0);
INSERT INTO `yyrecord` VALUES (600020, 1001, 10001, '2024-06-11', 2, 4, '有事', 0);
INSERT INTO `yyrecord` VALUES (600021, 1001, 10001, '2024-06-11', 2, 2, NULL, -10);
INSERT INTO `yyrecord` VALUES (600022, 1001, 10001, '2024-06-11', 1, 3, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
