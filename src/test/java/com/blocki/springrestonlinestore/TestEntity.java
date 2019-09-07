package com.blocki.springrestonlinestore;

import com.blocki.springrestonlinestore.core.domain.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@EqualsAndHashCode
@ToString
public class TestEntity {

    private Category category = new Category();
    private Product product = new Product();
    private ShoppingCart shoppingCart = new ShoppingCart();
    private ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
    private User user = new User();

    private static final LocalDate creationDate = LocalDate.now();

    //user data
    private static final Long userId = 1L;
    private static final String firstName = "Michael";
    private static final String lastName = "Borrows";
    private static final String address = "221B Baker Street";
    private static final String country = "Great Britain";
    private static final String phoneNumber = "213122112";
    private static final String emailAddress = "dsadsa@asdsa.sda";
    private static final String username = "UserMyName";
    private static final char[] password = {'q','s','t'};
    private static final User.Gender gender = User.Gender.MALE;

    //product data
    private static final Long productID = 2L;
    private static final String productName = "Doll";
    private static final Product.ProductStatus productStatus = Product.ProductStatus.AVALIABLE;
    private static final String description = "This is the description for the product";
    private static final BigDecimal cost = new BigDecimal(100.2);
    private static final Byte[] photo = {2,3,4};

    //shopping cart data
    private static final Long shoppingCartID = 3L;
    private static final ShoppingCart.CartStatus cartStatus = ShoppingCart.CartStatus.ACTIVE;

    //shopping cart item data
    private static final Long shoppingCartItemId = 2L;
    private static final Integer quantity = 10;
    private static final BigDecimal totalCost = BigDecimal.valueOf(30);

    //category data
    private static final Long categoryID = 1L;
    private static final String categoryName = "Clothes";

    public TestEntity() {

        category.setId(categoryID);
        category.setName(categoryName);

        user.setId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setCountry(country);
        user.setPhoneNumber(phoneNumber);
        user.setCreationDate(creationDate);
        user.setEmailAddress(emailAddress);
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(gender);
        user.setProducts(Arrays.asList(product, product));
        user.setShoppingCart(shoppingCart);

        product.setUser(user);
        product.setCategory(category);
        product.setCreationDate(LocalDate.now());
        product.setCost(cost);
        product.setProductStatus(productStatus);
        product.setName(productName);
        product.setId(productID);
        product.setDescription(description);
        product.setPhoto(photo);

        shoppingCart.setId(shoppingCartID);
        shoppingCart.setCreationDate(creationDate);
        shoppingCart.setCartStatus(cartStatus);
        shoppingCart.setUser(user);
        shoppingCart.setShoppingCartItems(Arrays.asList(shoppingCartItem, shoppingCartItem));

        shoppingCartItem.setId(shoppingCartItemId);
        shoppingCartItem.setQuantity(quantity);
        shoppingCartItem.setTotalCost(totalCost);
        shoppingCartItem.setProduct(product);
        shoppingCartItem.setShoppingCart(shoppingCart);
    }

    public Category getCategory() { return category; }

    public Product getProduct() {
        return product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public ShoppingCartItem getShoppingCartItem() {
        return shoppingCartItem;
    }

    public User getUser() {
        return user;
    }
}
