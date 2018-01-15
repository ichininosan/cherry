<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.internousdev.cherry.dto.ProductDTO, java.util.List" %>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Cherry</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
</head>

<body class="home">

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />


<!-- メインコンテンツ -->
<div class="top_main clearfix">
	<h1>商品一覧</h1>
	<ul>
		<s:iterator value="#session.proList">
		<li>
			<s:hidden name="def_id" value='<s:property value="def_id"/>' />
			<s:hidden name="id" value='<s:property value="def_id"/>' />
			    <s:url id="url" action="ProDetailAction">

			             </s:url>
			<s:a href="%{url}">
			<div><img src='<s:property value="image_file_name"/>' alt="画像なし"/></div>
			<p class="name"><s:property value="product_name"/></p>
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