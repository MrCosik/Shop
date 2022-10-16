package pl.cdp.orderws.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Table(name = "final_order")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<OrderedGame> games;
    private Double price;
}
