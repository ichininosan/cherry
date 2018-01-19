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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ochiai_style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />


<!-- メインコンテンツ -->
<div class="main">
		<s:form action="PutProductIntoCartAction">
  			<div class="detail">
			<div class="leftCol">
			    <h1>Product Image</h1>
			    <s:hidden name="imageFileName" value="%{pro_detail.image_file_name}"/>
  		  		<img src='<s:property value="pro_detail.image_file_name"/>'/>
    		</div>

			<div class="rightCol">
			    <h1>Details</h1>
				<s:hidden name="productId" value="%{pro_detail.product_id}"/>
				<s:property value="pro_detail.product_id"/>
				<br>
				<s:hidden name="productNameKana" value="%{pro_detail.product_name_kana}"/>
				<br>
				<s:property value="pro_detail.product_name_kana"/>
				<br>
				<s:hidden name="productName" value="%{pro_detail.product_name}"/>
				<br>
				<s:property value="pro_detail.product_name"/>
				<br>
				<s:hidden name="productDescription" value="%{pro_detail.product_description}"/>
				<br>
				<s:property value="pro_detail.product_description"/>
				<br>
				<s:hidden name="price" value="%{pro_detail.price}"/>
				<br>
				<s:property value="pro_detail.price"/>
			    <br>
				<s:hidden name="releaseCompany" value="%{pro_detail.release_company}"/>
				<br>
				<s:property value="pro_detail.release_company"/>
				<br>
				購入個数:<s:select list="count" name="productCount" value="1" />
				<br>
				<br>
			<%-- 	<br><br>
				<s:hidden name="productId" value="%{pro_detail.product_id}" />
				<s:hidden name="duplicationFlg" value="%{duplicationFlg}" />
				<s:if test="duplicationFlg">
				<input type="submit" value="購入個数を変更">
				</s:if>
				<s:else>
				<input type="submit" value="カートに追加">
				</s:else> --%>
				<br>
				<s:submit value="カートに追加"/>
			</div>
			</div>
		</s:form>
</div>

<!-- フッター -->
<jsp:include page="include_footer.jsp" />


</body>
</html>