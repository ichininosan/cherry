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
</head>

<body class="home">

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />


<!-- メインコンテンツ -->
	<div class="box">
	  <div class="sectionHeader">
			<h1>確認画面</h1>
	  </div>
		<div class="contBody">
			<h3>登録する内容は以下でよろしいですか。</h3>

				<s:form action="ResetPasswordCompleteAction">
				<table>
					<tr id="box">
						<th>
							<label>ログインID:</label>
						</th>
						<td>
							<s:property value="userId" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<th>
							<label>パスワード:</label>
						</th>
						<td>
							<s:property value="s" escape="false" />
						</td>
					</tr>
					</table>
				</s:form>
			   <div class="btnn">
				  <s:submit value="完了" />
			   </div>
		</div>
	</div>

<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>