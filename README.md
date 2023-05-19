Technical Assessment

Requirements:
Java 8
Npm
MySQL
Maven

How to Run?

Create a DB and Table with below SQL commands

=============================================================

CREATE database shyftlabs;

use shyftlabs;

CREATE TABLE student (
  student_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  family_name VARCHAR(255) NOT NULL,
  date_of_birth DATE NOT NULL,
  email_address VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE course (
  course_id INT AUTO_INCREMENT PRIMARY KEY,
  course_name VARCHAR(255) NOT NULL
);

CREATE TABLE student_course (
  student_id INT,
  course_id INT,
  score VARCHAR(255) NOT NULL,
  PRIMARY KEY (student_id, course_id),
  FOREIGN KEY (student_id) REFERENCES student(student_id) ON DELETE CASCADE,
  FOREIGN KEY (course_id) REFERENCES course(course_id) ON DELETE CASCADE
);



INSERT INTO student (first_name, family_name, date_of_birth, email_address)
VALUES ('John', 'Doe', '1990-01-01', 'johndoe@example.com');

INSERT INTO student (first_name, family_name, date_of_birth, email_address)
VALUES ('Jane', 'Smith', '1992-05-15', 'janesmith@example.com');

INSERT INTO student (first_name, family_name, date_of_birth, email_address)
VALUES ('Michael', 'Johnson', '1988-09-30', 'michaeljohnson@example.com');

INSERT INTO student (first_name, family_name, date_of_birth, email_address)
VALUES ('Sarah', 'Williams', '1994-07-18', 'sarahwilliams@example.com');

INSERT INTO student (first_name, family_name, date_of_birth, email_address)
VALUES ('David', 'Brown', '1991-03-25', 'davidbrown@example.com');

INSERT INTO student (first_name, family_name, date_of_birth, email_address)
VALUES ('Emily', 'Taylor', '1993-11-12', 'emilytaylor@example.com');


INSERT INTO student (first_name, family_name, date_of_birth, email_address)
VALUES ('as', 'wewe', '1990-01-01', 'mmm@example.com');


INSERT INTO course (course_name) VALUES
  ('Mathematics'),
  ('Science'),
  ('English'),
  ('History'),
  ('Computer Science');



=============================================================

Open the studentcourse project in Eclipse/IntelliJ it should be run in 8080
Open the react-blog project in VSCode
Run the command - npm install
Run the command - npm start - should run in port 3000











