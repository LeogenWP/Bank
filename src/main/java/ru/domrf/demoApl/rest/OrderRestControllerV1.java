package ru.domrf.demoApl.rest;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.domrf.demoApl.model.Order;
import ru.domrf.demoApl.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders/")
public class OrderRestControllerV1 {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") Integer orderId) {
        if(orderId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Order order = orderService.getById(orderId);

        if(order == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getAllOrders () {

         List<Order> orders = orderService.getAll();

        if(orders.isEmpty()) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> saveOrder (@RequestBody @Validated Order order) {
        HttpHeaders headers = new HttpHeaders();

        if(order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderService.saveOrder(order);
        return new ResponseEntity<>(order,headers,HttpStatus.CREATED);
    }

}
