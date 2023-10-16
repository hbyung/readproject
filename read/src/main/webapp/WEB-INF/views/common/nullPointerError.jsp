<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 에러 화면(NullPointerException)</title>
</head>
<body bgcolor="#ffffff" text="#000000">

	<table border="1" width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center" bgcolor="orange"><b>NullPointerException 예외 발생 화면입니다.</b></td>
		</tr>
	</table>
	
	<table border="1" width="100%" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td align="center">
				<br><br><br><br>
					Message : ${ exception.message }
				<br><br><br><br>
			</td>
		</tr>
	</table>

</body>
</html>