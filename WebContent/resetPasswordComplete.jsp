<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>パスワード設定完了</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sato_style.css">
</head>

<body class="home">

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />


<!-- メインコンテンツ -->
	<div class="box">
	    <div class="sectionHeader">
			<h1>完了画面</h1>
		</div>
		<div class="contBody"><br>
			<h3>パスワードの再設定が完了致しました。</h3>

			<div>
				<a href='<s:url action="LoginAction" />'>ログインへ</a>
			</div>
		</div>
	</div>

	<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>