package ru.domrf.demoApl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perk")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perk_id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "perk_name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
}
