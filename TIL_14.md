### DAY 14(4/22 Fri)

---



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

     

