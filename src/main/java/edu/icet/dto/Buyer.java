package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Buyer {
    private Integer buyerId;
    private String name;
    private String email;
    private String phone;
    private String password;
}