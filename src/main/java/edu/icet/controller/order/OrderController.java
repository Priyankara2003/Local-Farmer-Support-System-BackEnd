package edu.icet.controller.order;

import edu.icet.dto.Order;
import edu.icet.dto.OrderDetails;
import edu.icet.entity.OrderEntity;
import edu.icet.service.OrderService;
import edu.icet.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    final OrderService orderService;
    final OrderDetailsService orderDetailsService;

    @PostMapping("/place-order")
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        try{
            OrderEntity orderEntity = orderService.saveOrder(order);
            if(orderEntity != null) {
                for (OrderDetails orderDetails : order.getOrderDetails()) {
                    if (orderDetails.getProductId() != null || orderDetails.getQty() != null || orderDetails.getTotal() != null) {
                        System.out.println(orderDetails);
                        orderDetailsService.addOrderDetails(orderEntity.getOrderId(), orderDetails);
                    }else{
                        System.out.println(orderDetails);
                    }
                }
            }
        } catch (RuntimeException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResponseEntity.ok("SuccessFully Created");
    }
}
