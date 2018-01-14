<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.internousdev.cherry.dto.ProductDTO, java.util.List" %>

<%
	List<ProductDTO> proList = (List<ProductDTO>) session.getAttribute("proList");	//TopActionから
%>

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
		<% for(ProductDTO pro : proList){ %>
			<li>
				<a href="/cherry/ProDetailAction?id=<%= pro.getDef_id() %>">
					<div><img src="<%= pro.getImage_file_name() %>" alt="画像なし"></div>
					<p class="name"><%= pro.getProduct_name() %></p>
					<p class="price">\<span><%= pro.getPrice() %></span></p>
				</a>
			</li>
		<% }; %>
	</ul>
</div>

<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>