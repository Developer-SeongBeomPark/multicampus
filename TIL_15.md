### Day 15(4/25 Mon)

---

[Delete](#delete)

[데이터 형 변환](#데이터-형-변환)

[JOIN](#join)

[테이블과 뷰](#테이블과-뷰)

[제약조건](#제약조건)

[가상테이블 뷰](#가상테이블-뷰)





##### Delete

---

```mysql
-- DELETE
use world;
select count(*) from city_popul
	where city_name like 'NEW%';
    
delete 
	from city_popul
	where city_name like 'NEW%'
    limit 5;
```



##### 데이터 형 변환

---

```mysql
-- cast
select cast(avg(price) AS signed) '평균가격' from buy;
select cast('2022$12$12' as DATE);
select cast('2022/12/12' as DATE);
select cast('2022%12%12' as DATE);
select cast('2022@12@12' as DATE);
-- convert
select convert(avg(price), signed) '평균가격' from buy;

-- concat
select num, concat(cast(price as char), 'X', cast(amount as char), '=' )'가격X수량', price*amount '구매액' 
    from buy;
```



##### join

---

1. 내부 조인

   ```mysql
   select buy.mem_id, member.mem_name, buy.prod_name, member.addr,concat(phone1,phone2) '연락처'
    from  buy
    inner join member
    on buy.mem_id = member.mem_id
    where buy.mem_id = 'GRL';
    
   -- inner join 대신 join만 사용해도 됨.
   
   
   -- join문에 order by 사용
   select b.mem_id, m.mem_name, b.prod_name, m.addr
    from  buy b
    join member m
    on b.mem_id = m.mem_id
    order by m.mem_id;
   
   ```

2. 외부 조인

   ```mysql
   select m.mem_id, m.mem_name, b.prod_name, m.addr
    from  member m
    left outer join buy b
    on m.mem_id = b.mem_id
    order by m.mem_id;
   
   -- left outer : 왼쪽에 있는 테이블 전체를 출력
   
   select m.mem_id, m.mem_name, b.prod_name, m.addr
    from  buy b
    right outer join member m
    on m.mem_id = b.mem_id
    order by m.mem_id;
    
   -- right outer : 오른쪽에 있는 테이블 전체를 출력
   ```

3. 기타 조인

   (1) 상호조인(cross join)

   - 두 테이블의 모든행을 조인 시키는 기능이다.

   -  상호 조인 결과의 전체 행의 개수는 두 테이블의 각 행의 개수를 곱한 개수이다.

     ```mysql
     select *
     	from buy
         cross join member;
     ```

   (2) 자체 조인(self join)

   - 회사의 조직관계에서 직속 상관의 정보를 알고 싶을때 사용한다.

     ```mysql
     CREATE TABLE emp_table (emp CHAR(4), manager CHAR(4), phone VARCHAR(8));
      
     INSERT INTO emp_table VALUES('대표', NULL, '0000');
     INSERT INTO emp_table VALUES('영업이사', '대표', '1111');
     INSERT INTO emp_table VALUES('관리이사', '대표', '2222');
     INSERT INTO emp_table VALUES('정보이사', '대표', '3333');
     INSERT INTO emp_table VALUES('영업과장', '영업이사', '1111-1');
     INSERT INTO emp_table VALUES('경리부장', '관리이사', '2222-1');
     INSERT INTO emp_table VALUES('인사부장', '관리이사', '2222-2');
     INSERT INTO emp_table VALUES('개발팀장', '정보이사', '3333-1');
     INSERT INTO emp_table VALUES('개발주임', '정보이사', '3333-1-1');
      
     SELECT A.emp "직원" , B.emp "직속상관", B.phone "직속상관연락처"
        FROM emp_table A
           INNER JOIN emp_table B
              ON A.manager = B.emp
        WHERE A.emp = '경리부장';
     ```

     

##### 테이블과 뷰

---

```mysql
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

-- 구매테이블의 아이디 열을 회원테이블의 아이디 열의 외래키로 설정한다.
-- 부모테이블 먼저 데이터를 입력한다.
-- 참조하고 있는 자식 테이블은 나중에 입력한다.
-- 외래키 열은 부모 테이블에 존재하는 컬럼값만 입력할 수 있다.

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015-10-19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016-8-8');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015-1-15');


INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200); -- APN은 부모에 없기때문에 오류
```



##### 제약조건

---

\- 제약조건은 데이터의 무결성을 지키기 위해 제한하는 조건이다.
\- 데이터 무결성이란 '데이터에 결함이 없음' 이란 의미 이다.
\- 네이버 회원아이디가 중복되면 이메일, 쇼핑, 블로그, 쇼핑 기록 등 상당한 혼란이 일어난다.
 이것이 데이터의 결함이고, 이런 결함이 없는 것을 데이터의 무결성이라고 한다.
\- 이러한 결함을 방지하기 위해서 회원테이블의 아이디를 기본키(primary key)로 지정할 수 있다.
\- 기본키의 조건은 '중복되지 않고, 비어 있지 않음' 이므로, 실수로 중복된 아이디를 넣으려고 해도
 입력이 불가능하다.

1. 기본 키(primary key)

   ```mysql
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
   ```

2. 외래 키(foreign key)

   \- 두 테이블 사이의 관계를 연결해주고, 그 결과 데이터의 무결성을 보장해주는 역할을 한다.

   ```mysql
   CREATE TABLE member 
   ( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
     mem_name    VARCHAR(10) NOT NULL, 
     height      TINYINT UNSIGNED NULL
   );
   CREATE TABLE buy 
   (  num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
      mem_id      CHAR(8) NOT NULL, 
      prod_name     CHAR(6) NOT NULL, 
      FOREIGN KEY(mem_id) REFERENCES member(mem_id)
   );
   ```

   \- 참조테이블의 아이디 열 이름이 user_id와 같이 기준테이블의 mem_id와 달라도 된다.

   ```mysql
   CREATE TABLE member 
   ( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
     mem_name    VARCHAR(10) NOT NULL, 
     height      TINYINT UNSIGNED NULL
   );
    
   CREATE TABLE buy 
   (  num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
      user_id      CHAR(8) NOT NULL, 
      prod_name     CHAR(6) NOT NULL, 
      FOREIGN KEY(user_id) REFERENCES member(mem_id)
   );
   ```

   -

   \- alter table에서 외래 키 설정

   ```mysql
   CREATE TABLE buy 
   (  num         INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
      mem_id      CHAR(8) NOT NULL, 
      prod_name     CHAR(6) NOT NULL
   );
   ALTER TABLE buy
       ADD CONSTRAINT 
       FOREIGN KEY(mem_id) REFERENCES member(mem_id);
   ```

3.  고유 키(Unique)

   ```mysql
   CREATE TABLE member 
   ( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
     mem_name    VARCHAR(10) NOT NULL, 
     height      TINYINT UNSIGNED NULL,
     email       CHAR(30)  NULL UNIQUE
   );
    
   INSERT INTO member VALUES('BLK', '블랙핑크', 163, 'pink@gmail.com');
   INSERT INTO member VALUES('TWC', '트와이스', 167, NULL);
   INSERT INTO member VALUES('APN', '에이핑크', 164, 'pink@gmail.com');
   
   -- Error Code : 1062. Duplication entry 'pink@gmail.com' for key 'member.email'
   ```

4. 체크(check) 제약조건

   \- 입력되는 데이터를 점검하는 기능이다.
   \- 키에 마이너스 값이 입력되지 않도록 하거나, 연락처의 국번에 02, 031,
    041,055 중 하나만 입력 되도록 할 수 있다.

   ```mysql
   DROP TABLE IF EXISTS member;
   CREATE TABLE member 
   ( mem_id  CHAR(8) NOT NULL PRIMARY KEY, 
     mem_name    VARCHAR(10) NOT NULL, 
     height      TINYINT UNSIGNED NULL CHECK (height >= 100),
     phone1      CHAR(3)  NULL
   );
    
   INSERT INTO member VALUES('BLK', '블랙핑크', 163, NULL);
   INSERT INTO member VALUES('TWC', '트와이스', 99, NULL);
   -- Error Code : 3819. Check constraint 'member_ch_1' is violated
   
   -- Alter Table로 제약조건 추가할 수 있다.
   ALTER TABLE member
       ADD CONSTRAINT 
       CHECK  (phone1 IN ('02', '031', '032', '054', '055', '061' )) ;
    
   INSERT INTO member VALUES('TWC', '트와이스', 167, '02');
   INSERT INTO member VALUES('OMY', '오마이걸', 167, '010');
   -- Error Code : 3819. Check constraint 'member_ch_2' is violated
   ```



##### 가상테이블 뷰

---

```mysql
CREATE VIEW v_member
AS
    SELECT mem_id, mem_name, addr FROM member;
 
SELECT * FROM v_member;

SELECT mem_name, addr FROM v_member
   WHERE addr IN ('서울', '경기');
```

```mysql
CREATE VIEW v_memberbuy
AS
    SELECT B.mem_id, M.mem_name, B.prod_name, M.addr, 
            CONCAT(M.phone1, M.phone2) '연락처' 
       FROM buy B
         INNER JOIN member M
         ON B.mem_id = M.mem_id;
 
SELECT * FROM v_memberbuy WHERE mem_name = '블랙핑크';
```

```mysql
CREATE VIEW v_viewtest1
AS
    SELECT B.mem_id 'Member ID', M.mem_name AS 'Member Name', 
            B.prod_name "Product Name", 
            CONCAT(M.phone1, M.phone2) AS "Office Phone" 
       FROM buy B
         INNER JOIN member M
         ON B.mem_id = M.mem_id;
         
alter view v_viewtest1
as
	select b.mem_id '회원 아이디', m.mem_name '회원 이름',
    b.prod_name '제품 이름', concat(m.phone1,m.phone2) '연락처'
		from buy b
        join member m
        on b.mem_id = m.mem_id;
```

```mysql
DROP VIEW v_viewtest1;
```

