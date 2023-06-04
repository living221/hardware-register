package com.example.hardwareregister.hoover.hooverModel.model;

import com.example.hardwareregister.hoover.model.Hoover;
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
@Table(name = "hoover_models")
public class HooverModel {
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

    @Column(name = "dust_capacity", nullable = false)
    private Integer dustCapacity;

    @Column(name = "modes_count", nullable = false)
    private Integer modesCount;

    @Column(name = "in_stock")
    private Boolean inStock;

    @ManyToOne
    @JoinColumn(name = "hoover_id", nullable = false)
    private Hoover hoover;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HooverModel that = (HooverModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
