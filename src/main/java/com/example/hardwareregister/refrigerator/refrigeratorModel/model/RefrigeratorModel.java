package com.example.hardwareregister.refrigerator.refrigeratorModel.model;

import com.example.hardwareregister.refrigerator.model.Refrigerator;
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
@Table(name = "refrigerator_models")
public class RefrigeratorModel {
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

    @Column(name = "doors_count", nullable = false)
    private Integer doorsCount;

    @Column(name = "compressor_type", nullable = false)
    private String compressorType;

    @Column(name = "in_stock")
    private Boolean inStock;

    @ManyToOne
    @JoinColumn(name = "refrigerator_id", nullable = false)
    private Refrigerator refrigerator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RefrigeratorModel that = (RefrigeratorModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
