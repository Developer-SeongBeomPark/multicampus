create database javadb;

use javadb;

create table sungjuk(
		sungjukno 	int 		not null auto_increment primary key,
        name 		varchar(10) not null,
        kuk 		tinyint 	not null,
        eng 		tinyint 	not null,
        tot 		smallint 	default 0,
        avg 		float 		default 0.0
);

insert into sungjuk(name, kuk, eng) values ('김길동',87,94);
insert into sungjuk(name, kuk, eng) values ('가길동',90,15);

update sungjuk
	set tot = kuk + eng, avg = tot / 2;
    
select sungjukno '번호', name '이름', tot '총점', avg '평균'
	from sungjuk;
    
-- DELETE
use world;
select count(*) from city_popul
	where city_name like 'NEW%';
    
delete 
	from city_popul
	where city_name like 'NEW%'
    limit 5;
    
create table big_table1 (select * from city, sakila.country);
create table big_table2 (select * from city, sakila.country);
create table big_table3 (select * from city, sakila.country);

delete from big_table1; -- 2.054초
drop table big_table2; -- 0.016
truncate  big_table3; -- 0.031


-- 실습
create table memo_table(
	memono 		int 			auto_increment not null primary key,
    wname		varchar(20),
    title		varchar(200),
    content		text,
    passwd		varchar(10),
    viewcnt		int,
    wdate		date
);
delete from memo_table;

insert into memo_table values (null, '메모1', '제목', '내용', '비멀번호', 0, '2022-04-05');
insert into memo_table values (null, '메모2', '제목', '내용', '비멀번호', 0, '2022-04-05');
insert into memo_table values (null, '메모3', '제목', '내용', '비멀번호', 0, '2022-04-05');

update memo_table
	set content = '안녕하세요'
    where wname = '메모1';

delete
	from memo_table
    where wname = '메모3';
    
select *
	from memo_table
    where memono = 2;
    
select *
	from memo_table;
 
 
 -- 데이터 형 변환
 use market_db;
 select cast(avg(price) AS signed) '평균가격' from buy;
 select convert(avg(price), signed) '평균가격' from buy;
 
select cast('2022$12$12' as DATE);
select cast('2022/12/12' as DATE);
select cast('2022%12%12' as DATE);
select cast('2022@12@12' as DATE);

-- concat
select num, concat(cast(price as char), 'X', cast(amount as char), '=') '가격 X 수량', price * amount '구매액'
	from buy;
    
select '100' + '200'; -- 300
select concat('100','200'); -- 100200
 
select concat(100, '200'); -- 100200
select 100 + '200'; -- 300

-- join

-- inner join
select buy.mem_id, member.mem_name, buy.prod_name, member.addr,
concat(phone1,phone2) '연락처'
 from  buy
 inner join member
 on buy.mem_id = member.mem_id
 where buy.mem_id = 'GRL';
 
 select b.mem_id, m.mem_name, b.prod_name, m.addr, concat(phone1, phone2) '연락처'
	from buy b
    join member m
    on b.mem_id = m.mem_id
    where b.mem_id = 'GRL';
 
 
 -- outer join
 
 select m.mem_id, m.mem_name, b.prod_name, m.addr
  from member m
  left outer join buy b # 왼쪽에 있는 member 테이블에 대한 모든 값을 가져오겠다.
  on m.mem_id = b.mem_id
  order by mem_id;
  
select m.mem_id, m.mem_name, b.prod_name, m.addr
 from  buy b
 right outer join member m # 오른쪽에 있는 member테이블에 대한 모든 값을 가져오겠다.
 on m.mem_id = b.mem_id
 order by m.mem_id;
 
 
 -- self join
 create table emp_table(
	emp 		char(4),
    manager 	char(4),
    phone		varchar(8)
 );
 
INSERT INTO emp_table VALUES('대표', NULL, '0000');
INSERT INTO emp_table VALUES('영업이사', '대표', '1111');
INSERT INTO emp_table VALUES('관리이사', '대표', '2222');
INSERT INTO emp_table VALUES('정보이사', '대표', '3333');
INSERT INTO emp_table VALUES('영업과장', '영업이사', '1111-1');
INSERT INTO emp_table VALUES('경리부장', '관리이사', '2222-1');
INSERT INTO emp_table VALUES('인사부장', '관리이사', '2222-2');
INSERT INTO emp_table VALUES('개발팀장', '정보이사', '3333-1');
INSERT INTO emp_table VALUES('개발주임', '정보이사', '3333-1-1');

select a.emp 직원, b.emp 직속상관, b.phone 직속상관연락처
	from emp_table a
    join emp_table b
    on a.manager = b.emp
    where a.emp = '경리부장';
    
    
-- SQL 고급
drop database if exists naver_db;
create database naver_db;
use naver_db;
drop table if exists member;

create table member(
	mem_id 		char(8)		not null primary key,
    mem_name	varchar(10) not null,
    mem_number	tinyint		not null,
    addr		char(2) 	not null,
    phone1		char(3) 	,
    phone2		char(8)		,
    height		tinyint	unsigned ,
    debut_date	date		
);

drop table if exists buy;
create table buy(
	num			int					not null	auto_increment primary key,
    mem_id		char(8)				not null,
    prod_name	char(6)				not null,
    group_name	char(4)	,
    price		smallint unsigned	not null,
    foreign key(mem_id) references member(mem_id)
);

