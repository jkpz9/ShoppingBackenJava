CREATE TABLE category
(
id INT auto_increment PRIMARY KEY,
name VARCHAR(50) not null,
description VARCHAR(255),
url_image VARCHAR(50) not null,
is_active BOOLEAN DEFAULT TRUE
)

ALTER TABLE category AUTO_INCREMENT=143;

insert into Category
(name, description, url_image) value("Laptop", "Not thing much here :(", "temporary_wrong_url");

insert into Category
(name, description, url_image) value("Shoes", "Import From Fashional Paradise around the world =))", "demo_url");

CREATE TABLE user_detail
(
 id INT auto_increment PRIMARY KEY,
 first_name VARCHAR(50),
 last_name VARCHAR(50),
 role VARCHAR(50),
 enabled BOOLEAN,
 password VARCHAR(50),
 email VARCHAR(100),
 contact_number VARCHAR(15)
);
ALTER TABLE user_detail auto_increment = 243;

insert into user_detail(first_name, last_name,role, enabled, password, email, contact_number)
 				values('King', 'Pham', 'ADMIN', true, 'admin', 'kingkaka@gmail.com','0120-XXXX-XXX');
insert into user_detail(first_name, last_name,role, enabled, password, email, contact_number)
 				values('Hoang', 'Pham', 'SUPPLIER', true, '12345', 'Hoangkaka@gmail.com','096-XXXX-XXX');
insert into user_detail(first_name, last_name,role, enabled, password, email, contact_number)
 				values('Krys', 'Pham', 'SUPPLIER', true, '12345', 'Kryskaka@gmail.com','097-XXXX-XXX');

CREATE TABLE product
(
id INT PRIMARY KEY AUTO_INCREMENT,
code VARCHAR(20),
name VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(255),
unit_price DECIMAL(10,2),
quantity INT,
is_active BOOLEAN DEFAULT TRUE,
category_id INT not null,
supplier_id INT not null,
purchases INT DEFAULT 0,
views INT DEFAULT 0,
CONSTRAINT PK_product_category_id FOREIGN KEY (category_id)
REFERENCES category(id),
CONSTRAINT PK_product_supplier_id FOREIGN KEY (supplier_id)
REFERENCES user_detail(id)

);

insert into product(code, name, brand, description, unit_price, quantity,category_id, supplier_id)
			values('PRODUCT-001', 'iPhone 5S', 'Apple', 'this i one of the best phone available in the smartphone market',730,12,149,244);
insert into product(code, name, brand, description, unit_price, quantity,category_id, supplier_id)
			values('PRODUCT-002', 'SamSung Galaxy S7', 'SamSung', 'Flagship of December 2016',698,20,149,245);
			
insert into product(code, name, brand, description, unit_price, quantity,category_id, supplier_id)
			values('PRODUCT-003', 'HUAWEI GR5 2017 PRO', 'Huawei', 'Top 3 in MidRange 2017',499,5,150,244);
			
insert into product(code, name, brand, description, unit_price, quantity,category_id, supplier_id)
			values('PRODUCT-002', 'SamSung Galaxy S7', 'SamSung', 'Flagship of December 2016',698,20,149,245);
select code, name, brand, unit_price, quantity, category_id from product order by unit_price DESC;