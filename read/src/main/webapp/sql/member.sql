create table member
(
 id 		varchar2(45) primary key,
 password   varchar2(45),	
 name       varchar2(45),
 email		varchar2(45),
 rank		number(5)	default 0,
 rank1      number(5)	default 0,
 rank2		number(5)	default 0,
 blackrank	number(5) 	default 0
);

select * from MEMBER;

insert into member (id, password, name,email,rank,rank1,rank2,blackrank)  
values('myid', '1234', '강감찬', 'myid@com','0','0','0','-1');

insert into member(id, password, name,email) 
values('admin', 'admin', '관리자', 'Admin@com');
insert into member(id, password, name,email)  
values('hongkd', '1234', '홍길동', 'User@com');
insert into member(id, password, name,email)  
values('goat', '1234', '신사임당', 'goat@com');
insert into member (id, password, name,email)  
values('myid', '1234', '강감찬', 'myid@com');
insert into member (id, password, name,email)  
values('newid', '1234', '안중근', 'newid@com');
insert into member(id, password, name,email) 
values('mina', '1234', '이미나', 'mina@com');
insert into member(id, password, name,email)  
values('yujin', '1234', '최유진', 'yujin@com');
insert into member(id, password, name,email)  
values('sunny', '1234', '이선희', 'sunny@com');
insert into member (id, password, name,email)  
values('mrkang', '1234', '강진호', 'mrkang@com');
insert into member (id, password, name,email)  
values('likeit', '1234', '정다정', 'likeit@com');
insert into member(id, password, name,email)  
values('yunkyung', '1234', '최윤경', 'yunkyung@com');
insert into member(id, password, name,email)  
values('chanho', '1234', '안찬호', 'chanho@com');
insert into member (id, password, name,email)  
values('jaehyun', '1234', '김재현', 'jaehyun@com');
insert into member (id, password, name,email)  
values('sunwoo', '1234', '박선우', 'sunwoo@com');
insert into member (id, password, name,email)  
values('hwan12', '1234', '이환', 'hwan12@com');
insert into member(id, password, name,email)  
values('kkk123', '1234', '김재석', 'kkk123@com');
insert into member(id, password, name,email)  
values('vv1375', '1234', '신보람', 'vv1375@com');
insert into member (id, password, name,email)  
values('abc777', '1234', '김사랑', 'abc777@com');
insert into member (id, password, name,email)  
values('tree1004', '1234', '한원호', 'tree1004@com');
insert into member (id, password, name,email)  
values('kimhappy', '1234', '김재훈', 'kimhappy@com');
insert into member(id, password, name,email)  
values('heok', '1234', '하재혁', 'heok@com');


drop table member purge;

delete from member where id='myid';