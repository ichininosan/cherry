<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<s:form action="PutProductIntoCartAction">
<%= pro.getProduct_name_kana() %>
<%= pro.getProduct_name() %>
<%= pro.getProduct_description() %>
<%= pro.getPrice() %>
<img src="<%= pro.getImage_file_name() %>">
<%= pro.getRelease_company() %>

	<input type="submit" value="カートに追加">
</s:form>



</body>
</html>