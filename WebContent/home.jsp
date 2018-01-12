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

	<a href="/cherry/GoCartAction">カート</a>

	<a href="/cherry/MyPageAction">マイページ</a>

	<a href="/cherry/LoginAction">ログイン</a>

</header>

<h1>Cherry</h1>

<!-- ここから商品一覧 -->
<ul>
	<% for(ProductDTO pro : proList){ %>
		<li>
			<a href="/cherry/ProDetailAction?id=<%= pro.getDef_id() %>">
				<%= pro.getProduct_name() %>
				<img src="<%= pro.getImage_file_name() %>" alt="画像なし">
			</a>
		</li>
	<% }; %>
</ul>



<!-- フッター -->
<footer></footer>

</body>
</html>