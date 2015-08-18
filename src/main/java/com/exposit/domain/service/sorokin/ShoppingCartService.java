package com.exposit.domain.service.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.ShoppingCart;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;

public interface ShoppingCartService {

	public void addOneProduct(ProductCatalogUnit product);

	public void addProduct(Integer count, ProductCatalogUnit product);

	public void deleteOneProduct(ProductCatalogUnit product);

	public List<ProductCatalogUnit> getAllProductsInShoppingCart();

	public ShoppingCart getShoppingCart();

	public void removeAt(int i);

	public double getTotalPrice();

}
