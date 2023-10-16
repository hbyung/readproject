create table hopeboard(
	seq		number(5)	primary key,
	title	varchar2(200),
	writer	varchar2(20),
	author 	varchar2(50),
	content varchar2(2000),
	regdate	date	default sysdate,
	cnt		number(5)	default 0
);

drop table hopeboard purge;
select * from hopeboard;

insert into hopeboard(seq, title, writer,author, content) 
values(1, '각각의 계절', 'hongkd', '권여선', '희망도서 신청해요 ~.');

insert into hopeboard(seq, title, writer,author, content) 
values(2, '이토록 클래식이 끌리는 순간', 'myid', '최지환', '희망도서 신청합니다.');

insert into hopeboard(seq, title, writer,author, content) 
values(3, '어쩌다 클레식', 'namsik', '최은수', '꼭 보고 싶은 책이에요.');

insert into hopeboard(seq, title, writer,author, content) 
values(4, '방구석 미술관', 'eunsu09', '조원재', '희망도서 신청합니다. 언제쯤 볼 수 있을까요?');

insert into hopeboard(seq, title, writer,author, content) 
values(5, '아웃풋의법칙', 'namwoo', '김재수', '희망도서 신청합니다!.');

insert into hopeboard(seq, title, writer,author, content) 
values(6, '괜찮아, 그 길 끝에 행복이 기다릴 거야', 'gunHo', '손미나ㆍ코알라컴퍼니', '재밌어 보여서 신청해요 ~.');

insert into hopeboard(seq, title, writer,author, content) 
values(7, '언어의 무게', 'hwan12', '파스칼 메르시어', '친구가 추천해줘서 보고싶어서 신청해요 ~.');

insert into hopeboard(seq, title, writer,author, content) 
values(8, '메리골드 마음 세탁소', 'yunmok', '윤정은', '전편을 너무 재밌게 봐서 꼭보고 싶어서 신청해요.');

insert into hopeboard(seq, title, writer,author, content) 
values(9, '알래스카 한의원', 'hyungu', '이소영', '저번에 서점에서 살짝 봤는데, 재밌는거 같아서 신청합니다.');

insert into hopeboard(seq, title, writer,author, content) 
values(10, '경우 없는 세계', 'namwoo', '백온유', '김남우 저자님을 좋아해서, 희망도서 신청합니다..');

insert into hopeboard(seq, title, writer,author, content) 
values(11, '메리골드 마음 세탁소', 'hongkd', '윤정은', '혼자 읽는 것보다 여러 사람들과 함께 공유하고 읽고 싶은 책으로 희망 도서 신청합니다!');

insert into hopeboard(seq, title, writer,author, content) 
values(12, '돈의 심리학', 'myid', '모건 하우절', '금융 작가들 사이에서도 유명한 모건 하우절의 투자서를 희망 도서 신청합니다.');

insert into hopeboard(seq, title, writer,author, content) 
values(13, '이것은 작은 브랜드를 위한 책', 'goat', '이근상', '남들과는 다른 마케팅을 분석하는 이 책을 희망 도서로 신청드립니다ㅎㅎ');

insert into hopeboard(seq, title, writer,author, content) 
values(14, '사춘기 아들의 마음을 잡아주는 부모의 말 공부', 'sunny96', '이은경', '이 책은 사춘기 아들을 둔 부모에게 유용한 지침서가 될 듯 하여 신청합니다!');


