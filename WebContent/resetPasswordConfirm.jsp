<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>パスワード確認</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sato_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
</head>

<body class="home">

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />


<!-- メインコンテンツ -->
	<div class="main">
	  <div class="sectionHeader">
			<h1>確認画面</h1>
	  </div>
	  <br>
		<div class="contBody">
			<h3>登録する内容は以下でよろしいですか。</h3>

				<s:form action="ResetPasswordCompleteAction">
				<table>
					<tr id="box">
						<th>
							<label>cherryID</label>
						</th>
						<td>
							<s:property value="session.newUserId" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<th>
							<label>パスワード</label>
						</th>
						<td>
							<s:property value="s" escape="false" />
						</td>
					</tr>
				</table>
					<div class="btnn">
						<button type="submit">
							<span>送信</span>
						</button>
					</div>
				</s:form>

		</div>
	</div>

<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>