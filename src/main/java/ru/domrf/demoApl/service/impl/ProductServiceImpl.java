package ru.domrf.demoApl.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.domrf.demoApl.model.Product;
import ru.domrf.demoApl.service.ProductService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
