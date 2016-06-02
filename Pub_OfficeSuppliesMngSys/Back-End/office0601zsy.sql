/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.26-log : Database - officesystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`officesystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `officesystem`;

/*Table structure for table `t_background_categories_menu` */

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

/*Data for the table `t_background_categories_menu` */

/*Table structure for table `t_borrow_apply` */

DROP TABLE IF EXISTS `t_borrow_apply`;

CREATE TABLE `t_borrow_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_id` varchar(255) DEFAULT NULL COMMENT '物品编号（系统已有）',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称（如果领用的物品是系统中没有的，则只有该字段和物品分类）',
  `item_type_id` varchar(100) NOT NULL COMMENT '物品分类id',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `borrow_num` int(11) DEFAULT NULL COMMENT '借用数量（填写）',
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_borrow_apply` */

insert  into `t_borrow_apply`(`id`,`item_id`,`item_name`,`item_type_id`,`spec`,`borrow_num`,`price`,`monney`,`borrow_time`,`borrow_department_id`,`borrower`,`audit_time`,`auditor`,`state`,`is_return`,`return_time`,`is_display`,`is_valid`,`apply_time`,`reason`,`remark`) values (5,'1','铅笔','1','支',2,2,4,'2016-05-17 11:32:51',1,1,'2016-05-17 10:46:04',1,2,0,NULL,1,1,'2016-06-01 00:11:43',NULL,NULL),(6,'1','铅笔','1','支',1,1,1,'2016-05-17 11:33:09',2,2,'2016-05-17 10:55:07',1,2,0,NULL,1,1,'2016-05-31 19:13:28',NULL,NULL),(7,'it001605150000','铅笔','1','支',3,10,3,NULL,1,1,'2016-05-24 19:48:52',1,2,0,NULL,0,0,'2016-06-01 01:06:34',NULL,NULL),(8,'it001605150000','物品名称','1','啦啦啦',1,10,10,NULL,2,2,NULL,NULL,3,0,NULL,1,1,'2016-05-31 16:58:28',NULL,NULL),(9,'it001605150000','物品名称','1','啦啦啦',1,10,10,NULL,2,2,NULL,NULL,1,0,NULL,1,1,'2016-05-31 17:49:57',NULL,NULL);

/*Table structure for table `t_department` */

DROP TABLE IF EXISTS `t_department`;

CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '部门名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_department` */

insert  into `t_department`(`id`,`name`,`remark`) values (1,'新闻部','1'),(2,'宣传部',NULL);

/*Table structure for table `t_department_recipient_summary` */

DROP TABLE IF EXISTS `t_department_recipient_summary`;

CREATE TABLE `t_department_recipient_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `department_id` int(11) NOT NULL COMMENT '领用部门id',
  `out_storage_check_in_id` varchar(20) NOT NULL COMMENT '登记编号(出库)',
  `item_id` varchar(255) NOT NULL COMMENT '物品编号',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `item_type_id` int(11) NOT NULL COMMENT '商品类型id',
  `measure_unit_id` int(100) NOT NULL COMMENT '单位',
  `price` double NOT NULL COMMENT '单价',
  `number` bigint(11) NOT NULL COMMENT '数量',
  `monney` double NOT NULL COMMENT '金额',
  `out_storage_id` int(100) NOT NULL COMMENT '出库类型id(借用还是领用)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_department_recipient_summary` */

insert  into `t_department_recipient_summary`(`id`,`department_id`,`out_storage_check_in_id`,`item_id`,`item_name`,`spec`,`item_type_id`,`measure_unit_id`,`price`,`number`,`monney`,`out_storage_id`,`remark`) values (4,1,'os001605230000','1','苹果','规格',1,1,20,20,1000,1,NULL),(5,1,'os001605310000','1','苹果','规格',1,1,20,20,1000,1,NULL),(6,1,'os001605310001','1','苹果','规格',1,1,20,20,1000,1,NULL);

