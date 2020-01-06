CREATE DATABASE IF NOT EXISTS starter DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use starter;

CREATE TABLE if not EXISTS `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ops` smallint(6) DEFAULT NULL,
  `table_name` varchar(64) DEFAULT NULL,
  `summary` longtext,
  `ip` varchar(64) DEFAULT NULL,
  `auth_id` bigint(20) DEFAULT NULL,
  `created` datetime(6) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `log_ops_53a6ed64` (`ops`),
  KEY `log_auth_id_d4155be2` (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
