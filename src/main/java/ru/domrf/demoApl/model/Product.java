package ru.domrf.demoApl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    private Integer id;
    private String barcode;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private String price;
}
