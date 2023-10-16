<!DOCTYPE html>
<html lang="ko">

<head>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입 화면 샘플 - Bootstrap</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <style>
    body {
      min-height: 100vh;

     background-image: url('./image/bg-masthead.jpg');
	 background-size: cover;
    }

    .input-form {
      max-width: 680px;

      margin-top: 80px;
      padding: 32px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
  </style>
</head>

<body>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">회원가입</h4>
        <form class="validation-form" novalidate action="/insertmember.do">
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">아이디</label>
              <input type="text" class="form-control" id="id" placeholder="" name="id" required>
              <div class="invalid-feedback">
                아이디를 입력해주세요.
              </div>
            </div>
            <div class="col-md-6 mb-3">
              <label for="nickname">비밀번호</label>
              <input type="password" class="form-control" id="password" placeholder="" name="password" required>
              <div class="invalid-feedback">
                비밀번호을 입력해주세요.
              </div>
            </div>
          </div>

          <div class="mb-3">
            <label for="name">이름</label>
            <input type="text" class="form-control" id="name" placeholder="ex)홍길동" name="name"required>
            <div class="invalid-feedback">
              이름을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="email">이메일</label>
            <input type="text" class="form-control" id="email" placeholder="you@example.com" name="email" required>
            <div class="invalid-feedback">
             이메일을 입력해주세요.
            </div>
          </div>

  
          <hr class="mb-4">
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button><br>
        </form>
       	  <button class="btn btn-primary btn-lg btn-block" onclick="location.href='/main.do';">메인 화면으로</button>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2023 YD</p>
    </footer>
  </div>

</body>

</html>