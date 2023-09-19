drop all objects;
CREATE TABLE member (
  `mem_no` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT ,
  `mem_email` varchar(50) NOT NULL ,
  `mem_pwd` varchar(100) DEFAULT NULL ,
  `mem_name` varchar(50) NOT NULL  ,
  `mem_phone` varchar(30) NOT NULL ,
  `mem_zipcode` varchar(10) NOT NULL ,
  `mem_addr` varchar(255) NOT NULL ,
  `mem_detail_addr` varchar(255) NOT NULL ,
  `mem_bank` varchar(20) DEFAULT NULL ,
  `mem_acc` varchar(30) DEFAULT NULL ,
  `mem_auth` char(1) DEFAULT NULL ,
  `mem_createdDate` datetime DEFAULT NULL ,
  `mem_status` char(1) DEFAULT NULL
) ;

CREATE TABLE test (
  id varchar(50)
);