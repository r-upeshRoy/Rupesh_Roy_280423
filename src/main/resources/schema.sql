CREATE TABLE customer (
	id BIGINT not null PRIMARY KEY,
	first_name varchar(100) not null,
	last_name varchar(100) not null
);
CREATE TABLE mobile_number (
  id INT AUTO_INCREMENT,
  customer_id INT NOT NULL,
  Mob_number VARCHAR(20) NOT NULL,
  CONSTRAINT mob_cust_fk FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE SEQUENCE CUSTOMER_SEQ START WITH 54 INCREMENT BY 1;
CREATE SEQUENCE MOBILE_NUMBER_SEQ START WITH 54 INCREMENT BY 1;
