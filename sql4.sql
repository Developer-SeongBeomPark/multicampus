use market_db;

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
        
SELECT  DISTINCT `회원 아이디`, `회원 이름` FROM v_viewtest1;  -- 백틱을 사용

DESCRIBE v_viewtest1;