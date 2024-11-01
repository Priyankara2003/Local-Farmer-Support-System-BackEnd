package edu.icet.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Seller {
    private Integer sellerId;
    private String name;
    private String email;
    private String phone;
    private String password;
}
