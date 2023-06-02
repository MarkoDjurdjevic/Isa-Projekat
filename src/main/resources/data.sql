INSERT INTO role(id, name) VALUES (1, 'UNREGISTERED_USER');
INSERT INTO role(id, name) VALUES (2, 'REGISTERED_USER');
INSERT INTO role(id, name) VALUES (3, 'SYSTEM_ADMINISTRATOR');
INSERT INTO role(id, name) VALUES (4, 'CENTRE_ADMINISTRATOR');

INSERT INTO gender(id, name) VALUES (1, 'MALE');
INSERT INTO gender(id, name) VALUES (2, 'FEMALE');

INSERT INTO blood_type(id, name) VALUES (1, 'A+');
INSERT INTO blood_type(id, name) VALUES (2, 'A-');
INSERT INTO blood_type(id, name) VALUES (3, 'B+');
INSERT INTO blood_type(id, name) VALUES (4, 'B-');
INSERT INTO blood_type(id, name) VALUES (5, 'AB+');
INSERT INTO blood_type(id, name) VALUES (6, 'AB-');
INSERT INTO blood_type(id, name) VALUES (7, 'O+');
INSERT INTO blood_type(id, name) VALUES (8, 'O-');


--centre
INSERT INTO centre(id, name, adress, description, avg_grade) VALUES (nextval('centre_seq_gen'), 'center1', 'address1', 'descr', 5.0);
INSERT INTO centre(id, name, adress, description, avg_grade) VALUES (nextval('centre_seq_gen'), 'center2', 'address2', 'desc2', 4.5);



-- PASSWORD: password123

-- PASSWORD: password123
--System Admin
INSERT INTO user_app(id,email,username, password, active, role_id, password_salt,name,lastname,address, jmbg, phone_number, gender_id) VALUES (nextval('user_app_seq'), 'admin@email.com','admin', '$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 3, '', 'admin', 'adminic','address','12345678','123456',1);
INSERT INTO system_admin(id) values (1);
--UNREGISTERED_USER
INSERT INTO user_app(id,email,username, password, active, role_id, password_salt,name,lastname,address, jmbg, phone_number, gender_id) VALUES (nextval('user_app_seq'), 'unregister@email.com','unregister', '$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 1, '', 'unregister', 'lastname','address','12345678','123456',2);
INSERT INTO unregister_user(id) values (2);
INSERT INTO user_app(id,email,username, password, active, role_id, password_salt,name,lastname,address, jmbg, phone_number, gender_id) VALUES (nextval('user_app_seq'), 'unregister2@email.com','unregister2', '$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 1, '', 'unregister2', 'lastname2','address','12345678','123456',1);
INSERT INTO unregister_user(id) values (3);
--register user
INSERT INTO user_app(id,email,username, password, active, role_id, password_salt,name,lastname,address, jmbg, phone_number, gender_id) VALUES (nextval('user_app_seq'), 'register2@email.com', 'register2','$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 2, '', 'register', 'lastname','address','12345678','123456',1);
INSERT INTO register_user(id, penal) values (4,2);

--centre administartor
INSERT INTO user_app(id, email, username, password, active, role_id, password_salt, name, lastname, address, jmbg, phone_number, gender_id) VALUES (nextval('user_app_seq'), 'centreAdmin@email.com', 'centreAdmin', '$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 4, '', 'centreA', 'lastname', 'address', '12345678', '123456', 2);
INSERT INTO centre_admin(id, centre_id) values (5,1);
INSERT INTO user_app(id, email, username, password, active, role_id, password_salt, name, lastname, address, jmbg, phone_number, gender_id) VALUES (nextval('user_app_seq'), 'centreAdmin1@email.com', 'centreAdmin1', '$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 4, '', 'centreA', 'lastname', 'address', '12345678', '123456', 2);
INSERT INTO centre_admin(id, centre_id) values (6,1);
INSERT INTO user_app(id, email, username, password, active, role_id, password_salt, name, lastname, address, jmbg, phone_number, gender_id) VALUES (nextval('user_app_seq'), 'centreAdmin2@email.com', 'centreAdmin2', '$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 4, '', 'centreA', 'lastname', 'address', '12345678', '123456', 2);
INSERT INTO centre_admin(id, centre_id) values (7,2);
--INSERT INTO user_app(id, username, email, password, active, role_id, password_salt) VALUES (nextval('user_app_seq'), 'manager2', 'manager2@email.com', '$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 3, '');
--INSERT INTO project_manager(id) values (6);

INSERT INTO user_app(id,email,username, password, active, role_id, password_salt,name,lastname,address, jmbg, phone_number, gender_id) VALUES (nextval('user_app_seq'), 'register1@email.com', 'register3','$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 2, '', 'register2', 'lastname2','address','12345678','123456',1);
INSERT INTO register_user(id, penal) values (8, 2);
INSERT INTO user_app(id,email,username, password, active, role_id, password_salt,name,lastname,address, jmbg, phone_number, gender_id) VALUES (nextval('user_app_seq'), 'register3@email.com', 'register1','$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 2, '', 'register1', 'lastname1','address','12345678','123456',1);
INSERT INTO register_user(id,penal) values (9, 2);

--appointment
INSERT INTO appointments(id, date, time,duration, available, blood_type_id,centre_id,register_user_id,present,statement_id) VALUES (nextval('appointment_seq_gen'), '2023-04-12', '12:30h', 12, false, 1, 1,8,false,null);
INSERT INTO appointments(id, date, time,duration, available, blood_type_id,centre_id,register_user_id,present,statement_id) VALUES (nextval('appointment_seq_gen'), '2023-04-12', '12:30h', 30, false, 2, 1,4,false,null);
INSERT INTO appointments(id, date, time,duration, available, blood_type_id,centre_id,register_user_id,present,statement_id) VALUES (nextval('appointment_seq_gen'), '2023-04-12', '12:30h', 33, false, 3, 1,9,false,null);
--INSERT INTO appointments(id, date, time,duration, available, blood_type_id,centre_id,register_user_id,present,statement_id) VALUES (nextval('appointment_seq_gen'), '2023-04-12', '12:30h', 23, false, 4, 2,8,false,null);





