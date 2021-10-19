package ru.domrf.demoApl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.domrf.demoApl.model.Order;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
