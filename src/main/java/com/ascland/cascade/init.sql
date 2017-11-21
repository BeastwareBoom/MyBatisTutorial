#创建teacher、student和course表，teacher和course一对一关系，student和course多对多关系

DROP TABLE IF EXISTS t_teacher;
DROP TABLE IF EXISTS t_course;
DROP TABLE IF EXISTS t_student;
DROP TABLE IF EXISTS t_student_course;

# 教师表
CREATE TABLE t_teacher (
  t_id     INT         NOT NULL AUTO_INCREMENT,
  t_name   VARCHAR(20) NOT NULL,
  t_gender VARCHAR(2)  NOT NULL,
  t_age    VARCHAR(100),
  PRIMARY KEY (t_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#学生表
CREATE TABLE t_student (
  s_id     INT         NOT NULL AUTO_INCREMENT,
  s_name   VARCHAR(20) NOT NULL,
  s_gender VARCHAR(2)  NOT NULL,
  s_age    INT,
  PRIMARY KEY (s_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 课程表
CREATE TABLE t_course (
  c_id       INT         NOT NULL AUTO_INCREMENT,
  c_name     VARCHAR(20) NOT NULL,
  c_desc     VARCHAR(100),
  teacher_id INT         NOT NULL,
  PRIMARY KEY (c_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 学生课程关系表
CREATE TABLE t_student_course (
  sc_s_id INT NOT NULL,
  sc_c_id INT NOT NULL,
  PRIMARY KEY (sc_s_id, sc_c_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 学生课程关系表另一种写法
# CREATE TABLE t_student_course (
#   sc_s_id INT NOT NULL,
#   sc_c_id INT NOT NULL,
#   KEY FK_student_course_course_c_id(sc_c_id),
#   KEY FK_student_course_student_s_id(sc_s_id),
#   CONSTRAINT FOREIGN KEY (sc_c_id) REFERENCES t_course (c_id),
#   CONSTRAINT FOREIGN KEY (sc_s_id) REFERENCES t_student (s_id)
# )
#   ENGINE = InnoDB
#   DEFAULT CHARSET = utf8;

#为course表的teacher_id添加外键约束
ALTER TABLE t_course
  ADD CONSTRAINT FK_course_teacher_t_id FOREIGN KEY (teacher_id) REFERENCES t_teacher (t_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

#为t_student_course表的sc_c_id添加外键约束
ALTER TABLE t_student_course
  ADD CONSTRAINT FK_student_course_course_c_id FOREIGN KEY (sc_c_id) REFERENCES t_course (c_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

#为t_student_course表的sc_s_id添加外键约束
ALTER TABLE t_student_course
  ADD CONSTRAINT FK_student_course_student_s_id FOREIGN KEY (sc_s_id) REFERENCES t_student (s_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

INSERT INTO t_teacher(t_name, t_gender, t_age) VALUES ('陈同富', '男', 36);
INSERT INTO t_teacher(t_name, t_gender, t_age) VALUES ('李洁', '女', 31);
INSERT INTO t_teacher(t_name, t_gender, t_age) VALUES ('张爱华', '女', 32);

INSERT INTO t_student(s_name, s_gender, s_age) VALUES ('刘宗泽', '男', 26);
INSERT INTO t_student(s_name, s_gender, s_age) VALUES ('田军', '男', 27);
INSERT INTO t_student(s_name, s_gender, s_age) VALUES ('崔震', '男', 26);
INSERT INTO t_student(s_name, s_gender, s_age) VALUES ('邢亚男', '女', 26);
INSERT INTO t_student(s_name, s_gender, s_age) VALUES ('张虎', '男', 26);

INSERT INTO t_course(c_name, c_desc, teacher_id) VALUES ('数学', '理科最重要的学科',1);
INSERT INTO t_course(c_name, c_desc, teacher_id) VALUES ('英语', '我最喜欢的学科',2);
INSERT INTO t_course(c_name, c_desc, teacher_id) VALUES ('语文', '很重要的学科',3);

INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (1,1);
INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (1,2);
INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (1,3);

INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (2,1);
INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (2,2);
INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (2,3);

INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (3,1);
INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (3,2);
INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (3,3);

INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (4,1);
INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (4,2);
INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (4,3);

INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (5,1);
INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (5,2);
INSERT INTO t_student_course(sc_s_id, sc_c_id) VALUES (5,3);

