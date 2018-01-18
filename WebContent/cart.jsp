<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート画面</title>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />



<!-- ここからメイン -->
<div id="main">
	<br>
	<h2 class="title">カート</h2><br>

		<s:property value="errMsg"/>
		<s:if test="! cartList.isEmpty()">
			<caption>カートの中には以下の商品が入っています。</caption>
			<table>
				<s:iterator value="cartList">
					<s:form action="GoCartAction">

						<thead>
							<tr>
								<th></th>
								<th>商品名</th>
								<th>ふりがな</th>
								<th>値段</th>
								<th>購入個数</th>
								<th>発売会社名</th>
								<th>発売年月日</th>
								<th>購入個数</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td><img src='<s:property value="image_file_name"/>' alt="画像なし"/></td>
								<td><s:property value="product_name" /></td>
								<td><s:property value="product_name_kana" /></td>
								<td><s:property value="price" />円</td>
								<td><s:property value="productCount" /></td>
								<td><s:property value="release_company" /></td>
								<td><s:date name="releaseDate" format="yyyy年MM月dd日" /></td>
								<td><a href='<s:url action="CartDeleteAction"><s:param name="productId" value="productId"></s:param></s:url>'>削除</a></td>
							</tr>
						</tbody>
					</s:form>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
				<tr>
					<td>カートの中は空です</td>
				</tr>
			</s:else>

	<br>
		<div class="totalprice">
			合計金額:
			<s:property value="totalPrice" />
			<span>円</span>
		</div>
		<br>
       <s:if test="! cartList.isEmpty()">
		<div class="settlement_btn">
			<a href='<s:url action="PurchaseInfoAction" />'>決済画面へ</a>
		</div>
		</s:if>
</div>

</body>
<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</html>



















