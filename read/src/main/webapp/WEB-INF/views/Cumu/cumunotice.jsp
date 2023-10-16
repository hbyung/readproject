<!doctype html>
<html lang="ko">
  <head>
     <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.104.2">
    <title>커뮤니티 게시판</title>
	 <script src="/node_modules/jquery/dist/jquery.min.js"></script>
<link rel="stylesheet" href="/node_modules/bootstrap/dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/node_modules/font-awesome/css/font-awesome.min.css"/>
<script src="/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/headers/">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>
	
  </script>

    <style>
       
      .moveManualBtn {
 position: fixed;
  bottom: 31rem;
  right: 3rem;
  width: 5rem;
  height: 5rem;
  background: #F3F799;
  color: #000000;
  border-radius: 50%; /* make the button circular */
  cursor:pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  line-height: 4rem;
}
.moveTopBtn {
 position: fixed;
  bottom: 25rem;
  right: 3rem;
  width: 5rem;
  height: 5rem;
  background: #F3F799;
  color: #000000;
  border-radius: 50%; /* make the button circular */
  cursor:pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  line-height: 4rem;
}

.moveSearchBtn {
 position: fixed;
  bottom: 19rem;
  right: 3rem;
  width: 5rem;
  height: 5rem;
  background: #F3F799;
  color: #000000;
  border-radius: 50%; /* make the button circular */
  cursor:pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  line-height: 4rem;
}
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
       .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
       .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
      
      
      .dropbtn {
    background-color: #0A6EFF;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}
.dropdown {
    position: relative;
    display: inline-block;
}
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}
.dropdown-content a:hover {
    background-color: #f1f1f1
}
.dropdown:hover .dropdown-content {
    display: block;
}
.dropdown:hover .dropbtn {
    background-color: #289AFF;
}
      
.mybox{
	border:1px solid; padding:10px;
	background-image: url('../image/images.jpg');
	background-size: cover
}     

.pagination{
justify-content: center; 

}

 

    </style>

    
    <!-- Custom styles for this template -->
  
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">  
  
</head>
<body>
    
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="bootstrap" viewBox="0 0 118 94">
    <title>Bootstrap</title>
    <path fill-rule="evenodd" clip-rule="evenodd" d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z"></path>
  </symbol>
  <symbol id="home" viewBox="0 0 16 16">
    <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
  </symbol>
  <symbol id="speedometer2" viewBox="0 0 16 16">
    <path d="M8 4a.5.5 0 0 1 .5.5V6a.5.5 0 0 1-1 0V4.5A.5.5 0 0 1 8 4zM3.732 5.732a.5.5 0 0 1 .707 0l.915.914a.5.5 0 1 1-.708.708l-.914-.915a.5.5 0 0 1 0-.707zM2 10a.5.5 0 0 1 .5-.5h1.586a.5.5 0 0 1 0 1H2.5A.5.5 0 0 1 2 10zm9.5 0a.5.5 0 0 1 .5-.5h1.5a.5.5 0 0 1 0 1H12a.5.5 0 0 1-.5-.5zm.754-4.246a.389.389 0 0 0-.527-.02L7.547 9.31a.91.91 0 1 0 1.302 1.258l3.434-4.297a.389.389 0 0 0-.029-.518z"/>
    <path fill-rule="evenodd" d="M0 10a8 8 0 1 1 15.547 2.661c-.442 1.253-1.845 1.602-2.932 1.25C11.309 13.488 9.475 13 8 13c-1.474 0-3.31.488-4.615.911-1.087.352-2.49.003-2.932-1.25A7.988 7.988 0 0 1 0 10zm8-7a7 7 0 0 0-6.603 9.329c.203.575.923.876 1.68.63C4.397 12.533 6.358 12 8 12s3.604.532 4.923.96c.757.245 1.477-.056 1.68-.631A7 7 0 0 0 8 3z"/>
  </symbol>
  <symbol id="table" viewBox="0 0 16 16">
    <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z"/>
  </symbol>
  <symbol id="people-circle" viewBox="0 0 16 16">
    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
  </symbol>
  <symbol id="grid" viewBox="0 0 16 16">
    <path d="M1 2.5A1.5 1.5 0 0 1 2.5 1h3A1.5 1.5 0 0 1 7 2.5v3A1.5 1.5 0 0 1 5.5 7h-3A1.5 1.5 0 0 1 1 5.5v-3zM2.5 2a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zm6.5.5A1.5 1.5 0 0 1 10.5 1h3A1.5 1.5 0 0 1 15 2.5v3A1.5 1.5 0 0 1 13.5 7h-3A1.5 1.5 0 0 1 9 5.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zM1 10.5A1.5 1.5 0 0 1 2.5 9h3A1.5 1.5 0 0 1 7 10.5v3A1.5 1.5 0 0 1 5.5 15h-3A1.5 1.5 0 0 1 1 13.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zm6.5.5A1.5 1.5 0 0 1 10.5 9h3a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 13.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3z"/>
  </symbol>
