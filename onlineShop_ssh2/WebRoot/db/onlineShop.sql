drop database if exists onlineShop;
create database onlineShop;
use onlineShop;

#用户信息表
drop table if exists tb_user;
create table tb_user(
	user_id int(8) auto_increment,
	user_name char(50),
	user_password char(50) NOT NULL,
	user_tel char(11) NOT NULL,
    user_address varchar(1000),
    user_score int(8),
	PRIMARY KEY (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;

#密保问题表
drop table if exists tb_security;
create table tb_security(
	security_id char(10) NOT NULL,
	security_problem1 char(200) ,
	security_answer1 char(200),
	security_problem2 char(200),
	security_answer2 char(200),
    user_id int(8),
	PRIMARY KEY (security_id)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;

#订单表
drop table if exists tb_order;
create table tb_order(
	order_id char(8) NOT NULL,
	order_price char(10) not null,
    order_productNum int not null,
    order_submitTime datetime not null,
    order_businessDate datetime not null,
    order_isPayOff char(1) not null,   	#true:1 false:0
    order_isSale char(1) not null,		#true:1 false:0
    user_id int(8),
    orderProdInfo_id char(10),
    PRIMARY KEY (order_id)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;

#商品信息表
drop table if exists tb_product;
create table tb_product(
	product_id char(10) NOT NULL,
	product_name char(50) NOT NULL,
	product_rightPrice char(50),
	product_originalPrice char(50),
    product_stock int not null,
    product_promotion char(10),
    product_pic varchar(1000),
	PRIMARY KEY (product_id)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;

#订单商品信息表
drop table if exists tb_orderProdInfo;
create table tb_orderProdInfo(
	orderProdInfo_id char(10),
	product_id char(10),
    order_id char(8),
	PRIMARY KEY (orderProdInfo_id)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;


alter table tb_security add constraint foreign key(user_id) references tb_user(user_id);
alter table tb_order add constraint foreign key(user_id) references tb_user(user_id);
alter table tb_order add constraint foreign key(orderProdInfo_id) references tb_orderProdInfo(orderProdInfo_id);
alter table tb_orderProdInfo add constraint foreign key(product_id) references tb_product(product_id);
alter table tb_orderProdInfo add constraint foreign key(order_id) references tb_order(order_id);

insert into tb_user(user_name, user_password,user_tel) values('admin', '123456', '12345678998');