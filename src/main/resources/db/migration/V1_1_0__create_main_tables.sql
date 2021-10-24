CREATE TABLE IF NOT EXISTS person (
    person_id integer AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(255),
    phone_number varchar(30),
    email varchar(255),
    username varchar(255),
    password varchar(255)
);


CREATE TABLE IF NOT EXISTS purchase (
    purchase_id integer AUTO_INCREMENT PRIMARY KEY,
    person_fk_id integer,
    created datetime,
    updated datetime,
    delivery_adress varchar(255),
    purchase_status varchar(30)
);

CREATE TABLE IF NOT EXISTS product (
    product_id integer AUTO_INCREMENT PRIMARY KEY ,
    barcode varchar(25),
    product_name varchar(255),
    product_price varchar(255)
);

CREATE TABLE IF NOT EXISTS perk (
    perk_id integer AUTO_INCREMENT PRIMARY KEY,
    perk_name varchar(255)
);

CREATE TABLE IF NOT EXISTS purchase_product (
    purchase_product_id integer AUTO_INCREMENT PRIMARY KEY,
    purchase_fk_id integer,
    product_fk_id integer
);

CREATE TABLE IF NOT EXISTS person_perk (
    person_perk_id integer AUTO_INCREMENT PRIMARY KEY ,
    person_fk_id integer,
    perk_fk_id integer
);

