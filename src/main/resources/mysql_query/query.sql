DROP TABLE IF EXISTS `sample_user`;

CREATE TABLE `sample_user` (
  `user_id` varchar(20) NOT NULL COMMENT '아이디',
  `user_password` varchar(100) NOT NULL COMMENT '비밀번호',
  `user_name` varchar(20) NOT NULL COMMENT '이름',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '업데이트날짜',
  `register_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '등록날짜',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO sample_user(user_id, user_password,user_name,register_date)
values('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '부트관리자', now());

DROP TABLE IF EXISTS `sample_faq`;

CREATE TABLE `sample_faq` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `title` varchar(100) NOT NULL COMMENT '제목',
  `content` varchar(1000) NOT NULL COMMENT '내용',
  `user_id` varchar(20) NOT NULL COMMENT '작성자아이디',
  `register_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '등록날짜',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '업데이트날짜',
  PRIMARY KEY (`id`),
  KEY `sample_faq_fk` (`user_id`),
  CONSTRAINT `sample_faq_fk` FOREIGN KEY (`user_id`) REFERENCES `sample_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO sample_faq(title, content, user_id, register_date) values('제목1', '내용1', 'admin', now());
INSERT INTO sample_faq(title, content, user_id, register_date) values('제목2', '내용2', 'admin', now());
INSERT INTO sample_faq(title, content, user_id, register_date) values('제목3', '내용3', 'admin', now());