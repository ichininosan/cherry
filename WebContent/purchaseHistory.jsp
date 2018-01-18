<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 金額、日付表示カスタムタグ -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/honma_style.css">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
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
				<%-- <s:if test="message != null">
					<h2><s:property value="message"/></h2>
				</s:if> --%>
			</div>

		<!-- メインのトップここまで -->




		<div>
		<!-- リストに応じたトップメッセージ -->
				<s:if test = "historyList.size() == 0">
					<h2>購入情報はありません</h2>
				</s:if>
				<s:elseif test= "historyList != null && historyList.size() != 0">
					<h2>購入情報は以下になります</h2>
		<!-- リストに応じたトップメッセージここまで -->

<!----------------------ここから------------------------------->
				<s:iterator value = "historyList">
        			<div class="date">
            			<p>注文日</p>
            			<p>
            				<fmt:parseDate var="date" value="${registDate}" pattern="yyyy-MM-dd HH:mm:ss.SS" />
            				<fmt:formatDate value="${date}" pattern="yyyy年M月d日" />
            			</p>
            		</div>

				<div class="main_content">
					<div class="pro_image">
						<img src="<s:property value="productImage"/>">
					</div>

					 <div class="name">
           				 <div class="kana"><s:property value="productNameKana"/></div>
           				 <div class="pro_name">
           				 	商品名: <s:property value="productName"/>
           				 </div>
        			</div>

					<div class="price_count">
            			<div class="price">
            			<span>金額:\</span>
            			<%-- <s:property value="price"/> --%>
            			<fmt:formatNumber value="${price}" />
            			</div>
            			<div class="count">(購入数:  <s:property value="count"/>点)</div>
       				 </div>


					 <div class="comp_info">
           				 <div class="company">発売会社:　<s:property value="releaseCompany"/></div>
           				 <div class="release_date">
           				 	発売日　:　<fmt:parseDate var="date2" value="${releaseDate}" pattern="yyyy-MM-dd HH:mm:ss.SS" />
            						<fmt:formatDate value="${date2}" pattern="yyyy年M月d日" />
           				 </div>
        			</div>

					 <div class="delete">
					 	<!--  履歴個別削除ボタン-->
							<s:form action = "PurchaseHistoryAction">
								<input type="hidden" name="deleteFlg" value="2">
								<input type="hidden" name="id" value="${id}">
								<s:submit id="deletePart" value="×削除" method="deletePart"/>
							</s:form>
						<!--  履歴個別削除ボタンここまで-->
					 </div>
    			</div>

    			<!-- test -->

    			<!-- test -->
    		</s:iterator>
<!----------------------ここまで------------------------------->


			<!-- 全件削除ボタン -->
			<div class="all_delete">
				<s:form action = "PurchaseHistoryAction">
					<input type = "hidden" name="deleteFlg" value= "1">
					<s:submit id="all_delete" value="履歴をすべて削除" method="delete" />
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