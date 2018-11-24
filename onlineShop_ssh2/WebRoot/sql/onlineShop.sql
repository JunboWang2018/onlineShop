drop database if exists onlineShop;
create database onlineShop;
use onlineShop;

#用户信息表
drop table if exists tb_user;
create table tb_user(
	user_id int(8) auto_increment,
	user_name char(50) NOT NULL,
	user_password char(50) NOT NULL,
	user_mail char(50),
    user_realname char(20),
    user_sex char(5),
    user_date date,
	PRIMARY KEY (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;

#订单表
drop table if exists tb_order;
create table tb_order(
	order_id int(8) auto_increment,
	order_prodId int(10),
	order_prodPrice char(10) ,
    order_prodName char(200),
    order_prodPic char(50),
    order_prodNum int ,
    order_submitTime date ,
    order_businessDate date ,
    order_isPayOff char(1),   	#true:1 false:0
    order_isSale char(1) ,		#true:1 false:0
    user_id int(8),
    PRIMARY KEY (order_id)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;

#商品信息表
drop table if exists tb_product;
create table tb_product(
	product_id int(10) auto_increment,
	product_name char(255),
	product_rightPrice char(50),
	product_originalPrice char(50),
    product_stock int not null,
    product_promotion char(10),
    product_type char(20),
    product_pic varchar(500) not null,
    product_detail_pic varchar(1000)not null,
	PRIMARY KEY (product_id)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;

#购物车表
drop table if exists tb_cart;
create table tb_cart(
	cart_id int(8) auto_increment,
    cart_prodId int(10),
    cart_prodName char(200),
	cart_prodPrice char(10) ,
    cart_prodNum int ,
    cart_prodPic char(50),
    user_id int(8),
    PRIMARY KEY (cart_id)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;


insert into tb_product(product_name, product_rightPrice, product_originalPrice, product_stock, product_promotion, product_type, product_pic, product_detail_pic) values('【限时下单减200享6期免息】Huawei华为 P20 Pro 全面屏刘海屏徕卡三摄官方正品智能手机', '3688', '3888',200, '新品首发价', '手机数码', '2_1_1.jpg,2_1_2.jpg,2_1_3.jpg', '2_2_1.jpg,2_2_2.jpg,2_2_3.jpg,2_2_4.jpg,2_2_5.jpg,2_2_6.jpg,2_2_7.jpg,2_2_8.jpg,2_2_9.jpg,2_2_10.jpg,2_2_11.jpg,2_2_12.jpg,2_2_13.jpg,2_2_14.jpg,2_2_15.jpg,2_2_16.jpg,2_2_17.jpg,2_2_18.jpg,2_2_19.jpg,2_2_20.jpg,2_2_21.jpg,2_2_22.jpg,2_2_23.jpg,2_2_24.jpg,2_2_25.jpg,2_2_26.jpg,2_2_27.jpg');
insert into tb_product(product_name, product_rightPrice, product_originalPrice, product_stock, product_promotion, product_type, product_pic, product_detail_pic) values('【新品发售 享3期免息】Huawei华为 nova 3i 全面屏AI四摄逆光美颜大内存官方正品智能学生手机', '1999', '2099',200, '新品首发价', '手机数码', '1_1_1.jpg,1_1_2.jpg,1_1_3.jpg', '1_2_1.jpg,1_2_2.jpg,1_2_3.jpg,1_2_4.jpg,1_2_5.jpg,1_2_6.jpg,1_2_7.jpg,1_2_8.jpg,1_2_9.jpg,1_2_10.jpg,1_2_11.jpg,1_2_12.jpg,1_2_13.jpg,1_2_14.jpg,1_2_15.jpg,1_2_16.jpg,1_2_17.jpg,1_2_18.jpg,1_2_19.jpg,1_2_20.jpg,1_2_21.jpg,1_2_22.jpg');
insert into tb_product(product_name, product_rightPrice, product_originalPrice, product_stock, product_promotion, product_type, product_pic, product_detail_pic) values('【套餐赠好礼】Xiaomi小米 小米8年度旗舰全面屏骁龙845处理器智能拍照手机AI变焦双摄', '2699', '3299',200, '促销价', '手机数码', '3_1_1.jpg,3_1_2.jpg,3_1_3.jpg', '3_2 (1).png,3_2 (1).jpg,3_2 (2).jpg,3_2 (3).jpg,3_2 (4).jpg,3_2 (5).jpg,3_2 (6).jpg,3_2 (7).jpg,3_2 (8).jpg,3_2 (9).jpg,3_2 (10).jpg,3_2 (11).jpg,3_2 (12).jpg,3_2 (13).jpg,3_2 (14).jpg,3_2 (15).jpg');
insert into tb_product(product_name, product_rightPrice, product_originalPrice, product_stock, product_promotion, product_type, product_pic, product_detail_pic) values('【26日128G直降100】Xiaomi小米 小米8SE全面屏拍照游戏智能手机 学生机商务机小米8周年新品 官方旗舰正品', '1799', '1899',1000, '新品首发价', '手机数码', '4_1_1.jpg,4_1_2.jpg,4_1_3.jpg', '4_2 (1).jpg,4_2 (2).jpg,4_2 (3).jpg,4_2 (4).jpg,4_2 (5).jpg,4_2 (6).jpg,4_2 (7).jpg,4_2 (8).jpg,4_2 (9).jpg,4_2 (10).jpg');
insert into tb_product(product_name, product_rightPrice, product_originalPrice, product_stock, product_promotion, product_type, product_pic, product_detail_pic) values('【享6期免息赠运动耳机】Huawei华为 Mate 10 全网通徕卡双镜头旗舰芯片大内存官方正品智能手机', '3399', '3499',252, '促销价', '手机数码', '5_1_1.jpg,5_1_2.jpg,5_1_3.jpg', '5_2 (1).jpg,5_2 (2).jpg,5_2 (3).jpg,5_2 (4).jpg,5_2 (5).jpg,5_2 (6).jpg,5_2 (7).jpg,5_2 (8).jpg,5_2 (9).jpg,5_2 (10).jpg,5_2 (11).jpg');
insert into tb_product(product_name, product_rightPrice, product_originalPrice, product_stock, product_promotion, product_type, product_pic, product_detail_pic) values('【晒单送好礼】Huawei华为 MateBook X Pro MACH-W19笔记本 i5集显', '7899', '7899',541, '新品首发价', '电脑办公', '6_1_1.jpg,6_1_2.jpg,6_1_3.jpg', '6_2 (1).png,6_2 (1).jpg,6_2 (2).jpg,6_2 (3).jpg,6_2 (4).jpg,6_2 (5).jpg,6_2 (6).jpg,6_2 (7).jpg,6_2 (8).jpg,6_2 (9).jpg,6_2 (10).jpg,6_2 (11).jpg,6_2 (12).jpg,6_2 (13).jpg');




