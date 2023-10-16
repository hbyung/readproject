drop table bookRental purge;

create table bookRental (
	risbn	varchar2(45),
	remail	varchar2(45)	not null,	
	rid		varchar2(45)	not null,	
	rtitle	varchar2(200),
	rauthor	varchar2(200),
	rrentalDate		date,
	rreturnDate		date
)
select count(*) from bookRental;
select * from bookRental where id='admin';

alter table bookRental
drop column searchCondition;

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('qwer', 'User@com', 'hong', '첫번째 책', '홍길동', sysdate, sysdate + 7);

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('myid', 'User@com', 'myid', '두번째 책', '안중근', DATE '2022-10-06', DATE '2022-10-13');

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('2wkdi44', 'User@com', 'newid', '세번째 책', '서장훈', DATE '2022-12-12', DATE '2022-12-19');

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('myid', 'User@com', 'myid', '두번째 책', '안중근', DATE '2022-10-06', DATE '2022-10-13');

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('2wkdi44', 'User@com', 'newid', '세번째 책', '서장훈', DATE '2022-12-12', DATE '2022-12-19');

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('myid', 'User@com', 'myid', '두번째 책', '안중근', DATE '2022-10-06', DATE '2022-10-13');

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('2wkdi44', 'User@com', 'newid', '세번째 책', '서장훈', DATE '2022-12-12', DATE '2022-12-19');

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('myid', 'User@com', 'hongkd', '두번째 책', '안중근', DATE '2022-10-06', DATE '2022-10-13');

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('2wkdi44', 'User@com', 'hongkd', '세번째 책', '서장훈', DATE '2022-12-12', DATE '2022-12-19');

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('myid', 'User@com', 'hongkd', '두번째 책', '안중근', DATE '2022-10-06', DATE '2022-10-13');

insert into BOOKRENTAL (risbn, remail, rid, rtitle, rauthor, rrentalDate, rreturnDate)
values ('2wkdi44', 'User@com', 'newid', '세번째 책', '서장훈', DATE '2022-12-12', DATE '2022-12-19');

select * from BOOKRENTAL WHERE sysdate > returnDate;

delete from bookRental;

select * from bookrental where sysdate > returnDate;

select count(isbn) from bookRental;

select * from (select rownum rnum, isbn, email, id, title, author, rentalDate, returnDate from (select * from bookRental order by rentalDate desc))
			where rnum >= 1 and rnum <= 4 order by rentalDate desc;



	











