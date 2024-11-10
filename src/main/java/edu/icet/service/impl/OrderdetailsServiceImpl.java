package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.OrderDetails;
import edu.icet.entity.OrderDetailsEntity;
import edu.icet.entity.OrderDetailsId;
import edu.icet.repository.OrderDetailsDao;
import edu.icet.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderdetailsServiceImpl implements OrderDetailsService {

    final ObjectMapper mapper;
    final OrderDetailsDao orderDetailsDao;

    @Override
    public boolean addOrderDetails(Integer id, OrderDetails orderDetails) {
        OrderDetailsEntity orderDetailsEntity = mapper.convertValue(orderDetails, OrderDetailsEntity.class);
        OrderDetailsId orderDetailsId = new OrderDetailsId(id, orderDetails.getProductId());
        orderDetailsEntity.setId(orderDetailsId);
        orderDetailsDao.save(orderDetailsEntity);
        return true;
    }
}
