create table cumuboard(
	cuseq		number(5)	primary key,
	cutitle	varchar2(200),
	cuwriter	varchar2(20),
	cucontent varchar2(2000),
	curegdate	date	default sysdate,
	cucnt		number(5)	default 0,
	id			varchar2(20),
	password	varchar2(20),
	cucontents   varchar2(2000)
);

drop table cumuboard purge;

select * from cumuboard;

insert into cumuboard(cuseq, cutitle, cuwriter, cucontent) 
values(1, '판타지 관련 소설 찾아드립니다!', 'hongkd', '제가 판타지 책을 많이 읽었었는데 생각보다 특정 책을 찾고싶어하시는 분들이 많더라고요. 참여하시면 제가 판타지 관련 소설 추천해드릴게요.');

insert into cumuboard(cuseq, cutitle, cuwriter, cucontent) 
values(2, '한 달에 두 권씩 책 읽기 챌린지', 'sunwoo', '혼자 독서하기 보다 여러 명과 함께 인증하면서 독서를 습관화하는 취지에서 참여하신 분들은 매 달 2권씩 읽은 책을 댓글로 남겨주세요!');

insert into cumuboard(cuseq, cutitle, cuwriter, cucontent) 
values(5, '두번째 게시글', '홍홍홍', '첫번째 게시글입니다.');