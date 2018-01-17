<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cherry</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>

<body class="home">

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />


<!-- メインコンテンツ -->
<div class="top_main clearfix">


		<s:iterator value="msgList">
			<h1>検索キーワード "<s:property />"</h1>
		</s:iterator>
		<s:if test="searchDTOList.size()==0">
			<h1>検索結果がありません。</h1>
		</s:if>
	<ul>
		<s:iterator value="searchDTOList">
		<li>
			<s:url id="url" action="ProDetailAction">
				<s:param name="id" value="productId"/>

			</s:url>

			<s:a href="%{url}">
				<div><img src='<s:property value="imageFileName"/>' alt="画像なし"/></div>
					<p class="name"><s:property value="productName"/></p>
					<p class="price">\<span><s:property value="price"/></span></p>
			</s:a>
		</li>
		</s:iterator>

	</ul>
</div>

<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>