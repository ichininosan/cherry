<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cherry</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/onai_style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />
<br><br>

<div class="out" align="center">
	<div class="heart">&#9829;</div>
	<br>
	<h1>ログアウトしました</h1>
	<br><br><br><br>
	<div class="nomember_btn">
		<a href="/cherry/TopAction">T O P </a>
	</div>
</div>
<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>