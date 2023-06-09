package com.example.hardwareregister.tv.tvModel.model;

import com.example.hardwareregister.tv.model.Tv;
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
@Table(name = "tv_models")
public class TvModel {
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

    @Column(name = "technology", nullable = false)
    private String technology;

    @Column(name = "in_stock")
    private Boolean inStock;

    @ManyToOne
    @JoinColumn(name = "tv_id", nullable = false)
    private Tv tv;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TvModel tvModel = (TvModel) o;
        return id != null && Objects.equals(id, tvModel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
