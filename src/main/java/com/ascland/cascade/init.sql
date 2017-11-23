#创建teacher、student和course表，teacher和course一对一关系，student和course多对多关系

DROP TABLE IF EXISTS t_teacher;
DROP TABLE IF EXISTS t_course;
DROP TABLE IF EXISTS t_student;
DROP TABLE IF EXISTS t_student_course;

#班级表
CREATE TABLE t_class (
  c_id   INT         NOT NULL AUTO_INCREMENT,
  c_name VARCHAR(20) NOT NULL,
  PRIMARY KEY (c_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

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
  class_id INT         NOT NULL,
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

# 男学生健康表
CREATE TABLE t_male_health (
  mh_id      INT         NOT NULL AUTO_INCREMENT,
  mh_qlx     VARCHAR(20) NOT NULL,
  student_id INT         NOT NULL,
  PRIMARY KEY (mh_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 女学生健康表
CREATE TABLE t_female_health (
  fh_id      INT         NOT NULL AUTO_INCREMENT,
  fh_zg      VARCHAR(20) NOT NULL,
  student_id INT         NOT NULL,
  PRIMARY KEY (fh_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#为male_health表的student_id添加外键约束
ALTER TABLE t_male_health
  ADD CONSTRAINT FK_mh_student_s_id FOREIGN KEY (student_id) REFERENCES t_student (s_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

#为male_health表的student_id添加外键约束
ALTER TABLE t_female_health
  ADD CONSTRAINT FK_fh_student_s_id FOREIGN KEY (student_id) REFERENCES t_student (s_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

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

#为student表的class_id添加外键约束
ALTER TABLE t_student
  ADD CONSTRAINT FK_student_class_c_id FOREIGN KEY (class_id) REFERENCES t_class (c_id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

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

INSERT INTO t_class (c_name) VALUES ('07级22班');


INSERT INTO t_teacher (t_name, t_gender, t_age) VALUES ('陈同富', '男', 36);
INSERT INTO t_teacher (t_name, t_gender, t_age) VALUES ('李洁', '女', 31);
INSERT INTO t_teacher (t_name, t_gender, t_age) VALUES ('张爱华', '女', 32);

INSERT INTO t_student (s_name, s_gender, s_age, class_id) VALUES ('刘宗泽', '男', 26, 1);
INSERT INTO t_student (s_name, s_gender, s_age, class_id) VALUES ('田军', '男', 27, 1);
INSERT INTO t_student (s_name, s_gender, s_age, class_id) VALUES ('崔震', '男', 26, 1);
INSERT INTO t_student (s_name, s_gender, s_age, class_id) VALUES ('邢亚男', '女', 26, 1);
INSERT INTO t_student (s_name, s_gender, s_age, class_id) VALUES ('张虎', '男', 26, 1);

INSERT INTO t_course (c_name, c_desc, teacher_id) VALUES ('数学', '理科最重要的学科', 1);
INSERT INTO t_course (c_name, c_desc, teacher_id) VALUES ('英语', '我最喜欢的学科', 2);
INSERT INTO t_course (c_name, c_desc, teacher_id) VALUES ('语文', '很重要的学科', 3);

INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (1, 1);
INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (1, 2);
INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (1, 3);

INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (2, 1);
INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (2, 2);
INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (2, 3);

INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (3, 1);
INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (3, 2);
INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (3, 3);

INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (4, 1);
INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (4, 2);
INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (4, 3);

INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (5, 1);
INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (5, 2);
INSERT INTO t_student_course (sc_s_id, sc_c_id) VALUES (5, 3);

# 插入健康状况
INSERT INTO t_male_health (mh_qlx, student_id) VALUES ('健康', 1);
INSERT INTO t_male_health (mh_qlx, student_id) VALUES ('健康', 2);
INSERT INTO t_male_health (mh_qlx, student_id) VALUES ('健康', 3);
INSERT INTO t_male_health (mh_qlx, student_id) VALUES ('健康', 5);

INSERT INTO t_female_health (fh_zg, student_id) VALUES ('良好', 4);

# 查询班级对应学生
SELECT
  c.c_id   AS classId,
  c.c_name AS className,

  s.s_id,
  s.s_name,
  s.s_gender,
  s.s_age
FROM t_class c
  LEFT JOIN t_student s ON s.class_id = c.c_id
WHERE c_id = 1;

# 查询课程对应老师，不带 t.t_id as teacherId，否则解析失败
SELECT
  c.c_id   AS courseId,
  c.c_name AS courseName,
  c.c_desc AS courseDesc,
  t.t_id,
  t.t_name,
  t.t_gender,
  t.t_age
FROM t_course c LEFT JOIN t_teacher t ON c.teacher_id = t.t_id
WHERE c.c_id = 1;

# 查询课程对应老师和学生
SELECT
  c.c_id   AS courseId,
  c.c_name AS courseName,
  c.c_desc AS courseDesc,

  t.t_id,
  t.t_name,
  t.t_gender,
  t.t_age,

  s.s_id,
  s.s_name,
  s.s_gender,
  s.s_age,
  s.class_id
FROM t_course c
  LEFT JOIN t_teacher t ON c.teacher_id = t.t_id
  LEFT JOIN t_student_course sc ON sc.sc_c_id = c.c_id
  LEFT JOIN t_student s ON s.s_id = sc.sc_s_id
WHERE c.c_id = 1;