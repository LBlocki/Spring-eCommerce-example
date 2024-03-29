package com.blocki.springecommerceapp.api.v1.controllers;

import com.blocki.springecommerceapp.api.v1.models.OrderDTO;
import com.blocki.springecommerceapp.api.v1.models.OrderItemDTO;
import com.blocki.springecommerceapp.core.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = OrderController.ORDERS_BASIC_URL, produces = "application/hal+json")
public class OrderController {

    static final String ORDERS_BASIC_URL = "/api/v1/orders";

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource<OrderDTO>> getOrderById(@PathVariable final Long id) {

        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable final Long id) {

        orderService.deleteOrderById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/actions/purchase")
    public ResponseEntity<Resource<OrderDTO>> createPurchaseRequest(@PathVariable final Long id) {

        final Resource<OrderDTO> orderDTOResource = orderService.createPurchaseRequest(id);

        final URI uri = MvcUriComponentsBuilder.fromController(getClass())
                        .path("/{id}/actions/purchase")
                        .buildAndExpand(orderDTOResource.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(orderDTOResource);
    }

    @GetMapping("/{id}/orderItems")
    public ResponseEntity<Resources<Resource<OrderItemDTO>>> getAllOrderItems(
            @PathVariable final Long id) {

       return ResponseEntity.ok(orderService.getAllOrderItems(id));
    }

    @PostMapping(value = "/{id}/orderItems", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource<OrderItemDTO>> createNewOrderItem(
            @PathVariable final Long id, @RequestBody @Valid final OrderItemDTO orderItemDTO) {

        final Resource<OrderItemDTO> orderItemDTOResource =
                orderService.createNewOrderItem(id, orderItemDTO);

        final URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}/orderItems")
                .buildAndExpand(orderItemDTOResource.getId())
                .toUri();

        return ResponseEntity.created(uri).body(orderItemDTOResource);
    }
}
