package edu.icet.service;

import edu.icet.dto.OrderDetails;

public interface OrderDetailsService {
    boolean addOrderDetails(Integer id, OrderDetails orderDetails);
}
