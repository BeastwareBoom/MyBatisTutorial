CREATE DATABASE mybatis
  CHARSET utf8;

USE mybatis;

DROP TABLE IF EXISTS t_role;

CREATE TABLE t_role (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  role_name VARCHAR(20),
  note      VARCHAR(50)
);

SELECT *
FROM t_role;

USE mybatis;

SHOW TABLES;

INSERT INTO t_role (role_name, note) VALUES ('001', '002');

CREATE TABLE t_user (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  user_name    VARCHAR(20),
  user_role_id INT
);

#为t_user表user_role_id添加外键约束，t_role表的id
ALTER TABLE t_user
  ADD CONSTRAINT FK_user_role FOREIGN KEY (user_role_id)
REFERENCES t_role (id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

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