create database exam_db;

use exam_db;

create table book(
	isbn			int				not null	primary key		auto_increment,
    title			varchar(50)		not null,
    author			varchar(250)	not null,
    publisher		varchar(50)		not null,
    price			int				not null,
    des				varchar(200),
    publish_date 	date
);

insert into book values(21424,'Java Basic','김하나','Jaen.kr', 15000 ,'Java 기본 문법', sysdate());
insert into book values(33455,'JDBC Pro','김철수','Jaen.kr', 23000 ,null, sysdate());
insert into book values(55355,'Servlet/JSP','박자바','Jaen.kr', 41000 ,'Model2 기반', sysdate());
insert into book values(35332,'Android App','홍길동','Jaen.kr', 25000 ,'Lightweight Framework', sysdate());
insert into book values(35355,'OOAD 분석,설계','소나무','Jaen.kr', 30000 ,null, sysdate());	

insert into book values(12345,'insert_Ex','김길동','gildong.kr', 34000 ,null, sysdate());	

select * from book;

select *
	from book
    where isbn = 21424;
    
update book
	set publisher = 'Hana.kr'
    where isbn = 21424;
    
delete
	from book
    where isbn = 12345;



