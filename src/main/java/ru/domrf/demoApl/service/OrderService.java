package ru.domrf.demoApl.service;

import ru.domrf.demoApl.model.Order;
import ru.domrf.demoApl.model.Role;
import ru.domrf.demoApl.model.User;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    Order getById(Integer id);
    void delete(Integer id);
    List<Order> getAll();
}
