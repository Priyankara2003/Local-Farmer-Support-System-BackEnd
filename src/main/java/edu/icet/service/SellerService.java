package edu.icet.service;

import edu.icet.dto.Seller;

public interface SellerService {
    String addSeller(Seller seller);

    Integer getBuyer(String email, String password);
}
