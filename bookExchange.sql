create database bookexchange;

use bookexchange;

/*用户表*/
CREATE TABLE tb_user(
  uid CHAR(32) PRIMARY KEY,/*主键*/
  username VARCHAR(50) NOT NULL,/*用户名*/
  `password` VARCHAR(50) NOT NULL,/*密码*/
  money int not null
);
SELECT * FROM tb_user;

/*分类*/
CREATE TABLE category (
  cid CHAR(32) PRIMARY KEY,/*主键*/
  cname VARCHAR(100) NOT NULL/*分类名称*/
);

INSERT  INTO category(cid,cname) VALUES ('1','JavaSE');
INSERT  INTO category(cid,cname) VALUES ('2','JavaEE');
INSERT  INTO category(cid,cname) VALUES ('3','Javascript');

SELECT * FROM category;

/*图书表*/
CREATE TABLE book (
  bid CHAR(32) PRIMARY KEY,/*主键*/
  bname VARCHAR(100),/*图书名*/
  author VARCHAR(20),/*作者*/
  image VARCHAR(200),/*图片*/
  cid CHAR(32),/*所属分类*/
  FOREIGN KEY (cid) REFERENCES category(cid)/*建立主外键关系*/
);

INSERT  INTO book VALUES ('1','Java编程思想（第4版）','qdmmy6','book_img/9317290-1_l.jpg','1');
INSERT  INTO book VALUES ('2','Java核心技术卷1','qdmmy6','book_img/20285763-1_l.jpg','1');
INSERT  INTO book VALUES ('3','Java就业培训教程','张孝祥','book_img/8758723-1_l.jpg','1');
INSERT  INTO book VALUES ('4','Head First java','（美）塞若','book_img/9265169-1_l.jpg','1');
INSERT  INTO book VALUES ('5','JavaWeb开发详解','孙鑫','book_img/22788412-1_l.jpg','2');
INSERT  INTO book VALUES ('6','Struts2深入详解','孙鑫','book_img/20385925-1_l.jpg','2');
INSERT  INTO book VALUES ('7','精通Hibernate','孙卫琴','book_img/8991366-1_l.jpg','2');
INSERT  INTO book VALUES ('8','精通Spring2.x','陈华雄','book_img/20029394-1_l.jpg','2');
INSERT  INTO book VALUES ('9','Javascript权威指南','（美）弗兰纳根','book_img/22722790-1_l.jpg','3');

SELECT * FROM book;

/*订单表*/
CREATE TABLE orders (
  oid CHAR(32) PRIMARY KEY,/*主键*/
  ordertime DATETIME,/*订单生成时间*/
  state SMALLINT(1),/*订单状态：未付款、已付款但未发货、已发货但未确认收货、收货已结束*/
  uid CHAR(32),/*订单的主人*/
  FOREIGN KEY (uid) REFERENCES tb_user(uid)/*建立主外键关系*/
);

SELECT * FROM orders;