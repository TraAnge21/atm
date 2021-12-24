BEGIN TRANSACTION ;
DROP IF EXISTS USERS;
DROP IF EXISTS ACCOUNT;
DROP IF EXISTS SAVING_ACCOUNT;
DROP IF EXISTS CHECKING_ACCOUNT;
DROP IF EXISTS TRANSACTIONS;
DROP IF EXISTS TRANSACTION_TYPE;
DROP IF EXISTS TRANSACTION_STATUS;



CREATE TABLE USERS (
        user_id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
        user_password varchar(25),
        User_name varchar(255),
);

CREATE TABLE ACCOUNT (
        account_id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
        user_id int,
        saving_account_id int NOT NULL,
        checking_account_id int NOT NULL,
        FOREIGN KEY (user_id) REFERENCES USER (user_id),
        FOREIGN KEY (saving_account_id) REFERENCES SAVING_ACCOUNT (saving_account_id),
        FOREIGN KEY (checking_account_id) REFERENCES CHECKING_ACCOUNT (checking_account_id)

);

CREATE TABLE SAVING_ACCOUNT (
        saving_account_id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
        user_id int NOT NULL,
        balance decimal (13, 2),
        FOREIGN KEY (user_id) REFERENCES USER (user_id),

);

CREATE TABLE CHECKING_ACCOUNT (
        checking_account_id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
        user_id int NOT NULL,
        balance decimal (13, 2),
        FOREIGN KEY (user_id) REFERENCES USER (user_id),

);

CREATE TABLE TRANSACTIONS (
        transaction_id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
        account_from int,
        account_to int,
        amount decimal (13, 2),
        transaction_type_id int NOT NULL,
        transaction_status_id int NOT NULL,
        FOREIGN KEY (transaction_type_id) REFERENCES TRANSACTION_TYPE (transaction_type_id),
        FOREIGN KEY (transaction_status_id) REFERENCES TRANSACTION_STATUS (transaction_status_id),
        FOREIGN KEY (account_from) REFERENCES ACCOUNT (account_id),
        FOREIGN KEY (account_to) REFERENCES ACCOUNT (account_id),
);

CREATE TABLE TRANSACTION_TYPE (
        transaction_type_id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
        transaction_type_desc varchar(25),
);

CREATE TABLE TRANSACTION_STATUS (
        transaction_status_id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
        transaction_status_desc varchar(25),
);


INSERT INTO TRANSACTION_STATUS (transaction_status_desc)
VALUES ('pending');

INSERT INTO TRANSACTION_STATUS (transaction_status_desc)
VALUES ('approved');

INSERT INTO TRANSACTION_STATUS (transaction_status_desc)
VALUES ('rejected');


INSERT INTO TRANSACTION_TYPE (transaction_type_desc)
VALUES ('withdraw');

INSERT INTO TRANSACTION_TYPE (transaction_type_desc)
VALUES ('deposit');

INSERT INTO TRANSACTION_TYPE (transaction_type_desc)
VALUES ('send');


COMMIT TRANSACTIONS;
