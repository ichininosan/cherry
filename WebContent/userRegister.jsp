<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/onai_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
<script type="text/javascript" src="script.js"></script>
<title>ユーザー情報入力画面</title>
</head>
<body>
	<div id="main">
		<jsp:include page="include_header.jsp" />

		<br><br>

       <div class="title">新規ユーザー登録</div>
		<br>
		<div class="register_box">
			<div class="member">
				<div class="error" align="center">
					<s:iterator value="errorMessageList">
						<s:div>
							<s:property />
						</s:div>
					</s:iterator>
				</div>
				<br>
				<div class="member_form">
					<s:form action="CheckUserInfoAction" theme="simple"
						id="userRegister">
						<span class="member_form_title">姓</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="familyName" value="%{familyName}" />
						</div>

						<br>
						<span class="member_form_title">名</span>
						<span class="hissu">必須</span>

						<div class="member_form_text">
							<s:textfield type="text" name="firstName" value="%{firstName}" />
							<br>
						</div>

						<br>
						<span class="member_form_title">姓ふりがな</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="familyNameKana"
								value="%{familyNameKana}" />
							<br>
						</div>

						<br>
						<span class="member_form_title">名ふりがな</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="firstNameKana"
								value="%{firstNameKana}" />
							<br>
						</div>

						<br>
						<span class="member_form_title">ユーザーID＜半角英数字＞</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="userId" value="%{userId}" />
							<br>
						</div>

						<br>
						<span class="member_form_title">パスワード＜半角英数字＞</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:password name="password" value="%{password}" />
							<br>
						</div>

						<br>
						<span class="member_form_title">性別</span>
						<span class="hissu">必須</span>
						<div class="member_form_radio">
							<s:radio name="sex" list="#{'0': '男性', '1': '女性'}" value="0" />
							<br>
						</div>

						<br>
						<span class="member_form_title">メールアドレス</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="email" value="%{email}" />
							<br>
						</div>

						<br><br>
						<div class="member_btn">
							<button type="submit" class="">登 録 情 報 確 認</button>
						</div>
					</s:form>

				</div>
			</div>
		</div>
	</div>
		<!-- フッター -->
<jsp:include page="include_footer.jsp" />
</body>
</html>