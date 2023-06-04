package com.example.hardwareregister.smartphone.smartphoneModel.model;

import com.example.hardwareregister.smartphone.model.Smartphone;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "smartphone_models")
public class SmartphoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Column(name = "serial", nullable = false)
    private String serial;

    @Column(name = "colour", nullable = false)
    private String colour;

    @Column(name = "size", nullable = false)
    private Integer size;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "memory", nullable = false)
    private String memory;

    @Column(name = "cameras_count", nullable = false)
    private Integer camerasCount;

    @Column(name = "in_stock")
    private Boolean inStock;

    @ManyToOne
    @JoinColumn(name = "smartphone_id", nullable = false)
    private Smartphone smartphone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SmartphoneModel that = (SmartphoneModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
