package pl.cdp.userws.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
public class Role  {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String name;
}
