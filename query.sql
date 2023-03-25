create database quizhub;

create table admin(Password varchar(30), ID varchar(30));

create table exam_list(teacher_id int, course_teacher varchar(40), exam_id varchar(10), course_code varchar(10), time varchar(20), title varchar(30), dept varchar(5), session varchar(10), marks varchar(10), question_type int, isOver int);

create table quiz_questions(teacher_id varchar(8), couse_code varchar(10), exam_id varchar(15), question_no varchar(2), question varchar(500), option1 varchar(200), option2 varchar(200), option3 varchar(200), option4 varchar(200), correct_ans varchar(8));

create table result(exam_id varchar(10), exam_name varchar(50), name varchar(50), id varchar(12), dept varchar(5), session varchar(10), marks varchar(5));

create table student(name varchar(20), reg_no varchar(12), password varchar(20), department varchar(5), session varchar(10), age varchar(5), gender varchar(6), address varchar(30), phone varchar(20), email varchar(30));

create table teacher(name varchar(20), id varchar(10), password varchar(20), age varchar(5), department varchar(5), address varchar(20), phone varchar(20), email varchar(30));

insert into student (name, reg_no, password, department, session, age, gender, address, phone, email) values ('Redowanur Rahman', '2019331121', 'passcode', 'CSE', '2019-20', '22', 'Male', '12 Manley Avenue', '269-432-7746', 'eseatter0@answers.com');
insert into student (name, reg_no, password, department, session, age, gender, address, phone, email) values ('Rube Ekless', '5929372268', 'e0SpkneUwO', 'CSE', '2019-20', '23', 'Male', '3 Heath Trail', '399-977-8650', 'rekless1@edublogs.org');
insert into student (name, reg_no, password, department, session, age, gender, address, phone, email) values ('Anders Revelle', '6872877243', 'JKDkSKueB', 'SWE', '2019-20', '22', 'Male', '786 Tony Trail', '654-181-9576', 'arevelle2@google.com.br');
insert into student (name, reg_no, password, department, session, age, gender, address, phone, email) values ('Niki Farington', '8494502395', '3I4axBKsQ5HG', 'SWE', '2019-20', '21', 'Male', '806 Ridge Oak Pass', '508-506-4869', 'nfarington3@gmail.com');
insert into student (name, reg_no, password, department, session, age, gender, address, phone, email) values ('Ileana Bowdidge', '2550684907', 'MLQzw1nigHd', 'EEE', '2019-20', '22', 'Female', '0 Eliot Center', '537-430-1345', 'ibowdidge4@mozilla.com');

insert into teacher (name, id, password, age, department, address, phone, email) values ('Summit Haque', '123456', '987654321', 29, 'CSE', '20424 Waubesa Hill', '899-684-3468', 'fdomenici0@privacy.gov.au');
insert into teacher (name, id, password, age, department, address, phone, email) values ('Filide Camis', '5074640768', 'ccwZ3r5P', 8, 'CSE', '87350 Sauthoff Pass', '362-279-3434', 'fcamis1@youtube.com');
insert into teacher (name, id, password, age, department, address, phone, email) values ('Claudelle Cheesley', '9441131768', 'xbE5wGOtNsc', 35, 'SWE', '9 Orin Hill', '539-371-9061', 'ccheesley2@japanpost.jp');
insert into teacher (name, id, password, age, department, address, phone, email) values ('Tommie Beert', '0336995237', 'bSjckmbGn2', 35, 'SWE', '929 Upham Point', '926-447-4103', 'tbeert3@umich.edu');
insert into teacher (name, id, password, age, department, address, phone, email) values ('Petey Cardall', '4498961978', 'jvFbw2', 32, 'EEE', '11448 Rowland Cross', '140-457-7038', 'pcardall4@ed.gov');
