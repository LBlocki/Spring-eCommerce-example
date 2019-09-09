package com.blocki.springrestonlinestore.core.config.resourceAssemblers;

import com.blocki.springrestonlinestore.api.v1.controllers.OrderController;
import com.blocki.springrestonlinestore.api.v1.controllers.OrderItemController;
import com.blocki.springrestonlinestore.api.v1.models.OrderItemDTO;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class OrderItemResourceAssembler implements ResourceAssembler<OrderItemDTO,
        Resource<OrderItemDTO>> {

    @Override
    public Resource<OrderItemDTO> toResource(OrderItemDTO orderItemDTO) {

        return new Resource<>(orderItemDTO,
                linkTo(methodOn(OrderItemController.class).getOrderItemById(orderItemDTO.getId()))
                        .withSelfRel().withType("GET"),
                linkTo(methodOn(OrderItemController.class).getOrderItemById(orderItemDTO.getId()))
                        .withRel("delete order item").withType("DELETE"),
                linkTo(methodOn(OrderController.class).getAllOrderItems(orderItemDTO
                        .getOrderDTO().getId())).withRel("get list of order items").withType("GET"));

    }
}
