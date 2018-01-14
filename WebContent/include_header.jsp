<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div class="wrap">
		<a class="logo" href="/TopAction">Cherry</a>

		<ul>
			<li>
				<a href="/cherry/GoCartAction"><i class="material-icons">&#xE8CC;</i>カート</a>
			</li>

			<li>
				<a href="/cherry/MyPageAction"><i class="material-icons">&#xE853;</i>マイページ</a>
			</li>

			<li>
				<a href="/cherry/LoginAction"><i class="material-icons">&#xE879;</i>ログイン</a>
			</li>
		</ul>

		<form action="/cherry/Search" method="post">
			<input type ="search"  placeholder="キーワードで検索する">
			<button type="submit"><i class="material-icons">&#xE8B6;</i></button>
		</form>

	</div>
</header>