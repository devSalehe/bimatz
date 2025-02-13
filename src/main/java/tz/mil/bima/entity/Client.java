package tz.mil.bima.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import tz.mil.bima.baseEntity.BaseEntity;




@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "clients")
public class Client extends BaseEntity {

    private String name;

    @Column(unique = true)
    private Integer code;
}
