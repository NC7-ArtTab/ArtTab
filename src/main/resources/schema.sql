drop all objects;
CREATE TABLE test_table(
    abcd varchar(255)
);


CREATE TABLE `member` (
                          `mem_no` INT NOT NULL AUTO_INCREMENT COMMENT '회원번호',
                          `mem_email` VARCHAR(50) NOT NULL COMMENT '이메일',
                          `mem_pwd` VARCHAR(100) NOT NULL COMMENT '비밀번호',
                          `mem_name` VARCHAR(50) NOT NULL COMMENT '이름',
                          `mem_phone` VARCHAR(30) NOT NULL COMMENT '휴대폰',
                          `mem_zipcode` VARCHAR(10) NOT NULL COMMENT '우편번호',
                          `mem_addr` VARCHAR(255) NOT NULL COMMENT '기본주소',
                          `mem_detail_addr` VARCHAR(255) NOT NULL COMMENT '상세주소',
                          `mem_bank` VARCHAR(20) NULL COMMENT '은행명',
                          `mem_acc` VARCHAR(30) NULL COMMENT '계좌번호',
                          `mem_auth` CHAR(1) NULL DEFAULT 'M' COMMENT '회원권한 => A:관리자, M:일반회원',
                          `mem_datetime` DATETIME NULL DEFAULT NOW() COMMENT '회원등록일시',
                          `mem_status` CHAR(1) NULL DEFAULT 'Y' COMMENT '사용여부 => Y:회원, N:탈퇴회원',
                          PRIMARY KEY (`mem_no`)
);

CREATE TABLE `art` (
                       `art_no` INT NOT NULL AUTO_INCREMENT COMMENT '작품번호',
                       `art_title` VARCHAR(255) NOT NULL COMMENT '작품명',
                       `art_category` CHAR(1) NOT NULL COMMENT '작품구분 => 동양화 : E, 서양화:W, 공예품:P',
                       `art_writer` VARCHAR(20) NULL DEFAULT '작자미상' COMMENT '작가',
                       `art_conent` TEXT NULL COMMENT '작품설명',
                       `art_detail` MEDIUMTEXT NULL COMMENT '작품상세설명',
                       `start_price` INT NOT NULL COMMENT '경매시작가',
                       `buy_now_price` INT NOT NULL COMMENT '즉시구매가',
                       `bid_price_per` INT NOT NULL COMMENT '입찰가격단위',
                       `start_datetime` DATETIME NOT NULL COMMENT '경매시작일시',
                       `end_datetime` DATETIME NOT NULL COMMENT '경매종료일시',
                       `art_reg_datetime` DATETIME NULL DEFAULT NOW() COMMENT '작품등록일시',
                       `art_status` CHAR(1) NULL DEFAULT 'R' COMMENT '작품경매현황 => Y:낙찰 건, P:경매진행중인 건, R:경매준비중인 건, F:경매종료 건',
                       PRIMARY KEY (`art_no`)
);

CREATE TABLE `bid` (
                       `bid_no` INT NOT NULL AUTO_INCREMENT COMMENT '입찰번호',
                       `art_no` INT NOT NULL COMMENT '작품번호',
                       `mem_no` INT NOT NULL COMMENT '회원번호',
                       `bid_price` INT NOT NULL COMMENT '입찰가격',
                       `bid_datetime` DATETIME NULL DEFAULT NOW() COMMENT '입찰일시',
                       PRIMARY KEY (`bid_no`),
                       FOREIGN KEY (`art_no`) REFERENCES `art` (`art_no`),
                       FOREIGN KEY (`mem_no`) REFERENCES `member` (`mem_no`)
);

CREATE TABLE `file` (
                        `file_no` INT NOT NULL AUTO_INCREMENT COMMENT '파일번호',
                        `art_no` INT NOT NULL COMMENT '작품번호',
                        `file_path` VARCHAR(255) NOT NULL COMMENT '파일경로',
                        `origin_file_name` VARCHAR(50) NOT NULL COMMENT '원래파일명',
                        `save_file_name` VARCHAR(50) NOT NULL COMMENT '저장파일명',
                        `file_reg_datetime` DATETIME NULL DEFAULT NOW() COMMENT '파일등록일시',
                        `file_status` CHAR(1) NULL DEFAULT 'Y' COMMENT '파일사용여부 => 사용중(게시건), N:미사용(삭제건)',
                        PRIMARY KEY (`file_no`),
                        FOREIGN KEY (`art_no`) REFERENCES `art` (`art_no`)
);

CREATE TABLE `faq` (
                       `faq_no` INT NOT NULL AUTO_INCREMENT COMMENT 'faq번호',
                       `mem_no` INT NOT NULL COMMENT '회원번호',
                       `faq_title` VARCHAR(255) NOT NULL COMMENT 'faq제목',
                       `faq_content` MEDIUMTEXT NOT NULL COMMENT 'faq내용',
                       `faq_writer` INT NOT NULL COMMENT 'faq작가',
                       `faq_reg_datetime` DATETIME NULL DEFAULT NOW() COMMENT 'faq등록일시',
                       `faq_status` CHAR(1) NULL DEFAULT 'Y' COMMENT 'faq사용여부 => Y:사용중(게시중), N:미사용(삭제건)',
                       PRIMARY KEY (`faq_no`),
                       FOREIGN KEY (`mem_no`) REFERENCES `member` (`mem_no`)
);

CREATE TABLE `pay` (
                       `mem_no` INT NOT NULL COMMENT '회원번호',
                       `art_no` INT NOT NULL COMMENT '작품번호',
                       `pay_price` INT NOT NULL COMMENT '결제가격',
                       `pay_datetime` DATETIME NULL DEFAULT NOW() COMMENT '결제일시',
                       `pay_status` CHAR(1) NULL DEFAULT 'R' COMMENT '결제상태 =>  R:입금대기중 Y:결제완료',
                       PRIMARY KEY (`mem_no`, `art_no`),
                       FOREIGN KEY (`mem_no`) REFERENCES `member` (`mem_no`),
                       FOREIGN KEY (`art_no`) REFERENCES `art` (`art_no`)
);