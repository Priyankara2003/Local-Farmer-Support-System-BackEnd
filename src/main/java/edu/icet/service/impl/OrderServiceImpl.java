package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Order;
import edu.icet.entity.OrderEntity;
import edu.icet.repository.OrderDao;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final ObjectMapper mapper;
    final OrderDao orderDao;

    @Override
    public OrderEntity saveOrder(Order order) {
        OrderEntity orderEntity = mapper.convertValue(order, OrderEntity.class);
        return orderDao.save(orderEntity);
    }
}
