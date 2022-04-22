-- ddl

create table test(
	toy_id 		int auto_increment not null primary key,
    toy_name 	char(4),
    age 		int
);

-- dml

insert into test values(1, 'kim', 25);
insert into test values(null, 'hong', 30);
select * from test;


create table test2(
    toy_id int not null auto_increment primary key, 
    toy_name char(4), 
    age int);
 
insert into test2 values(null, '보핍',25);
insert into test2 values(null, '슬링키',22);
insert into test2 values(null, '렉스',21);
 
insert into test2(toy_name, age) values('홀길동',32);
 
 
select * from test2;

#자동증가로 증가된 값 확인하기
select last_insert_id();


-- alter
alter table test2 auto_increment = 100;
insert into test2(toy_name, age) values('lee', 21);
insert into test2(toy_name, age) values('park', 25);


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

use world;
desc city;
select count(*) from city;

select * from city limit 5;

create table city_popul(
	city_name char(35),
    population int
);

insert into city_popul
	select name, population
    from city;
    
select * from city_popul;

-- update

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

