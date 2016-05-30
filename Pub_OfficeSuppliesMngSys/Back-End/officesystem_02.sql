/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : officesystem

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-05-29 22:01:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_background_categories_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_background_categories_menu`;
CREATE TABLE `t_background_categories_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '菜单名称',
  `target_url` varchar(255) NOT NULL COMMENT '目标页面url',
  `permission_id` bigint(20) NOT NULL COMMENT '所需权限id',
  `parent_id` bigint(20) NOT NULL COMMENT '父菜单id',
  `children_ids` varchar(255) NOT NULL COMMENT '子菜单id串',
  `is_valid` smallint(6) NOT NULL COMMENT '是否可用（0:不可用；1：可用）',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_background_categories_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `t_borrow_apply`
-- ----------------------------
DROP TABLE IF EXISTS `t_borrow_apply`;
CREATE TABLE `t_borrow_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_id` varchar(255) DEFAULT NULL COMMENT '物品编号（系统已有）',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称（如果领用的物品是系统中没有的，则只有该字段和物品分类）',
  `item_type_id` int(100) NOT NULL COMMENT '物品分类id',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `borrow_num` bigint(11) DEFAULT NULL COMMENT '借用数量（填写）',
  `price` double DEFAULT NULL COMMENT '单价（系统已有）',
  `monney` double DEFAULT NULL COMMENT '金额（系统已有）',
  `borrow_time` datetime DEFAULT NULL COMMENT '借用时间',
  `borrow_department_id` int(11) NOT NULL COMMENT '借用部门',
  `borrower` bigint(20) NOT NULL COMMENT '借用人',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `auditor` bigint(20) DEFAULT NULL COMMENT '审核人',
  `state` smallint(6) NOT NULL COMMENT '状态（1待审核，2审核通过，3，审核不通过）',
  `is_return` smallint(6) NOT NULL COMMENT '是否归还(-1:为未借出，0：待归还，1：已归还)',
  `return_time` datetime DEFAULT NULL COMMENT '归还时间',
  `is_display` smallint(6) NOT NULL COMMENT '是否显示',
  `is_valid` smallint(6) NOT NULL COMMENT '是否有效（超过一定时间就置为0无效）',
  `apply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reason` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_borrow_apply
-- ----------------------------
INSERT INTO `t_borrow_apply` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '2016-03-03 17:20:57', '1', '1', '2016-05-13 17:21:09', '1', '1', '1', null, '1', '1', '2016-03-15 18:18:18', '111', null);

-- ----------------------------
-- Table structure for `t_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '部门名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '111', '1');

-- ----------------------------
-- Table structure for `t_department_recipient_summary`
-- ----------------------------
DROP TABLE IF EXISTS `t_department_recipient_summary`;
CREATE TABLE `t_department_recipient_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `department_id` int(11) NOT NULL COMMENT '领用部门id',
  `out_storage_check_in_id` bigint(20) NOT NULL COMMENT '登记编号(出库)',
  `item_id` varchar(255) NOT NULL COMMENT '物品编号',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `item_type_id` int(11) NOT NULL,
  `measure_unit_id` int(100) NOT NULL COMMENT '单位',
  `price` double NOT NULL COMMENT '单价',
  `number` int(11) NOT NULL COMMENT '数量',
  `monney` double NOT NULL COMMENT '金额',
  `out_storage_id` int(100) NOT NULL COMMENT '出库类型id(借用还是领用)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department_recipient_summary
-- ----------------------------

