use webtest;

describe memo;

delete from memo;

alter table memo
add(filename varchar(50) default 0, filesize int default 0);

alter table bbs
add(refnum int default 0);
    
select * from bbs
	where indent > 0;
    
select count(refnum)
	from bbs
    where refnum = 39;

delete from bbs
	where indent > 0;