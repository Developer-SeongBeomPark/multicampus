### DAY 14(4/22 Fri)

---

[데이터 입력](#데이터-입력)

[MYSQL](#mysql)


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

     