/*Table structure for table `t_in_storage_check_in` */

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_in_storage_check_in` */

insert  into `t_in_storage_check_in`(`id`,`in_storage_date`,`in_storage_type_id`,`supplier_id`,`agent_id`,`operater_id`,`item_procurement_id`,`total_number`,`total_monney`,`remark`) values (2,'2016-05-15 13:18:52',3,-1,-1,1,-1,10,0,'备注');

/*Table structure for table `t_in_storage_type` */

DROP TABLE IF EXISTS `t_in_storage_type`;

CREATE TABLE `t_in_storage_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_in_storage_type` */

insert  into `t_in_storage_type`(`id`,`name`,`remark`) values (1,'采购',NULL),(2,'归还',NULL),(3,'受赠',NULL);

/*Table structure for table `t_item` */

DROP TABLE IF EXISTS `t_item`;

CREATE TABLE `t_item` (
  `item_id` varchar(255) NOT NULL COMMENT 'id',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `item_type_id` varchar(100) NOT NULL COMMENT '物品分类id',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `measure_unit_id` varchar(100) NOT NULL COMMENT '单位',
  `max_inventory` int(11) NOT NULL COMMENT '库存上限',
  `min_inventory` int(11) NOT NULL COMMENT '库存下限',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商id',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_item` */

insert  into `t_item`(`item_id`,`item_name`,`item_type_id`,`spec`,`measure_unit_id`,`max_inventory`,`min_inventory`,`supplier_id`,`remark`) values ('1','笔','1','支','1',50,10,111,NULL),('10','商品名','typeId','spec','measureUnitId',50,10,111,NULL),('2','商品名','typeName','spec','measureUnitName',50,10,111,NULL),('3','商品名','typeName','spec','measureUnitName',50,10,111,NULL),('4','商品名','typeId','spec','measureUnitId',50,10,111,NULL),('5','商品名','typeId','spec','measureUnitId',50,10,111,NULL),('6','商品名','typeId','spec','measureUnitId',50,10,111,NULL),('7','商品名','typeId','spec','measureUnitId',50,10,111,NULL),('8','商品名','typeId','spec','measureUnitId',50,10,111,NULL),('9','商品名','typeId','spec','measureUnitId',50,10,111,NULL),('it001605150000','物品名称','1','规格型号','1',50,10,-1,'备注');

/*Table structure for table `t_item_classification_summary` */

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_item_classification_summary` */

insert  into `t_item_classification_summary`(`id`,`item_id`,`item_name`,`item_type_id`,`spec`,`measure_unit_id`,`price`,`inventory`,`inventory_monney`,`remark`) values (1,'it001605150000','物品名称','1','规格型号','1',10,31,210,NULL);

/*Table structure for table `t_item_procurement` */

DROP TABLE IF EXISTS `t_item_procurement`;

CREATE TABLE `t_item_procurement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_id` varchar(255) DEFAULT NULL COMMENT '物品编号（系统已有）',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商id（选一下或添加一下）',
  `staff_id` bigint(20) NOT NULL COMMENT '采购人员',
  `num` bigint(20) NOT NULL COMMENT '采购数量',
  `item_type_id` varchar(100) NOT NULL COMMENT '物品分类',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `price` double NOT NULL COMMENT '单价（不管有没有都让它填）',
  `monney` double NOT NULL COMMENT '金额',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_in_storage` smallint(6) NOT NULL COMMENT '是否已被登记入库(0,1)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_item_procurement` */

insert  into `t_item_procurement`(`id`,`item_id`,`supplier_id`,`staff_id`,`num`,`item_type_id`,`item_name`,`spec`,`price`,`monney`,`time`,`is_in_storage`,`remark`) values (1,'1',1,1,1,'1','1','1',1,1,'2016-05-13 16:45:55',0,NULL);

/*Table structure for table `t_item_type` */

DROP TABLE IF EXISTS `t_item_type`;

