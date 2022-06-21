
-- review 테이블 생성 
   create table review(
   rnum int not null auto_increment primary key,
   content varchar(500) not null,
   regdate date not null,
   id varchar(10) not null,
   contentsno int(7) not null,
   foreign key (contentsno) references contents(contentsno)
);

use webtest;

select * from review;
drop table review;

insert into review(content, regdate, id, contentsno)
values('의견입니다2.',sysdate(),'user1',13);
