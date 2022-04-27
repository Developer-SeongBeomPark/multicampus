use javadb;

-- ddl
create table team(
	no		int 		not null	auto_increment	primary key,
    name	varchar(20)	not null,
    phone	varchar(20) not null,
    email	varchar(50)	not null,
    skills	varchar(100) not null,
    address	varchar(500)
);

insert into team(name, phone, email, skills, address) values ('홍길동', '010-7777-8888', 'user1@gmail.com', 'java,jsp,spring', '서울시 동작구');
insert into team(name, phone, email, skills, address) values ('김길동', '010-4567-8888', 'user1@gmail.com', 'java', '서울시 종로구');
insert into team(name, phone, email, skills, address) values ('이길동', '010-7987-8888', 'user1@gmail.com', 'java,oracle,spring', '서울시 서초구');


-- read
select *
	from team;
    
    
select *
	from team
    where no = 1;
    
-- update
update team
	set phone = '010-1111-1111', email = 'user1111@gmail.com', skills = 'java,jsp,mysql,spring', address = '서울시 관악구'
	where no = 1;
    
-- delete
delete from team
	where no = 1;
    
    
    
-- ddl
create table memo(
	memono		int 		not null	auto_increment	primary key,
    wname		varchar(20) not null,
    title		varchar(200) not null,
    content		text,
    passwd		varchar(10)	not null,
    viewcnt		int			default 0,
    wdate		date		not null
);

insert into memo(wname, title, content, passwd, wdate) values ('이길동', 'mysql 수업', 'DAO,DTO', '1234', sysdate());

select * from memo;

-- list
select wname, title, passwd, wdate
	from memo
    order by wdate desc;
    
 -- read   
select *
	from memo
    where memono = 1;
    
update memo
	set title = 'mysql과 java연동', content = '내용 변경'
    where memono = 2;
    
delete
	from memo
    where memono = 1;




