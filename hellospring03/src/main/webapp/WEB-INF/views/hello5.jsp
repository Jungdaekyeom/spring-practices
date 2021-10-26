<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HelloController.java의 hello2 함수 안에 String name 해줌 -->
	<!-- System.out.println(name)을 해주고 -->
	<!-- 실행시킨 서버 URL 위에서 http://localhost:8080/hellospring03/hello2?n=바보야 라고 입력-->
	<!-- 콘솔창에서 바보야가 보이는 것을 확인 -->
	
	<h1>바보들아 ${name }</h1>
</body>
</html>