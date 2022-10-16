package pl.cdp.orderws.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cdp.orderws.entity.Order;
import pl.cdp.orderws.service.OrderService;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return  ResponseEntity.ok(orderService.getAllOrders());
    }

}
