drop table if exists user_role;
drop table if exists user;
drop table if exists role;


CREATE TABLE user (
    id integer AUTO_INCREMENT primary key,
    name varchar(20) NOT NULL,
    email varchar(20) NULL,
    password varchar(20) NOT NULL
);

CREATE TABLE role (
    id integer AUTO_INCREMENT primary key,
    name varchar(20) NOT NULL
);

CREATE TABLE user_role (
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    PRIMARY KEY (user_id, role_id)
);

insert into user (name, password) values ('Daniil', '123');
insert into user (name, password) values ('Anatoli', '310');
insert into role (name) values ('ROLE_USER');
insert into role (name) values ('ROLE_ADMIN');
insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (2, 1);
insert into user_role (user_id, role_id) values (2, 2);
