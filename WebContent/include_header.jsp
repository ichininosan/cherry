<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<header>
	<div class="wrap">
		<a class="logo" href="/cherry/TopAction">Cherry</a>

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

		<s:form action="SearchAction">
			<select name="categoryId" class="h_pulldown">
				<option value=1 selected="selected">全てのカテゴリ</option>
				<option value=2 >本</option>
				<option value=3 >家電・パソコン</option>
				<option value=4 >おもちゃ・ゲーム</option>
			</select>
			<s:textfield name="searchWord" class="h_search" />

			<s:submit type="image" src="/cherry/img/search.svg" class="h_button" />


		</s:form>

	</div>
</header>