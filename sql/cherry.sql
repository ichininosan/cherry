DROP DATABASE IF EXISTS cherry;
CREATE DATABASE cherry CHARACTER SET utf8;

use cherry;

-- -----------↓会員情報テーブル↓----------------------------
CREATE TABLE user_info(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ID
user_id varchar(16) UNIQUE KEY NOT NULL,-- ユーザーID
password varchar(16) NOT NULL,-- パスワード
family_name varchar(32) NOT NULL, -- 姓
first_name varchar(32) NOT NULL,-- 名
family_name_kana varchar(32) NOT NULL,-- 姓かな
first_name_kana varchar(32) NOT NULL, -- 名かな
sex tinyint NOT NULL DEFAULT 0, -- 性別 (0:男性 1:女性)
email varchar(32) NOT NULL,-- メールアドレス
status tinyint NOT NULL DEFAULT 0,-- ステータス (0:無効、1:有効)
logined tinyint NOT NULL DEFAULT 0,-- ログインフラグ (0:未ログイン、1:ログイン済み)
regist_date datetime NOT NULL,-- 登録日
update_date datetime-- 更新日
);


-- -----------↓カテゴリマスタテーブル↓----------------------------
CREATE TABLE m_category(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT, -- ID
category_id int NOT NULL UNIQUE KEY, -- カテゴリID
category_name varchar(20) NOT NULL UNIQUE KEY, -- カテゴリ名
category_description varchar(100), -- カテゴリ詳細
insert_date datetime NOT NULL, -- 登録日
update_date datetime-- 更新日
);



-- -----------↓商品情報テーブル↓----------------------------
CREATE TABLE product_info(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ID
product_id int UNIQUE KEY NOT NULL,-- 商品ID
product_name varchar(100) UNIQUE KEY NOT NULL,-- 商品名
product_name_kana varchar(100) UNIQUE KEY NOT NULL,-- 商品名かな
product_description varchar(255) NOT NULL,-- 商品詳細
category_id int NOT NULL,-- カテゴリID
price int ,-- 価格
image_file_path varchar(100),-- 画像ファイルパス
image_file_name varchar(50),-- 画像ファイル名
release_date datetime NOT NULL, -- 発売年月
release_company varchar(50), -- 発売会社
status tinyint NOT NULL DEFAULT 0,-- ステータス(0:無効、1:有効)
regist_date datetime NOT NULL,-- 登録日
update_date datetime,-- 更新日
FOREIGN KEY(category_id) REFERENCES m_category(category_id) ON UPDATE CASCADE
);


-- -----------↓カート情報テーブル↓----------------------------
CREATE TABLE cart_info(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ID
user_id varchar(16) NOT NULL,-- ユーザーID
temp_user_id varchar(128) UNIQUE KEY,-- 仮ユーザーID
product_id int NOT NULL ,-- 商品ID
product_count int NOT NULL,-- 個数
price int NOT NULL,-- 金額
regist_date datetime NOT NULL,-- 登録日
update_date datetime,-- 更新日
FOREIGN KEY(user_id) REFERENCES user_info(user_id) ON UPDATE CASCADE,
FOREIGN KEY(product_id) REFERENCES product_info(product_id) ON UPDATE CASCADE
);



-- -----------↓購入履歴情報テーブル↓----------------------------
CREATE TABLE purchase_history_info(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ID
user_id varchar(16) NOT NULL ,-- ユーザーID
product_id int NOT NULL ,-- 商品ID
product_count int NOT NULL ,-- 個数
price int NOT NULL, -- 金額
regist_date datetime NOT NULL,-- 登録日
update_date datetime,-- 更新日
FOREIGN KEY(user_id) REFERENCES user_info(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(product_id) REFERENCES product_info(product_id) ON UPDATE CASCADE
);


-- -----------↓宛先情報テーブル↓----------------------------
CREATE TABLE destination_info(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ID
user_id varchar(16) NOT NULL UNIQUE KEY,-- ユーザーID
family_name varchar(32) NOT NULL,-- 姓
first_name varchar(32) NOT NULL,-- 名
family_name_kana varchar(32) NOT NULL,-- 姓かな
first_name_kana varchar(32) NOT NULL,-- 名かな
email varchar(32) NOT NULL,-- メールアドレス
tell_number varchar(13) NOT NULL,-- 電話番号
user_address varchar(50) NOT NULL,-- 住所
regist_date datetime NOT NULL,-- 登録日
update_date datetime-- 更新日
);




-- ---------------↓INSERT文↓----------------------------

INSERT INTO m_category(-- カテゴリーマスタテーブルへ
	id,-- ID
	category_id,-- カテゴリID
	category_name,-- カテゴリ名
	category_description,-- カテゴリ詳細
	insert_date,-- 登録日
	update_date-- 更新日
)VALUES(
	1,
	4,
	"ゲーム",
	"ゲームに関するカテゴリー",
	NOW(),
	NOW()
	);



INSERT INTO product_info(-- 商品情報テーブルへ
	id, -- ID
	product_id,-- 商品ID
    product_name,-- 商品名
    product_name_kana,-- 商品名かな
    product_description,-- 商品詳細
    category_id,-- カテゴリID
    price,-- 値段
	image_file_path, -- 画像ファイルパス
	image_file_name, -- 画像ファイル名
	release_date,-- 発売年月
	release_company,-- 発売会社
	status,-- ステータス(0:無効、1:有効)
	regist_date,-- 登録日
	update_date-- 更新日
)VALUES(
	1,-- ID
	1,-- 商品ID
	"英雄伝説",-- 商品名
	"えいゆうでんせつ",-- 商品名かな
	"おもしろいゲーム",
	4,
	2000,
	"./image/",
	"test_game.jpeg",
	cast('2017-12-31' as date),
	"ファルファル",
	1,
	NOW(),
	NOW()
	);



