-- ----------------------------
-- Table structure for `t_in_storage_check_in`
-- ----------------------------
DROP TABLE IF EXISTS `t_in_storage_check_in`;
CREATE TABLE `t_in_storage_check_in` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `in_storage_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '入库日期',
  `in_storage_type_id` int(100) NOT NULL COMMENT '入库类型id',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商id',
  `agent_id` bigint(20) NOT NULL COMMENT '经办人(员工id)',
  `operater_id` bigint(20) NOT NULL COMMENT '制单人（操作员）',
  `item_procurement_id` bigint(255) NOT NULL COMMENT '物品清单--采购清单',
  `total_number` bigint(20) NOT NULL COMMENT '合计数量',
  `total_monney` double NOT NULL COMMENT '合计金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_in_storage_check_in
-- ----------------------------
INSERT INTO `t_in_storage_check_in` VALUES ('2', '2016-05-15 13:18:52', '3', '-1', '-1', '1', '-1', '10', '0', '备注');
INSERT INTO `t_in_storage_check_in` VALUES ('3', '2016-05-15 13:53:55', '3', '-1', '-1', '1', '-1', '10', '0', '备注');
INSERT INTO `t_in_storage_check_in` VALUES ('4', '2016-05-15 17:01:00', '1', '1', '1', '1', '1', '1', '1', null);
INSERT INTO `t_in_storage_check_in` VALUES ('5', '2016-05-15 18:18:31', '2', '111', '1', '1', '1', '1', '1', null);
INSERT INTO `t_in_storage_check_in` VALUES ('6', '2016-05-16 10:45:50', '2', '111', '1', '1', '1', '1', '1', null);
INSERT INTO `t_in_storage_check_in` VALUES ('7', '2016-05-16 10:51:35', '2', '111', '1', '1', '1', '1', '1', null);
INSERT INTO `t_in_storage_check_in` VALUES ('8', '2016-05-29 11:50:44', '3', '-1', '-1', '1', '-1', '10', '0', '备注');

-- ----------------------------
-- Table structure for `t_in_storage_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_in_storage_type`;
CREATE TABLE `t_in_storage_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_in_storage_type
-- ----------------------------
INSERT INTO `t_in_storage_type` VALUES ('1', '采购', null);
INSERT INTO `t_in_storage_type` VALUES ('2', '归还', null);
INSERT INTO `t_in_storage_type` VALUES ('3', '受赠', null);

