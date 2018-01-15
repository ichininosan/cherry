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
<title>
<s:property value="pro_detail.product_name"/>の詳細ページ


</title>
</head>
<body>

<s:form action="PutProductIntoCartAction">
<s:property value="pro_detail.product_name_kana"/>
<s:property value="pro_detail.product_name"/>
<s:property value="pro_detail.product_description"/>
<s:property value="pro_detail.price"/>
<img src='<s:property value="pro_detail.image_file_name"/>'/>
<s:property value="pro_detail.release_company"/>
<s:submit value="カートに追加"/>
</s:form>

</body>
</html>