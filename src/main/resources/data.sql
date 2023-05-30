INSERT INTO role(id, name) VALUES (1, 'UNREGISTERED_USER');
INSERT INTO role(id, name) VALUES (2, 'REGISTERED_USER');
INSERT INTO role(id, name) VALUES (3, 'SYSTEM_ADMINISTRATOR');
INSERT INTO role(id, name) VALUES (4, 'CENTRE_ADMINISTRATOR');

INSERT INTO gender(id, name) VALUES (1, 'MALE');
INSERT INTO gender(id, name) VALUES (2, 'FEMALE');


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
INSERT INTO register_user(id) values (4);
--centre administartor
INSERT INTO user_app(id,email,username, password, active, role_id, password_salt,name,lastname,address, jmbg, phone_number, gender_id) VALUES (nextval('user_app_seq'), 'centreAdmin@email.com','centreAdmin', '$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 4, '', 'centreA', 'lastname','address','12345678','123456',2);
INSERT INTO centre_admin(id) values (5);
--INSERT INTO user_app(id, username, email, password, active, role_id, password_salt) VALUES (nextval('user_app_seq'), 'manager2', 'manager2@email.com', '$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 3, '');
--INSERT INTO project_manager(id) values (6);
