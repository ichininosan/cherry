<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/honma_style.css">
<title>注文履歴</title>
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />
<!-- ヘッダーここまで -->

<!-- メイン -->
	<div class = "main">
		<!-- メインのトップ -->
			<div class = "top">
				<p class="title">注文履歴</p>
				<s:if test="message != null">
					<h2><s:property value="message"/></h2>
				</s:if>
			</div>
		<!-- メインのトップここまで -->




		<div>
		<!-- リストに応じたトップメッセージ -->
				<s:if test = "historyList.size() == 0">
					<h2>購入情報はありません</h2>
					<img src="../img/signboard.png">
					<img src="../img/signboard.png" alt="看板">
				</s:if>
				<s:elseif test= "historyList != null && historyList.size() != 0">
					<h2>購入情報は以下になります</h2>
					<img src="../img/signboard.png">
		<!-- リストに応じたトップメッセージここまで -->





			<table border = "1">
				<tr>
					<th>商品名</th>
					<th>ふりがな</th>
					<th>商品画像</th>
					<th>値段</th>
					<th>個数</th>
					<th>発売会社</th>
					<th>発売年月日</th>
					<th>注文日</th>
					<th>削除ボタン</th>
				</tr>

				<s:iterator value = "historyList">
					<tr>
						<td><s:property value="productName"/></td>
						<td><s:property value="productNameKana"/></td>
						<td><img src="<s:property value="productImage"/>""></td>
						<td><s:property value="price"/><span>円</span></td>
						<td><s:property value="count"/><span>個</span></td>
						<td><s:property value="releaseCompany"/></td>
						<td><s:property value="releaseDate"/></td>
						<td><s:property value="registDate"/></td>
						<td>
					<!--  履歴個別削除ボタン-->
							<s:form action = "PurchaseHistoryAction">
								<input type="hidden" name="deleteFlg" value="2">
								<input type="hidden" name="id" value="${id}">
								<s:submit value="削除" method="deletePart"/>
							</s:form>
					<!--  履歴個別削除ボタンここまで-->
						</td>
					</tr>
				</s:iterator>
			</table>


			<!-- 全件削除ボタン -->
			<div class="all_delete">
				<s:form action = "PurchaseHistoryAction">
					<input type = "hidden" name="deleteFlg" value= "1">
					<s:submit value="履歴をすべて削除" method="delete" />
				</s:form>
			</div>
			<!-- 全件削除ボタンここまで -->
		</s:elseif>


<!-- ページリンク -->
		<div class= "back">
			<!-- MyPageに戻る-->
				<a href='<s:url action="MyPageAction" />'>マイページに戻る</a>
		</div>
		<%-- <!-- あとで消す！！！！！ -->
			<a href='<s:url action="PurchaseHistoryAction" />'>テスト用リンク</a>
		 --%>

<!-- ページリンクここまで -->

		</div>
	</div>
<!-- メインここまで -->
<!-- フッター -->
	<span><jsp:include page="include_footer.jsp" /></span>
<!-- フッターここまで -->

</body>
</html>