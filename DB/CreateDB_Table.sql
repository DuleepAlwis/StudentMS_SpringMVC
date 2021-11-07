USE studentms_mvc_db;
SHOW TABLES;

CREATE TABLE IF NOT EXISTS USER(
	
	id INT PRIMARY KEY,
	NAME VARCHAR(255),
	email VARCHAR(255),
	contact_number VARCHAR(255),
	PASSWORD VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Student(
	
	id INT PRIMARY KEY,
	name VARCHAR(255),
	age INT,
	dob DATE,
	gender VARCHAR(7),
	city VARCHAR(255),
	district VARCHAR(255),
	address VARCHAR(255),
	contact VARCHAR(255),
	email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Tutor(

id INT,
NAME VARCHAR(255),
age INT,
dob DATE,
gender VARCHAR(7),
city VARCHAR(255),
district VARCHAR(255),
address VARCHAR(255),
CONSTRAINT FK_USER FOREIGN KEY (id) REFERENCES USER(id)
);

CREATE TABLE IF NOT EXISTS classroom(
	
	id INT PRIMARY KEY ,
	CODE VARCHAR(255),
	location VARCHAR(255),
	capacity int
	
);

CREATE TABLE IF NOT EXISTS class_room_incharge(
	classrid INT,
	tutorid INT,
	Start DATE,
	END DATE,
	PRIMARY KEY(classrid,tutorid),
	CONSTRAINT FK_classroom_inc FOREIGN KEY (classrid) REFERENCES classroom(id),
	CONSTRAINT FK_tutor_inc FOREIGN KEY (tutorid) REFERENCES Tutor(id)
);

CREATE TABLE IF NOT EXISTS class_room_student(

classrid INT,
studentid INT,
YEAR DATE,
PRIMARY KEY(classrid,studentid),
CONSTRAINT FK_classr_cst FOREIGN KEY (classrid) REFERENCES classroom(id),
 CONSTRAINT FK_student_cst FOREIGN KEY (studentid) REFERENCES student(id)
 );
 
 CREATE TABLE IF NOT EXISTS Subject(
 
 id INT,
 CODE VARCHAR(255),
 NAME VARCHAR(255),
 
 PRIMARY KEY(id)
 );
 
 CREATE TABLE IF NOT EXISTS St_subject(
 	
 	studentid INT,
 	subjectid INT,
 	enrolled DATE,
 	marks INT,
 	attempt INT,
 	PRIMARY KEY(studentid,subjectid),
 	CONSTRAINT FK_student_SST FOREIGN KEY (studentid) REFERENCES Student(id),
 	CONSTRAINT FK_subject_SST FOREIGN KEY (subjectid) REFERENCES Subject(id)
 );
 
 CREATE TABLE IF NOT EXISTS Tutor_sub(
 
 tutorid INT ,
 subjectid INT,
 START DATE,
 END DATE,
 DAY DATE,
 classroom INT,
 TIME TIME,
 
 PRIMARY KEY(tutorid,subjectid,classroom),
 CONSTRAINT FK_tutor_ts FOREIGN KEY(tutorid) REFERENCES Tutor(id),
 CONSTRAINT FK_subject_ts FOREIGN KEY(subjectid) REFERENCES Subject(id),
 CONSTRAINT FK_classroom_ts FOREIGN KEY(classroom) REFERENCES classroom(id)
 );
 
 CREATE TABLE IF NOT EXISTS org(
 
 id INT,
 NAME VARCHAR(255),
 location VARCHAR(255),
 PRIMARY KEY(id)
 )
 
 ALTER TABLE user ADD orgid INT
 ALTER TABLE user ADD CONSTRAINT FK_org_user FOREIGN KEY(orgid) REFERENCES org(id);
 ALTER TABLE user ADD role CHAR(17);