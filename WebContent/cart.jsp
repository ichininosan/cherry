<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート画面</title>
</head>
<body>

<!-- ここからメイン -->
<div id="main">
	<br>
	<h2 class="title">カート</h2><br>
	<table>
		<s:property value="errMsg"/>
		<s:if test="! cartList.isEmpty()">
			<caption>カートの中には以下の商品が入っています。</caption>
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
								<th></th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td><img src='<s:property value = "imageFileName"/>' alt="商品画像"></td>
								<td><s:property value="productName" /></td>
								<td><s:property value="productNameKana" /></td>
								<td><fmt:formatNumber value="${price}" />円</td>
								<td><s:property value="count" /></td>
								<td><s:property value="releaseCompany" /></td>
								<td><s:date name="releaseDate" format="yyyy年MM月dd日" /></td>
								<td><s:hidden name="deleteProduct" value="%{productId}" />
									<s:submit value="削除" /></td>
							</tr>
						</tbody>
					</s:form>
				</s:iterator>
		</s:if>
		<s:else>
				<tr>
					<td>カートの中は空です</td>
				</tr>
			</s:else>
	</table>
	<br>
		<div class="totalprice">
			合計金額:
			<fmt:formatNumber value="${totalPrice}" />
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
</html>



