CREATE TABLE `t_item_type` (
  `id` varchar(11) NOT NULL COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_item_type` */

insert  into `t_item_type`(`id`,`name`,`remark`) values ('1','写字用的',NULL),('2','用来写的',NULL);

/*Table structure for table `t_log` */

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

/*Data for the table `t_log` */

/*Table structure for table `t_measure_unit` */

DROP TABLE IF EXISTS `t_measure_unit`;

CREATE TABLE `t_measure_unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_measure_unit` */

insert  into `t_measure_unit`(`id`,`name`,`remark`) values (1,'个数',NULL);

/*Table structure for table `t_merchants_availability_summary` */

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

/*Data for the table `t_merchants_availability_summary` */

/*Table structure for table `t_out_storage_check_in` */

DROP TABLE IF EXISTS `t_out_storage_check_in`;

CREATE TABLE `t_out_storage_check_in` (
  `id` varchar(255) NOT NULL COMMENT 'id',
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

/*Data for the table `t_out_storage_check_in` */

insert  into `t_out_storage_check_in`(`id`,`out_storage_date`,`out_storage_type_id`,`recipienter`,`department_id`,`operater_id`,`apply_id`,`total_number`,`total_monney`,`remark`) values ('it','2016-05-18 01:35:56',1,1,1,1,'1',1,1,NULL),('os001605230000','2016-05-23 19:52:53',1,1,1,2,'1_2_3',20,1000,'备注'),('os001605310000','2016-05-31 16:54:06',1,1,1,2,'1_2_3',20,1000,'备注'),('os001605310001','2016-05-31 17:12:05',1,1,1,2,'1_2_3',20,1000,'备注');

/*Table structure for table `t_out_storage_type` */

DROP TABLE IF EXISTS `t_out_storage_type`;

CREATE TABLE `t_out_storage_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_out_storage_type` */

insert  into `t_out_storage_type`(`id`,`name`,`remark`) values (1,'借用',NULL),(2,'领用',NULL),(3,'赠予',NULL);

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '权限名称',
  `description` varchar(255) NOT NULL COMMENT '权限描述',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_permission` */

/*Table structure for table `t_pre_item_procurement` */

DROP TABLE IF EXISTS `t_pre_item_procurement`;

CREATE TABLE `t_pre_item_procurement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_id` varchar(255) DEFAULT NULL COMMENT '物品编号',
  `item_type_id` bigint(100) NOT NULL COMMENT '物品分类id',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `num` bigint(20) NOT NULL COMMENT '采购数量',
  `staff_id` bigint(20) NOT NULL COMMENT '制单人',
  `pre_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预采购生成时间',
  `audit_time` datetime(6) DEFAULT NULL COMMENT '审核时间（audit_time为空则就是未已到采购单）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_pre_item_procurement` */

/*Table structure for table `t_procurement_apply` */

DROP TABLE IF EXISTS `t_procurement_apply`;

CREATE TABLE `t_procurement_apply` (
  `id` bigint(20) NOT NULL,
  `item_type_id` int(11) NOT NULL COMMENT '物品类型id',
  `staff_id` varchar(255) NOT NULL COMMENT '员工id',
  `item_name` bigint(20) NOT NULL COMMENT '物品名称',
  `item_id` bigint(20) DEFAULT NULL COMMENT '物品编号',
  `spec` varchar(255) DEFAULT NULL,
  `num` int(11) NOT NULL COMMENT '采购申请数额',
  `apply_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `is_procurement` smallint(6) NOT NULL COMMENT '是否采购',
  `is_display` smallint(6) NOT NULL COMMENT '是否显示',
  `reason` varchar(255) DEFAULT NULL COMMENT '原因',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_procurement_apply` */

/*Table structure for table `t_recipient_apply` */

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_recipient_apply` */

insert  into `t_recipient_apply`(`id`,`item_name`,`item_type_id`,`recipient_num`,`item_id`,`spec`,`price`,`monney`,`recipient_department_id`,`recipienter`,`audit_time`,`auditor`,`recipient_time`,`apply_time`,`state`,`is_display`,`is_valid`,`reason`,`remark`) values (1,'1',1,1,'it001605150000',NULL,10,NULL,1,1,'2016-05-15 10:05:05',1,'2016-05-15 19:42:32','2016-05-15 08:26:57',2,1,1,NULL,NULL),(2,'2',2,1,'it001605150000',NULL,10,NULL,1,1,'2016-05-16 19:41:54',1,NULL,'2016-06-01 22:20:22',2,1,0,NULL,NULL),(3,'物品名称',1,1,'it001605150000','O(∩_∩)O哈哈哈~',10,10,2,2,NULL,NULL,NULL,'2016-06-01 22:03:41',1,1,1,NULL,NULL);

/*Table structure for table `t_staff` */

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
  `is_working` smallint(6) NOT NULL COMMENT '在职状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_staff` */

insert  into `t_staff`(`id`,`staff_name`,`department_id`,`cell_phone_number`,`phone`,`Email`,`sex`,`native_place`,`address`,`birthday`,`graduate_school`,`highest_record`,`role`,`is_working`,`remark`) values (1,'余晓明',1,'1','1','1','1','1','1','2016-05-15','1','1',1,1,NULL),(2,'zsy',2,'2','2','2','1','1','1','2016-05-17','2','2',2,1,NULL);

/*Table structure for table `t_staff_recipient_summary` */

DROP TABLE IF EXISTS `t_staff_recipient_summary`;

CREATE TABLE `t_staff_recipient_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `staff_id` bigint(20) NOT NULL COMMENT '领用人id',
  `out_storage_check_in_id` varchar(20) NOT NULL COMMENT '登记编号(出库)',
  `item_id` varchar(255) NOT NULL COMMENT '物品编号',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `item_type_id` int(11) DEFAULT NULL COMMENT '物品类型id',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `measure_unit_id` varchar(100) NOT NULL COMMENT '单位',
  `price` double NOT NULL COMMENT '单价',
  `number` int(11) NOT NULL COMMENT '数量',
  `monney` double NOT NULL COMMENT '金额',
  `out_storage_id` int(100) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_staff_recipient_summary` */

insert  into `t_staff_recipient_summary`(`id`,`staff_id`,`out_storage_check_in_id`,`item_id`,`item_name`,`item_type_id`,`spec`,`measure_unit_id`,`price`,`number`,`monney`,`out_storage_id`,`remark`) values (1,1,'os001605230000','1','苹果',1,'规格','1',20,20,1000,NULL,NULL),(2,1,'os001605310000','1','苹果',1,'规格','1',20,20,1000,NULL,NULL),(3,1,'os001605310001','1','苹果',1,'规格','1',20,20,1000,NULL,NULL);

/*Table structure for table `t_staff_role` */

DROP TABLE IF EXISTS `t_staff_role`;

CREATE TABLE `t_staff_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `description` varchar(255) NOT NULL COMMENT '角色描述',
  `permissions` varchar(255) DEFAULT NULL COMMENT '权限清单',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_staff_role` */

/*Table structure for table `t_supplier` */

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

/*Data for the table `t_supplier` */

insert  into `t_supplier`(`id`,`full_name`,`short_name`,`supplier_type_id`,`linkman`,`cell_phone_number`,`phone`,`fax`,`postcode`,`address`,`is_valid`,`remark`) values (1,'1','1','1','1','1','1',NULL,'1','1',1,NULL);

/*Table structure for table `t_supplier_type` */

DROP TABLE IF EXISTS `t_supplier_type`;

CREATE TABLE `t_supplier_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_supplier_type` */

/*Table structure for table `t_sys_table_key` */

DROP TABLE IF EXISTS `t_sys_table_key`;

CREATE TABLE `t_sys_table_key` (
  `table_name` varchar(100) NOT NULL COMMENT '表名',
  `table_key` varchar(100) NOT NULL COMMENT '该表最新主键',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_table_key` */

insert  into `t_sys_table_key`(`table_name`,`table_key`,`remark`) values ('item','it001605150000',NULL),('outStorageCheckIn','os001605310001',NULL);

/*Table structure for table `t_transfinite_inventory_warning` */

DROP TABLE IF EXISTS `t_transfinite_inventory_warning`;

CREATE TABLE `t_transfinite_inventory_warning` (
  `item_id` varchar(255) NOT NULL COMMENT '物品编号',
  `item_name` varchar(255) NOT NULL COMMENT '物品名称',
  `item_type_id` varchar(255) NOT NULL COMMENT '物品分类',
  `spec` varchar(255) NOT NULL COMMENT '规格型号',
  `measure_unit_id` varchar(100) NOT NULL COMMENT '单位',
  `price` double NOT NULL COMMENT '单价',
  `inventory` bigint(20) NOT NULL COMMENT '库存数量',
  `max_inventory` int(11) NOT NULL COMMENT '库存上限',
  `min_inventory` int(11) NOT NULL COMMENT '库存下限',
  `supplier_id` bigint(20) NOT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_transfinite_inventory_warning` */

insert  into `t_transfinite_inventory_warning`(`item_id`,`item_name`,`item_type_id`,`spec`,`measure_unit_id`,`price`,`inventory`,`max_inventory`,`min_inventory`,`supplier_id`,`remark`) values ('it001605150000','铅笔','1','物品','支',10,28,50,3,1,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