-- ----------------------------
-- Table structure for `t_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item` (
  `item_id` varchar(255) NOT NULL COMMENT 'id',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `item_type_id` int(100) NOT NULL COMMENT '物品分类id',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `measure_unit_id` varchar(100) NOT NULL COMMENT '单位',
  `max_inventory` int(11) NOT NULL COMMENT '库存上限',
  `min_inventory` int(11) NOT NULL COMMENT '库存下限',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商id',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_item
-- ----------------------------
INSERT INTO `t_item` VALUES ('1', '物品名称', '1', '规格型号', '1', '50', '10', '-1', '备注');
INSERT INTO `t_item` VALUES ('it001605150001', '物品名称', '1', '规格型号', '1', '50', '10', '-1', '备注');
INSERT INTO `t_item` VALUES ('it001605290000', '物品名称', '1', '规格型号', '1', '50', '10', '-1', '备注');

-- ----------------------------
-- Table structure for `t_item_classification_summary`
-- ----------------------------
DROP TABLE IF EXISTS `t_item_classification_summary`;
CREATE TABLE `t_item_classification_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_id` varchar(255) NOT NULL COMMENT '物品编号',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `item_type_id` varchar(100) NOT NULL COMMENT '物品分类',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `measure_unit_id` varchar(100) NOT NULL COMMENT '单位id',
  `price` double NOT NULL COMMENT '单价（如果下次录入的单价不一样，还是再生成一条记录）',
  `inventory` bigint(20) NOT NULL COMMENT '库存数量',
  `inventory_monney` double NOT NULL COMMENT '库存金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_item_classification_summary
-- ----------------------------
INSERT INTO `t_item_classification_summary` VALUES ('1', 'it001605150000', '物品名称', '1', '规格型号', '1', '0', '10', '0', null);
INSERT INTO `t_item_classification_summary` VALUES ('2', 'it001605150001', '物品名称', '1', '规格型号', '1', '0', '10', '0', null);
INSERT INTO `t_item_classification_summary` VALUES ('3', 'it001605290000', '物品名称', '1', '规格型号', '1', '0', '10', '0', null);

-- ----------------------------
-- Table structure for `t_item_procurement`
-- ----------------------------
DROP TABLE IF EXISTS `t_item_procurement`;
CREATE TABLE `t_item_procurement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_id` varchar(255) NOT NULL COMMENT '物品编号（系统已有）',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商id（选一下或添加一下）',
  `staff_id` bigint(20) NOT NULL COMMENT '采购人员',
  `num` bigint(20) NOT NULL COMMENT '采购数量',
  `item_type_id` varchar(100) NOT NULL COMMENT '物品分类',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `measure_unit_id` int(11) NOT NULL COMMENT '计量单位id',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `price` double NOT NULL COMMENT '单价（不管有没有都让它填）',
  `monney` double NOT NULL COMMENT '金额',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_time` datetime DEFAULT NULL COMMENT '采购完成时间即入库时间',
  `is_in_storage` smallint(6) NOT NULL COMMENT '是否已被登记入库(0,1)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_item_procurement
-- ----------------------------
INSERT INTO `t_item_procurement` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2016-05-29 11:35:36', null, '0', null);

-- ----------------------------
-- Table structure for `t_item_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_item_type`;
CREATE TABLE `t_item_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_item_type
-- ----------------------------
INSERT INTO `t_item_type` VALUES ('1', '纸', null);

-- ----------------------------
-- Table structure for `t_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `department_id` bigint(20) NOT NULL COMMENT '部门id',
  `staff_id` bigint(100) NOT NULL COMMENT '员工id',
  `staff_role` smallint(6) DEFAULT NULL COMMENT '员工角色',
  `staff_name` varchar(100) NOT NULL COMMENT '员工姓名',
  `computer_name` varchar(100) NOT NULL COMMENT '电脑名字',
  `computer_ip` varchar(100) NOT NULL COMMENT '电脑ip',
  `oper_detail` varchar(255) NOT NULL COMMENT '操作详情',
  `oper_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_measure_unit`
-- ----------------------------
DROP TABLE IF EXISTS `t_measure_unit`;
CREATE TABLE `t_measure_unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_measure_unit
-- ----------------------------
INSERT INTO `t_measure_unit` VALUES ('1', '箱', '24/箱');

-- ----------------------------
-- Table structure for `t_merchants_availability_summary`
-- ----------------------------
DROP TABLE IF EXISTS `t_merchants_availability_summary`;
CREATE TABLE `t_merchants_availability_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商id',
  `in_storage_check_in_id` bigint(20) NOT NULL COMMENT '登记编号',
  `item_id` varchar(255) NOT NULL COMMENT '物品编号',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `item_type_id` int(11) NOT NULL,
  `measure_unit_id` varchar(100) NOT NULL COMMENT '单位',
  `price` double NOT NULL COMMENT '单价',
  `num` bigint(20) NOT NULL COMMENT '数量',
  `monney` double NOT NULL COMMENT '金额',
  `remark` varchar(0) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_merchants_availability_summary
-- ----------------------------

-- ----------------------------
-- Table structure for `t_out_storage_check_in`
-- ----------------------------
DROP TABLE IF EXISTS `t_out_storage_check_in`;
CREATE TABLE `t_out_storage_check_in` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `out_storage_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '出库日期',
  `out_storage_type_id` int(100) NOT NULL COMMENT '出库类型id',
  `recipienter` bigint(20) NOT NULL COMMENT '领用人id',
  `department_id` int(11) NOT NULL COMMENT '领用部门id',
  `operater_id` bigint(20) NOT NULL COMMENT '制单人（操作员）',
  `apply_id` varchar(255) NOT NULL COMMENT '物品清单--领用申请或借用申请（可以批量出库）',
  `total_number` bigint(20) NOT NULL COMMENT '合计数量',
  `total_monney` double NOT NULL COMMENT '合计金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_out_storage_check_in
-- ----------------------------

-- ----------------------------
-- Table structure for `t_out_storage_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_out_storage_type`;
CREATE TABLE `t_out_storage_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_out_storage_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '权限名称',
  `description` varchar(255) NOT NULL COMMENT '权限描述',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `t_pre_item_procurement`
-- ----------------------------
DROP TABLE IF EXISTS `t_pre_item_procurement`;
CREATE TABLE `t_pre_item_procurement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_id` varchar(255) DEFAULT NULL COMMENT '物品编号',
  `item_type_id` bigint(100) NOT NULL COMMENT '物品分类id',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `measure_unit_id` int(11) NOT NULL COMMENT '计量单位id',
  `num` bigint(20) NOT NULL COMMENT '采购数量',
  `staff_id` bigint(20) DEFAULT NULL COMMENT '审核人',
  `pre_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预采购生成时间',
  `audit_time` datetime(6) DEFAULT NULL COMMENT '审核时间（audit_time为空则就是未已到采购单）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pre_item_procurement
-- ----------------------------
INSERT INTO `t_pre_item_procurement` VALUES ('1', '1', '1', '物品名称', '0', '1', '1', '2016-05-16 11:42:56', null, '备注');
INSERT INTO `t_pre_item_procurement` VALUES ('2', '1', '1', '物品名称', '1', '1', '1', '2016-05-29 16:02:57', null, '备注');

-- ----------------------------
-- Table structure for `t_procurement_apply`
-- ----------------------------
DROP TABLE IF EXISTS `t_procurement_apply`;
CREATE TABLE `t_procurement_apply` (
  `id` bigint(20) NOT NULL,
  `item_type_id` int(11) NOT NULL COMMENT '物品类型id',
  `staff_id` bigint(255) NOT NULL COMMENT '员工id',
  `item_name` bigint(20) NOT NULL COMMENT '物品名称',
  `item_id` bigint(20) DEFAULT NULL COMMENT '物品编号',
  `spec` varchar(255) DEFAULT NULL,
  `num` int(11) NOT NULL COMMENT '采购申请数额',
  `apply_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_staff_id` bigint(20) NOT NULL COMMENT '审核员工工号',
  `measure_unit_id` smallint(6) NOT NULL,
  `is_procurement` smallint(6) NOT NULL COMMENT '是否采购',
  `is_display` smallint(6) NOT NULL COMMENT '是否显示',
  `reason` varchar(255) DEFAULT NULL COMMENT '原因',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_procurement_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `t_recipient_apply`
-- ----------------------------
DROP TABLE IF EXISTS `t_recipient_apply`;
CREATE TABLE `t_recipient_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称（如果领用的物品是系统中没有的，则只有该字段和物品分类）',
  `item_type_id` int(100) NOT NULL COMMENT '物品分类',
  `recipient_num` int(11) DEFAULT NULL COMMENT '领用数量',
  `item_id` varchar(255) DEFAULT NULL COMMENT '物品编号（系统已有）',
  `spec` varchar(255) DEFAULT NULL COMMENT '规格型号（系统已有）',
  `price` double DEFAULT NULL COMMENT '单价（系统已有）',
  `monney` double DEFAULT NULL COMMENT '金额（系统已有）',
  `recipient_department_id` int(11) NOT NULL COMMENT '领用部门',
  `recipienter` bigint(20) NOT NULL COMMENT '领用人',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `auditor` bigint(20) DEFAULT NULL COMMENT '审核人',
  `recipient_time` datetime DEFAULT NULL COMMENT '领用时间',
  `apply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `state` smallint(6) NOT NULL COMMENT '状态（1待审核，2审核通过，3，审核不通过）',
  `is_display` smallint(6) NOT NULL COMMENT '是否显示',
  `is_valid` smallint(6) NOT NULL COMMENT '是否有效',
  `reason` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_recipient_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `t_staff`
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `staff_name` varchar(100) NOT NULL COMMENT '姓名',
  `department_id` int(11) NOT NULL COMMENT '部门编号',
  `cell_phone_number` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `phone` varchar(12) DEFAULT NULL COMMENT '联系电话',
  `Email` varchar(50) DEFAULT NULL COMMENT 'Email',
  `sex` varchar(10) NOT NULL COMMENT '性别',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `address` varchar(255) DEFAULT NULL COMMENT '家庭地址',
  `birthday` date NOT NULL COMMENT '出生年月',
  `graduate_school` varchar(100) DEFAULT NULL COMMENT '毕业院校',
  `highest_record` varchar(100) NOT NULL COMMENT '最高学历',
  `role` int(11) DEFAULT NULL COMMENT '角色',
  `salt` varchar(50) DEFAULT NULL,
  `is_working` smallint(6) NOT NULL COMMENT '在职状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_staff
-- ----------------------------
INSERT INTO `t_staff` VALUES ('1', '余晓明', '1', '1', '1', '1', '1', '1', '1', '2016-05-15', '1', '1', '1', null, '1', null);

-- ----------------------------
-- Table structure for `t_staff_recipient_summary`
-- ----------------------------
DROP TABLE IF EXISTS `t_staff_recipient_summary`;
CREATE TABLE `t_staff_recipient_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `staff_id` bigint(20) NOT NULL COMMENT '领用人id',
  `out_storage_check_in_id` bigint(20) NOT NULL COMMENT '登记编号(出库)',
  `item_id` varchar(255) NOT NULL COMMENT '物品编号',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `item_type_id` int(11) DEFAULT NULL,
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `measure_unit_id` varchar(100) NOT NULL COMMENT '单位',
  `price` double NOT NULL COMMENT '单价',
  `number` int(11) NOT NULL COMMENT '数量',
  `monney` double NOT NULL COMMENT '金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_staff_recipient_summary
-- ----------------------------

-- ----------------------------
-- Table structure for `t_staff_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_staff_role`;
CREATE TABLE `t_staff_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `description` varchar(255) NOT NULL COMMENT '角色描述',
  `permissions` varchar(255) DEFAULT NULL COMMENT '权限清单',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_staff_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier`;
CREATE TABLE `t_supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `full_name` varchar(255) NOT NULL COMMENT '供应商全称',
  `short_name` varchar(100) NOT NULL COMMENT '供应商简称',
  `supplier_type_id` varchar(100) NOT NULL COMMENT '供应商类型',
  `linkman` varchar(100) NOT NULL COMMENT '联系人',
  `cell_phone_number` varchar(11) NOT NULL COMMENT '手机号码',
  `phone` varchar(12) DEFAULT NULL COMMENT '联系电话',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `postcode` varchar(6) DEFAULT NULL COMMENT '邮编',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `is_valid` smallint(6) NOT NULL COMMENT '是否有效',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_supplier
-- ----------------------------
INSERT INTO `t_supplier` VALUES ('1', '1', '1', '1', '1', '1', '1', null, '1', '1', '1', null);

-- ----------------------------
-- Table structure for `t_supplier_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier_type`;
CREATE TABLE `t_supplier_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_supplier_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_table_key`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_table_key`;
CREATE TABLE `t_sys_table_key` (
  `table_name` varchar(100) NOT NULL COMMENT '表名',
  `table_key` varchar(100) NOT NULL COMMENT '该表最新主键',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_table_key
-- ----------------------------
INSERT INTO `t_sys_table_key` VALUES ('item', 'it001605290000', null);

-- ----------------------------
-- Table structure for `t_transfinite_inventory_warning`
-- ----------------------------
DROP TABLE IF EXISTS `t_transfinite_inventory_warning`;
CREATE TABLE `t_transfinite_inventory_warning` (
  `item_id` varchar(255) NOT NULL COMMENT '物品编号',
  `price` double NOT NULL COMMENT '单价',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `item_type_id` varchar(255) NOT NULL COMMENT '物品分类',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `measure_unit_id` varchar(100) NOT NULL COMMENT '单位',
  `inventory` bigint(20) NOT NULL COMMENT '库存数量',
  `max_inventory` int(11) NOT NULL COMMENT '库存上限',
  `min_inventory` int(11) NOT NULL COMMENT '库存下限',
  `supplier_id` bigint(20) NOT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_transfinite_inventory_warning
-- ----------------------------
INSERT INTO `t_transfinite_inventory_warning` VALUES ('1', '1', '1', '1', '1', '1', '1', '5', '3', '1', null);
