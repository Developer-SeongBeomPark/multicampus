use javadb;

drop table if exists address;

create table address(
	addressnum		int			not null	auto_increment primary key,
    name			varchar(10), 
    handphone		varchar(14),
    address			varchar(50)
);

insert into address values(null, '개발자3', '555-123-1234', '미국');
insert into address values(null, '개발자1', '111-123-1234', '일본');
insert into address values(null, '개발자1', '222-123-1234', '러시아');

select *
	from address;

select *
	from address
    where addressnum = 5;
    
update address
	set handphone = '010-5555-5555', address = '터키'
    where addressnum = 7;
    
delete from address
	where addressnum = 1;
    
delete from address;

    
