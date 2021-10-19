package ru.domrf.demoApl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.domrf.demoApl.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
