set foreign_key_checks = 0;

drop table if exists location;
drop table if exists restaurant;
drop table if exists restaurant_status;
drop table if exists user;
drop table if exists user_query;

CREATE TABLE `location` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `CITY` varchar(20) NOT NULL,
  `LATTITUDE` decimal(10,6) NOT NULL,
  `LONGITUDE` decimal(10,6) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `restaurant` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `CONTACT_NO` int(11) NOT NULL,
  `OWNER_NAME` varchar(45) NOT NULL,
  `OWNER_CONTACT_NO` int(11) DEFAULT NULL,
  `MANAGER_NAME` varchar(45) NOT NULL,
  `MANAGER_CONTACT_NO` int(11) NOT NULL,
  `LOCATION_ID` int(11) NOT NULL,
  `RESTAURANT_STATUS_ID` int(11) NOT NULL,
  `ADDRESS` varchar(135) NOT NULL,
  `LATTITUDE` decimal(10,6) NOT NULL,
  `LONGITUDE` decimal(10,6) NOT NULL,
  `OPENING_TIME` time(6) NOT NULL,
  `CLOSING_TIME` time(6) NOT NULL,
  `ACTIVE_FLAG` tinyint(1) NOT NULL DEFAULT '1',
  `ADVANCE_BOOKING_FLAG` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `LOCATION_ID_FK_idx` (`LOCATION_ID`),
  KEY `RESTAURANT_RESTAURANT_STATUS_ID_FK_idx` (`RESTAURANT_STATUS_ID`),
  CONSTRAINT `RESTAURANT_LOCATION_ID_FK` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RESTAURANT_RESTAURANT_STATUS_ID_FK` FOREIGN KEY (`RESTAURANT_STATUS_ID`) REFERENCES `restaurant_status` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `restaurant_status` (
  `ID` int(11) NOT NULL,
  `OCCUPANCY` int(11) DEFAULT NULL,
  `WAIT_TIME_2` int(11) DEFAULT NULL,
  `WAIT_TIME_GROUP` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `FIRST_NAME` varchar(20) NOT NULL,
  `LAST_NAME` varchar(20) NOT NULL,
  `CONTACT_NO` varchar(20) NOT NULL,
  `EMAIL_ID` varchar(45) NOT NULL,
  `FACEBOOK_ID` varchar(45) DEFAULT NULL,
  `GOOGLE_ID` varchar(45) DEFAULT NULL,
  `PROFILE_PIC` varchar(45) DEFAULT NULL,
  `LAST_LOGIN` datetime DEFAULT NULL,
  `ROLE` varchar(45) NOT NULL,
  `ACTIVE_FLAG` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `user_query` (
  `ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(1024) NOT NULL,
  `STATUS` varchar(12) NOT NULL,
  `REGISTRATION_TIME` datetime NOT NULL,
  `TYPE` int(11) NOT NULL,
  `LAST_UPDATE` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `USER_ID_FK_idx` (`USER_ID`),
  CONSTRAINT `USER_QUERY_USER_ID_FK` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

set foreign_key_checks = 1;