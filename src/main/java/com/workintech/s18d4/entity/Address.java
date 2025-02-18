package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address", schema = "fsweb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private Long id;

    @Column(name="street")
    private String street;

    @Column(name="no")
    private Integer no;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(nullable = true, name = "description")
    private String description;

    @OneToOne(mappedBy="address", cascade = {CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private Customer customer;
}
