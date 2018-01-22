<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/onai_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
<title>購入完了画面</title>

</head>
<body>
<!-- ヘッダー -->
		<jsp:include page="include_header.jsp" />

<!-- メイン -->
	<div id="main" align="center">
		<br><br>
		<div class="heart">&#9829;</div>
		<br>

			<p>購入手続きが完了致しました</p>
		<br><br><br><br>

			<div class="nomember_btn">
			 	<a href='<s:url action="GoPurchaseHistoryAction"/>'>購入履歴</a>
			 	<br><br>
				<a href='<s:url action="GoHomeAction"/>'>H O M E</a>
			</div>
	</div>


	<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>