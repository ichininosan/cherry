<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- <body>
	<h3>SUCCESS</h3>
		<s:iterator value="searchDTOList">
		<s:property value="productName"/>
		<s:property value="productNameKana"/>


	</s:iterator>
 --%>

</body>

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

	<h1>
		<s:property value="#session.searchWord"/>
	</h1>
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