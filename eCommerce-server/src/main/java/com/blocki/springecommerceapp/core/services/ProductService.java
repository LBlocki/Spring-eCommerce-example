package com.blocki.springecommerceapp.core.services;

import com.blocki.springecommerceapp.api.v1.models.ProductDTO;
import org.springframework.hateoas.Resource;

public interface ProductService {

    Resource<ProductDTO> getProductById(Long id);

    Resource<ProductDTO> getProductByName(String name);

    Resource<ProductDTO> patchProduct(Long id, ProductDTO shoppingCartDTO);

    void deleteProductById(Long id);
}
