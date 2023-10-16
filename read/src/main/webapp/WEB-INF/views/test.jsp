<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<!-- jQuery auto complete -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
<!-- 자동완성 결과 값 꾸며주기 -->
.autocomplete-suggestions { border: 1px solid #999; background: #FFF; overflow: auto; }
.autocomplete-suggestion { padding: 5px 5px; white-space: nowrap; overflow: hidden; font-size:22px}
.autocomplete-selected { background: #F0F0F0; }
.autocomplete-suggestions strong { font-weight: bold; color: #3399FF; }
</style>

<meta charset="UTF-8">
<title>Test</title>
</head>
<body>

    <input type="text" id="inputBox">
    <input type="hidden" id="book" value="${bookList}" />

<script>
    $(document).ready(function() {
        var inputSource = ${bookList}
        alert(${bookList});
        $('#inputBox').autocomplete({
            source : inputSource,
            minLength : 0
        }).focus(function() {
            $(this).autocomplete("search", $(this).val());
        });
        
    });
</script>

<script>
$(document).ready(function() {
    var inputSource = document.getElementById("input-text").value;
    document.write("<h1>"+inputSource+"</h1>")
</script>



</body>
</html>