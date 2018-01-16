<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title><s:property value="pro_detail.product_name"/>の詳細ページ</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
</head>

<body class="pro_detail">

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />



	<s:hidden name="productId" value="%{pro_detail.product_id}"/>
	<s:hidden name="imageFileName" value="%{pro_detail.image_file_name}"/>
	<s:hidden name="productNameKana" value="%{pro_detail.product_name_kana}"/>
	<s:hidden name="productName" value="%{pro_detail.product_name}"/>
	<s:hidden name="productDescription" value="%{pro_detail.product_description}"/>
	<s:hidden name="price" value="%{pro_detail.price}"/>
	<s:hidden name="releaseCompany" value="%{pro_detail.release_company}"/>

<s:form action="PutProductIntoCartAction">
<s:if test="pro_detail.stock == 0">
		<h3>在庫がありません</h3>
</s:if>
<s:else>
	<p class="no_need"><s:property value="pro_detail.product_id" /></p>

	<img src='<s:property value="pro_detail.image_file_name"/>'/>

	<%-- <p class="name_kana"><s:property value="pro_detail.product_name_kana"/></p> --%>
	<p class="name"><s:property value="pro_detail.product_name"/></p>

	<p class="price"><span>\</span><s:property value="pro_detail.price"/></p>

<table>

	<tr>
		<th>
			出品者から
		</th>
		<td>
			<s:property value="pro_detail.product_description"/>
		</td>
	</tr>
	<tr>
		<th>
			出品者
		</th>
		<td>
			<s:property value="pro_detail.release_company"/>
		</td>
	</tr>
</table>
	<p class="cart_before"></p>
		購入個数:<s:select list="count" name="count" value="1" />
		<s:hidden name="duplicationFlg" value="%{duplicationFlg}" />
		<s:if test="duplicationFlg">
			<input type="submit" value="購入個数を変更">
		</s:if>
		<s:else>
			<input type="submit" value="カートに追加">
		</s:else>
</s:else>
</s:form>
<a class="return" href="/cherry/TopAction">戻る<i class="material-icons">&#xE315;</i></a>

<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>