CREATE TABLE IF NOT EXISTS person (
    person_id integer NOT NULL ,
    first_name varchar(255),
    phone_number varchar(30),
    email varchar(255),
    username varchar(255),
    password varchar(255),
    PRIMARY KEY(person_id)
);

CREATE TABLE IF NOT EXISTS purchase (
    purchase_id integer NOT NULL ,
    person_fk_id integer NOT NULL,
    created datetime,
    updated datetime,
    delivery_adress varchar(255),
    purchase_status varchar(30),
    PRIMARY KEY(purchase_id)
);

CREATE TABLE IF NOT EXISTS product (
    product_id integer NOT NULL ,
    product_name varchar(255),
    product_price int,
    PRIMARY KEY(product_id)
);

CREATE TABLE IF NOT EXISTS perk (
    perk_id integer NOT NULL ,
    perk_name varchar(255),
    PRIMARY KEY(perk_id)
);

CREATE TABLE IF NOT EXISTS purchase_product (
    purchase_product_id integer NOT NULL ,
    purchase_fk_id integer,
    product_fk_id integer,
    PRIMARY KEY(purchase_product_id)
);

CREATE TABLE IF NOT EXISTS person_perk (
    person_perk_id integer NOT NULL ,
    person_fk_id integer,
    perk_fk_id integer,
    PRIMARY KEY(person_perk_id)
);

