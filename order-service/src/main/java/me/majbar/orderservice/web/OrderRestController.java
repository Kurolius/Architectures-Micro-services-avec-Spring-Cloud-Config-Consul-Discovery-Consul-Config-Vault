package me.majbar.orderservice.web;

import me.majbar.orderservice.OrderServiceApplication;
import me.majbar.orderservice.entities.Order;
import me.majbar.orderservice.models.Customer;
import me.majbar.orderservice.models.Product;
import me.majbar.orderservice.repositories.OrderRepository;
import me.majbar.orderservice.repositories.ProductItemRepository;
import me.majbar.orderservice.services.CustomerRestClientService;
import me.majbar.orderservice.services.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
//@RequestMapping("/api")
public class OrderRestController {
    private static final Logger LOG = Logger.getLogger(OrderServiceApplication.class.getName());

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    public OrderRestController(OrderRepository orderRepository,
                               ProductItemRepository productItemRepository,
                               CustomerRestClientService customerRestClientService,
                               InventoryRestClientService inventoryRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        LOG.log(Level.INFO, "Index API is calling");
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }
}