-- 부모테이블 먼저 데이터를 입력한다.
-- 참조하고 있는 자식 테이블은 나중에 입력한다.
-- 외래키 열은 부모 테이블에 존재하는 컬럼값만 입력할 수 있다.


INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015-10-19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016-8-8');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015-1-15');

select * from member;

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200); -- APN은 부모에 없기때문에 오류
select * from buy;
 
describe member; -- desc member;

-- primary key 지정 방법
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL
);

CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL,
  PRIMARY KEY (mem_id)
);

CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL,
  CONSTRAINT PRIMARY KEY PK_member_mem_id (mem_id)
);

CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL
);
 
ALTER TABLE member
     ADD CONSTRAINT 
     PRIMARY KEY (mem_id);


-- 기본키-외래키로 맺어진 후에는 기준 테이블의 열이름이 변경되지 않는다.
INSERT INTO member VALUES('BLK', '블랙핑크', 163);
INSERT INTO buy VALUES(NULL, 'BLK', '지갑');
INSERT INTO buy VALUES(NULL, 'BLK', '맥북');
 
SELECT M.mem_id, M.mem_name, B.prod_name 
   FROM buy B
      INNER JOIN member M
      ON B.mem_id = M.mem_id;
      
UPDATE member SET mem_id = 'PINK' WHERE mem_id='BLK';
-- Error Code: 1451. Cannat delete or update a parent row: a foreign key constraint fails
-- 삭제도 같은 오류로 삭제되지 않는다.
DELETE FROM member WHERE  mem_id='BLK';

-- ON UPDATE CASCADE : 기준테이블의 열이름이 변경될 때 참조 테이블의 열이름이 자동으로 변경된다.
drop table if exists buy;
create table buy(
	num         INT 	AUTO_INCREMENT NOT NULL PRIMARY KEY,
	mem_id      CHAR(8) NOT NULL, 
	prod_name   CHAR(6) NOT NULL	
);
alter table buy
	add constraint
    FOREIGN KEY(mem_id) REFERENCES member(mem_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE;
    
INSERT INTO buy VALUES(NULL, 'BLK', '지갑');
INSERT INTO buy VALUES(NULL, 'BLK', '맥북');
 
select * from buy;

UPDATE member SET mem_id = 'PINK' WHERE mem_id='BLK';

SELECT M.mem_id, M.mem_name, B.prod_name 
   FROM buy B
      INNER JOIN member M
      ON B.mem_id = M.mem_id;
      

-- 고유 키(Unique)
drop table if exists buy, member;

create table member(
	mem_id		char(8)		not null primary key,
    mem_name	varchar(10)	not null,
    height		tinyint unsigned,
    email		char(30)	unique
);

INSERT INTO member VALUES('BLK', '블랙핑크', 163, 'pink@gmail.com');
INSERT INTO member VALUES('TWC', '트와이스', 167);
INSERT INTO member VALUES('APN', '에이핑크', 164, 'pink@gmail.com'); 
-- unique 때문에 에러 발생


-- 체크(check) 제약조건
DROP TABLE IF EXISTS member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL CHECK (height >= 100),
  phone1      CHAR(3)
);

INSERT INTO member VALUES('BLK', '블랙핑크', 163, null);
INSERT INTO member VALUES('TWC', '트와이스', 99, null);
-- 오류 메세지
-- Error Code : 3819. Check constraint 'member_ch_1' is violated

-- Alter Table로 제약조건 추가할 수 있다.
ALTER TABLE member
    ADD CONSTRAINT 
    CHECK  (phone1 IN ('02', '031', '032', '054', '055', '061' )) ;
 
INSERT INTO member VALUES('TWC', '트와이스', 167, '02');
INSERT INTO member VALUES('OMY', '오마이걸', 167, '010');
-- 오류 메세지
-- Error Code : 3819. Check constraint 'member_ch_2' is violated

select *
	from information_schema.table_constraints;
    
-- 기본값 정의
DROP TABLE IF EXISTS member;
CREATE TABLE member 
( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
  mem_name    VARCHAR(10) NOT NULL, 
  height      TINYINT UNSIGNED NULL DEFAULT 160,
  phone1      CHAR(3)  NULL
);

-- alter table을 사용시에는 alter column문을 사용한다.
ALTER TABLE member
    ALTER COLUMN phone1 SET DEFAULT '02';
    
INSERT INTO member VALUES('RED', '레드벨벳', 161, '054');
INSERT INTO member VALUES('SPC', '우주소녀', default, default);
SELECT * FROM member;


-- 뷰(View)
USE market_db;
CREATE VIEW v_member
	AS
    SELECT mem_id, mem_name, addr FROM member;
 
SELECT * FROM v_member;

SELECT mem_name, addr FROM v_member
   WHERE addr IN ('서울', '경기');
   
CREATE VIEW v_memberbuy
AS
    SELECT B.mem_id, M.mem_name, B.prod_name, M.addr, 
            CONCAT(M.phone1, M.phone2) '연락처' 
       FROM buy B
         INNER JOIN member M
         ON B.mem_id = M.mem_id;
 
SELECT * FROM v_memberbuy WHERE mem_name = '블랙핑크';

