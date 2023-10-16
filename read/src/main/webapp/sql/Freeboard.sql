create table Freeboard(
	seq		number(5)	primary key,
	ttl	varchar2(200),
	writer	varchar2(20),
	content varchar2(2000),
	regdate	date	default sysdate,
	cnt		number(5)	default 0,
	id			varchar2(20),
	password	varchar2(20),
	contents   varchar2(2000)
);

select * from FREEBOARD;

delete from FREEBOARD where seq = '12';

drop table FREEBOARD purge;

insert into Freeboard(seq, ttl, writer, content) 
values(1, '너무 좋네요~!', 'hongkd', '책 읽으면서 커피 한 잔 마시니 너무 좋아요!');

insert into Freeboard(seq, ttl, writer, content) 
values(2, '다들 한 달 독서량 어떻게 되세요?', 'mina', '전 이제 여기서 독서 시작한지 한 달 됐는데 한 2권 읽었네요!! 다들 한 달에 평균 몇 권씩 읽으시나요??');

insert into Freeboard(seq, ttl, writer, content) 
values(3, '도움! 대출이 안 돼요', 'myid', '대출을 누르니 블랙리스트 회원이라면서 대출이 안 되는데 왜 안 되는 거죠??ㅠ ');

insert into Freeboard(seq, ttl, writer, content) 
values(4, '저녁 추천 받습니다', 'sunny', '오늘 저녁 메뉴 추천 좀요ㅎㅎ ');

insert into Freeboard(seq, ttl, writer, content) 
values(5, '이 책 어때요?', 'mrkang', '천선란 작가님의 ''천 개의 파랑''이 유명해서 읽어보려 하는 데 진짜 재밌나요??' );

insert into Freeboard(seq, ttl, writer, content) 
values(6, '인사드립니다!', 'likeit', '오늘 가입한 likeit 입니다 ~ 좋은 책 많이 읽고 공유하고 싶어요!');

insert into Freeboard(seq, ttl, writer, content) 
values(7, '아래 커피 글 보니까 갑자기 궁금해지네요', 'sunny', '다들 무슨 커피 제일 좋아하세요?? 전 책 읽으면서 달달한 카페라떼 마시면 너무 행복하더라고요');

insert into Freeboard(seq, ttl, writer, content) 
values(8, '여기 회원님들 책 추천 너무 잘하시네요', 'goat', '커뮤니티 게시판에서 과학 관련 책 추천해주는 게시글에 참여했는데 추천해준 모든 책들이 다 너무 재밌었어요! 책 보는 눈들이 좋으신듯^^');

insert into Freeboard(seq, ttl, writer, content) 
values(9, '얼른 퇴근하고 책 읽고 싶어요ㅠ', 'yunkyung', '일이 너무 바빠서 보던 책을 일주일 째 못 보고 있네요ㅠ 오늘은 꼭 퇴근하고 읽으러 가야겠어요');

insert into Freeboard(seq, ttl, writer, content) 
values(10, '책 읽는 습관 들이는 법 있으신가요?', 'chanho', '가입한지는 3달이 지났는데 혼자서 책 한 권을 다 마무리 못하고 계속 미루네요...다들 책 읽는 습관은 어떻게 들이셨나요??');

insert into Freeboard(seq, ttl, writer, content) 
values(11, '오늘 날씨가 너무 선선하고 좋네요~', 'hongkd', '이제 곧 퇴근시간인데 다들 행복한 저녁보내세요ㅎㅎ');
insert into Freeboard(seq, ttl, writer, content) 
values(12, '책 추천해주세요', 'hwan12', '독후감 써야하는데 어떤 책을 읽을지 모르겠어요');
insert into Freeboard(seq, ttl, writer, content) 
values(13, '같이 책 읽고 토론할 분?', 'goat', '있으시면 커뮤니티 게시판에 글 쓰려구요!');
insert into Freeboard(seq, ttl, writer, content) 
values(14, '제가 읽고 싶은 책은 인기가 많네요ㅠㅠ', 'hwan12', '항상 모두 대여 중...');
insert into Freeboard(seq, ttl, writer, content) 
values(15, '여기는 책말고 다른 얘기도 해도 되나요?', 'likeit', '자유 게시판이니까 다양한 주제로 얘기해도 되는 공간이죠?');
insert into Freeboard(seq, ttl, writer, content) 
values(16, '요즘 친구들은 어떤 책을 좋아할까요', 'vv1375', '책 선물을 하고 싶은데 제 취향의 책은 상대방 취향이 아닐까봐 고민이네요.');
insert into Freeboard(seq, ttl, writer, content) 
values(17, '화장실에 핸드폰 두고 가신 분!!', 'abc777', '사서님께 전달드렸으니 찾아가셔요~');
insert into Freeboard(seq, ttl, writer, content) 
values(18, '최근에 읽은 책 중에 뭐가 제일 좋으셨어요?', 'tree1004', '저는 아낌없이 주는 나무가 좋았어요');
insert into Freeboard(seq, ttl, writer, content) 
values(19, '혹시 같이 독후감 쓰실 분?', 'kimhappy', '혼자하려니까 자꾸 미루게 돼요ㅠ 같이 책 읽고 독후감 쓰실 분');
insert into Freeboard(seq, ttl, writer, content) 
values(20, '신간 도서는 보통 언제 들어오나요?', 'heok', '이번에 좋아하는 작가가 새 책을 냈는데 일등으로 보고 싶어서요!!');

select * from (select * from FREEBOARD where cnt >= 0 order by dbms_random.value) where rownum <=3;
