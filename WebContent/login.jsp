<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ログイン画面</title>

</head>
<body>

	<div id="main">
		<h2 class="title">ログイン</h2>
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
							<s:textfield type="text" name="userId" value="%{#session.saveId}"
								class="validate[required,minSize[1],maxSize[16],custom[onlyLetterNumber]]" />
							<br>
						</div>

						<br>
						<div class="member_form_title">
							パスワード<br>
						</div>
						<div class="member_textbox">
							<s:password name="password"
								class="validate[required,minSize[1],maxSize[16],custom[onlyLetterNumber]]" />
						</div>


						<p>
							<s:checkbox name="saveLogin" />
							次回からIDの入力を省略
						</p>

						<div class="member_btn">
							<button type="submit" class="">ログイン</button>
						</div>
					</s:form>
				</div>
			</div>



			<div class="nomember">
				商品購入の際はユーザー登録をお願いします。<br>
				<br>
				<div class="nomember_btn">
					<a href='<s:url action="userCreateAction"/>'>新規ユーザー登録</a>
				</div>
			</div>
		</div>



	</div>



</body>
</html>
