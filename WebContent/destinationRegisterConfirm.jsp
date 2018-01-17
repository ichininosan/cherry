<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入情報確認画面</title>
</head>
<body>

<h2 class="title">宛先情報確認</h2>

<s:form action="DestinationRegisterCompleteAction" theme="simple">

						<div class="member-form-title">
							<br>ふりがな:
							<s:property value="familyNameKana" />
							<s:hidden name="familyNameKana" value="%{familyNameKana}" />
							<s:property value="firstNameKana" />
							<s:hidden name="firstNameKana" value="%{firstNameKana}" />
							<br>名前:
							<s:property value="familyName" />
							<s:hidden name="familyName" value="%{familyName}" />
							<s:property value="firstName" />
							<s:hidden name="firstName" value="%{firstName}" />
							<br>メールアドレス:
							<s:property value="email" />
							<s:hidden name="email" value="%{email}" />
							<br>電話番号:
							<s:property value="telNumber" />
							<s:hidden name="telNumber" value="%{telNumber}" />
							<br>住所:
							<s:property value="userAddress" />
							<s:hidden name="userAddress" value="%{userAddress}" />
							<br>
							<br>
							<div class="member_btn">
								<button type="submit" class="">確定</button>
							</div>
						</div>
					</s:form>

</body>
</html>