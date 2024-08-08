/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb3 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `t273`;
CREATE DATABASE IF NOT EXISTS `t273` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `t273`;

DROP TABLE IF EXISTS `chongwu`;
CREATE TABLE IF NOT EXISTS `chongwu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `chongwu_name` varchar(200) DEFAULT NULL COMMENT '宠物名称  Search111 ',
  `chongwu_photo` varchar(200) DEFAULT NULL COMMENT '宠物照片',
  `chongwu_types` int DEFAULT NULL COMMENT '宠物类型 Search111',
  `chongwu_content` text COMMENT '宠物介绍',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='宠物信息';

DELETE FROM `chongwu`;
INSERT INTO `chongwu` (`id`, `chongwu_name`, `chongwu_photo`, `chongwu_types`, `chongwu_content`, `create_time`) VALUES
	(1, '宠物名称1', 'http://localhost:8080/liulangdongwubeihua/upload/chongwu1.jpg', 2, '宠物介绍1', '2022-04-04 09:33:52'),
	(2, '宠物名称2', 'http://localhost:8080/liulangdongwubeihua/upload/chongwu2.jpg', 2, '宠物介绍2', '2022-04-04 09:33:52'),
	(3, '宠物名称3', 'http://localhost:8080/liulangdongwubeihua/upload/chongwu3.jpg', 3, '宠物介绍3', '2022-04-04 09:33:52'),
	(4, '宠物名称4', 'http://localhost:8080/liulangdongwubeihua/upload/chongwu4.jpg', 1, '宠物介绍4', '2022-04-04 09:33:52'),
	(5, '宠物名称5', 'http://localhost:8080/liulangdongwubeihua/upload/chongwu5.jpg', 1, '宠物介绍5', '2022-04-04 09:33:52');

DROP TABLE IF EXISTS `chongwujiyang`;
CREATE TABLE IF NOT EXISTS `chongwujiyang` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `chongwu_name` varchar(200) DEFAULT NULL COMMENT '宠物名称  Search111 ',
  `chongwu_photo` varchar(200) DEFAULT NULL COMMENT '宠物照片',
  `chongwu_types` int DEFAULT NULL COMMENT '宠物类型 Search111',
  `jiyang_riqi_time` date DEFAULT NULL COMMENT '寄养日期',
  `jiyang_tianshu` int DEFAULT NULL COMMENT '寄养天数',
  `jiyangdizhi` varchar(200) DEFAULT NULL COMMENT '寄养地址',
  `lianxiren_name` varchar(200) DEFAULT NULL COMMENT '联系人姓名',
  `lianxiren_phone` varchar(200) DEFAULT NULL COMMENT '联系人手机号',
  `chongwujiyang_content` text COMMENT '寄养详情',
  `chongwujiyang_yesno_types` int DEFAULT NULL COMMENT '审核状态 Search111',
  `chongwujiyang_yesno_text` text COMMENT '审核意见',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='宠物寄养';

DELETE FROM `chongwujiyang`;
INSERT INTO `chongwujiyang` (`id`, `yonghu_id`, `chongwu_name`, `chongwu_photo`, `chongwu_types`, `jiyang_riqi_time`, `jiyang_tianshu`, `jiyangdizhi`, `lianxiren_name`, `lianxiren_phone`, `chongwujiyang_content`, `chongwujiyang_yesno_types`, `chongwujiyang_yesno_text`, `insert_time`, `create_time`) VALUES
	(1, 3, '宠物名称1', 'http://localhost:8080/liulangdongwubeihua/upload/chongwu1.jpg', 3, '2022-04-04', 353, '寄养地址1', '联系人姓名1', '17703786901', '寄养详情1', 1, NULL, '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(2, 1, '宠物名称2', 'http://localhost:8080/liulangdongwubeihua/upload/chongwu2.jpg', 1, '2022-04-04', 338, '寄养地址2', '联系人姓名2', '17703786902', '寄养详情2', 1, NULL, '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(3, 1, '宠物名称3', 'http://localhost:8080/liulangdongwubeihua/upload/chongwu3.jpg', 3, '2022-04-04', 245, '寄养地址3', '联系人姓名3', '17703786903', '寄养详情3', 1, NULL, '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(4, 2, '宠物名称4', 'http://localhost:8080/liulangdongwubeihua/upload/chongwu4.jpg', 2, '2022-04-04', 119, '寄养地址4', '联系人姓名4', '17703786904', '寄养详情4', 1, NULL, '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(5, 1, '宠物名称5', 'http://localhost:8080/liulangdongwubeihua/upload/chongwu5.jpg', 2, '2022-04-04', 387, '寄养地址5', '联系人姓名5', '17703786905', '寄养详情5', 2, '同意123', '2022-04-04 09:33:52', '2022-04-04 09:33:52');

DROP TABLE IF EXISTS `chongwulingyang`;
CREATE TABLE IF NOT EXISTS `chongwulingyang` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chongwulingyang_name` varchar(200) DEFAULT NULL COMMENT '标题  Search111',
  `chongwu_types` int DEFAULT NULL COMMENT '宠物类型 Search111',
  `chongwulingyang_photo` varchar(200) DEFAULT NULL COMMENT '宠物图片',
  `jieshu_types` int DEFAULT NULL COMMENT '是否被认领',
  `chongwulingyang_content` text COMMENT '宠物详情',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='宠物领养';

