INSERT INTO users(email, firstname, lastname, password, enabled, registerdate)
VALUES ('dude@boob.net', 'Dude', 'Dudeson', 'qwe123', 1, '2014-03-04'), 
	   ('megaman@rockman.no', 'Megaman', 'Thomasson', 'wilysucks', 1, '2153-01-09'),
	   ('donatello@ninjaturtle.jap', 'Donatello', 'Turtlekis', 'Fj3Gj_ty5¤)', 1, '2000-01-01'),
	   ('leonardo@ninjaturtle.jap', 'Leonardo', 'DaVinci', 'ninjatoman', 1, '1990-01-02'),
	   ('mario@peachcastle.derp', 'Super', 'Mario', 'omgshrooms', 1, '1999-12-03');

INSERT INTO subject(subject_code, subject_name, status, nr_of_tasks, rulestring)
VALUES	('TDAT-1995-12H', 'Datateknikk', 1, 15, ''),
		('2ING-2003-14V', 'Algoritmer og Datastrukturer', 1, 20, '13{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};5{1,2,3,4,5,6,7,8};3{7,8,11}');

INSERT INTO permissions (rolename)
VALUES	('ROLE_ADMIN'),
		('ROLE_STUDASS'),
		('ROLE_TEACHER'),
		('ROLE_USER');

INSERT INTO room (room_code, tablecount, picturelink, description)
VALUES	('KA-BR233', 9, '/res/labb1.bmp', 'Labben i 2.Etasje?'),
		('KA-KE101', 5, '/res/kake.jpg', 'Skolekjøkkenet');

INSERT INTO user_subject (email, subject_code, rolename)
VALUES	('megaman@rockman.no', '2ING-2003-14V', 'ROLE_USER'),
		('donatello@ninjaturtle.jap', '2ING-2003-14V', 'ROLE_USER'),
		('megaman@rockman.no', 'TDAT-1995-12H', 'ROLE_STUDASS'),
		('mario@peachcastle.derp', 'TDAT-1995-12H', 'ROLE_USER'),
		('dude@boob.net', 'TDAT-1995-12H', 'ROLE_ADMIN'),
		('leonardo@ninjaturtle.jap', 'TDAT-1995-12H', 'ROLE_TEACHER'),
		('leonardo@ninjaturtle.jap', '2ING-2003-14V', 'ROLE_TEACHER');

INSERT INTO approved_tasks (email, subject_code, task_nr, approved_date, approved_by)
VALUES	('megaman@rockman.no', '2ING-2003-14V', 1, '2014-03-11', 'leonardo@ninjaturtle.jap'),
		('megaman@rockman.no', '2ING-2003-14V', 2, '2014-03-11', 'leonardo@ninjaturtle.jap'),
		('megaman@rockman.no', '2ING-2003-14V', 4, '2014-03-11', 'leonardo@ninjaturtle.jap'),
		('megaman@rockman.no', '2ING-2003-14V', 6, '2014-03-11', 'leonardo@ninjaturtle.jap'),
		('megaman@rockman.no', 'TDAT-1995-12H', 9, '2014-03-11', 'leonardo@ninjaturtle.jap'),
		('mario@peachcastle.derp', 'TDAT-1995-12H', 4 ,'2013-05-06', 'megaman@rockman.no'),
		('mario@peachcastle.derp', 'TDAT-1995-12H', 6 ,'2013-05-07', 'megaman@rockman.no'),
		('mario@peachcastle.derp', 'TDAT-1995-12H', 7 ,'2013-05-08', 'megaman@rockman.no');

INSERT INTO queue (queue_id, subject_code, comment, status, location, `timestamp`)
VALUES	(1, '2ING-2003-14V', 'Trenger hjelp', 'Venter', 'Bord 1, rom skvett', '1960-01-01 16:10:11');

INSERT INTO queue_group (queue_id, email, task_nr)
VALUES	(1, 'megaman@rockman.no', 10),
		(1, 'donatello@ninjaturtle.jap', 10);