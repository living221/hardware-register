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
@Table(name = "hw_type")
public class HwType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hw_type")
    private String hwType;

//    @OneToOne(mappedBy = "hwType", cascade = CascadeType.ALL, optional = false)
//    private Hw hw;
}
