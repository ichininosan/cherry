<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/onai_style.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
<script type="text/javascript">
	history.forward();
</script>
<title>登録内容確認画面</title>
</head>
<body>
	<jsp:include page="include_header.jsp" />
	<div id="main">
	<br>
		<div class="title">新規ユーザー登録確認</div>
		<br>
		<div class="register_box">
			<div class="member">
				<div class="member_form">
					<s:form action="RegisterUserInfoAction" theme="simple">
						<div class="member-form-title">
							名前:
							<s:property value="familyName" />
							<s:hidden name="familyName" value="%{familyName}" />
							<s:property value="firstName" />
							<s:hidden name="firstName" value="%{firstName}" />
							<br><br>ふりがな:
							<s:property value="familyNameKana" />
							<s:hidden name="familyNameKana" value="%{familyNameKana}" />
							<s:property value="firstNameKana" />
							<s:hidden name="firstNameKana" value="%{firstNameKana}" />
							<br><br> ユーザーID:
							<s:property value="userId" />
							<s:hidden name="userId" value="%{userId}" />
							<br><br> パスワード:
							<s:property value="password" />
							<s:hidden name="password" value="%{password}" />
							<br><br> 性別:
							<s:if test="sex==0">
								男性
							</s:if>
							<s:else>
								女性
							</s:else>
							<s:hidden name="sex" value="%{sex}" />
							<br><br> メールアドレス:
							<s:property value="email" />
							<s:hidden name="email" value="%{email}" />
							<br> <br>
							<div class="member_btn">
								<button type="submit" class="">登録情報完了</button>
							</div>
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