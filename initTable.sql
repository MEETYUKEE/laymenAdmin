/*==============================================================*/
/* Table: users                                        */
/*==============================================================*/
-- 存在即删除 users 表
drop table if exists users;

create table users
(
    id                   bigint not null auto_increment comment 'ID，序列号',
    user_name            varchar(30) not null comment '客户名称',
    password             varchar(255) not null comment '密码',
    status               tinyint not null default 0 comment '状态。 默认 0. 0 -> 有效 1 -> 作废',
    create_date          datetime not null comment '创建时间',
    unique index(`user_name` ),
    primary key (id)
);
alter table users comment '用户表';
-- 初始化用户表数据。 注： $2a$10$zWrHNYjiJu7tCQ.HQRq8TexE8VxAxHBL.wt/pJWgedATQzVwgvtau 是加密后的密码。 加密前密码： 123456
INSERT INTO users (id, user_name, password, status, create_date) values (1, "admin", "$2a$10$zWrHNYjiJu7tCQ.HQRq8TexE8VxAxHBL.wt/pJWgedATQzVwgvtau", 0, "2020-11-10 00:00:00");
INSERT INTO users (id, user_name, password, status, create_date) values (2, "user", "$2a$10$zWrHNYjiJu7tCQ.HQRq8TexE8VxAxHBL.wt/pJWgedATQzVwgvtau", 0, "2020-11-10 00:00:00");

/*==============================================================*/
/* Table: roles                                        */
/*==============================================================*/
-- 存在即删除 roles 表
drop table if exists roles;
create table roles
(
    id                   bigint not null auto_increment comment 'ID，序列号',
    role_name            varchar(255) not null comment '角色名称',
    role_alias            varchar(255) not null comment '角色别名',
    create_date          datetime not null comment '创建时间',
    primary key (id)
);
alter table roles comment '角色表';
INSERT INTO roles (id, role_name, role_alias, create_date) values (1, "admin", "管理员", "2020-11-10 00:00:00");
INSERT INTO roles (id, role_name, role_alias, create_date) values (2, "ordinary", "普通客户", "2020-11-10 00:00:00");

/*==============================================================*/
/* Table: permission                                        */
/*==============================================================*/
-- 存在即删除 permission 表
drop table if exists permission;
create table permission
(
    id                   bigint not null auto_increment comment 'ID，序列号',
    permission_name      varchar(255) not null comment '权限名称。',
    permission_alias     varchar(255) not null comment '权限别名。',
    description          varchar(255) not null comment '描述。',
    create_date          datetime not null comment '创建时间',
    primary key (id)
);
alter table permission comment '权限表';
INSERT INTO permission (id, permission_name, permission_alias, description, create_date) values (1, "ROLE_admin", "所有接口权限", "所有需要认证的接口都需要加该权限","2020-11-10 00:00:00");
INSERT INTO permission (id, permission_name, permission_alias, description, create_date) values (2, "ROLE_user", "普通客户权限", "所有需要认证的接口都需要加该权限","2020-11-10 00:00:00");


/*==============================================================*/
/* Table: users_roles                                        */
/*==============================================================*/
-- 存在即删除 users_roles 表
drop table if exists users_roles;
create table users_roles
(
    users_id             bigint not null comment '客户ID',
    roles_id             bigint not null comment '角色ID',
    unique index(`users_id` ,`roles_id`)
);
alter table users_roles comment '用户-角色关联表';
INSERT INTO users_roles (users_id, roles_id) values (1, 1);
INSERT INTO users_roles (users_id, roles_id) values (2, 2);

/*==============================================================*/
/* Table: roles_permission                                        */
/*==============================================================*/
-- 存在即删除 roles_permission 表
drop table if exists roles_permission;
create table roles_permission
(
    roles_id             bigint not null comment '角色ID',
    permission_id             bigint not null comment '权限ID',
    unique index(`roles_id` ,`permission_id`)
);
alter table roles_permission comment '角色-权限关联表';
INSERT INTO roles_permission (roles_id, permission_id) values (1, 1);
INSERT INTO roles_permission (roles_id, permission_id) values (2, 2);
