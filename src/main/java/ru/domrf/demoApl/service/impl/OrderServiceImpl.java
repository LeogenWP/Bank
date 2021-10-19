package ru.domrf.demoApl.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.domrf.demoApl.model.Order;
import ru.domrf.demoApl.repository.OrderRepo;
import ru.domrf.demoApl.service.OrderService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    @Override
    public Order saveOrder(Order order) {
        log.info("Saving new Order to the database");
        return orderRepo.save(order);
    }

    @Override
    public Order getById(Integer id) {
        return orderRepo.getById(id);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Order> getAll() {
        return orderRepo.findAll();
    }
}
