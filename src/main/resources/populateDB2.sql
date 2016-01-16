USE gradplanner_2;

INSERT INTO Role(name) VALUES('Students');
INSERT INTO Role(name) VALUES('Professors');
INSERT INTO User(username,password,email) VALUES ('test','asd','gutorc@hotmail.com');
INSERT INTO User(username,password,email) VALUES ('test2','asd','gutorc2@hotmail.com');
INSERT INTO userRole(idUser,idRole) VALUES ( (SELECT id FROM User WHERE username = 'gutorc'),(SELECT id FROM Role WHERE name = 'Students'));
INSERT INTO userRole(idUser,idRole) VALUES ( (SELECT id FROM User WHERE username = 'gutorc2'),(SELECT id FROM Role WHERE name = 'Professors'));
