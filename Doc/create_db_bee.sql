CREATE DATABASE beeTools;
USE beeTools;
CREATE TABLE characters (
charId		int		NOT NULL,
name		varchar(50),
compteId	int		NOT NULL,
isActive		bit,
expireCache	date,
PRIMARY KEY (charId));

CREATE TABLE compte (
compteId		int		NOT NULL,
keyApi			varchar(20) NOT NULL,
vCodeApi		varchar(100) NOT NULL,
PRIMARY KEY (compteId));

CREATE TABLE notifications (
notifId		int		NOT NULL,
notifType		int		NOT NULL,
senderId	int,
senderName	varchar(20),
sentDate		date,
charId		int		NOT NULL,
isRead		bit,
PRIMARY KEY (notifId));

CREATE TABLE notifSettings (
id			int NOT NULL Identity(1, 1), /*Auto Increment en Tsql */
charId		int,
notifType	int NOT NULL,
disabled	bit,
PRIMARY KEY (id));


ALTER TABLE characters ADD FOREIGN KEY (compteId) REFERENCES compte (compteId);
ALTER TABLE notifications ADD FOREIGN KEY (charId) REFERENCES characters (charId);
ALTER Table notifSettings ADD FOREIGN KEY (charId) REFERENCES characters (charId);

