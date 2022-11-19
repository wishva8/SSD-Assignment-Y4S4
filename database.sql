CREATE DATABASE IF NOT EXISTS `janus` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `janus`;

-- Dumping structure for table janus.attachment
CREATE TABLE IF NOT EXISTS `attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_id` bigint(20) DEFAULT NULL,
  `issue_id` bigint(20) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `status` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `path` varchar(500) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint(20) NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `voided` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `FK_attachment_user` (`created_by`),
  KEY `FK_attachment_user_2` (`updated_by`),
  KEY `FK_attachment_task` (`task_id`),
  KEY `FK_attachment_issue` (`issue_id`),
  CONSTRAINT `FK_attachment_issue` FOREIGN KEY (`issue_id`) REFERENCES `issue` (`id`),
  CONSTRAINT `FK_attachment_task` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`),
  CONSTRAINT `FK_attachment_user` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_attachment_user_2` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identifier` varchar(100) NOT NULL,
  `description` mediumtext,
  `owned_by` bigint(20) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint(20) NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `voided` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `identifier` (`identifier`),
  KEY `FK_msg_user` (`created_by`),
  KEY `FK_msg_user_2` (`updated_by`),
  KEY `FK_msg_user_3` (`owned_by`),
  CONSTRAINT `FK_msg_user` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_msg_user_2` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_msg_user_3` FOREIGN KEY (`owned_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint(20) NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `voided` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK_user_role_user` (`created_by`),
  KEY `FK_user_role_user_2` (`updated_by`),
  CONSTRAINT `FK_user_role_user` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_user_role_user_2` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint(20) NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `voided` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `FK_user_user` (`created_by`),
  KEY `FK_user_user_2` (`updated_by`),
  CONSTRAINT `FK_user_user` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_user_user_2` FOREIGN KEY (`updated_by`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user_role_mapping` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FK_user_role_mapping_user` (`user_id`),
  KEY `FK_user_role_mapping_role` (`role_id`),
  CONSTRAINT `FK_user_role_mapping_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_user_role_mapping_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-log - MySQL Community Server (GPL)
-- Server OS:       useruseruser             Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table janus.user: ~1 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `full_name`, `password`, `created_at`, `created_by`, `updated_at`, `updated_by`, `enabled`, `voided`) VALUES
	(1, 'superadmin', 'Super Administrator', '$2a$10$5mdJYSPbxD.59e9SfOnTuuqFjXFzZyOHyrTNwaB8/zSOc0Ka7Rn2K', '2021-02-17 23:08:09', 1, '2021-02-17 23:11:07', 1, b'1', b'0'),
	(2, 'worker', 'worker', '$2a$10$5mdJYSPbxD.59e9SfOnTuuqFjXFzZyOHyrTNwaB8/zSOc0Ka7Rn2K', '2021-02-17 23:08:09', 1, '2021-02-17 23:11:07', 1, b'1', b'0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table janus.role: ~0 rows (approximately)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `description`, `created_at`, `created_by`, `updated_at`, `updated_by`, `enabled`, `voided`) VALUES
	(1, 'ROLE_MANAGER', 'Role manager', '2021-02-17 23:11:48', 1, '2021-02-17 23:11:53', 1, b'1', b'0'),
	(2, 'ROLE_WORKER', 'Role worker', '2021-02-17 23:12:34', 1, '2021-02-17 23:12:38', 1, b'1', b'0');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------useruser

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table janus.user_role_mapping: ~0 rows (approximately)
DELETE FROM `user_role_mapping`;
/*!40000 ALTER TABLE `user_role_mapping` DISABLE KEYS */;
INSERT INTO `user_role_mapping` (`user_id`, `role_id`) VALUES
	(1, 1),
	(2, 2);
/*!40000 ALTER TABLE `user_role_mapping` ENABLE KEYS */;


