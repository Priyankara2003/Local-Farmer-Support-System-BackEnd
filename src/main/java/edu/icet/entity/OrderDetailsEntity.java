package edu.icet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_details")
public class OrderDetailsEntity {
    @EmbeddedId
    private OrderDetailsId id;

    private Integer qty;
    private Double total;
}
