package ru.domrf.demoApl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchase")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "created")
    private Date created;
    @Column(name = "updated")
    private Date updated;
    @Column(name = "delivery_adress")
    private String  deliveryAdress;
    @Column(name = "purchase_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name="person_fk_id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY ,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "purchase_product",
            joinColumns = {@JoinColumn(name="purchase_fk_id")},
            inverseJoinColumns = {@JoinColumn(name="product_fk_id")})
    List<Product> products;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", deliveryAdress='" + deliveryAdress + '\'' +
                ", status=" + status +
                //", user=" + user +
                ", products=" + products +
                '}';
    }
}
