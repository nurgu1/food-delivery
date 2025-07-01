package com.fooddelivery.food_delivery;
import com.fooddelivery.food_delivery.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.pl.NIP;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name= "owner_id")
    private User owner;
}
