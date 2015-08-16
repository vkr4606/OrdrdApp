set foreign_key_checks = 0;

drop table if exists location;
drop table if exists location_admin;
drop table if exists price_range;
drop table if exists restaurant;
drop table if exists restaurant_status;
drop table if exists user;
drop table if exists user_query;

CREATE TABLE `location` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `CITY` varchar(20) NOT NULL,
  `LATTITUDE` decimal(10,6) NOT NULL,
  `LONGITUDE` decimal(10,6) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `LOCATION_ADMIN` (
  `ID` int(11) NOT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `LOCATION_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `price_range` (
  `ID` int(11) NOT NULL,
  `CODE_VALUE` int(2) NOT NULL,
  `CODE_DESCRIPTION` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `restaurant` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `CONTACT_NO` varchar(11) DEFAULT NULL,
  `OWNER_NAME` varchar(45) NOT NULL,
  `OWNER_CONTACT_NO` varchar(11) DEFAULT NULL,
  `MANAGER_NAME` varchar(45) NOT NULL,
  `MANAGER_CONTACT_NO` varchar(11) DEFAULT NULL,
  `LOCATION_ID` int(11) NOT NULL,
  `RESTAURANT_STATUS_ID` int(11) NOT NULL,
  `ADDRESS` varchar(135) NOT NULL,
  `LATTITUDE` decimal(10,6) NOT NULL,
  `LONGITUDE` decimal(10,6) NOT NULL,
  `OPENING_TIME` time DEFAULT NULL,
  `closing_time` time DEFAULT NULL,
  `active_flag` int(11) DEFAULT NULL,
  `advance_booking_flag` int(11) DEFAULT NULL,
  `NON_VEG_FLAG` int(11) NOT NULL,
  `ALCOHOL_FLAG` int(2) DEFAULT '0',
  `USER_NAME` varchar(20) NOT NULL,
  `PRICE_RANGE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `LOCATION_ID_FK_idx` (`LOCATION_ID`),
  KEY `RESTAURANT_RESTAURANT_STATUS_ID_FK_idx` (`RESTAURANT_STATUS_ID`),
  KEY `RESTAURANT_PRICE_RANGE_FK_idx` (`PRICE_RANGE_ID`),
  KEY `RESTAURANT_USER_ID_FK_idx` (`USER_NAME`),
  CONSTRAINT `RESTAURANT_LOCATION_ID_FK` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RESTAURANT_PRICE_RANGE_FK` FOREIGN KEY (`PRICE_RANGE_ID`) REFERENCES `PRICE_RANGE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `RESTAURANT_RESTAURANT_STATUS_ID_FK` FOREIGN KEY (`RESTAURANT_STATUS_ID`) REFERENCES `restaurant_status` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

CREATE TABLE `restaurant_status` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OCCUPANCY` int(11) DEFAULT NULL,
  `WAIT_TIME_2` int(11) DEFAULT NULL,
  `WAIT_TIME_GROUP` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `FIRST_NAME` varchar(20) NOT NULL,
  `LAST_NAME` varchar(20) NOT NULL,
  `CONTACT_NO` varchar(20) NOT NULL,
  `EMAIL_ID` varchar(45) NOT NULL,
  `FACEBOOK_ID` varchar(45) DEFAULT NULL,
  `GOOGLE_ID` varchar(45) DEFAULT NULL,
  `PROFILE_PIC` varchar(45) DEFAULT NULL,
  `LAST_LOGIN` datetime DEFAULT NULL,
  `ACTIVE_FLAG` tinyint(1) NOT NULL DEFAULT '1',
  `ROLE` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_query` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
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