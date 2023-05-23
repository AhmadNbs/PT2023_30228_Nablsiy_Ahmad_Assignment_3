CREATE TABLE clients
(id_c INTEGER(3), name_client VARCHAR(25), email VARCHAR(40), address VARCHAR(60));

CREATE TABLE products
(id_p INTEGER(5), name_product VARCHAR(50), manufacturer VARCHAR(30), quantity INTEGER(5), price DOUBLE(8,2));

CREATE TABLE orders
(nr INTEGER(5),id_p INTEGER(5), id_c INTEGER(5), quantity INTEGER(5), price DOUBLE(8,2));

ALTER TABLE clients
ADD CONSTRAINT c_id_pk PRIMARY KEY(id_c);

ALTER TABLE products
ADD CONSTRAINT p_id_pk PRIMARY KEY(id_p);

ALTER TABLE orders
ADD CONSTRAINT ord_id_c_fk FOREIGN KEY(id_c) REFERENCES clients(id_c);
ALTER TABLE orders
ADD CONSTRAINT ord_id_p_fk FOREIGN KEY(id_p) REFERENCES products(id_p);

ALTER TABLE clients
ADD CONSTRAINT c_email_per_ck CHECK(email LIKE '%@%' AND LENGTH(email)>=10);

INSERT INTO clients
VALUES(1,'Ahmad','amd7676@gmail.com','cluj, zorilor 99 bloc 5, ap2');
INSERT INTO clients
VALUES(2,'Andrei','andr7676@gmail.com','cluj, zorilor 40 bloc 5, ap2');
INSERT INTO clients
VALUES(3,'Bogdan','bgd7676@gmail.com','cluj, marasti 19 bloc 3, ap5');
INSERT INTO clients
VALUES(4,'Cosmin','csm7676@gmail.com','cluj, manasturi 20 bloc 1, ap4');
INSERT INTO clients
VALUES(5,'Sergiu','srg7676@gmail.com','cluj, bulevardu 30 bloc 12, ap1');
INSERT INTO clients
VALUES(6,'Paul','pl7676@gmail.com','cluj, dorabantilor 7 bloc 3, ap2');
INSERT INTO clients
VALUES(7,'Dan','dan7676@gmail.com','cluj, central 3 bloc 1, ap1');

INSERT INTO products
VALUES(101,'cuptor', 'WHIRLPOOL', 13,100);
INSERT INTO products
VALUES(102,'Blender', 'LG', 20,50);
INSERT INTO products
VALUES(103,'uscator de par', 'BOSCH', 40,30);
INSERT INTO products
VALUES(110,'frigider', 'BOSCH', 10,300);
INSERT INTO products
VALUES(111,'Congelator', 'SAMSUNG', 6,400);
INSERT INTO products
VALUES(120,'masina de spalat', 'OMO', 50,300);
INSERT INTO products
VALUES(191,'tabla', 'MOB',30,50);
INSERT INTO products
VALUES(192,'scaun', 'MOB',30,20);
INSERT INTO products
VALUES(193,'pat', 'KAT',70,120);

INSERT INTO orders(nr, id_c, id_p, quantity, price)
VALUES(1, 1, 102, 1,50);
INSERT INTO orders(nr, id_c, id_p, quantity, price)
VALUES(2, 4, 192, 5, 100);
INSERT INTO orders(nr, id_c, id_p, quantity, price)
VALUES(3, 7, 111, 1,400);
INSERT INTO orders(nr, id_c, id_p, quantity, price)
VALUES(4, 2, 191, 2,100);
INSERT INTO orders(nr, id_c, id_p, quantity, price)
VALUES(5, 1, 120, 1,300);
INSERT INTO orders(nr, id_c, id_p, quantity, price)
VALUES(6, 2, 101, 1,100);
INSERT INTO orders(nr, id_c, id_p, quantity, price)
VALUES(7, 5, 103, 2,60);
INSERT INTO orders(nr, id_c, id_p, quantity, price)
VALUES(8, 5, 102, 1,50);
INSERT INTO orders(nr, id_c, id_p, quantity, price)
VALUES(9, 2, 110, 1,300);
INSERT INTO orders(nr, id_c, id_p, quantity, price)
VALUES(10, 7, 193, 2, 240);
