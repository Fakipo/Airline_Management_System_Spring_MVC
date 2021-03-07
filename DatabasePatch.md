
CREATE TABLE `aeroplane` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  `noofseats` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `airport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `airportname` varchar(100) DEFAULT NULL,
  `airportcity` varchar(100) DEFAULT NULL,
  `airportstate` varchar(100) DEFAULT NULL,
  `airportcountry` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `recepientname` varchar(75) DEFAULT NULL,
  `recepientemail` varchar(255) DEFAULT NULL,
  `cargosizelarge` tinyint(4) DEFAULT NULL,
  `sendername` varchar(75) DEFAULT NULL,
  `recepientmobile` varchar(15) DEFAULT NULL,
  `recepientaddress` varchar(45) DEFAULT NULL,
  `sendermobile` varchar(15) DEFAULT NULL,
  `cargodate` timestamp NULL DEFAULT NULL,
  `fromairportid` int(11) DEFAULT NULL,
  `toairportid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cargo_ibfk_1_idx` (`fromairportid`),
  KEY `cargo_ibfk_2_idx` (`toairportid`),
  KEY `cargo_ibfk_3_idx` (`userid`),
  CONSTRAINT `cargo_ibfk_1` FOREIGN KEY (`fromairportid`) REFERENCES `airport` (`id`),
  CONSTRAINT `cargo_ibfk_2` FOREIGN KEY (`toairportid`) REFERENCES `airport` (`id`),
  CONSTRAINT `cargo_ibfk_3` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `flight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flightcharge` int(11) DEFAULT NULL,
  `aeroplaneid` int(11) DEFAULT NULL,
  `destairportid` int(11) DEFAULT NULL,
  `fromairportid` int(11) DEFAULT NULL,
  `arrivaldatetime` timestamp NULL DEFAULT NULL,
  `departuredatetime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `flight_ibfk_1_idx` (`aeroplaneid`),
  KEY `flight_ibfk_2_idx` (`destairportid`),
  KEY `flight_ibfk_2_idx1` (`fromairportid`),
  CONSTRAINT `flight_ibfk_1` FOREIGN KEY (`aeroplaneid`) REFERENCES `aeroplane` (`id`),
  CONSTRAINT `flight_ibfk_2` FOREIGN KEY (`destairportid`) REFERENCES `airport` (`id`),
  CONSTRAINT `flight_ibfk_3` FOREIGN KEY (`fromairportid`) REFERENCES `airport` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `passenger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first` varchar(75) DEFAULT NULL,
  `last` varchar(75) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `passportno` varchar(45) DEFAULT NULL,
  `flightid` int(11) DEFAULT NULL,
  `seatno` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passengerid` int(11) DEFAULT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `noofitems` int(11) DEFAULT NULL,
  `itemprice` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `country` varchar(75) DEFAULT NULL,
  `fullname` varchar(105) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
