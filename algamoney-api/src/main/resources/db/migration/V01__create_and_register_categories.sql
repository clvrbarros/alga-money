CREATE TABLE category (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 INSERT INTO category (name) values ('Others');
 INSERT INTO category (name) values ('Food');
 INSERT INTO category (name) values ('Transportation');
 INSERT INTO category (name) values ('Recreation'); 