USE MyUni;

INSERT INTO Role(name) VALUES('Students');
INSERT INTO Role(name) VALUES('Professors');
INSERT INTO User(username,password,email) VALUES ('test','asd','gutorc@hotmail.com');
INSERT INTO User(username,password,email) VALUES ('test2','asd','gutorc2@hotmail.com');
INSERT INTO userRole(idUser,idRole) VALUES ( (SELECT id FROM User WHERE username = 'test'),(SELECT id FROM Role WHERE name = 'Students'));
INSERT INTO userRole(idUser,idRole) VALUES ( (SELECT id FROM User WHERE username = 'test2'),(SELECT id FROM Role WHERE name = 'Professors'));

INSERT INTO Program(id,maxCredits,maxCreditsSemester,name,numSemesters) VALUES (1,240,38,'Engenharia de Software',10);
