/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : job

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 04/04/2019 18:24:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basedict
-- ----------------------------
DROP TABLE IF EXISTS `basedict`;
CREATE TABLE `basedict`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典id(主键)',
  `type_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典类别代码',
  `type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典类别名称',
  `item_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据字典项目名称',
  `item_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据字典项目代码(可为空)',
  `sort` int(10) NULL DEFAULT NULL COMMENT '排序字段',
  `enable` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1:使用 0:停用',
  `memo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basedict
-- ----------------------------
INSERT INTO `basedict` VALUES ('1', '001', '客户行业', '教育培训 ', NULL, 1, '1', NULL);
INSERT INTO `basedict` VALUES ('10', '003', '公司性质', '民企', NULL, 3, '1', NULL);
INSERT INTO `basedict` VALUES ('12', '004', '年营业额', '1-10万', NULL, 1, '1', NULL);
INSERT INTO `basedict` VALUES ('13', '004', '年营业额', '10-20万', NULL, 2, '1', NULL);
INSERT INTO `basedict` VALUES ('14', '004', '年营业额', '20-50万', NULL, 3, '1', NULL);
INSERT INTO `basedict` VALUES ('15', '004', '年营业额', '50-100万', NULL, 4, '1', NULL);
INSERT INTO `basedict` VALUES ('16', '004', '年营业额', '100-500万', NULL, 5, '1', NULL);
INSERT INTO `basedict` VALUES ('17', '004', '年营业额', '500-1000万', NULL, 6, '1', NULL);
INSERT INTO `basedict` VALUES ('18', '005', '客户状态', '基础客户', NULL, 1, '1', NULL);
INSERT INTO `basedict` VALUES ('19', '005', '客户状态', '潜在客户', NULL, 2, '1', NULL);
INSERT INTO `basedict` VALUES ('2', '001', '客户行业', '电子商务', NULL, 2, '1', NULL);
INSERT INTO `basedict` VALUES ('20', '005', '客户状态', '成功客户', NULL, 3, '1', NULL);
INSERT INTO `basedict` VALUES ('21', '005', '客户状态', '无效客户', NULL, 4, '1', NULL);
INSERT INTO `basedict` VALUES ('22', '006', '客户级别', '普通客户', NULL, 1, '1', NULL);
INSERT INTO `basedict` VALUES ('23', '006', '客户级别', 'VIP客户', NULL, 2, '1', NULL);
INSERT INTO `basedict` VALUES ('24', '007', '商机状态', '意向客户', NULL, 1, '1', NULL);
INSERT INTO `basedict` VALUES ('25', '007', '商机状态', '初步沟通', NULL, 2, '1', NULL);
INSERT INTO `basedict` VALUES ('26', '007', '商机状态', '深度沟通', NULL, 3, '1', NULL);
INSERT INTO `basedict` VALUES ('27', '007', '商机状态', '签订合同', NULL, 4, '1', NULL);
INSERT INTO `basedict` VALUES ('3', '001', '客户行业', '对外贸易', NULL, 3, '1', NULL);
INSERT INTO `basedict` VALUES ('30', '008', '商机类型', '新业务', NULL, 1, '1', NULL);
INSERT INTO `basedict` VALUES ('31', '008', '商机类型', '现有业务', NULL, 2, '1', NULL);
INSERT INTO `basedict` VALUES ('32', '009', '商机来源', '电话营销', NULL, 1, '1', NULL);
INSERT INTO `basedict` VALUES ('33', '009', '商机来源', '网络营销', NULL, 2, '1', NULL);
INSERT INTO `basedict` VALUES ('34', '009', '商机来源', '推广活动', NULL, 3, '1', NULL);
INSERT INTO `basedict` VALUES ('4', '001', '客户行业', '酒店旅游', NULL, 4, '1', NULL);
INSERT INTO `basedict` VALUES ('5', '001', '客户行业', '房地产', NULL, 5, '1', NULL);
INSERT INTO `basedict` VALUES ('6', '002', '客户信息来源', '电话营销', NULL, 1, '1', NULL);
INSERT INTO `basedict` VALUES ('7', '002', '客户信息来源', '网络营销', NULL, 2, '1', NULL);
INSERT INTO `basedict` VALUES ('8', '003', '公司性质', '合资', NULL, 1, '1', NULL);
INSERT INTO `basedict` VALUES ('9', '003', '公司性质', '国企', NULL, 2, '1', NULL);

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行业',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司地址',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司名称',
  `scale` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_deleted` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employment
