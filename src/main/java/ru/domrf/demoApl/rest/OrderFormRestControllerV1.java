package ru.domrf.demoApl.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.domrf.demoApl.model.*;
import ru.domrf.demoApl.service.OrderService;
import ru.domrf.demoApl.service.ProductService;
import ru.domrf.demoApl.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orderform/")
public class OrderFormRestControllerV1 {
    UserService userService;
    ProductService productService;
    OrderService orderService;

    @Autowired
    public OrderFormRestControllerV1(UserService userService, ProductService productService,  OrderService orderService) {
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @PostMapping(
            value = "updateform", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderForm> updateForm( @RequestBody OrderForm orderForm, HttpServletResponse response) {
        System.out.println("We are in a POST method");

        User user = userService.findByEmail(orderForm.getEmail());
        if (user.getEmail() == null) {
            user.setEmail(orderForm.getEmail());
            user.setFirstName(orderForm.getCustomerName());
            user.setPhoneNumber(orderForm.getCustomerPhone());
            user.setPassword("1234");
        }
        Order order = new Order();
        order.setDeliveryAdress(orderForm.getDeliveryAdress());
        order.setStatus(OrderStatus.CREATED);
        List<Product> products = new ArrayList<>();
        for( Product product : orderForm.getProducts()) {
            products.add(productService.getByBarcode(product.getBarcode()));
        }
        order.setProducts(products);
        //orderService.saveOrder(order);
        user.addOrder(order);
        userService.saveUser(user);

        return new ResponseEntity<>(orderForm,HttpStatus.OK);
    }
}
