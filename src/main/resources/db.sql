# ------------------------------------------------------------
# Dump of table ROLE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ROLE`;

CREATE TABLE `ROLE` (
  `id` bigint(20) NOT NULL,
  `roleName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roleName_UNIQUE` (`roleName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `ROLE` WRITE;


INSERT INTO `ROLE` (`id`, `roleName`)
VALUES
	(2,'ROLE_ADMIN'),
	(1,'ROLE_USER');


UNLOCK TABLES;

# ------------------------------------------------------------
# Dump of table USER
# ------------------------------------------------------------

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
  `id` bigint(20) NOT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `isEnabled` tinyint(1) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `USER` WRITE;

INSERT INTO `USER` (`id`, `firstName`, `lastName`, `password`, `isEnabled`, `email`)
VALUES
	(1,'Jane','Doe','21232f297a57a5a743894a0e4a801fc3',1,'admin@mail.com'),
	(2,'John','Doe','527bd5b5d689e2c32ae974c6229ff785',1,'john@mail.com');


UNLOCK TABLES;

# ------------------------------------------------------------
# Dump of table USER_ROLE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `USER_ROLE`;

CREATE TABLE `USER_ROLE` (
  `id_user` bigint(20) NOT NULL,
  `id_role` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_user`,`id_role`),
  KEY `USER_REF` (`id_user`),
  KEY `ROLE_REF` (`id_role`),
  CONSTRAINT `ROLE_REF` FOREIGN KEY (`id_role`) REFERENCES `ROLE` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `USER_REF` FOREIGN KEY (`id_user`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `USER_ROLE` WRITE;

INSERT INTO `USER_ROLE` (`id_user`, `id_role`, `id`)
VALUES
	(1,1,0),
	(1,2,0),
	(2,1,0);


UNLOCK TABLES;
