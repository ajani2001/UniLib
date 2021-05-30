package org.ajani2001.back.borrowing.order;

import org.ajani2001.back.RCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController extends RCRUDController<Order, OrderRepresentation> {
    @Autowired
    public OrderController(OrderRepository repository) {
        super(repository);
    }
}
