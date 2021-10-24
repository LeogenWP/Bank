package ru.domrf.demoApl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "username")
    private String username;
    @Column(name = "password")

    private String password;
    @OneToMany(mappedBy = "user",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "person_perk",
            joinColumns = {@JoinColumn(name="person_fk_id")},
            inverseJoinColumns = {@JoinColumn(name="perk_fk_id")})
    private List<Role> roles  = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this);
    }

    public void romoveOrder(Order order) {
        orders.remove(order);
        order.setUser(null);
    }

    public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }
    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }

}
