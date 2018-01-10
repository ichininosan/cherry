<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="com.internousdev.cherry.dto.ProductDTO, java.util.List" %>

<%
	List<ProductDTO> proList = (List<ProductDTO>) session.getAttribute("proList");	//TopActionから
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cherry</title>
</head>
<body>

<header>

	<form action="/cherry/Search" method="post">
		<input type ="search"  placeholder="キーワードで検索する">
	</form>

	<a href="/cherry/Cart">カート</a>

	<a href="/cherry/Mypage">マイページ</a>

	<a href="/cherry/Login">ログイン</a>

</header>

<h1>Cherry</h1>

<!-- ここから商品一覧 -->
<ul>
	<% for(ProductDTO pro : proList){ %>
		<li>
			<%= pro.getProduct_name() %>
			<img src="<%= pro.getImage_file_name() %>" alt="画像なし">
		</li>
	<% }; %>
</ul>



<!-- フッター -->
<footer></footer>

</body>
</html>