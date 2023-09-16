-- 회원 테이블에 테스트 데이터 삽입
INSERT INTO `member` (`mem_email`, `mem_pwd`, `mem_name`, `mem_phone`, `mem_zipcode`, `mem_addr`, `mem_detail_addr`, `mem_bank`, `mem_acc`, `mem_auth`, `mem_status`)
VALUES
    ('aaa@etest.com', sha1('1111'), '사용자', '010-1234-5678', '12345', '주소1', '상세주소1', '국민은행', '1234567890', 'M', 'Y'),
    ('bbb@test.com', sha1('1111'), '관리자', '010-5678-1234', '54321', '주소2', '상세주소2', '하나은행', '0987654321', 'A', 'Y');

-- 작품 테이블에 테스트 데이터 삽입
INSERT INTO `art` (`art_title`, `art_category`, `start_price`, `buy_now_price`, `bid_price_per`, `start_datetime`, `end_datetime`, `art_status`)
VALUES
    ('작품1', 'E', 10000, 20000, 1000, NOW(), NOW(), 'R'),
    ('작품2', 'W', 15000, 25000, 1000, NOW(), NOW(), 'R');

-- 경매 입찰 테이블에 테스트 데이터 삽입
INSERT INTO `bid` (`art_no`, `mem_no`, `bid_price`)
VALUES
    (1, 1, 12000),
    (1, 2, 13000),
    (2, 1, 16000);

-- 파일 테이블에 테스트 데이터 삽입
INSERT INTO `file` (`art_no`, `file_path`, `origin_file_name`, `save_file_name`)
VALUES
    (1, '/path/to/file1.jpg', 'file1.jpg', 'file1_saved.jpg'),
    (2, '/path/to/file2.jpg', 'file2.jpg', 'file2_saved.jpg');

-- FAQ 테이블에 테스트 데이터 삽입
INSERT INTO `faq` (`mem_no`, `faq_title`, `faq_content`, `faq_writer`)
VALUES
    (1, 'FAQ 1', 'FAQ 내용 1', 2),
    (2, 'FAQ 2', 'FAQ 내용 2', 2);

-- 결제 테이블에 테스트 데이터 삽입
INSERT INTO `pay` (`mem_no`, `art_no`, `pay_price`)
VALUES
    (1, 1, 20000),
    (2, 2, 25000);


