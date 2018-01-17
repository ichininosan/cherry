<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/onai_style.css">

<title>決済確認画面</title>
</head>
<body>

<!-- ここからヘッダー -->
	<jsp:include page="include_header.jsp" />
<!-- ヘッダーここまで -->

<!-- ここからメイン -->
<div id="main">
	<br>
	<h2 class="title">決済確認</h2>
	<br>

	<s:form action="PurchaseCompleteAction">
		<table>
		<caption>購入情報は以下になります</caption>
		<s:iterator value="cartInfoDTOList">
			<thead>
				<tr>
					<th></th>
					<th>商品名</th>
					<th>ふりがな</th>
					<th>値段</th>
					<th>購入個数</th>
					<th>発売会社名</th>
					<th>発売年月日</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<!-- <td>ここに商品画像挿入</td> -->
					<td><s:property value="productName"/></td>
					<td><s:property value="productNameKana"/></td>
					<td><s:property value="price"/>円</td>
					<td><s:property value="count"/></td>
					<td><s:property value="releaseCompany"/></td>
					<td><s:date name="releaseDate" format="yyyy年MM月dd日"/></td>
				</tr>
			</tbody>
		</s:iterator>
		</table>
		<br>
		<br>
		<div class="totalprice">
			合計金額:<s:property value="totalPrice"/><span>円</span>
		</div>
		<br>

		<!-- 宛先情報 -->
		<s:iterator value="destinationInfoListDTO">
			<div class="box">
				<div class="destination_title">
					<label>
						<input type="radio" name="id" checked="checked"/>宛先情報
					</label>
				</div>
				<div class="destination_box">
					ふりがな:
					<s:property value="familyNameKana"/>
					<s:property value="firstNameKana"/>
					<br>
					名前:
					<s:property value="familyName"/>
					<s:property value="firstName"/>
					<br>
					住所
					<s:property value="userAddress"/>
					<br>
					電話番号
					<s:property value="telNumber"/>
					<br>
					メールアドレス
					<s:property value="email"/>
					<br>
				</div>
			</div>
		</s:iterator>

		<div class="box_2">
			<div class="btn_1">
				<input type="button" value="宛先情報の新規登録"
				onclick="location.href='<s:url action="GoDestinationRegisterAction" />'">
			</div>
			<div class="btn_2">
				<button type="submit">完了</button>
			</div>
		</div>
	</s:form>
</div>
<br>
<br>

<!-- ページリンク -->
		<div class= "back">
			<a href='<s:url action="GoCartAction" />'>カートに戻る</a>
		</div>
<!-- ページリンクここまで -->

<!-- メインここまで -->

<!-- フッター -->
	<span><jsp:include page="include_footer.jsp" /></span>
<!-- フッターここまで -->

</body>
</html>
















