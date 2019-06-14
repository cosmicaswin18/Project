CREATE TABLE `ebook` (
  `callno` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `issued` int(11) DEFAULT NULL,
  PRIMARY KEY (`callno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ecount` (
  `studentid` varchar(100) NOT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `eissuebook` (
  `callno` varchar(100) DEFAULT NULL,
  `studentid` varchar(100) DEFAULT NULL,
  `studentname` varchar(100) DEFAULT NULL,
  `studentmobile` double DEFAULT NULL,
  `issuedate` date DEFAULT NULL,
  `returnstatus` varchar(100) DEFAULT NULL,
  `overdue` varchar(100) DEFAULT NULL,
  `returndate` date DEFAULT NULL,
  KEY `callno` (`callno`),
  KEY `studentid` (`studentid`),
  CONSTRAINT `eissuebook_ibfk_1` FOREIGN KEY (`callno`) REFERENCES `ebook` (`callno`),
  CONSTRAINT `eissuebook_ibfk_2` FOREIGN KEY (`studentid`) REFERENCES `ecount` (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `elibrarian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
