create table reply(
	seq  number(5),
	seqs number(5) primary key,
	id			varchar2(20),
	password	varchar2(20),
	contents   varchar2(2000),
	regDate	date	default sysdate,
	cnt		number(5)	default 0
);

drop table reply purge;

select * from REPLY;

delete from reply where seqs='18';

insert into reply(seqs, id, password, contents, seq) 
values(1, 'hwan12', '1234', '맞아요!! 시원한 아메리카노 한 잔에 책 한권이면 스트레스가 풀리더라고요', 1);

insert into reply(seqs, id, password, contents, seq) 
values(2, 'yujin', '1234', '저도 매 달 2권씩 읽으려고 해요! 꾸준히 읽은 지는 2년 된 것 같네요', 2);
insert into reply(seqs, id, password, contents, seq) 
values(3, 'hwan12', '1234', '그거 책 3권 이상 반납 안 하면 블랙리스트 올라요...얼른 반납하시고 관리자에게 문의드리세요!!', 3);
insert into reply(seqs, id, password, contents, seq) 
values(4, 'myid', '1234', '그게 이유였구나ㅠ 저도 대출 안되서 당황했는데 서둘러서 반납해야겠어요!!', 3);
insert into reply(seqs, id, password, contents, seq) 
values(5, 'hwan12', '1234', '저는 굉장히 재밌게 봤어요 추천합니다^^', 5);

insert into reply(seqs, id, password, contents, seq) 
values(6, 'mrkang', '1234', '환영합니다 likeit님 ~~ 여기 좋은 책들 많으니까 많이 즐기고 가세요', 6);
insert into reply(seqs, id, password, contents, seq) 
values(7, 'yunkyung', '1234', '환영합니다!', 6);
insert into reply(seqs, id, password, contents, seq) 
values(8, 'sunwoo', '1234', '저는 커피보다는 차를 좋아하지만 커피를 마신다면 카라멜 마끼아또가 좋더라고요', 7);
insert into reply(seqs, id, password, contents, seq) 
values(9, 'kkk123', '1234', '오 저도 카페라떼 좋아해요!!', 7);
insert into reply(seqs, id, password, contents, seq) 
values(10, 'vv1375', '1234', '도서 사이트 회원인만큼 다들 독서광인지라^^ 저도 여기서 믿고 책 추천받아요', 8);
insert into reply(seqs, id, password, contents, seq) 
values(11, 'sunny', '1234', '일이 바쁘면 휴식이 격하게 필요해지죠...칼퇴하길 바랄게요 yunkyung님!', 9);
insert into reply(seqs, id, password, contents, seq) 
values(12, 'tree1004', '1234', '책은 본인이 즐길 수 있는 주제를 찾으면 읽는 습관을 들일 수 있으실 거에요', 10);
insert into reply(seqs, id, password, contents, seq) 
values(13, 'kimhappy', '1234', '한 번에 많이 말고 한 챕터씩 읽어보도록 하세요! 좋은 독서 습관 꼭 가지시길 바랄게요', 10);
insert into reply(seqs, id, password, contents, seq) 
values(14, 'chanho', '1234', 'hongkd님도 좋은 저녁 보내세요 ~ 오늘 하루도 수고하셨습니다 다들', 11);
insert into reply(seqs, id, password, contents, seq) 
values(15, 'yunkyung', '1234', '독후감 쓰시는 거 보니 어린 친구인 것 같은데 동화 ''춘향전'' 어떠신가요ㅎㅎ', 12);
insert into reply(seqs, id, password, contents, seq) 
values(16, 'vv1375', '1234', '저요!!', 13);
insert into reply(seqs, id, password, contents, seq) 
values(17, 'sunwoo', '1234', '글 올리시면 저도 참여할게요', 13);
insert into reply(seqs, id, password, contents, seq) 
values(18, 'mina', '1234', '저도 참여할게요!', 13);
insert into reply(seqs, id, password, contents, seq) 
values(19, 'kkk123', '1234', '그만큼 책을 보는 눈이 뛰어나시다는 거겠죠!', 14);
insert into reply(seqs, id, password, contents, seq) 
values(20, 'tree1004', '1234', '그럼요!! 자유게시판인걸요', 15);
insert into reply(seqs, id, password, contents, seq) 
values(21, 'mrkang', '1234', '본인 취향을 공유해서 친구분이 새로운 책을 접하게 하는 것도 좋은 방법인 것 같아요!', 16);
insert into reply(seqs, id, password, contents, seq) 
values(22, 'vv1375', '1234', '감사합니다 영영 잃어버린 줄 알았어요..', 17);
insert into reply(seqs, id, password, contents, seq) 
values(23, 'goat', '1234', '저는''이것은 작은 브랜드를 위한 책''이 너무 좋았어요. 아직 사이트에 없길래 희망 도서 신청드렸어요.', 18);
insert into reply(seqs, id, password, contents, seq) 
values(24, 'mina', '1234', '저는''레스토랑의 세계사''요. 생각했던 것보다 너무 재밌게 봤어요', 18);
insert into reply(seqs, id, password, contents, seq) 
values(25, 'hwan12', '1234', '커뮤니티 게시판에 가시면 같이 활동하시려는 분들이 많을거에요!', 19);
insert into reply(seqs, id, password, contents, seq) 
values(26, 'yujin', '1234', '음 희망 도서 신청 넣고 보통 일주일이면 들어오는 것 같아요', 20);


insert into reply(seqs, id, password, contents, seq) 
values(2, '강감찬', '1234', '두번째 게시글입니다.', 5);

