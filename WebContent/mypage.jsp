<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/myPage.css">
<title>マイページ画面</title>
</head>
<body>

	<h1 class="title">マイページ</h1>
	<ul class="userList">
		<li class="userItem">姓：<s:property value="dto.getFamilyName()" /></li>
		<li class="userItem">名：<s:property value="dto.getFirstName()" /></li>
		<li class="userItem">ふりがな：<s:property value="dto.getFamilyNameKana"/><s:property value="dto.getFirstNameKana"/>
		<li class="userItem">性別：
			<s:if test="dto.getSex() == 0">
				男性
			</s:if>
			<s:else>
				女性
			</s:else>
		</li>
		<li class="userItem">メールアドレス：<s:property value="dto.getEmail()" /></li>
	</ul>

	<div class="moveWrapper">
		<a href="<s:url action="GoHomeAction" />" class="moveItem"><input type="submit" value="HOMEへ" id="submitArea"></a>
		<a href="<s:url action="PurchaseInfoAction" />" class="moveItem"><input type="submit" value="購入履歴へ" id="submitArea"></a>
	</div>


</body>
</html>

</body>
</html>