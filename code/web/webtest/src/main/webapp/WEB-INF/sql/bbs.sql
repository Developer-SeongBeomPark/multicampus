drop database if exists webtest;
CREATE DATABASE webtest;
use webtest;
drop table if exists bbs;
CREATE TABLE bbs ( 
  bbsno     int NOT NULL auto_increment primary key,   -- 글 일련 번호
  wname     VARCHAR(20)      NOT NULL,   -- 글쓴이 
  title     VARCHAR(100)        NOT NULL,   -- 제목(*) 
  content   VARCHAR(4000)    NOT NULL,   -- 글 내용 
  passwd    VARCHAR(15)      NOT NULL,   -- 비밀 번호 
  viewcnt   int                    DEFAULT 0,  -- 조회수, 기본값 사용 
  wdate     DATE                NOT NULL,   -- 등록 날짜,  
  grpno     int                   DEFAULT 0,  -- 부모글 번호 
  indent    int                   DEFAULT 0,  -- 답변여부,답변의 깊이
  ansnum    int                 DEFAULT 0  -- 답변 순서 
);

-- create
insert into bbs(wname, title, content, passwd, wdate) 
values('왕눈이', '제목', '내용', '1234', sysdate());
insert into bbs(wname, title, content, passwd, wdate) 
values('아로미', '제목', '내용', '31421', sysdate());
insert into bbs(wname, title, content, passwd, wdate) 
values('홍길동', '제목', '내용', '51234', sysdate());

-- list
select bbsno, wname, title, viewcnt, wdate, grpno, indent, ansnum
	from bbs
    --  where wname like '%t%'
    order by bbsno desc
    limit 0, 5;
    
-- total 레코드 개수
select count(*)
	from bbs;
    
-- 조회수 증가
update bbs
 set viewcnt = viewcnt + 1
 where bbsno = 1;
 
-- 조회
select bbsno, wname, title, content, viewcnt, wdate
	from bbs
    where bbsno = 1;
    
-- 패스워드 검사
select count(bbsno) as cnt
	from bbs
    where bbsno = 1
    and passwd = '1234';
    
-- update
update bbs
	set wname = '김길동',
		title = '비오는날',
        content = '개구리 연못'
	where bbsno = 1;
    
-- delete
delete from bbs
	where bbsno = 1;