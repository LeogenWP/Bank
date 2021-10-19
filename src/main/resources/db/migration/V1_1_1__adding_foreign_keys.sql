 ALTER TABLE purchase
    ADD FOREIGN KEY (person_fk_id)
    REFERENCES person(person_id);

ALTER TABLE purchase_product
    ADD FOREIGN KEY (purchase_fk_id)
    REFERENCES purchase(purchase_id);

ALTER TABLE purchase_product
    ADD FOREIGN KEY (product_fk_id)
    REFERENCES product(product_id);

ALTER TABLE person_perk
    ADD FOREIGN KEY (person_fk_id)
    REFERENCES person(person_id);

ALTER TABLE person_perk
    ADD FOREIGN KEY (perk_fk_id)
    REFERENCES perk(perk_id)