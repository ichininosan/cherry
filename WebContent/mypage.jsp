<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ochiai_style.css">
<title>マイページ画面</title>
</head>
<body>

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />
        <div class="header">
        </div>



        <div class="main">


			<table class="human">
				<caption>ユーザー情報</caption>
				<s:iterator value="myPageList">
					<tr>
						<th class="arror_box">ふりがな</th>
						<td><s:property value="familyNameKana" /><s:property value="firstNameKana" /></td>
					</tr>
					<tr>
						<th class="arror_box">名前</th>
						<td><s:property value="familyName" /> <s:property value="firstName" /></td>
					</tr>
					<tr>
						<th class="arror_box">性別</th>
						<td><s:if test="sex==0">男性</s:if> <s:else>女性</s:else></td>
					</tr>
					<tr>
						<th class="arror_box">メールアドレス</th>
						<td><s:property value="email" /></td>
					</tr>
				</s:iterator>
 			</table>

			<div class="btn">
				<a href="/cherry/PurchaseHistoryAction" type="submit">注文履歴確認</a>
			</div>


	</div>



<!-- フッター -->
<jsp:include page="include_footer.jsp" />

  <div id="footer">
    <div id="pr"></div>
  </div>




</body>
</html>

