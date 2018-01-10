<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>決済確認画面</title>
</head>
<body>

<!-- メイン -->
<div id="main">
	<br>
	<h2 class="title">決済確認</h2>
	<br>

	<s:form action="PurchaseCompleteAction">
		<caption>購入情報は以下になります</caption>
		<s:iterator value=""></s:iterator>
	</s:form>
</div>

</body>
</html>