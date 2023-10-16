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

      background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c));
      background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
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
        <h4 class="mb-3" style="text-align: center;">비밀번호 변경</h4>
        <form class="validation-form" novalidate action="/updatemember.do" method="post">
          <div class="row">
          </div>
            <div class="col-md-6 mb-3">
              <label for="name">아이디</label>
              <input type="text" class="form-control" id="id" placeholder="아이디를 입력해주세요." name="id" required>
              <div class="invalid-feedback">
              </div>
            </div>
            
            <div class="col-md-6 mb-3">
              <label for="nickname">새 비밀번호</label>
              <input type="password" class="form-control" id="password" placeholder="새 비밀번호를 입력해주세요." name="password" required>
              <div class="invalid-feedback">
              </div>
            </div>
            
            <div class="col-md-6 mb-3">
              <label for="nickname">새 비밀번호확인</label>
              <input type="password" class="form-control" id="repassword" placeholder="새 비밀번호을 다시 입력해주세여" name="repassword" required>
              <div class="invalid-feedback">
  
              </div>
            </div>
          

          <hr class="mb-4">
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">수정 완료</button>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2023 YD</p>
    </footer>
  </div>

</body>

</html>