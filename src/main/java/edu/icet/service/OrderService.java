package edu.icet.service;

import edu.icet.dto.Order;
import edu.icet.entity.OrderEntity;

public interface OrderService {
    OrderEntity saveOrder(Order order);
}
