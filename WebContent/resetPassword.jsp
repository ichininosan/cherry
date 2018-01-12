<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>パスワード再設定画面</title>
	<style type="text/css">
		/* ========TAG LAYOUT======== */
		body {
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana, Helvetica, sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
		}

		table {
			text-align:center;
			margin:0 auto;
		}

		/* ========ID LAYOUT======== */
		#top {
			width:780px;
			margin:30px auto;
			border:1px solid #333;
		}

		#header {
			width: 100%;
			height: 80px;
			background-color: black;
		}

		#main {
			width: 100%;
			height: 500px;
			text-align: center;
		}

		#footer {
			width: 100%;
			height: 80px;
			background-color: black;
			clear: both;
		}
	</style>
</head>
<body>
	<div id="header">
		<div id="top">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>ResetPassword</p>
		</div>
		<div>
			<table>
			<s:form action="ResetPasswordConfirmAction">

				<!-- ここから入力エラーメッセージ表示 -->
				<h5>
					<s:iterator value="errMsgList">
						<s:property/>
					</s:iterator>
				</h5>
				<!-- ここまで入力エラーメッセージ表示 -->

				<tr>
					<td>
						<label>ログインID:</label>
					</td>
					<td>
						<input type="text" name="userId" value="" >
					</td>
				</tr>
				<tr>
					<td>
						<label>パスワード:</label>
					</td>
					<td>
						<input type="password" name="password" value="">
					</td>
				</tr>
				<tr>
					<td>
						<label>再確認パスワード:</label>
					</td>
					<td>
						<input type="password" name="passwordc" value="">
					</td>
				</tr>
				<s:submit value="登録" />
			</s:form>
			</table>
			<div>
				<span>前画面に戻る場合は</span><a href='<s:url action="LoginAction" />'>こちら</a>
			</div>
		</div>
	</div>
		<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>