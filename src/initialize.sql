create database angularjs_restful_service;
use angularjs_restful_service;
create table plans_list(
	id int not null auto_increment, 
	time varchar(20) not null, 
	activity text,
	type varchar(20),
	address varchar(64),
	primary key(id));