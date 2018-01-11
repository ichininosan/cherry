<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/myPage.css">
<title>決済完了画面</title>
</head>
<body>
<div class="header">
</div>

<div class="main">
  <div class="top"><p>購入完了<p></div>
  <div>
      <a href='<s:url action="MyPageAction"/>'>購入履歴</a><span>の確認が可能です。</span>
      <p>Homeへ戻る場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
    </div>
</div>

<div class="footer"></div>

</body>
</html>