package ru.domrf.demoApl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.domrf.demoApl.model.Order;
import ru.domrf.demoApl.model.OrderStatus;
import ru.domrf.demoApl.model.Product;
import ru.domrf.demoApl.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {

    private Integer id;
    private Date created;
    private Date updated;
    private String  deliveryAdress;
    private OrderStatus status;
    private User user;
    private List<Product> products;

    public Order toOrder() {
        Order order = new Order();
        order.setId(id);
        order.setCreated(created);
        order.setUpdated(updated);
        order.setDeliveryAdress(deliveryAdress);
        order.setStatus(status);
        order.setUser(user);
        order.setProducts(products);
        return order;
    }

    public static OrderDTO toOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setCreated(order.getCreated());
        orderDTO.setUpdated(order.getUpdated());
        orderDTO.setDeliveryAdress(order.getDeliveryAdress());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setUser(order.getUser());
        orderDTO.setProducts(order.getProducts());
        orderDTO.getUser().setOrders(null);
        return orderDTO;
    }
}