DELETE FROM `chongwulingyang`;
INSERT INTO `chongwulingyang` (`id`, `chongwulingyang_name`, `chongwu_types`, `chongwulingyang_photo`, `jieshu_types`, `chongwulingyang_content`, `create_time`) VALUES
	(1, '标题1', 2, 'http://localhost:8080/liulangdongwubeihua/upload/chongwulingyang1.jpg', 1, '宠物详情1', '2022-04-04 09:33:52'),
	(2, '标题2', 3, 'http://localhost:8080/liulangdongwubeihua/upload/chongwulingyang2.jpg', 1, '宠物详情2', '2022-04-04 09:33:52'),
	(3, '标题3', 1, 'http://localhost:8080/liulangdongwubeihua/upload/chongwulingyang3.jpg', 2, '宠物详情3', '2022-04-04 09:33:52'),
	(4, '标题4', 1, 'http://localhost:8080/liulangdongwubeihua/upload/chongwulingyang4.jpg', 2, '宠物详情4', '2022-04-04 09:33:52'),
	(5, '标题5', 3, 'http://localhost:8080/liulangdongwubeihua/upload/chongwulingyang5.jpg', 1, '宠物详情5', '2022-04-04 09:33:52');

DROP TABLE IF EXISTS `chongwulingyangshenhe`;
CREATE TABLE IF NOT EXISTS `chongwulingyangshenhe` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chongwulingyang_id` int DEFAULT NULL COMMENT '宠物领养',
  `yonghu_id` int DEFAULT NULL COMMENT '领养用户',
  `chongwurenlingshenhe_text` text COMMENT '认领凭据',
  `chongwulingyangshenhe_yesno_types` int DEFAULT NULL COMMENT '申请状态',
  `chongwulingyangshenhe_yesno_text` text COMMENT '申请结果',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COMMENT='宠物领养审核';

DELETE FROM `chongwulingyangshenhe`;
INSERT INTO `chongwulingyangshenhe` (`id`, `chongwulingyang_id`, `yonghu_id`, `chongwurenlingshenhe_text`, `chongwulingyangshenhe_yesno_types`, `chongwulingyangshenhe_yesno_text`, `create_time`) VALUES
	(1, 1, 2, '认领凭据1', 1, NULL, '2022-04-04 09:33:52'),
	(2, 2, 1, '认领凭据2', 1, NULL, '2022-04-04 09:33:52'),
	(3, 3, 3, '认领凭据3', 1, NULL, '2022-04-04 09:33:52'),
	(4, 4, 2, '认领凭据4', 2, '1112233', '2022-04-04 09:33:52');

DROP TABLE IF EXISTS `chongwu_collection`;
CREATE TABLE IF NOT EXISTS `chongwu_collection` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chongwu_id` int DEFAULT NULL COMMENT '宠物',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `chongwu_collection_types` int DEFAULT NULL COMMENT '类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '收藏时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='宠物收藏';

