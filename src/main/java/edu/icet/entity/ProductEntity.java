package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "productDetails")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String sellerId;
    private String productName;
    private String description;
    private String price;
    private String qty;
    private String category;
    private String date;
    private String status;
    @Lob
    @Column(name = "image_data", columnDefinition = "LONGBLOB")
    private byte[] imgData;
}
