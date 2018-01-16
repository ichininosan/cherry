<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>パスワード再設定</title>
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
			<h1>パスワード再設定</h1>
		<div>
			<table>
			<s:form action="ResetPasswordConfirmAction">

				<!-- ここから入力エラーメッセージ表示 -->
				<h5>
					<s:iterator value="errMsgList">
						<s:property/>
					</s:iterator>
				</h5>
				<!-- ここまで入力エラーメッセージ表示 -->

				<tr>
					<td>
						<label>ログインID:</label>
					</td>
					<td>
						<input type="text" name="userId" value='<s:property value="#session.saveId"/>' />
					</td>
				</tr>
				<tr>
					<td>
						<label>パスワード:</label>
					</td>
					<td>
						<input type="password" name="password" value="">
					</td>
				</tr>
				<tr>
					<td>
						<label>再確認パスワード:</label>
					</td>
					<td>
						<input type="password" name="passwordc" value="">
					</td>
				</tr>
				<s:submit value="登録" />
			</s:form>
			</table>
			<div>
				<span>前画面に戻る場合は</span><a href='<s:url action="LoginAction" />'>こちら</a>
			</div>
		</div>
	</div>
<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>