package hu.progmatic.modul_close.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_info")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String place;
    @Column(name = "order_type")
    private String orderType;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "people_id")
    @JsonBackReference
    private Person owner;


}
