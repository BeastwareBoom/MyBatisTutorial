CREATE	DATABASE mybatis CHARSET utf8;

USE mybatis;

DROP TABLE  IF EXISTS t_role;

CREATE TABLE t_role(id INT PRIMARY KEY AUTO_INCREMENT,roleName VARCHAR(20),note VARCHAR(50));