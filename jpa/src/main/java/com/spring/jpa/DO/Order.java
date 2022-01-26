package com.spring.jpa.DO;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_order")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private Long menuId;

}
