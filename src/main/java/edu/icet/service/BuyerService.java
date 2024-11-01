package edu.icet.service;

import edu.icet.dto.Buyer;

public interface BuyerService {
    String addBuyer(Buyer buyer);

    Integer getBuyer(String email, String password);
}
