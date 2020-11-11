CREATE TABLE posting (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(50) NOT NULL,
	expiration_date DATE NOT NULL,
	payment_date DATE,
	price DECIMAL(10,2) NOT NULL,
	note VARCHAR(100),
	type VARCHAR(20) NOT NULL,
	category_id BIGINT(20) NOT NULL,
	person_id BIGINT(20) NOT NULL,
	FOREIGN KEY (category_id) REFERENCES category(id),
	FOREIGN KEY (person_id) REFERENCES person(id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;