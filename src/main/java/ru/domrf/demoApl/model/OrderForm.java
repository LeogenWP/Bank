package ru.domrf.demoApl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {
    private String customerName;
    private String customerPhone;
    private String email;
    private String deliveryAdress;
    private List<Product> products;
}
