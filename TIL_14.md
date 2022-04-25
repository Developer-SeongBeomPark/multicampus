### DAY 14(4/22 Fri)

---

[데이터 입력](#데이터-입력)

[MYSQL](#mysql)

[데이터 형 변환](#데이터-형-변환)

[JOIN](#join)

[테이블과 뷰](#테이블과-뷰)

[제약조건](#제약조건)

[가상테이블 뷰](#가상테이블-뷰)

##### 데이터 입력

---

\- PK - Primary key, 중복이나 빈값(NULL)이 들어올 수 없음

\- NN - Not Null(빈값) 못들어옴

\- UQ - Unique, 중복 값을 넣을 수 없음

\- B -데이터를 이진 문자열로 저장함(010101 같은)

\- UN - Unsigned data type (- 범위 삭제)

  INT, DOUBLE 등의 경우 UN을 사용해 주면 -값 +값 이던 범위가 -값은 없어지고 +값만 2배로 늘어남

\- ZF - Zero Filled 컬럼 크기보다 작은 값을 넣었을 경우 0으로 채운 뒤 삽입시킴

\- AI - Insert 시마다 값 1씩 늘어남

\- G - 다른 열을 기반으로 한 수식으로 생성된 값

\- Default/Expression - 기본값, 기본값에 수식 설정 



##### MYSQL

---

1. DQL(Data Query Language)

   - use문

     select문을 실행하기 위해 먼저 사용할 데이터베이스를 지정한다.

     ```mysql
     use market_db;
     ```

     

   - select문

     ```mysql
     #BETWEEN과 AND를 사용해서 평균 키(height) 가 163 ~ 165인 회원 조회
     select  mem_name, height
       from  member
      where  height  between 163 and 165;
     ```

     ```mysql
     #IN()
     select  mem_name, addr
        from  member
       where  addr in ( '경기','전남' , '경남');
     
     ```

     ```mysql
     # Like
     #특정 단어가 포함되거나, 시작, 끝나는 데이터를 검색할 때 사용한다.
     #여러문자를 매칭하기 위해서 (%) 를 사용한다.
     #한자를 매칭하기 위해서 (_)를 사용한다.
     
     #우로 시작하는 어떠한 문자가 올 수 있다.
      select  *
        from  member
       where  mem_name like '우%';
       
      # 앞 두글자는 상관없고 뒤에 '핑크'인 회원을 검색
      select  *
        from  member
       where  mem_name like '__핑크'; 
     ```

     ```mysql
     # 서브쿼리
     select  mem_name, height
       from member
       where height > (select  height from  member where  mem_name = '에이핑크');
       
     select * 
     	from member
         where addr = (
     		select addr
             from member
             where mem_name = '에이핑크'
             );
     ```

     ```mysql
     #서브쿼리의 리턴결과가 두개 이상일때 in연산자 사용한다.
     select mem_id 
      from member
     where mem_name in (
                     select mem_name
                      from  member
                     where  mem_number = 6 
                      and   addr = '경기'
             );
     ```

     ```mysql
     # 평균키(height)가 큰 순으로 정렬하여 3번째부터 2건만 조회한다.
     select  mem_name, height
       from  member
       order by height
       limit 3, 2;
     ```
     
     ```mysql
     #집계함수(sum)와 Group by를 사용하면 한번에 계산된 결과를 확인할 수 있다.
      select  mem_id "회원 아이디" , sum(amount) "총 구매 개수"
        from  buy
        group by mem_id;
     ```
     
     ```mysql
     #Having 사용
     #where절에는 집계함수를 사용할 수 없다.
      select  mem_id "회원 아이디" , sum(price * amount) "총 구매 금액"
        from  buy
        group by mem_id
        having sum(price * amount) > 1000;
        
     #order by사용
      select  mem_id "회원 아이디" , sum(price * amount) "총 구매 금액"
        from  buy
        group by mem_id
        having sum(price * amount) > 1000
        order by "총 구매 금액" ; # 쌍따옴표 대신 백틱도 가능(`)
     ```
     
     ```mysql
     # round(), truncate()를 이용하면 반올림을 사용할 수 있다.
     select mem_id "회원 아이디", round(avg(amount)) "평균 구매 개수"
       from buy
      group by mem_id;
      
     #ROUND(숫자,반올림할 자릿수) - 숫자를 반올림할 자릿수 +1 자릿수에서 반올림
     #TRUNCATE(숫자,버릴 자릿수) - 숫자를 버릴 자릿수 아래로 버림(버릴 자리수 반드시 명시) 
     ```
   
2. DQL(Data Manapulation Language)

   - insert문

     ```mysql
     #기본적인 형식
     INSERT INTO 테이블 [(열1, 열2, ......)] VALUES (값1, 값2, ......)
     ```

     ```mysql
     #auto_increment
     create table test2(
         toy_id int not null auto_increment primary key, 
         toy_name char(4), 
         age int);
      
     insert into test2 values(null, '보핍',25);
     insert into test2 values(null, '슬링키',22);
     insert into test2 values(null, '렉스',21);
     
     #자동으로 pk가 1,2,3 들어감
     ```

     ```mysql
     #자동증가되는 값을 중간에 변경하고 싶을때 alter table 뒤에 auto_increment값을변경하면 된다.
     
     alter table test2 auto_increment = 100;
     insert into test2(toy_name, age) values('lee', 21);
     insert into test2(toy_name, age) values('park', 25);
     ```

     ```mysql
     # @@auto_increment_increment
     #처음 테이블이 생성되고 자동 증가의 시작값을 원하는 값으로 설정한 후 증가값을 지정할 때 사용하는 시스템 변수 이다.
     create table test3(
             toy_id int not null auto_increment primary key, 
             toy_name char(4), 
             age int
             );
     
     alter table test3 auto_increment = 1000; -- 시작값
     SET @@auto_increment_increment = 3; -- 증가값
     insert into test3(toy_name, age) values('토마스', 21);
     insert into test3(toy_name, age) values('제임스', 23);
     insert into test3(toy_name, age) values('고든', 25);
     select * from test3;
     ```

     ```mysql
     # 여러줄을 한줄로 간단히 입력하는 방법
     insert into test3(toy_name, age) 
     values('보핍',25),('슬링키',22),('lee',21);
     ```

     ```mysql
     insert into ~ select
     # 다른 테이블의 데이터를 한 번에 입력할 때 사용한다.
     create table city_popul(
     	city_name char(35),
         population int
     );
     
     insert into city_popul
     	select name, population
         from city;
     ```

     ```mysql
     # Update
     use city_popul;
     update city_popul
     	set city_name = '서울'
         where city_name = 'Seoul';
         
     update city_popul
     	set city_name = '뉴욕', population  = 0
         where city_name = 'New York';
         
     select city_name, population
     	from city_popul
         where city_name = '뉴욕';
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

