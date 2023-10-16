create table cureply(
	cuseq  number(5),
	cuseqs number(5) primary key,
	id			varchar2(20),
	password	varchar2(20),
	cucontents   varchar2(2000),
	curegdate	date	default sysdate,
	cucnt		number(5)	default 0,
	FOREIGN KEY (cuseq) REFERENCES cumuboard(cuseq) ON DELETE CASCADE
);

drop table cureply purge;

select * from CUREPLY;

select * from CUREPLY where seq=5 ;

insert into cureply(cuseqs, id, password, cucontents, cuseq) 
values(1, 'jaehyun', '1234', '안녕하세요 hongkd님! 제가 해리포터 팬이여서 마법사 나오는 판타지 소설이 너무 보고 싶어요. 혹시 좋은 책이 있으실까요??', 1);

insert into cureply(cuseqs, id, password, cucontents, cuseq) 
values(2, 'hongkd', '1234', 'jaehyun님 : 해리포터 좋아하시는 분들 정말 많이 봤죠ㅎㅎ. 레브 그로스만의 ''The Magicians'' 추천드려요! 해리포터와 비슷하게 마법 대학을 다니는 마법사의 이야기라서 좋아하실 것 같아요 ', 1);

insert into cureply(cuseqs, id, password, cucontents, cuseq) 
values(3, 'jaehyun', '1234', 'hongkd님! : 감사합니다 hongkd님 ~ 꼭 읽어보도록 할게요', 1);

insert into cureply(cuseqs, id, password, cucontents, cuseq) 
values(4, 'vv1375', '1234', 'hongkd님! 저는 hongkd님이 가장 재밌게 봤던 판타지 소설이 궁금해요.', 1);

insert into cureply(cuseqs, id, password, cucontents, cuseq) 
values(5, 'hongkd', '1234', 'vv1375님 : 저는 아직까지도 기억에 남는 소설이 닐 게이먼의 ''신들의 전쟁''이네요. 한 번쯤은 꼭 읽어보시길 추천드려요!', 1);

insert into cureply(cuseqs, id, password, cucontents, cuseq) 
values(6, 'vv1375', '1234', 'hongkd님: 굉장히 많이 들어본 이름인데 막상 읽어보진 못한 책이네요. 꼭 읽어볼게요! 감사합니다~', 1);

insert into cureply(cuseqs, id, password, cucontents, cuseq) 
values(7, 'chanho', '1234', '4월의 책(2권 완료) : 김승호 저자의 ''돈의 속성'' / 세이노 저자의 ''세이노의 가르침''', 2);

insert into cureply(cuseqs, id, password, cucontents, cuseq) 
values(8, 'sunwoo', '1234', '4월의 책(2권 완료) : 김혜남 저자의 ''만일 내가 인생을 다시 산다면'' / 장재형 저자의 ''마흔에 읽는 니체'' ', 2);

insert into cureply(cuseqs, id, password, cucontents, cuseq) 
values(9, 'abc777', '1234', '4월의 책(1권 완료): Elizabeth Strout의 ''My Name Is Lucy Barton'' ', 2);









select * from cureply where cuseqs=3;