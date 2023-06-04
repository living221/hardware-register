package com.example.hardwareregister.computer.computerModel.model;

import com.example.hardwareregister.computer.model.Computer;
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
@Table(name = "computer_models")
public class ComputerModel {
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

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "processor_type", nullable = false)
    private String processorType;

    @Column(name = "in_stock")
    private Boolean inStock;

    @ManyToOne
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ComputerModel that = (ComputerModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
