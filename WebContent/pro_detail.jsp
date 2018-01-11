<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.internousdev.cherry.dto.ProductDTO" %>

<%
	ProductDTO pro = (ProductDTO) session.getAttribute("pro_detail");	//ProDetailActionから
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= pro.getProduct_name() %>の詳細ページ</title>
</head>
<body>
<%= pro.getProduct_name_kana() %>
<%= pro.getProduct_name() %>
<%= pro.getProduct_description() %>
<%= pro.getPrice() %>
<img src="<%= pro.getImage_file_name() %>">
<%= pro.getRelease_company() %>

<p><a href="/cherry/Cart">カートへ</a></p>

</body>
</html>