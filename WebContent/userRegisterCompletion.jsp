<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/onai_style.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">

<title>新規登録完了画面</title>
</head>
<body>
	<jsp:include page="include_header.jsp" />
	<div id="main" align="center">
	<br><br>
		<div class="kan" >
			新規登録完了しました
		</div>
		<br><br>
		<div class="nomember_btn">
			<a href='<s:url action="GoHomeAction"/>'>Home画面へ</a>
		</div>
	</div>
	<!-- フッター -->
<jsp:include page="include_footer.jsp" />
</body>
</html>