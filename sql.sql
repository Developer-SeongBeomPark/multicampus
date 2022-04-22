use market_db;
select mem_name from member;
select addr, debut_date, mem_name from member;
select addr 주소, debut_date "데뷔 일자", mem_name 이름 from member;
select debut_date from member where mem_name = '블랙핑크';

select  mem_id, mem_name
	from  member
	where  height <= 162;

select mem_id, mem_name, height
	from member
    where height <= 165 and mem_number > 6;
    
select  mem_name, height
  from member
  where height >= 163 and height <= 165;
  
select mem_name, addr
	from member
    where addr in ('경기', '전남', '경남');
    
 #우로 시작하는 어떠한 문자가 올 수 있다.
 select  *
	from  member
	where  mem_name like '우%';
    
 # 앞 두글자는 상관없고 뒤에 '핑크'인 회원을 검색
 select  *
	from  member
	where  mem_name like '__핑크';

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
        
#서브쿼리의 리턴결과가 두개 이상일때 in연산자 사용한다.
select mem_id 
 from member
where mem_name in (
                select mem_name
                 from  member
                where  mem_number = 6 
                 and   addr = '경기'
        );

select mem_id, mem_name, debut_date
	from member
    order by debut_date desc;
    

#alias와 컬럼순서를 사용한 예제
select mem_id, mem_name, height, debut_date 데뷔일자 -- alias는 ""로 사용하면 인식안됨
  from member
where height >= 164
order by 3 desc, 데뷔일자;

#데뷔날짜가 가장 빠른 3팀만 가져오기
select  mem_name, debut_date
   from  member
  order by debut_date
  limit 3;
  
# 평균키(height)가 큰 순으로 정렬하여 3번째부터 2건만 조회한다.
select  mem_name, height
  from  member
  order by height
  limit 3, 2;
  
#집계함수(sum)와 Group by를 사용하면 한번에 계산된 결과를 확인할 수 있다.
 select  mem_id "회원 아이디" , sum(amount) "총 구매 개수"
   from  buy
   group by mem_id;
   
#각 회원이 한 번 구매 시 평균 몇 개를 구매했는지 알아본다.
 select  mem_id "회원 아이디" , avg(amount) "평균 구매 개수"
   from  buy
   group by mem_id;
   
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
   
# round(), truncate()를 이용하면 반올림을 사용할 수 있다.
select mem_id "회원 아이디", round(avg(amount)) "평균 구매 개수"
  from buy
 group by mem_id;
 
#ROUND(숫자,반올림할 자릿수) - 숫자를 반올림할 자릿수 +1 자릿수에서 반올림
#TRUNCATE(숫자,버릴 자릿수) - 숫자를 버릴 자릿수 아래로 버림(버릴 자리수 반드시 명시) 



