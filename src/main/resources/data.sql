insert into test_table values ('a');
insert into test_table values ('b');
insert into test_table values ('c');
insert into test_table values ('d');

INSERT INTO `art` (`art_title`, `art_category`, `art_writer`,  `art_conent`, `art_detail`, `start_price`, `buy_now_price`, `bid_price_per`, `start_datetime`, `end_datetime`, `art_status`)
VALUES
    ('yellow', 'E', 'old', 'hyun', 'old clothes', 10000, 20000, 1000, NOW(), NOW(), 'R'),
    ('pink', 'W', 'happy', 'joo', 'pretty pants', 15000, 25000, 1000, NOW(), NOW(), 'R');

INSERT INTO `faq` (
    `mem_no`,
    `faq_title`,
    `faq_content`,
    `faq_writer`
) VALUES
    (1, 'FAQ 1', 'FAQ 내용 1', 2),
    (2, 'FAQ 2', 'FAQ 내용 2', 2);
