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
<title>ユーザー情報入力画面</title>
</head>
<body>

<!-- ここからヘッダー -->
	<jsp:include page="include_header.jsp" />
<!-- ヘッダーここまで -->

<!-- ここからメイン -->
<div class="main">
	<br>
	<h2 class="title">新規宛先情報入力</h2>
	<br>
	<br>
	<div class="register_box">
		<div class="member">
			<s:form action="DestinationRegisterConfirmAction">

				<!-- ここから入力エラーメッセージ表示 -->
				<h5>
					<s:iterator value="errMsgList">
						<s:property/>
					</s:iterator>
				</h5>
				<!-- ここまで入力エラーメッセージ表示 -->

				<h3>下記に必要事項を記入してください</h3>
					<div class="member_form">
						<div class="member_form_title">姓</div>
						<div class="member_form_text">
							<s:textfield name="familyName" value="%{familyName}"/>
						</div>
						<br>

						<div class="member_form_title">名</div>
						<div class="member_form_text">
							<s:textfield name="firstName" value="%{firstName}"/>
						</div>
						<br>

						<div class="member_form_title">姓ふりがな</div>
						<div class="member_form_text">
							<s:textfield name="familyNameKana" value="%{familyNameKana}"/>
						</div>
						<br>

						<div class="member_form_title">名ふりがな</div>
						<div class="member_form_text">
							<s:textfield name="firstNameKana" value="%{firstNameKana}"/>
						</div>
						<br>

						<div class="member_form_title">メールアドレス</div>
						<div class="member_form_text">
							<s:textfield name="email" value="%{email}"/>
						</div>
						<br>

						<div class="member_form_title">電話番号</div>
						<div class="member_form_text">
							<s:textfield name="telNumber" value="%{telNumber}"/>
						</div>
						<br>

						<div class="member_form_title">住所</div>
						<div class="member_form_text">
							<s:textfield name="userAddress" value="%{userAddress}"/>
						</div>
						<br>

						<div class="member_btn">
							<button type="submit" class="">登録情報確認</button>
						</div>
					</div>
			</s:form>
		</div>
	</div>
</div>
<!-- ここまでメイン -->

<!-- フッター -->
	<span><jsp:include page="include_footer.jsp" /></span>
<!-- フッターここまで -->

</body>
</html>















