<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
<s:property value="pro_detail.product_name"/>の詳細ページ



</title>


	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />


<!-- メインコンテンツ -->

<s:form action="PutProductIntoCartAction">
	<s:hidden name="productId" value="%{pro_detail.product_id}"/>
	<s:property value="pro_detail.product_id"/>

	<s:hidden name="productNameKana" value="%{pro_detail.product_name_kana}"/>
	<s:property value="pro_detail.product_name_kana"/>

	<s:hidden name="productName" value="%{pro_detail.product_name}"/>
	<s:property value="pro_detail.product_name"/>

	<s:hidden name="productDescription" value="%{pro_detail.product_description}"/>
	<s:property value="pro_detail.product_description"/>

	<s:hidden name="price" value="%{pro_detail.price}"/>
	<s:property value="pro_detail.price"/>

	<s:hidden name="imageFileName" value="%{pro_detail.image_file_name}"/>
	<img src='<s:property value="pro_detail.image_file_name"/>'/>

	<s:hidden name="releaseCompany" value="%{pro_detail.release_company}"/>
	<s:property value="pro_detail.release_company"/>

	購入個数:<s:select list="count" name="productCount" value="1" />
	<%-- 	<br><br>
		<s:hidden name="productId" value="%{pro_detail.product_id}" />
		<s:hidden name="duplicationFlg" value="%{duplicationFlg}" />
		<s:if test="duplicationFlg">
		<input type="submit" value="購入個数を変更">
		</s:if>
		<s:else>
		<input type="submit" value="カートに追加">
		</s:else> --%>

	<s:submit value="カートに追加"/>
</s:form>

<!-- フッター -->
<jsp:include page="include_footer.jsp" />


</body>
</html>