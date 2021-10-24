package ru.domrf.demoApl.service;

import ru.domrf.demoApl.model.Product;
import java.util.List;

public interface ProductService {
    Product saveProduct (Product product);
    Product getById(Integer id);
    Product getByBarcode(String barcode);
    void delete(Integer id);
    List<Product> getAll();
}
