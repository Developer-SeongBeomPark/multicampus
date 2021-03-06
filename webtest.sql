create database webtest;

use webtest;

CREATE TABLE suggest(
        suggestno int NOT NULL auto_increment primary key,
        sqlpart   VARCHAR(20)  NOT NULL,
        sqlquery  VARCHAR(100) NOT NULL, 
        etc       VARCHAR(100)     NULL
    );
 
  
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('INSERT', 'INSERT 테이블명 VALUES( ~ )', '');
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('INSERT','INSERT 테이블명 ( ~ ) VALUES( ~ )', '');
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('SELECT','SELECT * FROM ~', '');    
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('SELECT','SELECT * FROM ~ WHERE ~', '');    
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('UPDATE','UPDATE ~ SET ~', '');    
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('UPDATE','UPDATE ~ SET ~ WHERE ~', '');    
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('DELETE','DELETE FROM ~', ''); 
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('DELETE','DELETE FROM ~ WHERE ~', ''); 
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('자바코드', '자바001', ''); 
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('자바코드', '자바002', '');                       
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('자바코드','자바003', '');                       
 
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 15inch', '');      
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 16inch', '');      
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 17inch', '');      
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 18inch', '');      
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 19inch', '');      
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 20inch', '');      
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 21inch', '');      
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 22inch', '');      
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 23inch', '');      
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 24inch', '');      
    INSERT INTO suggest( sqlpart, sqlquery, etc)
    VALUES('모니터','LCD 25inch', '');
    
    select count(sqlquery) as cnt
    from suggest
    where sqlquery like "INS%";
    
    select count(sqlquery) as cnt
    from suggest
    where sqlquery like "자%";
    
    select sqlquery as cnt
    from suggest
    where sqlquery like "자%";