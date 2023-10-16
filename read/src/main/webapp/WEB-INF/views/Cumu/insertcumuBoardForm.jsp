<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새 글 등록</title>

<!-- jQuery -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>



<!-- Bootstrap CSS -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
 <script src="/node_modules/jquery/dist/jquery.min.js"></script>  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.1.3/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/node_modules/bootstrap/dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/node_modules/font-awesome/css/font-awesome.min.css"/>
<script src="/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/headers/">
    <link rel="stylesheet" href="style.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>

	
  </script>

<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">


<title>board</title>



<script>

	$(document).on('click', '#btnSave', function(e){

		e.preventDefault();

		

		$("#form").submit();

	});

	

	$(document).on('click', '#btnList', function(e){

		e.preventDefault();

		

		location.href="getcumuBoardList.do";

	});

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
	background-image: url('./image/images.jpg');
	background-size: cover; 
	background-repeat: no-repeat;
  	background-position: center;
	color:white;
	animation: myAnimation 20s infinite;
	width:100%; height:300px;
	

}   

@keyframes myAnimation {
  0% {
    
    background-image: url('./image/newpxfuel.jpg');
  }

  15% {
    
    background-image: url('./image/newpxfuel.jpg');
  }

  30% {
    
    background-image: url('./image/변형이미지xcf.png');
  }

  45% {
   
    background-image: url('./image/변형이미지xcf.png');
  }

  60% {
    
    background-image: url('./image/new annie-spratt-hCb3lIB8L8E-unsplash.jpg');
  }
   
   85% {
   
    background-image: url('./image/new annie-spratt-hCb3lIB8L8E-unsplash.jpg');
  }
  
  100% {
   
    background-image: url('./image/newpxfuel.jpg');
  }
 
}

.ance {
	margin: 0 auto;
	display: inline-block;

}

#hanging-icons{
	border:1px solid; padding:10px;
	background-image: url('./image/bg-masthead.jpg');
	background-size: cover;
	color:white;
	
}

#friend{
	border:1px solid; padding:10px;
	background-image: url('./image/john-schnobrich-2FPjlAyMQTA-unsplash.jpg');
	background-size: cover;
	color:white;
	
}

.nbd{
	border:1px solid; padding:10px;
	background-color:#000000;
	background-size: cover;
	color:white;
	
}

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


#boardBackground{
	background-image:url(./image/write2.png);
	background-size: 400px 360px;
	background-position:center;
	background-repeat: no-repeat;
	width:300px; height: 300px;
	margin-right: 70px;
	color:black;
}
 .a{
     background-color:black;
     height: 1px;
      }



</style>

</head>

<body>

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
	
	<div>&nbsp;</div>
		<div>&nbsp;</div>
			<div>&nbsp;</div>
	<article>
			
			<h2 align="center">Community Board</h2>
			<div>&nbsp;</div>
				
		<div class="container" role="main" style="text-align:center;">

			<form name="form" id="form" role="form" method="post" action="/insertcumuBoard.do">


				<div class="mb-3" >
				
					

					<input type="text" class="form-control" name="cutitle" id="cutitle" placeholder="제목을 입력해 주세요" style="width:700px; display:block; margin: 0 auto;">

				</div>

				

					<input type="hidden" class="form-control" name="cuwriter" id="cuwriter" value="${id}">


				

				<div class="mb-3">

	

					<textarea class="form-control" rows="10" name="cucontent" id="cucontent" placeholder="내용을 입력해 주세요" style="width:700px; display:block; margin: 0 auto;"></textarea>

				</div>

			<div >

				<button type="button" class="btn btn-sm btn-primary" id="btnSave" style="width:65px; height:35px;">저장</button>

				<button type="button" class="btn btn-sm btn-primary me-2" id="btnList" style="width:65px; height:35px;">목록</button>

			</div>
				</form>	
		</div>
	</article>
		<div>&nbsp;</div>
			<div>&nbsp;</div>
				<div>&nbsp;</div>
				<div>&nbsp;</div>
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
		window.location.href="/getBookList.do";
	}
	</script>
     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>

</html>
</body>
</html>














