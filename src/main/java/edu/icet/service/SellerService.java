package edu.icet.service;

import edu.icet.dto.Seller;

public interface SellerService {
    String addSeller(Seller seller);

    Seller getBuyer(String email, String password);
}
