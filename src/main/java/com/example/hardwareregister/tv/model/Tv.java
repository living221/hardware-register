package com.example.hardwareregister.tv.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tv")
public class Tv {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tv tv = (Tv) o;
        return id != null && Objects.equals(id, tv.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
