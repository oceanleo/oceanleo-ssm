
set foreign_key_checks=0;

-- 基础字段
alter table role_menu add create_date datetime default null;
alter table role_menu add update_date datetime default null;
alter table role_menu add delete_date datetime default null;
alter table role_menu add create_id varchar(50) default null;
alter table role_menu add update_id varchar(50) default null;
alter table role_menu add delete_id varchar(50) default null;
alter table role_menu add deleted tinyint(1) default 0;
alter table role_menu add version varchar(50) default 1;

drop table if exists 'menu';
create table 'menu' (
  'id' varchar(50) not null,
  'name' varchar(100) default null,
  'code' varchar(100) default null,
  'url' varchar(100) default null,
  'sort' int(5) default null,
  'parent_id' varchar(50) default null,
  'create_date' datetime default null,
  'update_date' datetime default null,
  'delete_date' datetime default null,
  'create_id' varchar(50) default null,
  'update_id' varchar(50) default null,
  'delete_id' varchar(50) default null,
  'deleted' tinyint(1) default null,
  'version' varchar(50) default null,
  primary key ('id')
) engine=innodb default charset=utf8;


drop table if exists 'resource';
create table 'resource' (
  'id' varchar(50) not null,
  'resource_name' varchar(50) default null,
  'resource_type' varchar(50) default null,
  'resource_string' varchar(50) default null,
  'create_date' datetime default null,
  'update_date' datetime default null,
  'delete_date' datetime default null,
  'create_id' varchar(50) default null,
  'update_id' varchar(50) default null,
  'delete_id' varchar(0) default null,
  'deleted' tinyint(1) default null,
  'version' varchar(5) default null,
  primary key ('id')
) engine=innodb default charset=utf8;

drop table if exists 'role';
create table 'role' (
  'id' varchar(50) not null,
  'role_name' varchar(50) default null,
  'role_code' varchar(50) default null,
  'create_date' datetime default null,
  'update_date' datetime default null,
  'delete_date' datetime default null,
  'create_id' varchar(50) default null,
  'update_id' varchar(50) default null,
  'delete_id' varchar(0) default null,
  'deleted' tinyint(1) default null,
  'version' varchar(5) default null,
  primary key ('id')
) engine=innodb default charset=utf8;

drop table if exists 'role_resource';
create table 'role_resource' (
  'id' varchar(50) not null,
  'role_id' varchar(50) default null,
  'resource_id' varchar(50) default null,
  'create_date' datetime default null,
  'update_date' datetime default null,
  'delete_date' datetime default null,
  'create_id' varchar(50) default null,
  'update_id' varchar(50) default null,
  'delete_id' varchar(50) default null,
  'deleted' tinyint(1) default null,
  'version' varchar(5) default null,
  primary key ('id')
) engine=innodb default charset=utf8;

drop table if exists 'user';
create table 'user' (
  'id' varchar(50) not null,
  'user_name' varchar(50) default null,
  'password' varchar(50) default null,
  'age' int(3) default null,
  'sex' tinyint(1) default null,
  'name' varchar(50) default null,
  'status' varchar(50) default null,
  'is_enabled' tinyint(1) default null,
  'create_date' datetime default null,
  'update_date' datetime default null,
  'delete_date' datetime default null,
  'create_id' varchar(50) default null,
  'update_id' varchar(50) default null,
  'delete_id' varchar(50) default null,
  'deleted' tinyint(1) not null,
  'version' varchar(5) default null,
  primary key ('id')
) engine=innodb default charset=utf8;

drop table if exists 'user_role';
create table 'user_role' (
  'id' varchar(50) not null,
  'role_id' varchar(50) default null,
  'user_id' varchar(50) default null,
  'create_date' datetime default null,
  'update_date' datetime default null,
  'delete_date' datetime default null,
  'create_id' varchar(50) default null,
  'update_id' varchar(50) default null,
  'delete_id' varchar(50) default null,
  'deleted' tinyint(1) default null,
  'version' varchar(5) default null,
  primary key ('id')
) engine=innodb default charset=utf8;
