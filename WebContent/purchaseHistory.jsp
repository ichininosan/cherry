<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品購入履歴画面</title>

<!--------------------------------------------------------------


1/12

個別削除で全部消したら「購入情報はありません」って出したい！
なんかテーブルもでてくる！


 ----------------------------------------------------------------->
</head>
<body>
<!-- ヘッダー -->
	<div class = "header">
	</div>
<!-- ヘッダーここまで -->

<!-- メイン -->
	<div class = "main">
		<!-- メインのトップ -->
			<div class = "top">
				<p>商品購入履歴です</p>
				<s:if test="message != null">
					<h2><s:property value="message"/></h2>
				</s:if>
			</div>
		<!-- メインのトップここまで -->
		<div>
		<s:if test= "historyList == null">
			<h2>購入情報はありません</h2>
		</s:if>
		<s:elseif test= "historyList != null">
			<h2>購入情報は以下になります</h2>

			<table border = "1">
				<tr>
					<th>商品名</th>
					<th>ふりがな</th>
					<th>商品画像</th>
					<th>値段</th>
					<th>発売会社</th>
					<th>発売年月日</th>
					<th>削除ボタン</th>
				</tr>

				<s:iterator value = "historyList">
					<tr>
						<td><s:property value="productName"/></td>
						<td><s:property value="productNameKana"/></td>
						<td><img src="<s:property value="productImage"/>" style="width: 300px; height: 300px;"></td>
						<td><s:property value="price"/><span>円</span></td>
						<td><s:property value="releaseCompany"/></td>
						<td><s:property value="releaseDate"/></td>
						<td>
							<s:form action = "PurchaseHistoryAction">
								<input type="hidden" name="deleteFlg" value="2">
								<input type="hidden" name="id" value="${id}">
								<s:submit value="削除" method="deletePart"/>
							</s:form>
						</td>
					</tr>

				</s:iterator>
			</table>

			<!-- 削除ボタン -->
				<s:form action = "PurchaseHistoryAction">
					<input type = "hidden" name="deleteFlg" value= "1">
					<s:submit value="履歴をすべて削除" method="delete" />
				</s:form>
			<!-- 削除ボタンここまで -->
		</s:elseif>

		<div class= "back">
			<!-- MyPageに戻る-->
			<a href='<s:url action="MyPageAction" />'>マイページに戻る</a>
		<!-- あとで消す！！！！！ -->
			<a href='<s:url action="PurchaseHistoryAction" />'>テスト用リンク</a>
		</div>

		</div>
	</div>
<!-- メインここまで -->
<!-- フッター -->
	<div class = "footer">
	</div>
<!-- フッターここまで -->

</body>
</html>