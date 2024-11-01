package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "buyers")
public class BuyerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer buyerId;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    private String password;
}
