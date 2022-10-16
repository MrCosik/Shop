package pl.cdp.orderws.service;

import org.springframework.http.ResponseEntity;
import pl.cdp.orderws.entity.Order;

import java.util.List;

public interface OrderService  {
    List<Order> getAllOrders();
}
