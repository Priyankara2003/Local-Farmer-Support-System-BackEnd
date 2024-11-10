package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer orderId;
    private String date;
    private Integer buyerId;
    private Double netTotal;
    private List<OrderDetails> orderDetails;
}
