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
	<br>
	<h2 class="title">カート</h2><br>

<div class="main">
		<s:property value="errMsg"/>
		<s:if test="! cartList.isEmpty()">
			<p class="message">カートの中には以下の商品が入っています。</p>


<!----------------- カート内容ここから --------------------------------------->

			<s:iterator value="cartList">
				<s:form action="GoCartAction">
<div class="cart_info">
		<!-- 画像 --><div class="pro_img">
							<img class="pro_img" src='<s:property value="image_file_name"/>' alt="画像なし"/>
						</div>

		<!-- 商品名 --><div class="pro_name">
							商品名<s:property value="product_name" />
						</div>

		<!-- ふりがな --><div class="kana">
							ふりがな<s:property value="product_name_kana" />
						</div>

		<!-- 値段 --><div class="price">
							値段<s:property value="price" />円
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

		<!-- 削除 --><div class="delete">
							<a href='<s:url action="CartDeleteAction"><s:param name="productId" value="productId"></s:param></s:url>'>削除</a>
						</div>
</div>
				</s:form>
			</s:iterator>
		</s:if>

<!----------------- カート内容ここまで --------------------------------------->


		<!-- カートが殻のときのメッセージ！！ -->
			<s:else>
				<p class="message">カートの中は空です</p>
			</s:else>
		<!-- カートが殻のときのメッセージここまで -->
	</div>


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



















