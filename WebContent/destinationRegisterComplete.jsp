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

<%-- <script type="text/javascript">
	function autolink(){
		location.href = "PurcahseInfoAction";
	}
	setTimeout("autolink()", 5000);
</script> --%>

<title>購入情報完了画面</title>
</head>
<body>

<!-- ここからヘッダー -->
	<jsp:include page="include_header.jsp" />
<!-- ヘッダーここまで -->

<h2 class="title">宛先情報確認</h2>

<div class="main">
	<h3>宛先登録しました</h3>
	<a href='<s:url action="PurchaseInfoAction" />'>決済画面へ</a>
</div>

<!-- フッター -->
	<span><jsp:include page="include_footer.jsp" /></span>
<!-- フッターここまで -->
</body>
</html>