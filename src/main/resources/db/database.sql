set foreign_key_checks = 0;

CREATE TABLE `cuisine` (
  `ID` int(11) NOT NULL COMMENT 'Primary Key',
  `RESTAURANT_ID` int(11) NOT NULL COMMENT 'Foreign Key to map with Restaurant.',
  `MENU_ID` int(11) NOT NULL,
  `NAME` varchar(45) NOT NULL COMMENT 'Name. e.g. Paneer Tikka Masala.',
  `DESCRIPTION` varchar(125) DEFAULT NULL COMMENT 'Detailed Description of the Cuisine.',
  `TYPE_TAG` varchar(20) DEFAULT NULL COMMENT 'Mapped to CUISINE_SYSTEM_CODES',
  `RATING_FLAG` tinyint(1) NOT NULL COMMENT 'Whether user can rate this cuisine or not',
  `RATING` decimal(4,0) DEFAULT NULL COMMENT 'Cumulative rating of this cuisine',
  `RATING_LSTUPDDT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ACTIVE_FLAG` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `RESTAURANT_ID_FK_idx` (`RESTAURANT_ID`),
  KEY `MENU_ID_FK_idx` (`MENU_ID`),
  CONSTRAINT `CUISINE_MENU_ID_FK` FOREIGN KEY (`MENU_ID`) REFERENCES `menu` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `CUISINE_RESTAURANT_ID_FK` FOREIGN KEY (`RESTAURANT_ID`) REFERENCES `restaurant` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Stores the description of Cuisine served by the Restaurant.\nMapped to Restaurant and Menu.';

CREATE TABLE `cuisine_price_details` (
  `ID` int(11) NOT NULL,
  `CUISINE_VARIANT_ID` int(11) NOT NULL COMMENT 'Mapping from CUISINE.ID',
  `CUISINE_QUANTITY` varchar(12) DEFAULT NULL,
  `PRICE` decimal(10,0) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `CUISINE_VARIANT_ID_FK_idx` (`CUISINE_VARIANT_ID`),
  CONSTRAINT `CUISINE_PRICE_DETAILS_CUISINE_VARIANT_ID_FK` FOREIGN KEY (`CUISINE_VARIANT_ID`) REFERENCES `cuisine_variant` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cuisine_variant` (
  `ID` int(11) NOT NULL,
  `CUISINE_ID` int(11) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `NONVEG_FLAG` tinyint(1) NOT NULL,
  `SPICE_LEVEL` int(11) NOT NULL COMMENT 'Mapped to SYSTEM_CODES.CODE_ID',
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  `ACTIVE_FLAG` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `CUISINE_ID_FK_idx` (`CUISINE_ID`),
  CONSTRAINT `CUISINE_VARIANT_CUISINE_ID_FK` FOREIGN KEY (`CUISINE_ID`) REFERENCES `cuisine` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `feffew_idx` (`location_id`),
  CONSTRAINT `location_id_fk` FOREIGN KEY (`location_id`) REFERENCES `location` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `location` (
  `ID` int(11) NOT NULL COMMENT 'To be stored in corresponding Columns of Table RESTAURANT',
  `NAME` varchar(45) NOT NULL COMMENT 'Name of the location:\nSector - 22 B',
  `CITY` varchar(20) NOT NULL COMMENT 'City of the location:\nGurgaon',
  `LATTITUDE` decimal(10,6) NOT NULL COMMENT 'Mean coordinates of this location\n',
  `LONGITUDE` decimal(10,6) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table stores saved locations which are pre-defined.\ne.g. Gurgaon is divided in various location such as Sector-22 B, Sector- 21 etc.\nIt also stores the mean coordinates of that particular location.';

CREATE TABLE `menu` (
  `ID` int(11) NOT NULL COMMENT 'Primary Key',
  `RESTAURANT_ID` int(11) NOT NULL COMMENT 'Foreign Ket: Maps the table with the corresponding Restaurant.',
  `TYPE` varchar(45) NOT NULL COMMENT 'Menu Types:\nSoup,Starters,Main Course',
  `ACTIVE_FLAG` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Whether the Restaurant serves the Menu Type or not.',
  PRIMARY KEY (`ID`),
  KEY `RESTAURANT_ID_FK_idx` (`RESTAURANT_ID`),
  CONSTRAINT `MENU_RESTAURANT_ID_FK` FOREIGN KEY (`RESTAURANT_ID`) REFERENCES `restaurant` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table describes the different criteria in the Restaurant Menu.\ne.g. Soup,Starters,Main Course';

CREATE TABLE `order` (
  `ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `RESTAURANT_ID` int(11) NOT NULL,
  `USER_ALTERNATE_NO` int(11) DEFAULT NULL,
  `ORDER_TIME` datetime NOT NULL,
  `ORDER_TYPE` varchar(20) NOT NULL COMMENT 'Mapped to ORDER_SYSTEM_CODES, InHouse/ PreOrder',
  `NO_OF_PEOPLE` int(11) NOT NULL,
  `ESTMTD_ARRIVAL_TIME` time DEFAULT NULL,
  `ORDER_INSTRUCTIONS` varchar(255) DEFAULT NULL COMMENT 'Special Cooking instructions',
  `NET_AMOUNT` decimal(20,0) NOT NULL,
  `ORDER_TAX1` decimal(20,0) DEFAULT NULL,
  `ORDER_TAX2` decimal(20,0) DEFAULT NULL,
  `ORDER_TAX3` decimal(20,0) DEFAULT NULL,
  `TOTAL_AMOUNT` decimal(20,0) NOT NULL,
  `PAYMENT_MODE` varchar(20) NOT NULL COMMENT 'Create mapping Table',
  `STATUS` varchar(20) NOT NULL COMMENT 'Mapped to ORDER_SYSTEM_CODES, Cancelled by User/System Cancelled/Completed/Rated ',
  `CANCELATION_TIME` datetime DEFAULT NULL,
  `CANCELATION_REASON` varchar(255) DEFAULT NULL,
  `RATING_1` decimal(4,0) DEFAULT NULL,
  `RATING_2` decimal(4,0) DEFAULT NULL,
  `RATING_3` decimal(4,0) DEFAULT NULL,
  `FINAL_RATING` decimal(4,0) DEFAULT NULL,
  `USER_RATING_COMMENTS` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USER_ID_FK_idx` (`USER_ID`),
  KEY `RESTAURANT_ID_FK_idx` (`RESTAURANT_ID`),
  CONSTRAINT `ORDER_RESTAURANT_ID_FK` FOREIGN KEY (`RESTAURANT_ID`) REFERENCES `restaurant` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ORDER_USER_ID_FK` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Contains Order Details (Single Row per Order)';

CREATE TABLE `order_details` (
  `ID` int(11) NOT NULL,
  `ORDER_ID` int(11) NOT NULL,
  `CUISINE_VARIANT_ID` int(11) NOT NULL,
  `CUISINE_PRICE_DETAILS_ID` int(11) DEFAULT NULL,
  `NO_OF_ITEMS` int(11) DEFAULT NULL,
  `PRICE` decimal(20,0) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ORDER_ID_FK_idx` (`ORDER_ID`),
  KEY `CUISIN_VARIANT_ID_FK_idx` (`CUISINE_VARIANT_ID`),
  KEY `CUSIN_PRICE_DETAILS_ID_FK_idx` (`CUISINE_PRICE_DETAILS_ID`),
  CONSTRAINT `ORDER_DETAILS_CUISIN_VARIANT_ID_FK` FOREIGN KEY (`CUISINE_VARIANT_ID`) REFERENCES `cuisine_variant` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ORDER_DETAILS_CUSIN_PRICE_DETAILS_ID_FK` FOREIGN KEY (`CUISINE_PRICE_DETAILS_ID`) REFERENCES `cuisine_price_details` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ORDER_DETAILS_ORDER_ID_FK` FOREIGN KEY (`ORDER_ID`) REFERENCES `order` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `restaurant` (
  `ID` int(11) NOT NULL COMMENT 'Unique Restaurent ID',
  `NAME` varchar(45) NOT NULL COMMENT 'Restaurent Name',
  `DESCRIPTION` varchar(100) NOT NULL COMMENT 'Detailed Restaurant Description',
  `CONTACT_NO` int(11) NOT NULL COMMENT 'Landline/ Mobile Contact Number of Restaurant',
  `OWNER_NAME` varchar(45) NOT NULL COMMENT 'Name of the  Owner',
  `OWNER_CONTACT_NO` int(11) DEFAULT NULL COMMENT 'Owner Contact Number',
  `MANAGER_NAME` varchar(45) NOT NULL COMMENT 'Manager Name',
  `MANAGER_CONTACT_NO` int(11) NOT NULL COMMENT 'Manager Contact Number',
  `LOCATION_ID` int(11) NOT NULL COMMENT 'Mapped to RESTAURANT_SYSTEM_CODES\n(Used to Map Locality\ne.g. Sector-22 B)',
  `ADDRESS` varchar(135) NOT NULL COMMENT 'Detailed Address',
  `LATTITUDE` decimal(10,6) NOT NULL COMMENT 'Used to implement Google Map Integration',
  `LONGITUDE` decimal(10,6) NOT NULL,
  `OPENING_TIME` time(6) NOT NULL COMMENT 'Opening Hour',
  `CLOSING_TIME` time(6) NOT NULL COMMENT 'Closing Hour',
  `PRICE_RANGE` varchar(20) NOT NULL COMMENT 'Mapped to RESTAURANT_SYSTEM_CODES',
  `RATING` decimal(4,0) NOT NULL COMMENT 'Cumulative Rating of the Restaurant',
  `RATING_LSTUPDDT` datetime NOT NULL COMMENT 'Last updated time of the Rating.',
  `ACTIVE_FLAG` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Flag used describe whether the Restaurant is Active,Closed Permanently.',
  `NONVEG_FLAG` tinyint(1) NOT NULL COMMENT 'Whether the restaurant serves non-veg or not',
  `ALCOHOL_FLAG` tinyint(1) NOT NULL COMMENT 'Whether the restaurant serves alcohol or not\n',
  PRIMARY KEY (`ID`),
  KEY `LOCATION_ID_FK_idx` (`LOCATION_ID`),
  CONSTRAINT `RESTAURANT_LOCATION_ID_FK` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table contains the detailed description of Restaurant.';

CREATE TABLE `system_codes` (
  `CODE_ID` int(11) NOT NULL,
  `CODE_NAME` varchar(20) NOT NULL,
  `CODE_TYPE` varchar(20) NOT NULL COMMENT 'TYPE_TAG,\nSPICE_METER',
  `CODE_DESC` varchar(45) DEFAULT NULL COMMENT 'Mughlai, Low-Medium-High',
  PRIMARY KEY (`CODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) NOT NULL COMMENT 'login id of the user',
  `PASSWORD` varchar(20) NOT NULL,
  `FIRST_NAME` varchar(20) NOT NULL COMMENT 'first name of the user',
  `LAST_NAME` varchar(20) NOT NULL COMMENT 'last name of the user',
  `CONTACT_NO` varchar(20) NOT NULL COMMENT 'Contact no of the user',
  `EMAIL_ID` varchar(45) NOT NULL,
  `FACEBOOK_ID` varchar(45) DEFAULT NULL,
  `GOOGLE_ID` varchar(45) DEFAULT NULL,
  `PROFILE_PIC` varchar(45) DEFAULT NULL,
  `LAST_LOGIN` datetime DEFAULT NULL COMMENT 'Last login date time',
  `ROLE` varchar(45) NOT NULL,
  `ACTIVE_FLAG` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='Contains End User Data';

set foreign_key_checks = 1;