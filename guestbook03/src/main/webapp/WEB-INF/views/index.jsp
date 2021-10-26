<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("newLine", "\n");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guestbook03 스프링 공부</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/add" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
			</tr>
		</table>
	</form>

	<!-- jstl문 -->
	<c:set var='count' value='${fn:length(list) }' />
	<c:forEach items='${list }' var='vo' varStatus='status'>
		<br>
		<form action="${pageContext.request.contextPath }/delete/${vo.no }"
			method="post">
			<table width=510 border=1>
				<tr>
					<td align=right width="200">No</td>
					<td>[${count-status.index }]</td>
				</tr>
				<tr>
				<tr>
					<td align=right width="200">Name</td>
					<td>${vo.name }</td>
				</tr>
				<tr>
					<td align=right width="200">Date</td>
					<td>${vo.regDate }</td>
				</tr>
				<tr>
					<td align=right width="200">Message</td>
					<td>${fn:replace(vo.message, newLine, "<br/>") }</td>
				</tr>
				<tr>
					<td align=right width="200">삭제</td>
					<td><input type="submit" value="삭제"></td>
				</tr>
			</table>
	</c:forEach>
</body>
</html>
