DROP TABLE IF EXISTS 'persistence_logins';

CREATE TABLE `persistence_logins` (
	`no`	INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '번호',
	`username`		VARCHAR(100)	NOT NULL	COMMENT '회원 아이디',
	`token`			VARCHAR(255)	NOT NULL	COMMENT '인증 토큰',
	`expiry_date`	TIMESTAMP	NOT NULL	COMMENT '만료시간',
	`reg_date`		TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '등록일자',
	`upd_date`		TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '수정일자'
);