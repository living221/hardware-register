package com.example.hardwareregister.hw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hw_reg")
public class Hw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "online_order")
    private Boolean onlineOrder;

    @Column(name = "credit")
    private Boolean credit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hw_type_id", referencedColumnName = "id")
    private HwType hwType;
}