</svg>

<main>

     
 <div class="container" >
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
        <svg xmlns="http://www.w3.org/2000/svg" width="70" height="32" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
  <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
		</svg>
		&nbsp; &nbsp; &nbsp;<h4>Library Management</h4>
      </a>
      
      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
      	<div class="dropdown">
      <button class="dropbtn" onclick="location.href='/index.jsp';">Home</button>
   	 </div>
   	 <li>&nbsp;</li>
   	 <div class="dropdown">
      <button class="dropbtn">Rental/Return</button>
      <div class="dropdown-content">
      	<a href="./searchForBookPage.do">도서 검색</a>
        <a href="./insertRental.rn">도서 대출</a>
        <a href="./getBookList.do ">도서 전체목록</a>
        <a href="./deleteRental.rn">도서 반납</a>
      </div>
   	 </div>
   	 <li>&nbsp;</li>
   	 <div class="dropdown">
      <button class="dropbtn" onclick="location.href='/hopelist.do';">hope book</button>
      <div class="dropdown-content">
      </div>
   	 </div>
   	 <li>&nbsp;</li>
   	 <div class="dropdown">
      <button class="dropbtn">Notice</button>
      <div class="dropdown-content">
     	<a href="/getBoardList.do">공지사항</a>
        <a href="/getFreeBoardList.do">자유게시판</a>
        <a href="getcumuBoardList.do">커뮤니티게시판</a>
      </div>
   	 </div>
   	 <li>&nbsp;</li>
   	 <div class="dropdown">
      <button class="dropbtn">Information</button>
      <div class="dropdown-content">
        <a href="homeinfo.do">도서관정보</a>
        <a href="usermenu.do">사용자메뉴얼</a>
        <a href="getAdminMain.me" >관리자 페이지</a>
      </div>
   	 </div>  
      </ul>
      <div class="col-md-3 text-end">
      <% String id = (String)session.getAttribute("id");%>
       <% if (id == null) { %>
       	 <div style="display: flex; align-items: center;">

   		 <button type="button" class="btn btn-primary" onclick="location.href='/memberlogin.me';" style="margin-left:0px;">Login</button>
   		 <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='/joinmembership.me';" style="margin-left:0px;">member</button>
   		 </div>
  	   <% } else { %>
  	   <div style="display: flex; align-items: center;">
  	   	 <div style="font-weight:620;">${id}님,<br> 환영합니다!&nbsp;&nbsp;</div> &nbsp;
   		 <button type="button" class="btn btn-primary" onclick="location.href='/memberlogout.me';" style="margin-left:5px;">
   		 	LogOut
   		 </button>
   		
   	   </div>
  	   <% } %>
      </div>
    </header>
  </div>
  
  <div class="b-example-divider"></div>
  <div align="center">
  <div>&nbsp;</div>
  <div>&nbsp;</div>
  <h4>${board.cutitle}</h4>
  </div>
  <div>&nbsp;</div>
  <table style="margin-left:auto; margin-right:auto; border: 1px black solid; border-left:0; border-right:0;" cellspacing="0" cellpadding="0" >
  <tr>
  <td width="900" height="80" align="left" colspan="2">
  작성자 :&nbsp;${board.cuwriter}
  </td>
  <td width="100" height="80" align="right" style="white-space: nowrap;">
  등록일 : ${board.curegdate}&nbsp;
  </td>
  </tr>
  <tr style="border-top:1px black solid; ">
  <td width="900" height="300" valign="top" align="left">
  <div>&nbsp;</div>
  &nbsp;${board.cucontent}
  </td>
  </tr>
  </table>
     <div>&nbsp;</div>
   <div style="text-align:center;">
   		<button type="button" class="btn btn-outline-secondary" onclick="location.href='/updaterank.do?cuseq=${board.cuseq}';">참여</button>
        <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='/updatecumuBoardform.do?cuseq=${board.cuseq}&cuwriter=${board.cuwriter}';">수정</button>
        <button type="button" class="btn btn-outline-warning" onclick="location.href='/getcumuBoardList.do';">목록</button>
        <form action="/deletecumuBoard.do?cuseq=${board.cuseq}" style="display:inline-block;">
        <input type="hidden" name="cuwriter" value="${board.cuwriter}" >
        <input type="hidden" name="cuseq" value="${board.cuseq}" >
        <button type="submit" class="btn btn-outline-danger" >삭제</button>
        </form>
        
   </div>
  <div>&nbsp;</div>
  <div>&nbsp;</div>
  <form action="cureply.do?cuseq=${board.cuseq}" method="post">
  <div style="text-align:center;">
  <input name="ceseq" type="hidden" value="${board.cuseq}" />
  <div class="mb-3" align="center" style="display: inline-block;">
  <input type="hidden" name="id" class="form-control" style="width:150px;height:30px;font-size:18px;" value="${id}">
  </div>
  <div class="mb-3" align="center" style="display: inline-block;">
  <input type="text" class="form-control" name="cucontents" id="exampleFormControlInput1" style="width:650px;height:150px;font-size:18px;">
  </div>
  <div class="mb-3" align="center" style="display: inline-block;">
  <input type="submit" class="btn btn-outline-primary me-2" value="저장" style="width:150px;height:100px">
  </div>
  </div>
  </form>
   <div>&nbsp;</div>	
   <div align="center">
  <h4 align="center">Reply</h4>
  </div>	
  <table class="table-striped table-hover" width="1000" style="margin-left:auto;  margin-right:auto; border-top:1px blue solid; border-bottom: 1px blue solid;">
				<tr align="center">
				<th bgcolor="#32A4FF" width="100">작성자</th>
				<th bgcolor="#32A4FF" width="150">내용</th>
				<th bgcolor="#32A4FF" width="100">작성일자</th>
			</tr>
			<c:forEach items="${boardlist}"  var="boardlist">
				<tr align="center" height="50">
					<td>${boardlist.id}</td>
					<td><a href="getdetailcureply.do?cuseqs=${boardlist.cuseqs}">${boardlist.cucontents}</a></td>
					<td style=" margin-right: 100px;">${ boardlist.curegdate }</td>
				</tr>
			</c:forEach>
		</table>
	 <div>&nbsp;</div>		
	<nav aria-label="Page navigation example">
  <ul class="pagination">
  	
    <li class="page-item"><a class="page-link" href="getcumuBoard.do${pageMaker.makeQuery(pageMaker.cri.page - 1)}&cuseq=${board.cuseq}">Previous</a></li>
    
     <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
    <li class="page-item"><a class="page-link" href="getcumuBoard.do${pageMaker.makeQuery(idx)}&cuseq=${board.cuseq}">${idx}</a></li>
    </c:forEach>
    
    <li class="page-item"><a class="page-link" href="getcumuBoard.do${pageMaker.makeQuery(pageMaker.cri.page + 1)}&cuseq=${board.cuseq}">Next</a></li>	
  </ul>
</nav>
      <div>&nbsp;</div>
	 
  <div class="b-example-divider"></div>
<div class="container">
  <footer class="py-3 my-4">
    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Home</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Rental/Return</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Announcement</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Notice</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">About</a></li>
    </ul>
    <p class="text-center text-muted">&copy; 2022 Company, Inc</p>
  </footer>
</div>
<div class="moveManualBtn" align="center" style="font-weight: bold;">Manual</div>
	<div class="moveTopBtn" align="center" style="font-weight: bold;">▲TOP</div>
	<div class="moveSearchBtn" align="center" style="font-weight: bold;">Search</div>
	<script>
	const $topBtn = document.querySelector(".moveTopBtn");
	const $manualBtn = document.querySelector(".moveManualBtn");
	const $moveSearchBtn = document.querySelector(".moveSearchBtn");
	
	$topBtn.onclick = () => {
	  window.scrollTo({ top: 0, behavior: "smooth" });  
	}
	
	$manualBtn.onclick = () => {
		window.location.href = "/usermenu.do";
	}
	
	$moveSearchBtn.onclick = () =>{
		window.location.href="/searchForBookPage.do";
	}
	</script>
<div class="b-example-divider"></div>
</body>
</html>