<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/or_style.css">
<title>ログイン画面</title>

</head>
<body>

	<div id="main" align="center">
	 <s:if test="message !=null">
          <h5><strong><s:property value="message"/></strong></h5>
          </s:if>
		<header><h1>ログイン</h1></header>
		<br><br><br>
		<div class="login_box">
			<div class="member">
				<h5>
					<s:iterator value="errorMessageList"/>
				</h5>
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

						<div class="member_btn">
							<button type="submit" class="">ログイン</button>

						</div>
						<div class="member_btn">
					<a href='<s:url action="ResetPasswordAction"/>'>パスワード再設定</a>
				</div>
					</s:form>
				</div>
			</div>

			<div class="nomember">
				商品購入の際はユーザー登録をお願いします。<br>
				<br>
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
