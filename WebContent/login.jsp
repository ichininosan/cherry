<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/onai_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
<title>ログイン画面</title>

</head>
<body>
<!-- ヘッダー -->
		<jsp:include page="include_header.jsp" />

<!-- メイン -->
	<div id="main">

        <br><br>
        <div class="title">ログイン</div>
          	<br>
		<div class="login_box">
			<div class="member">
				<div class="error" align="center">
					<s:if test="message !=null">
	          			<strong><s:property value="message"/></strong>
	          		</s:if>
					<s:if test="errorMessageList !=null">
	          			<s:property value="errorMessageList"/>
	          		</s:if>
          		</div>

				<div class="member_form">
					<s:form action="LoginAction" theme="simple" id="LoginForm">

						<div class="member_form_title">
							ユーザーID<br>
						</div>
						<div class="member_textbox">
							<s:textfield type="text" name="userId" value="%{#session.saveId}"/>
							<br>
						</div>

						<br>
						<div class="member_form_title">
							パスワード<br>
						</div>
						<div class="member_textbox">
							<s:password name="password"/>
						</div>

						<p>
							<s:checkbox name="saveLogin" />
							次回からIDの入力を省略
						</p>
						<br>
						<div class="member_btn">
							<button type="submit" class="">ログイン</button>
						</div>
						<br>
						<div>
					<a href='<s:url action="ResetPasswordAction"/>'>パスワード再設定</a>
				</div>
					</s:form>
				</div>
			</div>
			<br><br>
			<div class="nomember">
				商品購入の際はユーザー登録をお願いします<br>

				<div class="nomember_btn">
					<a href='<s:url action="UserCreateAction"/>'>新規ユーザー登録</a>
				</div>

			</div>
		</div>



	</div>
<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>
