<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/or_style.css">
<title>新規登録完了画面</title>
</head>
<body>
	<header></header>
	<div id="main" align="center">
	<br><br><br><br>
		<div class="member" >
			<h1>新規登録完了しました</h1>
		</div>
		<div class="nomember_btn">
			<a href='<s:url action="GoHomeAction"/>'>Home画面へ</a>
		</div>
	</div>
	<!-- フッター -->
<jsp:include page="include_footer.jsp" />
</body>
</html>