package ru.domrf.demoApl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.domrf.demoApl.model.Product;
import ru.domrf.demoApl.model.Role;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findByBarcode(String barcode);

}
