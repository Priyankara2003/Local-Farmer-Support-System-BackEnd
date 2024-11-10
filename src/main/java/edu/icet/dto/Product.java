package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private int productId;
    private String sellerId;
    private String productName;
    private String description;
    private String price;
    private String qty;
    private String category;
    private String date;
    private String status;
}
