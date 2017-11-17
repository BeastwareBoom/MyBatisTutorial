CREATE	DATABASE mybatis CHARSET utf8;

USE mybatis;

DROP TABLE  IF EXISTS t_role;

CREATE TABLE t_role(id INT PRIMARY KEY AUTO_INCREMENT,role_name VARCHAR(20),note VARCHAR(50));

SELECT * FROM t_role;

USE mybatis;

SHOW TABLES;

INSERT INTO t_role(role_name, note) VALUES ("001","002");