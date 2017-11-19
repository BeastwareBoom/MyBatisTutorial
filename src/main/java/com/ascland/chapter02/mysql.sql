CREATE	DATABASE mybatis CHARSET utf8;

USE mybatis;

DROP TABLE  IF EXISTS t_role;

CREATE TABLE t_role(id INT PRIMARY KEY AUTO_INCREMENT,role_name VARCHAR(20),note VARCHAR(50));

SELECT * FROM t_role;

USE mybatis;

SHOW TABLES;

INSERT INTO t_role(role_name, note) VALUES ('001','002');

CREATE TABLE t_user(id INT PRIMARY KEY AUTO_INCREMENT,user_name VARCHAR(20),user_role_id INT);

#为t_user表user_role_id添加外键约束，t_role表的id
alter table t_user add constraint FK_user_role foreign key (user_role_id)
references t_role (id) on delete restrict on update restrict;

SELECT
  u.id,
  u.user_name    AS userName,
  u.user_role_id AS userRoleId,
  r.id,
  r.role_name    AS roleName,
  r.note
FROM t_user u
  LEFT JOIN t_role r ON u.user_role_id = r.id
WHERE u.id = 1;