-- ----------------------------
DROP TABLE IF EXISTS `employment`;
CREATE TABLE `employment`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `entry_time` datetime(0) NULL DEFAULT NULL COMMENT '入职时间',
  `job_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作岗位',
  `salary_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '薪资等级',
  `company_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `be_deleted` bit(1) NOT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK3u9c49adog6ox1epg2pb76fn`(`company_id`) USING BTREE,
  INDEX `FKgchq0bqxu8gx55ttycifquiv6`(`student_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKpu4in3tmn3k7jpmm7mnx9ittk`(`create_user_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleid` int(11) NULL DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '/readName', 1, '查看名单');
INSERT INTO `permission` VALUES (2, '/readData', 2, '查看数据');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', '管理员');
INSERT INTO `role` VALUES (2, '普通用户', '普通用户');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `admission_time` datetime(0) NULL DEFAULT NULL COMMENT '入学时间',
  `birthday` datetime(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employment_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `be_deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK1lxshmivmhrmu58ti3qvo0s01`(`employment_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '123', '123', '123', '1');
INSERT INTO `user` VALUES (2, '1234', '1234', '124', '1');

-- ----------------------------
-- Table structure for user_customer
-- ----------------------------
DROP TABLE IF EXISTS `user_customer`;
CREATE TABLE `user_customer`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户名称',
  `user_id` int(32) NULL DEFAULT NULL COMMENT '负责人id',
  `create_id` int(32) NULL DEFAULT NULL COMMENT '创建人id',
  `source` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户信息来源',
  `industry` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户所属行业',
  `level` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户级别',
  `linkman` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固定电话',
  `mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动电话',
  `zipcode` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 179 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_customer
-- ----------------------------
INSERT INTO `user_customer` VALUES (15, '小韩1', NULL, 2, '7', '3', '23', '小雪1', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:01');
INSERT INTO `user_customer` VALUES (16, '小李', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:01');
INSERT INTO `user_customer` VALUES (17, '小赵', NULL, 4, '6', '4', '23', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:02');
INSERT INTO `user_customer` VALUES (22, '小明', NULL, 3, '6', '2', '23', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:03');
INSERT INTO `user_customer` VALUES (24, '小伟', NULL, 2, '7', '5', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:03');
INSERT INTO `user_customer` VALUES (25, 'Tom', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:03');
INSERT INTO `user_customer` VALUES (26, 'jack', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:03');
INSERT INTO `user_customer` VALUES (28, 'Rose', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:04');
INSERT INTO `user_customer` VALUES (29, '小韩', NULL, 1, '7', '1', '23', '小雪', '010-88888886', '13888888886', '100096', '北京昌平区西三旗', '2016-04-08 16:32:04');
INSERT INTO `user_customer` VALUES (30, '小叶', NULL, 2, '6', '2', '23', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:04');
INSERT INTO `user_customer` VALUES (31, '小韩', NULL, 4, '7', '1', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:04');
INSERT INTO `user_customer` VALUES (33, '小海', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:04');
INSERT INTO `user_customer` VALUES (34, '小韩', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:05');
INSERT INTO `user_customer` VALUES (35, '小姜', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:05');
INSERT INTO `user_customer` VALUES (36, '小韩', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:05');
INSERT INTO `user_customer` VALUES (37, '小梦', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:05');
INSERT INTO `user_customer` VALUES (38, '小孙', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:05');
INSERT INTO `user_customer` VALUES (39, '小韩', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:06');
INSERT INTO `user_customer` VALUES (40, '小韩', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:06');
INSERT INTO `user_customer` VALUES (41, '小韩', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:06');
INSERT INTO `user_customer` VALUES (42, '小韩', NULL, 1, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:06');
INSERT INTO `user_customer` VALUES (43, '小韩', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:06');
INSERT INTO `user_customer` VALUES (44, '小韩', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:07');
INSERT INTO `user_customer` VALUES (45, '小韩', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:07');
INSERT INTO `user_customer` VALUES (46, '小韩', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:07');
INSERT INTO `user_customer` VALUES (47, '小韩', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:07');
INSERT INTO `user_customer` VALUES (48, '小高', NULL, 5, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:07');
INSERT INTO `user_customer` VALUES (49, '小韩', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:07');
INSERT INTO `user_customer` VALUES (50, '小钱', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:08');
INSERT INTO `user_customer` VALUES (51, '小韩', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:08');
INSERT INTO `user_customer` VALUES (52, '小周', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:08');
INSERT INTO `user_customer` VALUES (53, '小韩', NULL, 1, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:08');
INSERT INTO `user_customer` VALUES (54, '小丽', NULL, 1, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:08');
INSERT INTO `user_customer` VALUES (55, '小韩', NULL, 1, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:08');
INSERT INTO `user_customer` VALUES (56, '小韩', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:09');
INSERT INTO `user_customer` VALUES (57, '小韩', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:09');
INSERT INTO `user_customer` VALUES (58, '张三', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:09');
INSERT INTO `user_customer` VALUES (59, '李四', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:29');
INSERT INTO `user_customer` VALUES (60, '小韩', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:29');
INSERT INTO `user_customer` VALUES (61, '小韩', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:29');
INSERT INTO `user_customer` VALUES (62, '小韩', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:29');
INSERT INTO `user_customer` VALUES (63, '小韩', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:30');
INSERT INTO `user_customer` VALUES (64, '小韩', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:30');
INSERT INTO `user_customer` VALUES (65, '王五', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:30');
INSERT INTO `user_customer` VALUES (66, '小韩', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:30');
INSERT INTO `user_customer` VALUES (67, '小韩', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:30');
INSERT INTO `user_customer` VALUES (68, '赵六', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:30');
INSERT INTO `user_customer` VALUES (69, '小韩', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:31');
INSERT INTO `user_customer` VALUES (70, '小韩', NULL, 1, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:31');
INSERT INTO `user_customer` VALUES (71, '小韩', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:31');
INSERT INTO `user_customer` VALUES (72, '小韩', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:31');
INSERT INTO `user_customer` VALUES (73, '小七', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:31');
INSERT INTO `user_customer` VALUES (74, '小韩', NULL, 4, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:32');
INSERT INTO `user_customer` VALUES (75, '小韩', NULL, 3, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:32');
INSERT INTO `user_customer` VALUES (76, '小韩', NULL, 2, '6', '2', '22', '小雪', '010-88888887', '13888888888', '100096', '北京昌平区西三旗', '2016-04-08 16:32:32');
INSERT INTO `user_customer` VALUES (178, 'test', NULL, 1, '6', '1', '22', 'zhao', '186569615365', '', '', '', '2018-05-29 10:42:52');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
