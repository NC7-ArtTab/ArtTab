DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS bid;
DROP TABLE IF EXISTS file;
DROP TABLE IF EXISTS faq;
DROP TABLE IF EXISTS pay;

CREATE TABLE member (
                        mem_no INT AUTO_INCREMENT PRIMARY KEY,
                        mem_email VARCHAR(50) NOT NULL,
                        mem_pwd VARCHAR(100) NOT NULL,
                        mem_name VARCHAR(50) NOT NULL,
                        mem_phone VARCHAR(30) NOT NULL,
                        mem_zipcode VARCHAR(10) NOT NULL,
                        mem_addr VARCHAR(255) NOT NULL,
                        mem_detail_addr VARCHAR(255) NOT NULL,
                        mem_bank VARCHAR(20),
                        mem_acc VARCHAR(30),
                        mem_auth CHAR(1) DEFAULT 'M',
                        mem_datetime DATETIME DEFAULT CURRENT_TIMESTAMP,
                        mem_status CHAR(1) DEFAULT 'Y'
);

CREATE TABLE art (
                     art_no INT AUTO_INCREMENT PRIMARY KEY,
                     art_title VARCHAR(255) NOT NULL,
                     art_category CHAR(1) NOT NULL,
                     art_writer VARCHAR(20) DEFAULT '작자미상',
                     art_conent TEXT,
                     art_detail MEDIUMTEXT,
                     start_price INT NOT NULL,
                     buy_now_price INT NOT NULL,
                     bid_price_per INT NOT NULL,
                     start_datetime DATETIME NOT NULL,
                     end_datetime DATETIME NOT NULL,
                     art_reg_datetime DATETIME DEFAULT CURRENT_TIMESTAMP,
                     art_status CHAR(1) DEFAULT 'R'
);

CREATE TABLE bid (
                     bid_no INT AUTO_INCREMENT PRIMARY KEY,
                     art_no INT NOT NULL,
                     mem_no INT NOT NULL,
                     bid_price INT NOT NULL,
                     bid_datetime DATETIME DEFAULT CURRENT_TIMESTAMP,
                     FOREIGN KEY (art_no) REFERENCES art(art_no),
                     FOREIGN KEY (mem_no) REFERENCES member(mem_no)
);

CREATE TABLE file (
                      file_no INT AUTO_INCREMENT PRIMARY KEY,
                      art_no INT NOT NULL,
                      file_path VARCHAR(255) NOT NULL,
                      origin_file_name VARCHAR(50) NOT NULL,
                      save_file_name VARCHAR(50) NOT NULL,
                      file_reg_datetime DATETIME DEFAULT CURRENT_TIMESTAMP,
                      file_status CHAR(1) DEFAULT 'Y',
                      FOREIGN KEY (art_no) REFERENCES art(art_no)
);

CREATE TABLE faq (
                     faq_no INT AUTO_INCREMENT PRIMARY KEY,
                     mem_no INT NOT NULL,
                     faq_title VARCHAR(255) NOT NULL,
                     faq_content MEDIUMTEXT NOT NULL,
                     faq_writer INT NOT NULL,
                     faq_reg_datetime DATETIME DEFAULT CURRENT_TIMESTAMP,
                     faq_status CHAR(1) DEFAULT 'Y',
                     FOREIGN KEY (mem_no) REFERENCES member(mem_no)
);

CREATE TABLE pay (
                     mem_no INT NOT NULL,
                     art_no INT NOT NULL,
                     pay_price INT NOT NULL,
                     pay_datetime DATETIME DEFAULT CURRENT_TIMESTAMP,
                     pay_status CHAR(1) DEFAULT 'R',
                     PRIMARY KEY (mem_no, art_no),
                     FOREIGN KEY (mem_no) REFERENCES member(mem_no),
                     FOREIGN KEY (art_no) REFERENCES art(art_no)
);