DELETE FROM `chongwu_collection`;
INSERT INTO `chongwu_collection` (`id`, `chongwu_id`, `yonghu_id`, `chongwu_collection_types`, `insert_time`, `create_time`) VALUES
	(1, 1, 1, 1, '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(2, 2, 2, 1, '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(3, 3, 3, 1, '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(5, 5, 1, 1, '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(6, 3, 1, 1, '2024-07-18 07:48:05', '2024-07-18 07:48:05');

DROP TABLE IF EXISTS `chongwu_liuyan`;
CREATE TABLE IF NOT EXISTS `chongwu_liuyan` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chongwu_id` int DEFAULT NULL COMMENT '宠物',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `chongwu_liuyan_text` text COMMENT '留言内容',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '留言时间',
  `reply_text` text COMMENT '回复内容',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='宠物留言';

DELETE FROM `chongwu_liuyan`;
INSERT INTO `chongwu_liuyan` (`id`, `chongwu_id`, `yonghu_id`, `chongwu_liuyan_text`, `insert_time`, `reply_text`, `update_time`, `create_time`) VALUES
	(1, 1, 2, '留言内容1', '2022-04-04 09:33:52', '回复信息1', '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(2, 2, 2, '留言内容2', '2022-04-04 09:33:52', '回复信息2', '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(3, 3, 2, '留言内容3', '2022-04-04 09:33:52', '回复信息3', '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(4, 4, 2, '留言内容4', '2022-04-04 09:33:52', '回复信息4', '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(5, 5, 1, '留言内容5', '2022-04-04 09:33:52', '回复信息5', '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(7, 1, 1, '321', '2022-04-04 09:49:00', '回复123', '2022-04-04 09:50:34', '2022-04-04 09:49:00');

DROP TABLE IF EXISTS `config`;
CREATE TABLE IF NOT EXISTS `config` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='配置文件';

DELETE FROM `config`;
INSERT INTO `config` (`id`, `name`, `value`) VALUES
	(1, '轮播图1', 'http://localhost:8080/liulangdongwubeihua/upload/config1.jpg'),
	(2, '轮播图2', 'http://localhost:8080/liulangdongwubeihua/upload/config2.jpg'),
	(3, '轮播图3', 'http://localhost:8080/liulangdongwubeihua/upload/config3.jpg');

DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE IF NOT EXISTS `dictionary` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(200) DEFAULT NULL COMMENT '字段',
  `dic_name` varchar(200) DEFAULT NULL COMMENT '字段名',
  `code_index` int DEFAULT NULL COMMENT '编码',
  `index_name` varchar(200) DEFAULT NULL COMMENT '编码名字  Search111 ',
  `super_id` int DEFAULT NULL COMMENT '父字段id',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COMMENT='字典';

DELETE FROM `dictionary`;
INSERT INTO `dictionary` (`id`, `dic_code`, `dic_name`, `code_index`, `index_name`, `super_id`, `beizhu`, `create_time`) VALUES
	(1, 'chongwu_types', '宠物类型', 1, '宠物类型1', NULL, NULL, '2022-04-04 09:33:41'),
	(2, 'chongwu_types', '宠物类型', 2, '宠物类型2', NULL, NULL, '2022-04-04 09:33:41'),
	(3, 'chongwu_types', '宠物类型', 3, '宠物类型3', NULL, NULL, '2022-04-04 09:33:41'),
	(4, 'chongwujiyang_yesno_types', '审核状态', 1, '审核中', NULL, NULL, '2022-04-04 09:33:41'),
	(5, 'chongwujiyang_yesno_types', '审核状态', 2, '同意', NULL, NULL, '2022-04-04 09:33:41'),
	(6, 'chongwujiyang_yesno_types', '审核状态', 3, '拒绝', NULL, NULL, '2022-04-04 09:33:41'),
	(7, 'jieshu_types', '是否被认领', 1, '可认领', NULL, NULL, '2022-04-04 09:33:41'),
	(8, 'jieshu_types', '是否被认领', 2, '已认领', NULL, NULL, '2022-04-04 09:33:41'),
	(9, 'chongwulingyangshenhe_yesno_types', '审核状态', 1, '审核中', NULL, NULL, '2022-04-04 09:33:41'),
	(10, 'chongwulingyangshenhe_yesno_types', '审核状态', 2, '同意', NULL, NULL, '2022-04-04 09:33:41'),
	(11, 'chongwulingyangshenhe_yesno_types', '审核状态', 3, '拒绝', NULL, NULL, '2022-04-04 09:33:41'),
	(12, 'sex_types', '性别类型', 1, '男', NULL, NULL, '2022-04-04 09:33:41'),
	(13, 'sex_types', '性别类型', 2, '女', NULL, NULL, '2022-04-04 09:33:41'),
	(14, 'forum_state_types', '帖子状态', 1, '发帖', NULL, NULL, '2022-04-04 09:33:41'),
	(15, 'forum_state_types', '帖子状态', 2, '回帖', NULL, NULL, '2022-04-04 09:33:41'),
	(16, 'chongwu_collection_types', '收藏表类型', 1, '收藏', NULL, NULL, '2022-04-04 09:33:41'),
	(17, 'news_types', '公告类型', 1, '公告类型1', NULL, NULL, '2022-04-04 09:33:42'),
	(18, 'news_types', '公告类型', 2, '公告类型2', NULL, NULL, '2022-04-04 09:33:42'),
	(19, 'news_types', '公告类型', 3, '宠物知识科普', NULL, NULL, '2022-04-04 09:33:42');

DROP TABLE IF EXISTS `forum`;
CREATE TABLE IF NOT EXISTS `forum` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `forum_name` varchar(200) DEFAULT NULL COMMENT '帖子标题  Search111 ',
  `yonghu_id` int DEFAULT NULL COMMENT '用户',
  `ziyuanzhe_id` int DEFAULT NULL COMMENT '自愿者',
  `users_id` int DEFAULT NULL COMMENT '管理员',
  `forum_content` text COMMENT '发布内容',
  `super_ids` int DEFAULT NULL COMMENT '父id',
  `forum_state_types` int DEFAULT NULL COMMENT '帖子状态',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '发帖时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COMMENT='论坛';

DELETE FROM `forum`;
INSERT INTO `forum` (`id`, `forum_name`, `yonghu_id`, `ziyuanzhe_id`, `users_id`, `forum_content`, `super_ids`, `forum_state_types`, `insert_time`, `update_time`, `create_time`) VALUES
	(1, '帖子标题1', 2, NULL, NULL, '发布内容1', NULL, 1, '2022-04-04 09:33:52', '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(2, '帖子标题2', 3, NULL, NULL, '发布内容2', NULL, 1, '2022-04-04 09:33:52', '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(3, '帖子标题3', 3, NULL, NULL, '发布内容3', NULL, 1, '2022-04-04 09:33:52', '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(4, '帖子标题4', 2, NULL, NULL, '发布内容4', NULL, 1, '2022-04-04 09:33:52', '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(5, '帖子标题5', 1, NULL, NULL, '发布内容5', NULL, 1, '2022-04-04 09:33:52', '2022-04-04 09:33:52', '2022-04-04 09:33:52'),
	(6, NULL, 1, NULL, NULL, '用户评论123', 5, 2, '2022-04-04 09:49:31', NULL, '2022-04-04 09:49:31'),
	(7, NULL, NULL, NULL, 1, '管理回复123', 5, 2, '2022-04-04 09:53:12', NULL, '2022-04-04 09:53:12'),
	(8, NULL, NULL, 1, NULL, '自愿者评论1111', 5, 2, '2022-04-04 09:53:50', NULL, '2022-04-04 09:53:50');

DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `news_name` varchar(200) DEFAULT NULL COMMENT '公告标题  Search111 ',
  `news_types` int DEFAULT NULL COMMENT '公告类型  Search111 ',
  `news_photo` varchar(200) DEFAULT NULL COMMENT '公告图片',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `news_content` text COMMENT '公告详情',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show1 show2 nameShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='公告信息';

DELETE FROM `news`;
INSERT INTO `news` (`id`, `news_name`, `news_types`, `news_photo`, `insert_time`, `news_content`, `create_time`) VALUES
	(1, '公告标题1', 1, 'http://localhost:8080/liulangdongwubeihua/upload/news1.jpg', '2022-04-04 09:33:52', '公告详情1', '2022-04-04 09:33:52'),
	(2, '公告标题2', 3, 'http://localhost:8080/liulangdongwubeihua/upload/news2.jpg', '2022-04-04 09:33:52', '公告详情2', '2022-04-04 09:33:52'),
	(3, '公告标题3', 3, 'http://localhost:8080/liulangdongwubeihua/upload/news3.jpg', '2022-04-04 09:33:52', '公告详情3', '2022-04-04 09:33:52'),
	(4, '公告标题4', 2, 'http://localhost:8080/liulangdongwubeihua/upload/news4.jpg', '2022-04-04 09:33:52', '公告详情4', '2022-04-04 09:33:52'),
	(5, '公告标题5', 3, 'http://localhost:8080/liulangdongwubeihua/upload/news5.jpg', '2022-04-04 09:33:52', '公告详情5', '2022-04-04 09:33:52');

DROP TABLE IF EXISTS `token`;
CREATE TABLE IF NOT EXISTS `token` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='token表';

DELETE FROM `token`;
INSERT INTO `token` (`id`, `userid`, `username`, `tablename`, `role`, `token`, `addtime`, `expiratedtime`) VALUES
	(1, 1, 'admin', 'users', '管理员', 'nfllptng2srat03g11y02nhj2zqy5b3g', '2022-04-04 09:12:14', '2024-07-18 08:46:08'),
	(2, 1, 'a1', 'yonghu', '用户', 'lijsojllugb4ytib4m18x1ev95ee2cdc', '2022-04-04 09:17:37', '2024-07-18 08:47:54'),
	(3, 1, 'a1', 'ziyuanzhe', '自愿者', 'i5zlpo3pg3crrr5fz3hadhz4m7lneepf', '2022-04-04 09:53:27', '2024-07-18 08:47:28');

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='用户表';

DELETE FROM `users`;
INSERT INTO `users` (`id`, `username`, `password`, `role`, `addtime`) VALUES
	(1, 'admin', '123456', '管理员', '2022-04-30 16:00:00');

DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE IF NOT EXISTS `yonghu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `yonghu_name` varchar(200) DEFAULT NULL COMMENT '用户姓名 Search111 ',
  `yonghu_photo` varchar(200) DEFAULT NULL COMMENT '头像',
  `yonghu_phone` varchar(200) DEFAULT NULL COMMENT '手机号',
  `yonghu_email` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `sex_types` int DEFAULT NULL COMMENT '性别 Search111 ',
  `yonghu_delete` int DEFAULT '1' COMMENT '假删',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='用户';

DELETE FROM `yonghu`;
INSERT INTO `yonghu` (`id`, `username`, `password`, `yonghu_name`, `yonghu_photo`, `yonghu_phone`, `yonghu_email`, `sex_types`, `yonghu_delete`, `create_time`) VALUES
	(1, '用户1', '123456', '用户姓名1', 'http://localhost:8080/liulangdongwubeihua/upload/yonghu1.jpg', '17703786901', '1@qq.com', 1, 1, '2022-04-04 09:33:52'),
	(2, '用户2', '123456', '用户姓名2', 'http://localhost:8080/liulangdongwubeihua/upload/yonghu2.jpg', '17703786902', '2@qq.com', 2, 1, '2022-04-04 09:33:52'),
	(3, '用户3', '123456', '用户姓名3', 'http://localhost:8080/liulangdongwubeihua/upload/yonghu3.jpg', '17703786903', '3@qq.com', 1, 1, '2022-04-04 09:33:52');

DROP TABLE IF EXISTS `ziyuanzhe`;
CREATE TABLE IF NOT EXISTS `ziyuanzhe` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `ziyuanzhe_name` varchar(200) DEFAULT NULL COMMENT '自愿者姓名 Search111 ',
  `ziyuanzhe_photo` varchar(200) DEFAULT NULL COMMENT '头像',
  `ziyuanzhe_phone` varchar(200) DEFAULT NULL COMMENT '手机号',
  `ziyuanzhe_email` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `sex_types` int DEFAULT NULL COMMENT '性别 Search111 ',
  `ziyuanzhe_delete` int DEFAULT '1' COMMENT '假删',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='自愿者';

DELETE FROM `ziyuanzhe`;
INSERT INTO `ziyuanzhe` (`id`, `username`, `password`, `ziyuanzhe_name`, `ziyuanzhe_photo`, `ziyuanzhe_phone`, `ziyuanzhe_email`, `sex_types`, `ziyuanzhe_delete`, `create_time`) VALUES
	(1, '自愿者1', '123456', '自愿者姓名1', 'http://localhost:8080/liulangdongwubeihua/upload/ziyuanzhe1.jpg', '17703786901', '1@qq.com', 2, 1, '2022-04-04 09:33:52'),
	(2, '自愿者2', '123456', '自愿者姓名2', 'http://localhost:8080/liulangdongwubeihua/upload/ziyuanzhe2.jpg', '17703786902', '2@qq.com', 2, 1, '2022-04-04 09:33:52'),
	(3, '自愿者3', '123456', '自愿者姓名3', 'http://localhost:8080/liulangdongwubeihua/upload/ziyuanzhe3.jpg', '17703786903', '3@qq.com', 1, 1, '2022-04-04 09:33:52');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
