### Day 15(4/25 Mon)

---







##### Delete

---

```mysql
-- DELETE
use world;
select count(*) from city_popul
	where city_name like 'NEW%';
    
delete 
	from city_popul
	where city_name like 'NEW%'
    limit 5;
```

