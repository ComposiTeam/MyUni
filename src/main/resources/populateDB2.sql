USE gradplanner_2;

INSERT INTO Mention(id,description,abreviation,weight) VALUES(1,'Super','SS',1);
INSERT INTO Mention(id,description,abreviation,weight) VALUES(2,'Medium','MS',1);
INSERT INTO Mention(id,description,abreviation,weight) VALUES(3,'Normal','MM',1);
INSERT INTO Mention(id,description,abreviation,weight) VALUES(4,'Low','RS',1);
INSERT INTO Mention(id,description,abreviation,weight) VALUES(5,'Nothing','SI',1);

INSERT INTO Role(id,name) VALUES(1,'SuperAdmin');
INSERT INTO Role(id,name) VALUES(2,'Admin');
INSERT INTO Role(id,name) VALUES(3,'Students');
INSERT INTO Role(id,name) VALUES(4,'Professors');

INSERT INTO User(id,username,password,email) VALUES (1,'test','asd','gutorc@hotmail.com');
INSERT INTO User(id,username,password,email) VALUES (2,'test2','asd','gutorc2@hotmail.com');
INSERT INTO userRole(idUser,idRole) VALUES ( (SELECT id FROM User WHERE username = 'test'),(SELECT id FROM Role WHERE name = 'Students'));
INSERT INTO userRole(idUser,idRole) VALUES ( (SELECT id FROM User WHERE username = 'test2'),(SELECT id FROM Role WHERE name = 'Professors'));


INSERT INTO Discipline(id,code,name,NumberOfCredits) VALUES (1,'1','Usar facebook 1',4);
INSERT INTO Discipline(id,code,name,NumberOfCredits) VALUES (2,'2','Criando o orku',8);
INSERT INTO Discipline(id,code,name,NumberOfCredits) VALUES (3,'3','Foto no insta',12);
INSERT INTO Discipline(id,code,name,NumberOfCredits) VALUES (4,'4','Hashtag onde usar',6);
INSERT INTO Discipline(id,code,name,NumberOfCredits) VALUES (5,'5','Likes como ganhar',2);

INSERT INTO Program(id,maxCredits,maxCreditsSemester,name,numSemesters) VALUES (1,240,38,'Engenharia de Software',10);
INSERT INTO SemesterProgram(id,number,numberCredits) VALUES (1,1,12);
INSERT INTO SemesterProgram(id,number,numberCredits) VALUES (2,2,14);
INSERT INTO SemesterProgram(id,number,numberCredits) VALUES (3,3,6);

INSERT INTO semesterDiscipline(idSemester,idDiscipline) VALUES(1,1);
INSERT INTO semesterDiscipline(idSemester,idDiscipline) VALUES(1,2);
INSERT INTO semesterDiscipline(idSemester,idDiscipline) VALUES(2,3);
INSERT INTO semesterDiscipline(idSemester,idDiscipline) VALUES(2,5);
INSERT INTO semesterDiscipline(idSemester,idDiscipline) VALUES(3,4);

INSERT INTO programSemester(idProgram,idSemesterProgram,semesters_KEY) VALUES(1,1,1);
INSERT INTO programSemester(idProgram,idSemesterProgram,semesters_KEY) VALUES(1,2,2);
INSERT INTO programSemester(idProgram,idSemesterProgram,semesters_KEY) VALUES(1,3,3);

INSERT INTO CourseTime(id,part,year,DTYPE) VALUES (1,1,2010,'Semester');
INSERT INTO CourseTime(id,part,year,DTYPE) VALUES (2,1,2009,'Semester');
INSERT INTO CourseTime(id,part,year,DTYPE) VALUES (3,2,2009,'Semester');


INSERT INTO Course(id,description,discipline_id,semester_id) VALUES (1,'A',1,1);
INSERT INTO Course(id,description,discipline_id,semester_id) VALUES (2,'B',1,2);
INSERT INTO Course(id,description,discipline_id,semester_id) VALUES (3,'C',2,3);
INSERT INTO Course(id,description,discipline_id,semester_id) VALUES (4,'D',3,2);
INSERT INTO Course(id,description,discipline_id,semester_id) VALUES (5,'E',4,1);
INSERT INTO Course(id,description,discipline_id,semester_id) VALUES (6,'A',5,2);


INSERT INTO Person(id,DTYPE,name,mwId,mwPassword,user_id,program_id) VALUES (1,'Student','Testando','11/0030559','japz1217',1,1);
INSERT INTO Transcript(idTranscript,numberOfCompletedSemesters,yearOfAdmission,student_id) VALUES (1,12,2011,1);

INSERT INTO AcademicResult(id,course_id,mention_id,semester_id,transcript_idTranscript) VALUES(1,1,1,1,1);
INSERT INTO AcademicResult(id,course_id,mention_id,semester_id,transcript_idTranscript) VALUES(2,2,2,2,1);
INSERT INTO AcademicResult(id,course_id,mention_id,semester_id,transcript_idTranscript) VALUES(3,3,3,3,1);
INSERT INTO AcademicResult(id,course_id,mention_id,semester_id,transcript_idTranscript) VALUES(4,4,4,2,1);
INSERT INTO AcademicResult(id,course_id,mention_id,semester_id,transcript_idTranscript) VALUES(5,5,4,1,1);
INSERT INTO AcademicResult(id,course_id,mention_id,semester_id,transcript_idTranscript) VALUES(6,6,4,2,1);
