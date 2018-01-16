<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/or_style.css">
<script type="text/javascript" src="script.js"></script>
<title>ユーザー情報入力画面</title>
</head>
<body>
	<div id="main">
		</div>
		<header><h2 class="title">新規ユーザー登録</h2></header>
		<div class="register_box">
			<div class="member" align="center">
				<br><br><br><br>

				<h5>
					<s:iterator value="errorMessageList">
						<s:div>
							<s:property />
						</s:div>
					</s:iterator>
				</h5>
				<div class="member_form">
					<s:form action="CheckUserInfoAction" theme="simple"
						id="userRegister">
						<div class="member_form_title">姓</div>
						<div class="member_form_text">
							<s:textfield type="text" name="familyName" value="%{familyName}" />
						</div>

						<br>
						<div class="member_form_title">名</div>

						<div class="member_form_text">
							<s:textfield type="text" name="firstName" value="%{firstName}" />
							<br>
						</div>

						<br>
						<div class="member_form_title">姓ふりがな</div>
						<div class="member_form_text">
							<s:textfield type="text" name="familyNameKana"
								value="%{familyNameKana}" />
							<br>
						</div>

						<br>
						<div class="member_form_title">名ふりがな</div>
						<div class="member_form_text">
							<s:textfield type="text" name="firstNameKana"
								value="%{firstNameKana}" />
							<br>
						</div>

						<br>
						<div class="member_form_title">ユーザーID</div>
						<div class="member_form_text">
							<s:textfield type="text" name="userId" value="%{userId}" />
							<br>
						</div>

						<br>
						<div class="member_form_title">パスワード</div>
						<div class="member_form_text">
							<s:password name="password" value="%{password}" />
							<br>
						</div>

						<br>
						<div class="member_form_title">性別</div>
						<div class="member_form_radio">
							<s:radio name="sex" list="#{'0': '男性', '1': '女性'}" value="0" />
							<br>
						</div>

						<br>
						<div class="member_form_title">メールアドレス</div>
						<div class="member_form_text">
							<s:textfield type="text" name="email" value="%{email}" />
							<br>
						</div>

						<br>
						<div class="member_btn">
							<button type="submit" class="">登録情報確認</button>
						</div>
					</s:form>

				</div>
			</div>
		</div>
		<!-- フッター -->
<jsp:include page="include_footer.jsp" />
</body>
</html>