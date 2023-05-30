INSERT INTO role(id, name) VALUES (1, 'UNREGISTERED_USER');
INSERT INTO role(id, name) VALUES (2, 'REGISTERED_USER');
INSERT INTO role(id, name) VALUES (3, 'SYSTEM_ADMINISTRATOR');
INSERT INTO role(id, name) VALUES (4, 'CENTRE_ADMINISTRATOR');


-- PASSWORD: password123
--Admins
INSERT INTO user_app(id, username, email, password, active, role_id, password_salt,address) VALUES (nextval('user_app_seq'), 'admin', 'admin@email.com', '$2a$10$SFp508WvAPKDbemvKcYdd.wLahgUcoBDOPjBRXgNMzDBe3ot/ElwG', true, 1, '','neka tamo');
INSERT INTO unregister_user(id) values (1);