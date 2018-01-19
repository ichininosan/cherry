<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 金額、日付表示カスタムタグ -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート画面</title>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cart_style.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />
<!-- ヘッダーここまで -->


<!-- ここからメイン -->



<div class="main">

	<h2 class="title">カート</h2><br>

		<s:property value="errMsg"/>
		<!-- カートが殻のときのメッセージ！！ -->
			<s:if test="cartList.isEmpty()">
				<p class="message">カートの中は空です</p>
			</s:if>
		<!-- カートが殻のときのメッセージここまで -->

			<s:else>
				<p class="message">カートには以下の商品が入っています</p>

<!----------------- カート内容ここから --------------------------------------->

			<s:iterator value="cartList">

	<div class="cart_info">
		<!-- 画像 --><div class="pro_img">
						<s:url id="url" action="ProDetailAction"><s:param name="id" value="productId" /></s:url>
							<s:a href="%{url}">
								<img class="pro_img" src='<s:property value="image_file_name"/>' alt="画像なし"/>
							</s:a>
					</div>


		<!-- 商品名 --><div class="pro_name">
							商品名
							<s:url id="url" action="ProDetailAction"><s:param name="id" value="productId" /></s:url>
								<s:a href="%{url}">
									<s:property value="product_name" />
								</s:a>
						</div>

		<!-- ふりがな --><div class="kana">
							ふりがな<s:property value="product_name_kana" />
						</div>

		<!-- 値段 --><div class="price">
							価格<s:property value="price" />円
						</div>

		<!-- 個数 --><div class="count">
							購入個数<s:property value="productCount" />
						</div>

		<!-- 発売会社 --><div class="company">
							発売会社名<s:property value="release_company" />
						</div>

		<!-- 年月日 --><div class="date">
							発売年月日<s:date name="releaseDate" format="yyyy年MM月dd日" />
						</div>
			<!-- 削除 -->
				<s:form action="GoCartAction">
					<div class="delete">
						<a href='<s:url action="CartDeleteAction"><s:param name="productId" value="productId"></s:param></s:url>'>削除</a>
					</div>
				</s:form>
				</div>
			</s:iterator>
		</s:else>
	</div>


<!----------------- カート内容ここまで --------------------------------------->





	<!-- 合計金額を表示 -->
		<div class="totalprice">
			合計金額:
			<s:property value="totalPrice" />
			<span>円</span>
		</div>
	<!-- 合計金額ここまで -->
		<br>



	<!-- 決済にとばす -->
       <s:if test="! cartList.isEmpty()">
		<div class="settlement_btn">
			<a href='<s:url action="PurchaseInfoAction" />'>決済画面へ</a>
		</div>
		</s:if>
	<!-- 決済にとばすここまで -->

</body>
<!-- フッター -->
	<jsp:include page="include_footer.jsp" />
<!-- フッターここまで -->
</html>



















