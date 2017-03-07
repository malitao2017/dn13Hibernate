
##############################################################
第一、hibernate基础
##############################################################
1.使用的数据库是mysql默认的：  test
除非特殊注明都是mysql，如oracle使用标记
#drop table if exists t_user;
create table t_user (
t_id int(11) not null auto_increment,
t_login_name varchar(50) default null,
t_password varchar(50) default null,
t_name varchar(50) default null,
primary key(t_id)
)engine=innodb;

select * from t_user;

#测试id的自增形式
#########orcle#########
create sequence user_seq;
create table t_user (
t_id number(11) not null ,
t_login_name varchar(50) default null,
t_password varchar(50) default null,
t_name varchar(50) default null,
primary key(t_id)
);



2.#测试hibernate的映射类型
#drop table if exists t_emp;
create table t_emp(
	t_id int(11) not null auto_increment,
	t_name varchar(50) not null,
	t_salary double(9,2) not null,
	t_hire_date date not null,
	t_last_login timestamp not null,
	t_register char(1) not null,
	t_dept_id int(11) NOT NULL, # many-to-one 增加部门id
primary key(t_id)
)engine=innodb DEFAULT CHARSET=utf8;

##############################################################
# many-to-one 增加部门
##############################################################

#DROP TABLE IF EXISTS t_dept;
CREATE TABLE t_dept (
t_id int(11) NOT NULL AUTO_INCREMENT,
t_name varchar(50) NOT NULL,
t_loc varchar(200) NOT NULL,
PRIMARY KEY (t_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into t_dept(t_name,t_loc) values('r&d','beijing');

##############################################################
# hibernate的一级缓存
##############################################################
DROP TABLE IF EXISTS t_foo;
CREATE TABLE t_foo (
t_id int(11) NOT NULL AUTO_INCREMENT,
t_value varchar(50) NOT NULL,
PRIMARY KEY (t_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

##############################################################
# one-to-many
##############################################################
# DROP TABLE IF EXISTS t_item;
CREATE TABLE t_item (
	t_id int(11) NOT NULL AUTO_INCREMENT,
	t_product_name varchar(50) NOT NULL,
	t_unit_price double(9,2) NOT NULL,
	t_amount int(11) NOT NULL,
	t_order_id int(11) NOT NULL, ##用于关联订单
	PRIMARY KEY (t_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
# DROP TABLE IF EXISTS t_order;
CREATE TABLE t_order (
	t_id int(11) NOT NULL AUTO_INCREMENT,
	t_create_date timestamp NOT NULL,
	PRIMARY KEY (t_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into t_order(t_create_date) values(now());
insert into t_order(t_create_date) values(now());
insert into t_item(t_product_name , t_unit_price , t_amount , t_order_id)
values( 'Struts', 100.90 , 2 , 1);
insert into t_item(t_product_name , t_unit_price , t_amount , t_order_id)
values( 'Hibernate', 200.20 , 3 , 1);
insert into t_item(t_product_name , t_unit_price , t_amount , t_order_id)
values( 'Spring', 500.30 , 4 , 2);
insert into t_item(t_product_name , t_unit_price , t_amount , t_order_id)
values( 'Ajax', 900.10 , 5 , 2);
















