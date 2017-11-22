CREATE DATABASE mybatis
  DEFAULT CHARSET utf8;

USE mybatis;

DROP TABLE IF EXISTS t_role;

CREATE TABLE t_role (
  role_id   INT PRIMARY KEY AUTO_INCREMENT,
  role_name VARCHAR(20),
  role_memo VARCHAR(50)
);


CREATE TABLE t_user (
  user_id      INT PRIMARY KEY AUTO_INCREMENT,
  user_name    VARCHAR(20),
  user_role_id INT
);

#为t_user表user_role_id添加外键约束，t_role表的id
ALTER TABLE t_user
  ADD CONSTRAINT FK_user_role FOREIGN KEY (user_role_id)
REFERENCES t_role (role_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

INSERT INTO t_role (role_name, role_memo) VALUES ('管理员', '拥有最高权限');

SELECT
  u.user_id,
  u.user_name,
  u.user_role_id,
  r.role_id,
  r.role_name,
  r.role_memo
FROM t_user u
  LEFT JOIN t_role r ON u.user_role_id = r.role_id
WHERE u.user_id = 1;

# LEFT JOIN 与 LEFT OUTER JOIN 表示相同，只是写法不同