<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/myPage.css">
<title>マイページ画面</title>
</head>
<body>


        <div class="header">
        </div>

        <div class="main">


			<table border="1">
				<caption>ユーザー情報</caption>
				<s:iterator value="myPageList">
					<tr>
						<td>ふりがな</td>
						<td><s:property value="familyNameKana" /><s:property value="firstNameKana" /></td>
					</tr>
					<tr>
						<td>名前</td>
						<td><s:property value="familyName" /> <s:property value="firstName" /></td>
					</tr>
					<tr>
						<td>性別</td>
						<td><s:if test="sex==0">男性</s:if> <s:else>女性</s:else></td>
					</tr>
					<tr>
						<td>メールアドレス</td>
						<td><s:property value="email" /></td>
					</tr>
				</s:iterator>
			</table>

			<div>
				<button type="submit">注文履歴を確認する</button>
			</div>


	</div>




  <div id="footer">
    <div id="pr"></div>
  </div>




</body>
</html>

