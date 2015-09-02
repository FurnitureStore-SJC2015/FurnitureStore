package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ShoppingCart;

public interface ShoppingCartService {

	public void addOneProduct(ProductCatalogUnit product);

	public void addProduct(Integer count, ProductCatalogUnit product);

	public void deleteOneProduct(ProductCatalogUnit product);

	public List<ProductCatalogUnit> getAllProductsInShoppingCart();

	public ShoppingCart getShoppingCart();

	public void removeAt(int i);

	public double getTotalPrice();

	public void clearCart();

}
