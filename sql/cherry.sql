DROP DATABASE IF EXISTS cherry;
CREATE DATABASE cherry CHARACTER SET utf8;

use cherry;


CREATE TABLE user_info(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ID
user_id varchar(16) UNIQUE KEY NOT NULL,-- ユーザーID
password varchar(16) NOT NULL,-- パスワード
family_name varchar(32) NOT NULL, -- 姓
first_name varchar(32) NOT NULL,-- 名
family_name_kana varchar(32),-- 姓かな
first_name_kana varchar(32), -- 名かな
sex tinyint NOT NULL DEFAULT 0, -- 性別 (0:男性 1:女性)
email varchar(32) NOT NULL,-- メールアドレス
status tinyint NOT NULL DEFAULT 0,-- ステータス (0:無効、1:有効)
logined tinyint NOT NULL DEFAULT 0,-- ログインフラグ (0:未ログイン、1:ログイン済み)
regist_date datetime NOT NULL,-- 登録日
update_date datetime-- 更新日
);


CREATE TABLE product_info(
id int PRIMARY KEY NOT NULL AUTO INCREMENT,-- ID
product_id int UNIQUE KEY NOT NULL-- 商品ID
product_name varchar(100) UNIQUE KEY NOT NULL,-- 商品名
product_name_kana varchar(100) UNIQUE KEY NOT NULL,-- 商品名かな
-- 商品詳細
-- カテゴリID
-- 価格
-- 画像ファイルパス
-- 画像ファイル名
-- 発売年月
-- 発売会社
-- ステータス
-- 登録日
-- 更新日
);

CREATE TABLE cart_info();

CREATE TABLE purchase_history_info();

CREATE TABLE destination_info();

CREATE TABLE m_category();
