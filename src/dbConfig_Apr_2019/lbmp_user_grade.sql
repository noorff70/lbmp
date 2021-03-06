CREATE TABLE `user_grade` (
  `USER_USERID` int(11) NOT NULL,
  `GRADE_GRADEID` int(11) NOT NULL,
  PRIMARY KEY (`USER_USERID`,`GRADE_GRADEID`),
  KEY `FK_GRADE_GRADEID_idx` (`GRADE_GRADEID`),
  CONSTRAINT `FK_GRADE_GRADEID` FOREIGN KEY (`GRADE_GRADEID`) REFERENCES `grade` (`GRADEID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USR_USERID` FOREIGN KEY (`USER_USERID`) REFERENCES `user` (`USERID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
