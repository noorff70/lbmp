CREATE TABLE `user` (
  `USERID` int(11) NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `USERTYPE` varchar(45) DEFAULT NULL,
  `POSTALCODE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;